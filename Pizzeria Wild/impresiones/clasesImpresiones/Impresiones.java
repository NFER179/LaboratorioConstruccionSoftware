package clasesImpresiones;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import clasesImpresiones.ObjDatosRepartidor;
import clasesImpresiones.ObjItinerario.objPuntoItinerario;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class Impresiones {

	private static String tempPath = "Templates/%s.pdf";
	private static String resultPath = "reportesImpresiones/%s.pdf";

	// public static void main(String[] args) {
	// try {
	// // itinerarioTest();
	// ticketComandaTest();
	// } catch (Exception e) {
	// System.out.println("MACANAS");
	// }
	// }

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
	//
	// private static void ticketComandaTest() throws Exception {
	// ObjComandaTicket comanda = new ObjComandaTicket(new ObjDatosCliente(
	// "Pepe", "CCC 888", "0303456"), "12/12/12", 33,
	// "Objseraskjd clienbte ", "obs delivery", null);
	// List<ObjProductoTicketComanda> a = new
	// ArrayList<ObjProductoTicketComanda>();
	// a.add(new ObjProductoTicketComanda(1, 50, "mat", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(2, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(30, 50, "materia", "unidad", "3"));
	//
	// a.add(new ObjProductoTicketComanda(40, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(50, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(60, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(70, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(80, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(90, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(100, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(110, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(120, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(130, 50, "materia", "unidad", "3"));
	// a.add(new ObjProductoTicketComanda(140, 50, "materia", "unidad", "3"));
	// comanda.setListaProductos(a);
	//
	// ImprimirComandaTicket(comanda);
	// }

	public static void ImprimirReporteDiario(ObjReporteDiario reporte)
			throws IOException, DocumentException {
		int totalHojas = reporte.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaReporteDiario(reporte, i);
		}
	}

	public static void ImprimirComandaTicket(ObjComandaTicket comanda)
			throws IOException, DocumentException {
		int totalHojas = comanda.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaComandaTicket(comanda, i, totalHojas);
		}
	}

	public static void ImprimirSolicitudMP(ObjSolicitudMP solicitud)
			throws IOException, DocumentException {
		// int totalHojas = solicitud.getCantidadHojas();
		// for (int i = 1; i <= solicitud.getCantidadHojas(); i++) {
		// imprimirHojaSolicitudMP(solicitud, i);
		// }
	}

	public static void ImprimirItinerario(ObjItinerario itinerario)
			throws Exception {
		int totalHojas = itinerario.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaItinerario(itinerario, i, totalHojas);
		}
	}

	// public static void generateAshwinFriends() throws IOException,
	// FileNotFoundException, DocumentException {
	// PdfReader pdfTemplate = new PdfReader("Templates/template_.pdf");
	// FileOutputStream fileOutputStream = new FileOutputStream(
	// "Templates/test.pdf");
	//
	// ByteArrayOutputStream out = new ByteArrayOutputStream();
	// PdfStamper stamper = new PdfStamper(pdfTemplate, fileOutputStream);
	// stamper.setFormFlattening(true);
	//
	// System.out.println("Hola");
	// stamper.getAcroFields().setField("txt", "SOME");
	//
	// stamper.close();
	// pdfTemplate.close();
	//
	// }

	private static void imprimirHojaReporteDiario(ObjReporteDiario reporte,
			int numeroPagina) throws IOException, DocumentException {

		String templatePath = String
				.format(tempPath, reporte.getTemplateName());

		PdfReader pdfTemplate = new PdfReader(templatePath);
		String pdfResultPath = String.format(resultPath,
				reporte.getNombreArchivo() + "_" + numeroPagina);
		FileOutputStream pdfOut = new FileOutputStream(pdfResultPath);
		PdfStamper stamper = getStamper(pdfTemplate, pdfOut);

		// boolean a = stamper.getAcroFields().setField("txt",
		// reporte.getFecha());

		stamper.close();
		pdfTemplate.close();

	}

	private static void imprimirHojaComandaTicket(ObjComandaTicket comanda,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		PdfReader pdfTemplate = getPdfreader(comanda);
		FileOutputStream pdfOut = getPdfOut(comanda, numeroPagina);
		PdfStamper stamper = getStamper(pdfTemplate, pdfOut);

		llenarStamperTicketComandaTicket(comanda, numeroPagina, totalHojas,
				stamper);

		stamper.close();
		pdfTemplate.close();

	}

	private static void imprimirHojaItinerario(ObjItinerario itinerario,
			int numeroPagina, int totalHojas) throws IOException,
			DocumentException {

		PdfReader pdfTemplate = getPdfreader(itinerario);
		FileOutputStream pdfOut = getPdfOut(itinerario, numeroPagina);
		PdfStamper stamper = getStamper(pdfTemplate, pdfOut);

		llenarStamperItinerario(itinerario, numeroPagina, totalHojas, stamper);

		stamper.close();
		pdfTemplate.close();
	}

	private static void llenarStamperTicketComandaTicket(
			ObjComandaTicket comanda, int numeroPagina, int totalHojas,
			PdfStamper stamper) throws IOException, DocumentException {
		llenarCabeceraComandaTicket(comanda, stamper);
		double total = llenarComandaTicket(comanda, numeroPagina, stamper);
		llenarPieComandaTicket(comanda, stamper, total, numeroPagina,
				totalHojas);
	}

	private static void llenarCabeceraComandaTicket(ObjComandaTicket comanda,
			PdfStamper stamper) throws IOException, DocumentException {
		stamper.getAcroFields().setField("txtFechaTicket", comanda.getFecha());
		stamper.getAcroFields().setField("txtFechaComanda", comanda.getFecha());
		stamper.getAcroFields().setField("txtIdComanda", comanda.getId() + "");
		stamper.getAcroFields().setField("txtIdTicket", comanda.getId() + "");

		ObjDatosPizzeria wild = ObjDatosPizzeria.getDatos();

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
			int numeroPagina, PdfStamper stamper) throws IOException,
			DocumentException {
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
			PdfStamper stamper, double total, int numeroPagina, int totalHojas)
			throws IOException, DocumentException {

		// GUARDO EL TOTAL

		stamper.getAcroFields().setField("txtTotalComanda", total + "");
		stamper.getAcroFields().setField("txtTotalTicket", total + "");

		stamper.getAcroFields().setField("txtObservacionComanda",
				"Observaciones: " + comanda.getObservaciones());

		stamper.getAcroFields().setField("txtObservacionDelivery",
				"Observaciones: " + comanda.getObservacionDelivery());
		stamper.getAcroFields().setField("txtObservacionTicket",
				"Observaciones: " + comanda.getObservaciones());

		stamper.getAcroFields().setField("txtPaginadoComanda",
				numeroPagina + " DE " + totalHojas);
		stamper.getAcroFields().setField("txtPaginadoTicket",
				numeroPagina + " DE " + totalHojas);
	}

	private static void llenarStamperItinerario(ObjItinerario itinerario,
			int numeroPagina, int totalHojas, PdfStamper stamper)
			throws IOException, DocumentException {
		llenarCabeceraItinerario(itinerario, stamper);
		double total = llenarItinerario(itinerario, numeroPagina, stamper);
		llenarPie(itinerario, stamper, total, numeroPagina, totalHojas);
	}

	private static void llenarCabeceraItinerario(ObjItinerario itinerario,
			PdfStamper stamper) throws IOException, DocumentException {
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

	private static double llenarItinerario(ObjItinerario itinerario,
			int numeroPagina, PdfStamper stamper) throws IOException,
			DocumentException {
		double total = 0;
		int desde = 0;
		if (numeroPagina != 1)
			desde = ((numeroPagina - 1) * itinerario.getMaxPaginacion()) - 1;
		int hasta = (numeroPagina * itinerario.getMaxPaginacion()) - 1;
		int puntos = itinerario.getPuntos().size();
		hasta = (hasta > puntos) ? puntos : hasta;
		int i = 0;
		for (objPuntoItinerario punto : itinerario.getPuntos().subList(desde,
				hasta)) {
			total += punto.getCosto();
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
		return total;
	}

	private static void llenarPie(ObjItinerario itinerario, PdfStamper stamper,
			double total, int numeroPagina, int totalHojas) throws IOException,
			DocumentException {
		// GUARDO EL TOTAL
		stamper.getAcroFields().setField("txtTotal", total + "");
		// OBS GRAL
		stamper.getAcroFields().setField("txtObservaciones",
				"Observaciones: " + itinerario.getObservacionGral());
		stamper.getAcroFields().setField("txtPaginacion",
				numeroPagina + " DE " + totalHojas);
	}

	private static PdfStamper getStamper(PdfReader pdfTemplate,
			FileOutputStream pdfOut) throws DocumentException, IOException {
		PdfStamper stamper = new PdfStamper(pdfTemplate, pdfOut);

		stamper.setFormFlattening(false);
		return stamper;
	}

	private static FileOutputStream getPdfOut(ObjImprimible itinerario,
			int numeroPagina) throws FileNotFoundException {
		String pdfResultPath = String.format(resultPath,
				itinerario.getNombreArchivo() + "_" + numeroPagina);
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
}
