package modelo;

import java.util.ArrayList;
import java.util.List;

import clasesImpresiones.Impresiones;
import clasesImpresiones.ObjReporteComandaTicket;
import clasesImpresiones.ObjDatosCliente;
import clasesImpresiones.ObjProductoTicketComanda;

import utilidades.Fecha;
import utilidades.Msj;
import dto.VentaDTO;
import dto.ProductoEnVentaDTO;
import dao.ProductoDAO;
import dao.SaborDAO;
import dao.VentaDAO;
import dao.ProductoEnVentaDAO;
import daoImplementacion.ProductoImp;
import daoImplementacion.SaborImp;
import daoImplementacion.VentaImp;
import daoImplementacion.ProductoEnVentaImp;

public class VentaModelo {

	private VentaDAO venta;
	private ProductoEnVentaDAO productos;
	private SaborDAO Sabor;
	private ProductoDAO productoImp;

	public VentaModelo() {
		this.venta = new VentaImp();
		this.productos = new ProductoEnVentaImp();
		this.Sabor = new SaborImp();
		this.productoImp = new ProductoImp();
	}

	public int GetNuevoNumeroVenta() {
		return this.venta.UltimoNumVenta(Fecha.CurrentDate()) + 1;
	}

	public void AgregarVenta(VentaDTO NuevaVenta) {
		this.venta.CrearNuevaVenta(NuevaVenta);
	}

	public void CancelarVenta(String Fecha, int NumVenta) {
		this.venta.CancelarVenta(Fecha, NumVenta);
	}

	public List<VentaDTO> GetVentasPendientesCocina() {
		return this.venta.VentasPendientesCocina();
	}

	public List<VentaDTO> GetVentaSinFacturar() {
		return this.venta.VentasPendientesEntregar();
	}

	public void ModificarVenta(VentaDTO Venta) {
		this.venta.ModificarVenta(Venta);
	}

	public VentaDTO GetVenta(String Fecha, int NumVenta) {
		return this.venta.GetVenta(Fecha, NumVenta);
	}

	public void FinalizarVenta(String Fecha, int NumVenta) {
		this.venta.FacturarVenta(Fecha, NumVenta);
	}

	public void VentaArmado(String Fecha, int NumVenta) {
		this.venta.VentaArmado(Fecha, NumVenta);
	}

	/*
	 * Manda la orden a Base de Datos para que las ventas pasadas por parametro
	 * se les cambie el estado a que estan camino a ser entregador.
	 */
	public void VentasEnViaje(List<VentaDTO> Ventas) {
		this.venta.EnviarVentas(Ventas);
	}

	public List<VentaDTO> GetVentasEnViaje() {
		return this.venta.GetVentasEnViaje();
	}

	public List<ProductoEnVentaDTO> GetProductosEnVenta(String Fecha,
			int NumVenta) {
		
		return this.productos.GetProductosPara(Fecha, NumVenta);
	}

	public List<ProductoEnVentaDTO> GetProductosFaltantesElaborarCocina() {
		return this.productos.GetFaltantesElabracion();
	}

	public int ObtenerCurCantidadVentasFacturadas() {
		return this.venta.GetCantidadFacturadas(Fecha.CurrentDate(),
				Fecha.CurrentDate());
	}

	public List<VentaDTO> ObtenerCurVentasFacturadas() {
		return this.venta.GetFacturadas(Fecha.CurrentDate(),
				Fecha.CurrentDate());
	}

	public int ObtenerCurGananciaFacturadas() {
		return this.venta.GetGananciaFacturadas(Fecha.CurrentDate(),
				Fecha.CurrentDate());
	}

	public int ObtenerCurCantidadVentasCanceladas() {
		return this.venta.GetCantidadCanceladas(Fecha.CurrentDate(),
				Fecha.CurrentDate());
	}

	public List<VentaDTO> ObtenerCurVentasCanceladas() {
		return this.venta.GetCanceladas(Fecha.CurrentDate(),
				Fecha.CurrentDate());
	}

	public int ObtenerCurPerdidaCanceladas() {
		return this.venta.GetPerdidas(Fecha.CurrentDate(), Fecha.CurrentDate());
	}

	public void crearComanda(vista.ArmadoVentaVista vista) {
		String fecha = vista.getTxtFecha().getText();
		int id = Integer.parseInt(vista.getTxtNumVenta().getText());
		String obs = vista.getTxtrObservacion().getText();
		String obsDelivery = vista.getTxtrObservacionDelivery().getText();
		ObjDatosCliente cliente = getDatosCliente(vista);

		List<ObjProductoTicketComanda> listaTicket = getItemsTicket(vista);
		List<ObjProductoTicketComanda> listaComanda = getItemsComanda(vista);

		ObjReporteComandaTicket reporte = new ObjReporteComandaTicket(cliente,
				fecha, id, obs, obsDelivery, listaTicket, listaComanda);
		try {
			Impresiones.ImprimirComandaTicket(reporte);
		} catch (Exception e) {
			Msj.error("Error", "Error al generar el ticket comanda inesperado");
		}
	}

	private List<ObjProductoTicketComanda> getItemsComanda(
			vista.ArmadoVentaVista vista) {
		int id = Integer.parseInt(vista.getTxtNumVenta().getText());
		String fecha = vista.getTxtFecha().getText();
		List<ProductoEnVentaDTO> query = productos.GetProductosPara(fecha, id);
		List<ObjProductoTicketComanda> listaComanda = castToReportObject(query);

		return listaComanda;
	}

	// NICOF
	private List<ObjProductoTicketComanda> getItemsTicket(
			vista.ArmadoVentaVista vista) {
		int id = Integer.parseInt(vista.getTxtNumVenta().getText());
		String fecha = vista.getTxtFecha().getText();
		List<ProductoEnVentaDTO> productosComanda = productos.GetProductosPara(
				fecha, id);

		// ACA ESTA LA MAGIA - reemplazar por items de bebida
		List<ProductoEnVentaDTO> productosNOComanda = productos
				.GetProductosNoCocina(fecha, id);
		List<ObjProductoTicketComanda> listaTicket = castToReportObject(productosComanda);

		listaTicket.addAll(castToReportObject(productosNOComanda));

		return listaTicket;
	}

	private List<ObjProductoTicketComanda> castToReportObject(
			List<ProductoEnVentaDTO> productss) {
		List<ObjProductoTicketComanda> listaComanda = new ArrayList<ObjProductoTicketComanda>();
		for (ProductoEnVentaDTO producto : productss) {
			int precio = this.Sabor.GetPrecio(producto.getProducto(),
					producto.getSabor());
			int cantidad = producto.getCantidad();
			String productoNombre = productoImp.GetDescipcion(producto
					.getProducto());
			String materia = productoNombre + " - " + producto.getSabor();
			String codigo = producto.getProducto();
			ObjProductoTicketComanda nuevo = new ObjProductoTicketComanda(
					cantidad, precio, materia, codigo);
			listaComanda.add(nuevo);
		}
		return listaComanda;
	}

	private ObjDatosCliente getDatosCliente(vista.ArmadoVentaVista vista) {
		String nombre = vista.getTxtCliente().getText();
		String direccion = vista.getTxtDireccion().getText();
		String telefono = vista.getTxtTel().getText();
		return new ObjDatosCliente(nombre, direccion, telefono);
	}

	public List<VentaDTO> ObtenerTodasLasVentas() {
		return this.venta.GetAllVentas();
	}

	public static String ObtenerFechaInicioVentas() {
		VentaDAO v = new VentaImp();
		return v.GetFechaInicioVentas();
	}
}