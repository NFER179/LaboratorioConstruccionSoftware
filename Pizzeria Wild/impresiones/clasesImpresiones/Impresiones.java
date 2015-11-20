package clasesImpresiones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import modelo.ReportesModelo;

import clasesImpresiones.ObjDatosRepartidor;
import clasesImpresiones.ObjReporteItinerario.objPuntoItinerario;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import dto.ClienteReporteDTO;
import dto.MateriaPrimaDTO;
import dto.ProveedorDTO;
import dto.RepartidoReporteDTO;
import dto.VentaReporteDTO;

public class Impresiones {

	private static String tempPath = "Templates/%s.pdf";
	private static String resultPath = "reportesImpresiones/%s.pdf";
	private static String pdfResultPath;
	private static PdfReader pdfTemplate;
	private static FileOutputStream pdfOut;
	private static PdfStamper stamper;
	private static ObjDatosPizzeria wild = new ObjDatosPizzeria();
	private static DecimalFormat formato = new DecimalFormat("##.##");

	public static void main(String[] args) {
		try {
			// itinerarioTest();
			solicitudMPTest3();
		} catch (Exception e) {
			System.out.println("MACANAS");
			System.out.println(e.toString());
		}
	}

	// private static void solicitudMPTest() throws Exception {
	//
	// ReportesModelo model = new ReportesModelo();
	//
	// List<ClienteReporteDTO> lista = new ArrayList<ClienteReporteDTO>();
	// lista.add(new ClienteReporteDTO(12, "nombre", 1, "12-12-12"));
	// lista.add(new ClienteReporteDTO(12, "nombre", 2, "12-12-12"));
	// lista.add(new ClienteReporteDTO(12, "nombre", 3, "12-12-12"));
	// lista.add(new ClienteReporteDTO(12, "nombre", 4, "12-12-12"));
	// lista.add(new ClienteReporteDTO(12, "nombre", 5, "12-12-12"));
	// lista.add(new ClienteReporteDTO(12, "nombre", 6, "12-12-12"));
	// lista.add(new ClienteReporteDTO(12, "nombre", 7, "12-12-12"));
	// lista.add(new ClienteReporteDTO(12, "nombre", 8, "12-12-12"));
	// lista.add(new ClienteReporteDTO(12, "nombre", 9, "12-12-12"));
	// lista.add(new ClienteReporteDTO(12, "nombre", 10, "12-12-12"));
	// System.out.println(lista.size());
	// ObjReporteMejoresClientes reporte = new ObjReporteMejoresClientes(
	// "2010-1-1", "2020-1-1", lista);
	// ImprimirReporteMejoresClientes(reporte);
	// }

	private static void solicitudMPTest2() throws Exception {
		ReportesModelo model = new ReportesModelo();
		List<RepartidoReporteDTO> lista = model.GetRepartidores("2015-11-13",
				pdfResultPath, 1);

		ObjReporteReparto reporte = new ObjReporteReparto("2010-1-1",
				"Fulano mengano", lista);
		ImprimirReporteReparto(reporte);
	}

	private static void solicitudMPTest3() throws Exception {
		ReportesModelo model = new ReportesModelo();
		List<VentaReporteDTO> lista = new ArrayList<VentaReporteDTO>();
		lista.add(new VentaReporteDTO(0, "papas", 3));
		lista.add(new VentaReporteDTO(1, "dos", 3));
		lista.add(new VentaReporteDTO(2, "gfs", 30));
		lista.add(new VentaReporteDTO(3, "pagfs", 35));
		lista.add(new VentaReporteDTO(4, "lalas", 43));
		lista.add(new VentaReporteDTO(5, "JEEJs", 73));
		lista.add(new VentaReporteDTO(6, "kakaks", 93));
		lista.add(new VentaReporteDTO(7, "fff", 83));
		lista.add(new VentaReporteDTO(8, "Gggas", 39));
		lista.add(new VentaReporteDTO(9, "ttttas", 39));
		lista.add(new VentaReporteDTO(10, "lllas", 38));
		lista.add(new VentaReporteDTO(11, "124as", 32));
		lista.add(new VentaReporteDTO(12, "ñññas", 39));
		lista.add(new VentaReporteDTO(13, "ggggas", 38));
		lista.add(new VentaReporteDTO(14, "papas", 32));
		lista.add(new VentaReporteDTO(15, "ñññas", 39));
		lista.add(new VentaReporteDTO(16, "ggggas", 38));
		lista.add(new VentaReporteDTO(17, "papas", 32));
		ObjReporteVentass reporte = new ObjReporteVentass("2010-1-1",
				"2016-1-1", lista);
		ImprimirReporteVentas(reporte);
	}

	// private static void itinerarioTest() throws Exception {
	// ObjItinerario itinerario = new ObjItinerario("12/12/12", 33,
	// new ObjDatosRepartidor("Pepe", "CCC 888", "0303456"),
	// "lleva cambio ");
	// itinerario.addPunto("la direccion", "la observacion", 1, 55.4);
	// itinerario.addPunto("la direccion", "la observacion", 2, 100);
	// itinerario.addPunto("la direccion", "la observacion", 3, 454);
	// itinerario.addPunto("la direccion", "la observacion", 4, 11);
	// itinerario.addPunto("la direccion", "la observacion", 5, 879.00);
	// itinerario.addPunto("la direccion", "la observacion", 6, 0.1);
	// itinerario.addPunto("la direccion", "la observacion", 7, 11);
	// itinerario.addPunto("la direccion", "la observacion", 8, 879.00);
	// itinerario.addPunto("la direccion", "la observacion", 9, 0.1);
	// itinerario.addPunto("la direccion", "la observacion", 10, 0.1);
	// itinerario.addPunto("la direccion", "la observacion", 11, 879.00);
	// itinerario.addPunto("la direccion", "la observacion", 12, 0.1);
	// itinerario.addPunto("la direccion", "la observacion", 13, 0.1);
	// itinerario.addPunto("la direccion", "la observacion", 14, 0.1);
	// itinerario.addPunto("la direccion", "la observacion", 15, 0.1);
	//
	// ImprimirItinerario(itinerario);
	// }

	/*
	 * private static void ticketComandaTest() throws Exception {
	 * ObjComandaTicket comanda = new ObjComandaTicket(new ObjDatosCliente(
	 * "Pepe", "CCC 888", "0303456"), "12/12/12", 33, "Objseraskjd clienbte ",
	 * "obs delivery", null); List<ObjProductoTicketComanda> a = new
	 * ArrayList<ObjProductoTicketComanda>(); a.add(new
	 * ObjProductoTicketComanda(1, 50, "mat", "unidad", "3")); a.add(new
	 * ObjProductoTicketComanda(2, 50, "materia", "unidad", "3")); a.add(new
	 * ObjProductoTicketComanda(30, 50, "materia", "unidad", "3"));
	 * 
	 * a.add(new ObjProductoTicketComanda(40, 50, "materia", "unidad", "3"));
	 * a.add(new ObjProductoTicketComanda(50, 50, "materia", "unidad", "3"));
	 * a.add(new ObjProductoTicketComanda(60, 50, "materia", "unidad", "3"));
	 * a.add(new ObjProductoTicketComanda(70, 50, "materia", "unidad", "3"));
	 * a.add(new ObjProductoTicketComanda(80, 50, "materia", "unidad", "3"));
	 * a.add(new ObjProductoTicketComanda(90, 50, "materia", "unidad", "3"));
	 * a.add(new ObjProductoTicketComanda(100, 50, "materia", "unidad", "3"));
	 * a.add(new ObjProductoTicketComanda(110, 50, "materia", "unidad", "3"));
	 * a.add(new ObjProductoTicketComanda(120, 50, "materia", "unidad", "3"));
	 * a.add(new ObjProductoTicketComanda(130, 50, "materia", "unidad", "3"));
	 * a.add(new ObjProductoTicketComanda(140, 50, "materia", "unidad", "3"));
	 * comanda.setListaProductos(a);
	 * 
	 * ImprimirComandaTicket(comanda); }
	 */

	public static void ImprimirSolicitudMP(ObjReporteSolicitudMP solicitud)
			throws IOException, DocumentException {
		int totalHojas = solicitud.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaSolicitudMP(solicitud, i, totalHojas);
		}
	}

	public static void ImprimirComandaTicket(ObjReporteComandaTicket comanda)
			throws IOException, DocumentException {
		int totalHojas = comanda.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaComandaTicket(comanda, i, totalHojas);
		}
	}

	public static void ImprimirItinerario(ObjReporteItinerario itinerario)
			throws Exception {
		int totalHojas = itinerario.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaItinerario(itinerario, i, totalHojas);
		}
	}

	// TOTEST:

//	public static void ImprimirReporteVentas(ObjReporteVentas reporte)
//			throws Exception {
//		int totalHojas = reporte.getCantidadHojas();
//		for (int i = 1; i <= totalHojas; i++) {
//			imprimirHojaReporteVentas(reporte, i, totalHojas);
//		}
//	}

	public static void ImprimirReporteVentas(ObjReporteVentass reporte)
			throws Exception {
		int totalHojas = reporte.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaReporteVentas(reporte, i, totalHojas);
		}
	}

	public static void ImprimirReporteReparto(ObjReporteReparto reporte)
			throws Exception {
		int totalHojas = reporte.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaReporteReparto(reporte, i, totalHojas);
		}
	}

	public static void ImprimirReporteMejoresClientes(
			ObjReporteMejoresClientes reporte) throws IOException,
			DocumentException {
		initAll(reporte, 1);

		llenarStamperReporteMejoresClientes(reporte);

		closeAll();
		imprimir();
	}

	// REGION REPORTE REPARTO
	private static void imprimirHojaReporteReparto(ObjReporteReparto reporte,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		initAll(reporte, numeroPagina);

		llenarStamperReporteReparto(reporte, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperReporteReparto(ObjReporteReparto reporte,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		llenarCabeceraReporteReparto(reporte);
		double total = llenarReporteReparto(reporte, numeroPagina);
		llenarPieReporteReparto(reporte, total, numeroPagina, totalHojas);

	}

	private static void llenarCabeceraReporteReparto(ObjReporteReparto reporte)
			throws IOException, DocumentException {
		stamper.getAcroFields().setField("txtFecha", reporte.getFecha());
		stamper.getAcroFields().setField("txtRepartidor",
				reporte.getNombreRepartidor());
	}

	private static double llenarReporteReparto(ObjReporteReparto reporte,
			int numeroPagina) throws IOException, DocumentException {
		// txtReparto txtPedido txtCliente txtEntrega txtMonto
		int desde = 0;
		if (numeroPagina != 1)
			desde = ((numeroPagina - 1) * reporte.getMaxPaginacion()) - 1;
		int hasta = (numeroPagina * reporte.getMaxPaginacion()) - 1;
		int puntos = reporte.getRepartos().size();
		hasta = (hasta > puntos) ? puntos : hasta;
		int i = 0;
		double total = 0;
		for (RepartidoReporteDTO reparto : reporte.getRepartos().subList(desde,
				hasta)) {
			stamper.getAcroFields().setField("txtReparto" + i,
					reparto.getReparto() + "");
			stamper.getAcroFields().setField("txtPedido" + i,
					reparto.getPedido() + "");
			stamper.getAcroFields().setField("txtCliente" + i,
					reparto.getCliente());
			stamper.getAcroFields().setField("txtEntrega" + i,
					reparto.getEntregado());
			stamper.getAcroFields().setField("txtMonto" + i,
					reparto.getMonto() + "");
		}
		for (RepartidoReporteDTO reparto : reporte.getRepartos()) {
			total += reparto.getMonto();
		}
		return total;
	}

	private static void llenarPieReporteReparto(ObjReporteReparto reporte,
			double total, int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		// txtPaginado
		stamper.getAcroFields().setField("txtTotal", total + "");
		stamper.getAcroFields().setField("txtPaginado",
				numeroPagina + " DE " + totalHojas);

	}

	// REGION REPORTE VENTAS
	private static void imprimirHojaReporteVentas(ObjReporteVentass reporte,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		initAll(reporte, numeroPagina);

		llenarStamperReporteVentas(reporte, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperReporteVentas(ObjReporteVentass reporte,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		llenarCabeceraReporteVentas(reporte);
		double total = llenarReporteVentas(reporte, numeroPagina);
		llenarPieReporteVentas(reporte, total, numeroPagina, totalHojas);

	}

	private static void llenarCabeceraReporteVentas(ObjReporteVentass reporte)
			throws IOException, DocumentException {
		// txtFamilia txtFecha txtDia txtSemana
		stamper.getAcroFields().setField("txtDesde", reporte.getFechaDesde());
		stamper.getAcroFields().setField("txtHasta", reporte.getFechaHasta());
		// stamper.getAcroFields().setField("txtDia", reporte.getDia() + "");
		// stamper.getAcroFields().setField("txtSemana", reporte.getSemana() +
		// "");
	}

	private static double llenarReporteVentas(ObjReporteVentass reporte,
			int numeroPagina) throws IOException, DocumentException {
		// txtPuesto txtProducto txtVenta
		int desde = 0;
		if (numeroPagina != 1)
			desde = ((numeroPagina - 1) * reporte.getMaxPaginacion()) - 1;
		int hasta = (numeroPagina * reporte.getMaxPaginacion()) - 1;
		int puntos = reporte.getLista().size();
		hasta = (hasta > puntos) ? puntos : hasta;
		int i = 0;
		for (Object product : reporte.getLista().subList(desde, hasta)) {
			VentaReporteDTO producto = (VentaReporteDTO) product;
			stamper.getAcroFields().setField("txtPuesto" + i,
					producto.getPuesto() + "");
			stamper.getAcroFields().setField("txtProducto" + i,
					producto.getProducto());
			stamper.getAcroFields().setField("txtVenta" + i,
					producto.getCantidad() + "");
			i++;
		}
		return 0;
	}

	private static void llenarPieReporteVentas(ObjReporteVentass reporte,
			double total, int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		stamper.getAcroFields().setField("txtPaginado",
				numeroPagina + " DE " + totalHojas);
	}

	// REGION REPORTE VENTASS
	private static void imprimirHojaReporteVentas(ObjReporteVentas reporte,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		initAll(reporte, numeroPagina);

		llenarStamperReporteVentas(reporte, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperReporteVentas(ObjReporteVentas reporte,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		llenarCabeceraReporteVentas(reporte);
		double total = llenarReporteVentas(reporte, numeroPagina);
		llenarPieReporteVentas(reporte, total, numeroPagina, totalHojas);

	}

	private static void llenarCabeceraReporteVentas(ObjReporteVentas reporte)
			throws IOException, DocumentException {
		// txtFamilia txtFecha txtDia txtSemana
		// stamper.getAcroFields().setField("txtFamilia", reporte.getFamilia());
		// stamper.getAcroFields().setField("txtFecha", reporte.getFecha());
		// stamper.getAcroFields().setField("txtDia", reporte.getDia() + "");
		// stamper.getAcroFields().setField("txtSemana", reporte.getSemana() +
		// "");
	}

	private static double llenarReporteVentas(ObjReporteVentas reporte,
			int numeroPagina) throws IOException, DocumentException {
		// txtPuesto txtProducto txtVenta
		int desde = 0;
		if (numeroPagina != 1)
			desde = ((numeroPagina - 1) * reporte.getMaxPaginacion()) - 1;
		int hasta = (numeroPagina * reporte.getMaxPaginacion()) - 1;
		int puntos = reporte.getProductos().size();
		hasta = (hasta > puntos) ? puntos : hasta;
		int i = 0;
		for (VentaReporteDTO producto : reporte.getProductos().subList(desde,
				hasta)) {
			stamper.getAcroFields().setField("txtPuesto" + i,
					producto.getPuesto() + "");
			stamper.getAcroFields().setField("txtProducto" + i,
					producto.getProducto());
			stamper.getAcroFields().setField("txtVenta" + i,
					producto.getCantidad() + "");
			i++;
		}
		return 0;
	}

	private static void llenarPieReporteVentas(ObjReporteVentas reporte,
			double total, int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		stamper.getAcroFields().setField("txtPaginado",
				numeroPagina + " DE " + totalHojas);
	}

	// REGION REPORTE MEJORES CLIENTES

	private static void llenarStamperReporteMejoresClientes(
			ObjReporteMejoresClientes reporte) throws IOException,
			DocumentException {
		llenarCabeceraReporteMejoresClientes(reporte);
		llenarReporteMejoresClientes(reporte);

	}

	private static void llenarCabeceraReporteMejoresClientes(
			ObjReporteMejoresClientes reporte) throws IOException,
			DocumentException {
		stamper.getAcroFields().setField("txtDesde", reporte.getFechaDesde());
		stamper.getAcroFields().setField("txtHasta", reporte.getFechaHasta());
	}

	private static void llenarReporteMejoresClientes(
			ObjReporteMejoresClientes reporte) throws IOException,
			DocumentException {
		// txtPuesto txtCliente txtAcumulado txtUltVenta
		int i = 0;
		for (ClienteReporteDTO cliente : reporte.getClientes()) {
			String nombre = cliente.getNombre() != null ? cliente.getNombre()
					: "";
			String posicion = cliente.getPosicion() != 0 ? cliente
					.getPosicion() + "" : "";
			int precios = cliente.getPrecio();
			boolean esPrecio = precios != 0;
			String precio = esPrecio ? cliente.getPrecio() + "" : "";
			String ultimaVenta = cliente.getFechaUltimaCompra() != null ? cliente
					.getFechaUltimaCompra() : "";
			stamper.getAcroFields().setField("txtPuesto" + i, posicion);
			stamper.getAcroFields().setField("txtCliente" + i, nombre);
			stamper.getAcroFields().setField("txtAcumulado" + i, precio);
			stamper.getAcroFields().setField("txtUltVenta" + i, ultimaVenta);
			i++;
		}
	}

	// REGION SOLICITUD MATERIA PRIMA
	private static void imprimirHojaSolicitudMP(
			ObjReporteSolicitudMP solicitud, int numeroPagina, int totalHojas)
			throws IOException, DocumentException {
		initAll(solicitud, numeroPagina);

		llenarStamperSolicitudMP(solicitud, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperSolicitudMP(
			ObjReporteSolicitudMP solicitud, int numeroPagina, int totalHojas)
			throws IOException, DocumentException {
		llenarCabeceraSolicitudMP(solicitud);
		llenarSolicitudMP(solicitud, numeroPagina);
		llenarPieSolicitudMP(numeroPagina, totalHojas);
	}

	private static void llenarCabeceraSolicitudMP(
			ObjReporteSolicitudMP solicitud) throws IOException,
			DocumentException {
		stamper.getAcroFields().setField("txtFecha", solicitud.getFecha());
		stamper.getAcroFields().setField("txtId", solicitud.getId() + "");

		stamper.getAcroFields().setField("txtTelefonoPizzeria",
				wild.getTelefono());
		stamper.getAcroFields().setField("txtDireccionWild",
				wild.getDireccion());
		ProveedorDTO proveedor = solicitud.getProveedor();
		stamper.getAcroFields().setField("txtMail", proveedor.getMail());
		stamper.getAcroFields().setField("txtTelefonoProveedor",
				proveedor.getTelefono());
		stamper.getAcroFields().setField("txtSolicitante",
				proveedor.getNombre());

	}

	private static void llenarSolicitudMP(ObjReporteSolicitudMP solicitud,
			int numeroPagina) throws IOException, DocumentException {
		int desde = 0;
		if (numeroPagina != 1)
			desde = ((numeroPagina - 1) * solicitud.getMaxPaginacion()) - 1;
		int hasta = (numeroPagina * solicitud.getMaxPaginacion()) - 1;
		int puntos = solicitud.getMateriasPrimas().size();
		hasta = (hasta > puntos) ? puntos : hasta;
		int i = 0;
		for (MateriaPrimaDTO materiaPrima : solicitud.getMateriasPrimas()
				.subList(desde, hasta)) {

			stamper.getAcroFields().setField("txtMP" + i,
					materiaPrima.getNombre());
			stamper.getAcroFields().setField("txtCantidad" + i,
					materiaPrima.getUnidad());
			i++;
		}
	}

	private static void llenarPieSolicitudMP(int numeroPagina, int totalHojas)
			throws IOException, DocumentException {

		stamper.getAcroFields().setField("txtPaginado",
				numeroPagina + " DE " + totalHojas);
	}

	// REGION TICKET-COMANDA
	private static void imprimirHojaComandaTicket(
			ObjReporteComandaTicket comanda, int numeroPagina, int totalHojas)
			throws IOException, DocumentException {
		initAll(comanda, numeroPagina);

		llenarStamperTicketComanda(comanda, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperTicketComanda(
			ObjReporteComandaTicket comanda, int numeroPagina, int totalHojas)
			throws IOException, DocumentException {
		llenarCabeceraComandaTicket(comanda);
		double total = llenarComandaTicket(comanda, numeroPagina);
		llenarPieComandaTicket(comanda, total, numeroPagina, totalHojas);
	}

	private static void llenarCabeceraComandaTicket(
			ObjReporteComandaTicket comanda) throws IOException,
			DocumentException {
		stamper.getAcroFields().setField("txtFechaTicket", comanda.getFecha());
		stamper.getAcroFields().setField("txtFechaComanda", comanda.getFecha());
		stamper.getAcroFields().setField("txtIdComanda", comanda.getId() + "");
		stamper.getAcroFields().setField("txtIdTicket", comanda.getId() + "");

		stamper.getAcroFields().setField("txtTelefonoTicket",
				wild.getTelefono());
		stamper.getAcroFields().setField("txtDireccionWild",
				wild.getDireccion());

		ObjDatosCliente repartidor = comanda.getCliente();

		stamper.getAcroFields().setField("txtClienteTicket",
				repartidor.getNombre());
		stamper.getAcroFields().setField("txtClienteComanda",
				repartidor.getNombre());

		stamper.getAcroFields().setField("txtDireccionClienteTicket",
				repartidor.getDireccion());
		stamper.getAcroFields().setField("txtDireccionClienteComanda",
				repartidor.getDireccion());

		stamper.getAcroFields().setField("txtTelefonoComanda",
				repartidor.getTelefono());

	}

	private static double llenarComandaTicket(ObjReporteComandaTicket comanda,
			int numeroPagina) throws IOException, DocumentException {
		double total = 0;
		int desde = 0;
		if (numeroPagina != 1)
			desde = ((numeroPagina - 1) * comanda.getMaxPaginacion()) - 1;
		int hasta = (numeroPagina * comanda.getMaxPaginacion()) - 1;
		int puntos = comanda.getListaProductos().size();
		hasta = (hasta > puntos) ? puntos : hasta;
		int i = 0;
		double subtotal = 0;
		for (ObjProductoTicketComanda punto : comanda.getListaProductos()
				.subList(desde, hasta)) {

			stamper.getAcroFields().setField("txtCantidad" + i,
					punto.getCantidad() + "");

			stamper.getAcroFields().setField("txtMaterialRemito" + i,
					punto.getMaterial());
			stamper.getAcroFields().setField("txtMaterialComanda" + i,
					punto.getMaterial());

			stamper.getAcroFields().setField("txtPrecio" + i,
					punto.getPrecio() + "");

			subtotal = punto.getPrecio() * punto.getCantidad();

			stamper.getAcroFields().setField("txtSubTotal" + i, subtotal + "");

			stamper.getAcroFields()
					.setField("txtCodigo" + i, punto.getCodigo());
			stamper.getAcroFields().setField("txtUnd" + i, punto.getUnd());
			i++;
		}
		for (ObjProductoTicketComanda punto : comanda.getListaProductos()) {
			total += punto.getPrecio() * punto.getCantidad();
		}
		return total;
	}

	private static void llenarPieComandaTicket(ObjReporteComandaTicket comanda,
			double total, int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		// stamper.getAcroFields().setField("txtTotalComanda", total + "");
		stamper.getAcroFields().setField("txtTotalTicket", total + "");

		stamper.getAcroFields().setField("txtObservacionComanda",
				"Obser: " + comanda.getObservaciones());

		stamper.getAcroFields().setField("txtObservacionDelivery",
				"Obser: " + comanda.getObservacionDelivery());
		stamper.getAcroFields().setField("txtObservacionTicket",
				"Obser: " + comanda.getObservaciones());

		stamper.getAcroFields().setField("txtPaginadoComanda",
				numeroPagina + " DE " + totalHojas);
		stamper.getAcroFields().setField("txtPaginadoTicket",
				numeroPagina + " DE " + totalHojas);
	}

	// REGION ITINERARIO
	private static void imprimirHojaItinerario(ObjReporteItinerario itinerario,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		initAll(itinerario, numeroPagina);

		llenarStamperItinerario(itinerario, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperItinerario(
			ObjReporteItinerario itinerario, int numeroPagina, int totalHojas)
			throws IOException, DocumentException {
		llenarCabeceraItinerario(itinerario);
		llenarItinerario(itinerario, numeroPagina);
		llenarPieItinerario(itinerario, numeroPagina, totalHojas);
	}

	private static void llenarCabeceraItinerario(ObjReporteItinerario itinerario)
			throws IOException, DocumentException {
		stamper.getAcroFields().setField("txtFecha", itinerario.getFecha());
		stamper.getAcroFields().setField("txtId", itinerario.getId() + "");
		ObjDatosRepartidor repartidor = itinerario.getRepartidor();
		stamper.getAcroFields().setField("txtRepartidor",
				repartidor.getNombre());
		stamper.getAcroFields().setField("txtVehiculo",
				repartidor.getDatosVehiculo());
		stamper.getAcroFields().setField("txtTelefono",
				repartidor.getNumTelefono());

	}

	private static void llenarItinerario(ObjReporteItinerario itinerario,
			int numeroPagina) throws IOException, DocumentException {
		int desde = 0;
		if (numeroPagina != 1)
			desde = ((numeroPagina - 1) * itinerario.getMaxPaginacion()) - 1;
		int hasta = (numeroPagina * itinerario.getMaxPaginacion()) - 1;
		int puntos = itinerario.getPuntos().size();
		hasta = (hasta > puntos) ? puntos : hasta;
		int i = 0;
		for (objPuntoItinerario punto : itinerario.getPuntos().subList(desde,
				hasta)) {
			stamper.getAcroFields().setField("txtPedido" + i,
					punto.getNumPedido() + "");
			stamper.getAcroFields().setField("txtDireccion" + i,
					punto.getDireccion());
			stamper.getAcroFields().setField("txtObservacion" + i,
					punto.getObservaciones());
			stamper.getAcroFields().setField("txtTotal" + i,
					"$" + punto.getCosto());
			i++;
		}
	}

	private static void llenarPieItinerario(ObjReporteItinerario itinerario,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		String decimalValue = formato.format(itinerario.getTotal()).replace(
				",", ".");
		double total = new Double(decimalValue);
		stamper.getAcroFields().setField("txtTotal", "$" + total);
		// stamper.getAcroFields().setField("txtObservaciones",
		// "Obser: " + itinerario.getObservacionGral());
		stamper.getAcroFields().setField("txtPaginacion",
				numeroPagina + " DE " + totalHojas);
	}

	// REGION GENERAL

	private static void initAll(ObjImprimible reporte, int numeroPagina)
			throws IOException, FileNotFoundException, DocumentException {
		pdfTemplate = getPdfreader(reporte);
		pdfOut = getPdfOut(reporte, numeroPagina);
		stamper = getStamper();
	}

	private static PdfStamper getStamper() throws DocumentException,
			IOException {
		PdfStamper stamper = new PdfStamper(pdfTemplate, pdfOut);

		stamper.setFormFlattening(false);
		return stamper;
	}

	private static FileOutputStream getPdfOut(ObjImprimible imprimible,
			int numeroPagina) throws FileNotFoundException {
		pdfResultPath = String.format(resultPath, imprimible.getNombreArchivo()
				+ "_" + numeroPagina);
		FileOutputStream pdfOut = new FileOutputStream(pdfResultPath);
		return pdfOut;
	}

	private static PdfReader getPdfreader(ObjImprimible itinerario)
			throws IOException {
		String templatePath = String.format(tempPath,
				itinerario.getTemplateName());

		PdfReader pdfTemplate = new PdfReader(templatePath);
		return pdfTemplate;
	}

	private static void closeAll() throws DocumentException, IOException {
		stamper.close();
		pdfTemplate.close();
	}

	private static void imprimir() throws IOException {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(pdfResultPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (inputStream == null) {
			return;
		}

		DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		Doc document = new SimpleDoc(inputStream, docFormat, null);

		PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

		PrintService defaultPrintService = PrintServiceLookup
				.lookupDefaultPrintService();

		if (defaultPrintService != null) {
			DocPrintJob printJob = defaultPrintService.createPrintJob();
			try {
				printJob.print(document, attributeSet);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("No existen impresoras instaladas");
		}

		inputStream.close();
	}
}
