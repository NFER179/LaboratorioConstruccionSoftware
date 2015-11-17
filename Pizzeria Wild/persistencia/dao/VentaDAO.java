package dao;

import dto.VentaDTO;
import java.util.List;

public interface VentaDAO {

	/* Obtener pedido que no estan cancelados ni finalizados. */
	public List<VentaDTO> VentasPendientesEntregar();
	
	/* Obtencion de pedidos pendiente */
	public List<VentaDTO> VentasPendientesCocina();
	
	/* Ultimo Num de Pedido */
	public int UltimoNumVenta(String Fecha);
	
	/* Agregar un nuevo pedido */
	public void CrearNuevaVenta(VentaDTO Venta);

	/* Por la referencia de pedido lo cancela. */
	public void CancelarVenta(String Fecha, int numVenta);

	/* Modifica los pedido. */
	public void ModificarVenta(VentaDTO Venta);

	/* Trae la imformacion de un pedido en particular. */
	public VentaDTO GetVenta(String Fecha, int VentaID);
	
	/* Por la referencia de pedido lo pone en estado entregado al cliente. */
	public void FacturarVenta(String Fecha, int NumVenta);

	/* Por la referencia de pedido lo pone en estado armado */
	public void VentaArmado(String Fecha, int numVenta);

	/* Pasa los pedidos a estado en Viaje. */
	public void EnviarVentas(List<VentaDTO> Ventas);

	/* Se Obtienen todos los pedidos que se encuentran en estado Viaje */
	public List<VentaDTO> GetVentasEnViaje();

	/* Cantidad de Ventas Facturadas. */
	public int GetCantidadFacturadas(String FromDate, String ToDate);

	/* Lista de ventas Facturasa. */
	public List<VentaDTO> GetFacturadas(String FromDate, String ToDate);

	/* Total de Ganancias en las Ventas FActuradas. */
	public int GetGananciaFacturadas(String FromDate, String ToDate);

	/* Cantidad de Ventas Canceladas. */
	public int GetCantidadCanceladas(String FromDate, String ToDate);

	/* Cantidad de ventas Canceladas. */
	public List<VentaDTO> GetCanceladas(String FromDate, String ToDate);

	/* Total de Perdidas por Ventas Canceladas */
	public int GetPerdidas(String FromDate, String ToDate);

	/* Todos los pedidos. */
	public List<VentaDTO> GetAllVentas();

	/* Trae la fecha de la primer venta. */
	public String GetFechaInicioVentas();
}