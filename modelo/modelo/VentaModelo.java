package modelo;

import java.util.List;
import dto.VentaDTO;
import dto.ProductoEnVentaDTO;
import dao.VentaDAO;
import dao.ProductoEnVentaDAO;
import daoImplementacion.VentaImp;
import daoImplementacion.ProductoEnVentaImp;

public class VentaModelo {

	private VentaDAO venta;
	private ProductoEnVentaDAO productos;
	
	public VentaModelo() {
		this.venta = new VentaImp();
		this.productos = new ProductoEnVentaImp();
	}
	
	public int GetNuevoNumeroVenta() {
		return this.venta.UltimoNumVenta() + 1;
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

	/* Manda la orden a Base de Datos para que las ventas pasadas por parametro se les cambie el estado a que estan camino a ser entregador. */
	public void VentasEnViaje(List<VentaDTO> Ventas) {
		this.venta.EnviarVentas(Ventas);
	}

	public List<VentaDTO> GetVentasEnViaje() {
		return this.venta.GetVentasEnViaje();
	}
	
	public List<ProductoEnVentaDTO> GetProductosEnVenta(String Fecha, int NumVenta) {
		return this.productos.GetProductosPara(Fecha, NumVenta);
	}

	public List<ProductoEnVentaDTO> GetProductosFaltantesElaborarCocina() {
		return this.productos.GetFaltantesElabracion();
	}
}