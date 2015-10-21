package clasesImpresiones;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import clasesImpresiones.ObjTicketCliente.ObjProductoTicket;

import dto.ProductoEnVentaDTO;

public class MainTemporal {
	public static void main(String[] args) {
		impresionTicketClienteTest();
		impresionReporteTest();
		impresionComandaTest();
		impresionSolicitudMateriasPrimas();
	}

	private static void impresionSolicitudMateriasPrimas() {
		ObjSolicitudMP solicitud = new ObjSolicitudMP();
		solicitud.fecha = "13/10/2015";
		solicitud.hora = "13:00:00";
		solicitud.NombreArchivo = "Solicitud MP ";
		solicitud.numSolicitud = 12;
		solicitud.addMateriaPrima("Queso", 3);
		solicitud.addMateriaPrima("Jamon", 50);
		solicitud.addMateriaPrima("Morron", 10);

		ImpresionDocx.ImprimirSolicitudMP(solicitud);
	}

	private static void impresionTicketClienteTest() {
		ObjTicketCliente ticketCliente = new ObjTicketCliente();
		ticketCliente.fecha = "13/10/2015";
		ticketCliente.nombreDocumento = "Ticket Cliente ";

		ticketCliente.addProducto("Pizza - Muzza", 3, 100, 300);

		ticketCliente.addProducto("Faina - Simple", 4, 5, 20);
		double acum = 0;
		for (ObjProductoTicket producto : ticketCliente.productos) {
			acum += producto.total;
		}
		ticketCliente.totalFinal = acum;
		ImpresionDocx.ImprimirTicketCliente(ticketCliente);
	}

	private static void impresionReporteTest() {
		ObjReporte reporte = new ObjReporte();
		reporte.fecha = "13/10/2015";
		reporte.nombre = "REPORTE DIARIO";
		reporte.total = 340.4;
		reporte.productos = new ArrayList<ProductoEnVentaDTO>();
		reporte.productos.add(new ProductoEnVentaDTO("Pizza", "Fugazetta", 2));
		reporte.productos.add(new ProductoEnVentaDTO("Faina", "Simple", 14));
		reporte.productos.add(new ProductoEnVentaDTO("Empanada", "Carne", 8));
		reporte.productos.add(new ProductoEnVentaDTO("Pizza", "Muzza", 3));
		ImpresionDocx.ImprimirReporteDiario(reporte);
	}

	private static void impresionComandaTest() {
		ObjComanda comanda = new ObjComanda();
		comanda.fecha = "13/10/2015";
		comanda.hora = new Date().toString();
		comanda.nombre = "COMANDA";
		comanda.listaProductos = new ArrayList<ProductoEnVentaDTO>();
		comanda.listaProductos.add(new ProductoEnVentaDTO("Pizza", "Fugazetta", 2));
		comanda.listaProductos.add(new ProductoEnVentaDTO("Faina", "Simple", 14));
		comanda.listaProductos.add(new ProductoEnVentaDTO("Empanada", "Carne", 8));
		comanda.listaProductos.add(new ProductoEnVentaDTO("Pizza", "Muzza", 3));
		comanda.observaciones = "POCO QUESO dasdasdascghjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkfasdasddfhaskjhfdakshdkas";
		ImpresionDocx.ImprimirComanda(comanda);
	}
}
