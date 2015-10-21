package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import dto.VentaDTO;
import dto.ProductoEnVentaDTO;

import modelo.VentaModelo;

import vista.CocinaVista;

public class ControladorVentasCocina implements ActionListener {

	
	private static ControladorVentasCocina instancia = null;
	private CocinaVista vtCocina;
	private VentaModelo mdlVenta;
	private List<VentaDTO> ventas;
	
	protected ControladorVentasCocina() {
		this.vtCocina = new CocinaVista();
		this.mdlVenta = new VentaModelo();
		this.ventas = new ArrayList<VentaDTO>();
	}
	
	public static ControladorVentasCocina GetInstancia() {
		if (instancia == null)
			instancia = new ControladorVentasCocina();
		
		return instancia;
	}
	
	public void Inicializar() {
		this.CargarTablas();
		this.vtCocina.Open();
	}
	
	private void CargarTablas() {
		this.ventas = this.mdlVenta.GetVentasPendientesCocina();
		/* Carga de la primera venta, si existe. */
		/**
		 * Por cada tabla lo que va a realizar es:
		 * 1. Borrar todo posible datos del txt que indica el num de Venta.
		 * 2. Borrar todos los posibles Datos que pueda haber en las tablas.
		 * 3. Cargar el txt que identifica el numero de Venta en un numero de venta(Si es que hay una venta en estad pendiente).
		 * 4. Cargar la tabla con los productos que contenga ese pedido(para los pedido que esten en estado pendientes).
		 **/
		this.vtCocina.getTxtPeido1().setText("");
		this.vtCocina.getModelTable1().setRowCount(0);
		this.vtCocina.getModelTable1().setColumnCount(0);
		this.vtCocina.getModelTable1().setColumnIdentifiers(this.vtCocina.getNombreColumnasPedidos());
		if(this.ventas.size() >= 1) {
			this.vtCocina.getTxtPeido1().setText(Integer.toString(this.ventas.get(0).getNumVenta()));
			
			List<ProductoEnVentaDTO> productos1 = this.mdlVenta.GetProductosEnVenta(this.ventas.get(0).getFecha(), this.ventas.get(0).getNumVenta());
			for(ProductoEnVentaDTO pp:productos1) {
				Object[] fila = {pp.getProducto(), pp.getSabor(), Integer.toString(pp.getCantidad())};
				this.vtCocina.getModelTable1().addRow(fila);
			}
			this.vtCocina.getTblPedido1().setModel(this.vtCocina.getModelTable1());
		}
		/* Carga del segundo pedido, si existe. */
		this.vtCocina.getModelTable2().setRowCount(0);
		this.vtCocina.getModelTable2().setColumnCount(0);
		this.vtCocina.getModelTable2().setColumnIdentifiers(this.vtCocina.getNombreColumnasPedidos());
		if(this.ventas.size() >= 2) {
			this.vtCocina.getTxtPeido2().setText(Integer.toString(this.ventas.get(1).getNumVenta()));			

			List<ProductoEnVentaDTO> productos2 = this.mdlVenta.GetProductosEnVenta(this.ventas.get(0).getFecha(), this.ventas.get(1).getNumVenta());
			for(ProductoEnVentaDTO pp:productos2) {
				Object[] fila = {pp.getProducto(), pp.getSabor(), Integer.toString(pp.getCantidad())};
				this.vtCocina.getModelTable2().addRow(fila);
			}
			this.vtCocina.getTblPedido2().setModel(this.vtCocina.getModelTable2());
		}
		/* Carga del tercer pedido, si existe. */
		this.vtCocina.getModelTable3().setRowCount(0);
		this.vtCocina.getModelTable3().setColumnCount(0);
		this.vtCocina.getModelTable3().setColumnIdentifiers(this.vtCocina.getNombreColumnasPedidos());
		if(this.ventas.size() >= 3) {
			this.vtCocina.getTxtPeido3().setText(Integer.toString(this.ventas.get(2).getNumVenta()));
			
			List<ProductoEnVentaDTO> productos3 = this.mdlVenta.GetProductosEnVenta(this.ventas.get(0).getFecha(), this.ventas.get(2).getNumVenta());
			for(ProductoEnVentaDTO pp:productos3) {
				Object[] fila = {pp.getProducto(), pp.getSabor(), Integer.toString(pp.getCantidad())};
				this.vtCocina.getModelTable3().addRow(fila);
			}
			this.vtCocina.getTblPedido3().setModel(this.vtCocina.getModelTable3());
		}
		/* Carga del cuarto pedido, si existe. */
		this.vtCocina.getModelTable4().setRowCount(0);
		this.vtCocina.getModelTable4().setColumnCount(0);
		this.vtCocina.getModelTable4().setColumnIdentifiers(this.vtCocina.getNombreColumnasPedidos());
		if(this.ventas.size() >= 4) {
			this.vtCocina.getTxtPeido4().setText(Integer.toString(this.ventas.get(3).getNumVenta()));
			
			List<ProductoEnVentaDTO> productos4 = this.mdlVenta.GetProductosEnVenta(this.ventas.get(0).getFecha(), this.ventas.get(3).getNumVenta());
			for(ProductoEnVentaDTO pp:productos4) {
				Object[] fila = {pp.getProducto(), pp.getSabor(), Integer.toString(pp.getCantidad())};
				this.vtCocina.getModelTable4().addRow(fila);
			}
			this.vtCocina.getTblPedido4().setModel(this.vtCocina.getModelTable4());
		}
		/* Carga del quinto pedido, si existe. */
		this.vtCocina.getModelTable5().setRowCount(0);
		this.vtCocina.getModelTable5().setColumnCount(0);
		this.vtCocina.getModelTable5().setColumnIdentifiers(this.vtCocina.getNombreColumnasPedidos());
		if(this.ventas.size() >= 5) {
			this.vtCocina.getTxtPeido5().setText(Integer.toString(this.ventas.get(4).getNumVenta()));
			
			List<ProductoEnVentaDTO> productos5 = this.mdlVenta.GetProductosEnVenta(this.ventas.get(0).getFecha(), this.ventas.get(4).getNumVenta());
			for(ProductoEnVentaDTO pp:productos5) {
				Object[] fila = {pp.getProducto(), pp.getSabor(), Integer.toString(pp.getCantidad())};
				this.vtCocina.getModelTable5().addRow(fila);
			}
			this.vtCocina.getTblPedido5().setModel(this.vtCocina.getModelTable5());
		}
		/* Carga del sexto pedido, si existe. */
		this.vtCocina.getModelTable6().setRowCount(0);
		this.vtCocina.getModelTable6().setColumnCount(0);
		this.vtCocina.getModelTable6().setColumnIdentifiers(this.vtCocina.getNombreColumnasPedidos());
		if(this.ventas.size() >= 6) {
			this.vtCocina.getTxtPeido6().setText(Integer.toString(this.ventas.get(5).getNumVenta()));
			
			List<ProductoEnVentaDTO> productos6 = this.mdlVenta.GetProductosEnVenta(this.ventas.get(0).getFecha(), this.ventas.get(5).getNumVenta());
			for(ProductoEnVentaDTO pp:productos6) {
				Object[] fila = {pp.getProducto(), pp.getSabor(), Integer.toString(pp.getCantidad())};
				this.vtCocina.getModelTable6().addRow(fila);
			}
			this.vtCocina.getTblPedido6().setModel(this.vtCocina.getModelTable6());
		}
		/* Carga la tabla de los productos pendientes. */
		this.vtCocina.getModelTablePendientes().setRowCount(0);
		this.vtCocina.getModelTablePendientes().setColumnCount(0);
		this.vtCocina.getModelTablePendientes().setColumnIdentifiers(this.vtCocina.getNombreColumnasPedidos());
		List<ProductoEnVentaDTO> productosPendintes = this.mdlVenta.GetProductosFaltantesElaborarCocina();
		for(ProductoEnVentaDTO pp:productosPendintes) {
			Object[] fila = {pp.getProducto(), pp.getSabor(), Integer.toString(pp.getCantidad())};
			this.vtCocina.getModelTablePendientes().addRow(fila);
		}
		this.vtCocina.getTblProductosPendientes().setModel(this.vtCocina.getModelTablePendientes());
	}
	
	public void RecargarTablas() {
		this.CargarTablas();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
	}
}