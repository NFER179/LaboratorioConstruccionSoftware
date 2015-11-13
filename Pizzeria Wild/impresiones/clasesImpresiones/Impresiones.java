package clasesImpresiones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import clasesImpresiones.ObjDatosRepartidor;
import clasesImpresiones.ObjItinerario.objPuntoItinerario;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import dto.MateriaPrimaDTO;
import dto.ProveedorDTO;

public class Impresiones {

	private static String tempPath = "Templates/%s.pdf";
	private static String resultPath = "reportesImpresiones/%s.pdf";
	private static String pdfResultPath;
	private static PdfReader pdfTemplate;
	private static FileOutputStream pdfOut;
	private static PdfStamper stamper;
	private static ObjDatosPizzeria wild = new ObjDatosPizzeria();

	// public static void main(String[] args) {
	// try {
	// solicitudMPTest();
	// } catch (Exception e) {
	// System.out.println("MACANAS");
	// System.out.println(e.toString());
	// }
	// }
	//
	// private static void solicitudMPTest() throws Exception {
	// ProveedorDTO proveedor = new ProveedorDTO("IDPROVEEDOR", "NOmbre",
	// "1234", "micho@gmail.com");
	// ObjSolicitudMP solicitud = new ObjSolicitudMP("12-12-12", 22, proveedor);
	// solicitud.addMateriaPrima("LECHE", "Unidad1");
	// solicitud.addMateriaPrima("LECHE", "Unidad2");
	// solicitud.addMateriaPrima("LECHE", "Unidad3");
	// solicitud.addMateriaPrima("LECHE", "Unidad4");
	// solicitud.addMateriaPrima("LECHE", "Unidad5");
	// solicitud.addMateriaPrima("LECHE", "Unidad6");
	// solicitud.addMateriaPrima("LECHE", "Unidad7");
	// solicitud.addMateriaPrima("LECHE", "Unidad8");
	// solicitud.addMateriaPrima("LECHE", "Unidad9");
	// solicitud.addMateriaPrima("LECHE", "Unidad10");
	// solicitud.addMateriaPrima("LECHE", "Unidad11");
	// solicitud.addMateriaPrima("LECHE", "Unidad12");
	// solicitud.addMateriaPrima("LECHE", "Unidad13");
	// solicitud.addMateriaPrima("LECHE", "Unidad14");
	// solicitud.addMateriaPrima("LECHE", "Unidad15");
	// solicitud.addMateriaPrima("LECHE", "Unidad16");
	// solicitud.addMateriaPrima("LECHE", "Unidad17");
	// solicitud.addMateriaPrima("LECHE", "Unidad18");
	// solicitud.addMateriaPrima("LECHE", "Unidad19");
	// solicitud.addMateriaPrima("LECHE", "Unidad20");
	// solicitud.addMateriaPrima("LECHE", "Unidad21");
	// solicitud.addMateriaPrima("LECHE", "Unidad22");
	// solicitud.addMateriaPrima("LECHE", "Unidad23");
	// solicitud.addMateriaPrima("LECHE", "Unidad24");
	// solicitud.addMateriaPrima("LECHE", "Unidad25");
	// solicitud.addMateriaPrima("LECHE", "Unidad26");
	// solicitud.addMateriaPrima("LECHE", "Unidad27");
	// solicitud.addMateriaPrima("LECHE", "Unidad28");
	// solicitud.addMateriaPrima("LECHE", "Unidad29");
	// solicitud.addMateriaPrima("LECHE", "Unidad30");
	// solicitud.addMateriaPrima("LECHE", "Unidad31");
	// solicitud.addMateriaPrima("LECHE", "Unidad32");
	// solicitud.addMateriaPrima("LECHE", "Unidad33");
	// solicitud.addMateriaPrima("LECHE", "Unidad34");
	// solicitud.addMateriaPrima("LECHE", "Unidad35");
	// solicitud.addMateriaPrima("LECHE", "Unidad36");
	// ImprimirSolicitudMP(solicitud);
	// }
	//
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

	public static void ImprimirSolicitudMP(ObjSolicitudMP solicitud)
			throws IOException, DocumentException {
		int totalHojas = solicitud.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaSolicitudMP(solicitud, i, totalHojas);
		}
	}

	public static void ImprimirComandaTicket(ObjComandaTicket comanda)
			throws IOException, DocumentException {
		int totalHojas = comanda.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaComandaTicket(comanda, i, totalHojas);
		}
	}

	public static void ImprimirItinerario(ObjItinerario itinerario)
			throws Exception {
		int totalHojas = itinerario.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaItinerario(itinerario, i, totalHojas);
		}
	}

	// TOTEST:

	public static void ImprimirReporteVentas(ObjReporteVentas reporte)
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

	// REGION REPORTE VENTAS
	private static void imprimirHojaReporteReparto(ObjReporteReparto reporte,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		initAll(reporte, numeroPagina);

		llenarStamperReporteReparto(reporte, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperReporteReparto(ObjReporteReparto reporte,
			int numeroPagina, int totalHojas) {
		llenarCabeceraReporteReparto(reporte);
		double total = llenarReporteReparto(reporte, numeroPagina);
		llenarPieReporteReparto(reporte, total, numeroPagina, totalHojas);

	}

	private static void llenarCabeceraReporteReparto(ObjReporteReparto reporte) {
	}

	private static double llenarReporteReparto(ObjReporteReparto reporte,
			int numeroPagina) {
		return 0;
	}

	private static void llenarPieReporteReparto(ObjReporteReparto reporte,
			double total, int numeroPagina, int totalHojas) {

	}

	// REGION REPORTE VENTAS
	private static void imprimirHojaReporteVentas(ObjReporteVentas reporte,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		initAll(reporte, numeroPagina);

		llenarStamperReporteVentas(reporte, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperReporteVentas(ObjReporteVentas reporte,
			int numeroPagina, int totalHojas) {
		llenarCabeceraReporteVentas(reporte);
		double total = llenarReporteVentas(reporte, numeroPagina);
		llenarPieReporteVentas(reporte, total, numeroPagina, totalHojas);

	}

	private static void llenarCabeceraReporteVentas(ObjReporteVentas reporte) {

	}

	private static double llenarReporteVentas(ObjReporteVentas reporte,
			int numeroPagina) {
		return 0;
	}

	private static void llenarPieReporteVentas(ObjReporteVentas reporte,
			double total, int numeroPagina, int totalHojas) {

	}

	// REGION REPORTE MEJORES CLIENTES

	private static void llenarStamperReporteMejoresClientes(
			ObjReporteMejoresClientes reporte) {
		llenarCabeceraReporteMejoresClientes(reporte);
		llenarReporteMejoresClientes(reporte);
		llenarPieReporteMejoresClientes(reporte);

	}

	private static void llenarCabeceraReporteMejoresClientes(
			ObjReporteMejoresClientes reporte) {

	}

	private static void llenarReporteMejoresClientes(
			ObjReporteMejoresClientes reporte) {

	}

	private static void llenarPieReporteMejoresClientes(
			ObjReporteMejoresClientes reporte) {

	}

	// REGION SOLICITUD MATERIA PRIMA
	private static void imprimirHojaSolicitudMP(ObjSolicitudMP solicitud,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		initAll(solicitud, numeroPagina);

		llenarStamperSolicitudMP(solicitud, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperSolicitudMP(ObjSolicitudMP solicitud,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		llenarCabeceraSolicitudMP(solicitud);
		llenarSolicitudMP(solicitud, numeroPagina);
		llenarPieSolicitudMP(numeroPagina, totalHojas);
	}

	private static void llenarCabeceraSolicitudMP(ObjSolicitudMP solicitud)
			throws IOException, DocumentException {
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

	private static void llenarSolicitudMP(ObjSolicitudMP solicitud,
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
	private static void imprimirHojaComandaTicket(ObjComandaTicket comanda,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		initAll(comanda, numeroPagina);

		llenarStamperTicketComanda(comanda, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperTicketComanda(ObjComandaTicket comanda,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		llenarCabeceraComandaTicket(comanda);
		double total = llenarComandaTicket(comanda, numeroPagina);
		llenarPieComandaTicket(comanda, total, numeroPagina, totalHojas);
	}

	private static void llenarCabeceraComandaTicket(ObjComandaTicket comanda)
			throws IOException, DocumentException {
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

	private static double llenarComandaTicket(ObjComandaTicket comanda,
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
			total += subtotal;
			stamper.getAcroFields().setField("txtSubTotal" + i, subtotal + "");

			stamper.getAcroFields()
					.setField("txtCodigo" + i, punto.getCodigo());
			stamper.getAcroFields().setField("txtUnd" + i, punto.getUnd());
			i++;
		}
		return total;
	}

	private static void llenarPieComandaTicket(ObjComandaTicket comanda,
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
	private static void imprimirHojaItinerario(ObjItinerario itinerario,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		initAll(itinerario, numeroPagina);

		llenarStamperItinerario(itinerario, numeroPagina, totalHojas);

		closeAll();
		imprimir();
	}

	private static void llenarStamperItinerario(ObjItinerario itinerario,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		llenarCabeceraItinerario(itinerario);
		llenarItinerario(itinerario, numeroPagina);
		llenarPieItinerario(itinerario, numeroPagina, totalHojas);
	}

	private static void llenarCabeceraItinerario(ObjItinerario itinerario)
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

	private static void llenarItinerario(ObjItinerario itinerario,
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

	private static void llenarPieItinerario(ObjItinerario itinerario,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		stamper.getAcroFields()
				.setField("txtTotal", itinerario.getTotal() + "");
		stamper.getAcroFields().setField("txtObservaciones",
				"Obser: " + itinerario.getObservacionGral());
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

	private static FileOutputStream getPdfOut(ObjImprimible itinerario,
			int numeroPagina) throws FileNotFoundException {
		pdfResultPath = String.format(resultPath, itinerario.getNombreArchivo()
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
