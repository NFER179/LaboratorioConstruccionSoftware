package clasesImpresiones;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import clasesImpresiones.ObjDatosRepartidor;
import clasesImpresiones.ObjItinerario.objPuntoItinerario;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import dto.ProductoEnVentaDTO;

public class Impresiones {

	private static String tempPath = "Templates/%s.pdf";
	private static String resultPath = "reportesImpresiones/%s.pdf";

	public static void main(String[] args) {
		try {
			itinerarioTest();
		} catch (Exception e) {
			System.out.println("MACANAS");
		}
	}

	private static void itinerarioTest() throws Exception {
		ObjItinerario itinerario = new ObjItinerario("12/12/12", 33,
				new ObjDatosRepartidor("Pepe", "CCC 888", "0303456"),
				"lleva cambio ");
		itinerario.addPunto("la direccion", "la observacion", 1, 55.4);
		itinerario.addPunto("la direccion", "la observacion", 2, 100);
		itinerario.addPunto("la direccion", "la observacion", 3, 454);
		itinerario.addPunto("la direccion", "la observacion", 4, 11);
		itinerario.addPunto("la direccion", "la observacion", 5, 879.00);
		itinerario.addPunto("la direccion", "la observacion", 6, 0.1);
		itinerario.addPunto("la direccion", "la observacion", 7, 11);
		itinerario.addPunto("la direccion", "la observacion", 8, 879.00);
		itinerario.addPunto("la direccion", "la observacion", 9, 0.1);

		itinerario.addPunto("la direccion", "la observacion", 10, 0.1);

		ImprimirItinerario(itinerario);
	}

	private static void testReporteDiario() throws IOException,
			DocumentException {
		ObjReporteDiario reporte = new ObjReporteDiario("SomeName",
				"13/10/2015", 4);
		reporte.total = 340.4;
		reporte.productos = new ArrayList<ProductoEnVentaDTO>();
		reporte.productos.add(new ProductoEnVentaDTO("Pizza", "Fugazetta", 2));
		reporte.productos.add(new ProductoEnVentaDTO("Faina", "Simple", 14));
		reporte.productos.add(new ProductoEnVentaDTO("Empanada", "Carne", 8));
		reporte.productos.add(new ProductoEnVentaDTO("Pizza", "Muzza", 3));
		ImprimirReporteDiario(reporte);
	}

	public static void ImprimirReporteDiario(ObjReporteDiario reporte)
			throws IOException, DocumentException {
		for (int i = 1; i <= reporte.getCantidadHojas(); i++) {
			imprimirHojaReporteDiario(reporte, i);
		}
	}

	public static void ImprimirComandaTicket(ObjComandaTicket comanda)
			throws IOException, DocumentException {
		for (int i = 1; i <= comanda.getCantidadHojas(); i++) {
			imprimirHojaComandaTicket(comanda, i);
		}
	}

	public static void ImprimirSolicitudMP(ObjSolicitudMP solicitud)
			throws IOException, DocumentException {
		for (int i = 1; i <= solicitud.getCantidadHojas(); i++) {
			imprimirHojaSolicitudMP(solicitud, i);
		}
	}

	public static void ImprimirItinerario(ObjItinerario itinerario)
			throws Exception {
		int totalHojas = itinerario.getCantidadHojas();
		for (int i = 1; i <= totalHojas; i++) {
			imprimirHojaItinerario(itinerario, i, totalHojas);
		}
	}

	public static void generateAshwinFriends() throws IOException,
			FileNotFoundException, DocumentException {
		PdfReader pdfTemplate = new PdfReader("Templates/template_.pdf");
		FileOutputStream fileOutputStream = new FileOutputStream(
				"Templates/test.pdf");

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfStamper stamper = new PdfStamper(pdfTemplate, fileOutputStream);
		stamper.setFormFlattening(true);

		System.out.println("Hola");
		stamper.getAcroFields().setField("txt", "SOME");

		stamper.close();
		pdfTemplate.close();

	}

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
			int numeroPagina) throws IOException, DocumentException {

		String templatePath = String
				.format(tempPath, comanda.getTemplateName());

		PdfReader pdfTemplate = new PdfReader(templatePath);
		String pdfResultPath = String.format(resultPath,
				comanda.getNombreArchivo() + "_" + numeroPagina);
		FileOutputStream pdfOut = new FileOutputStream(pdfResultPath);
		PdfStamper stamper = getStamper(pdfTemplate, pdfOut);

		boolean a = stamper.getAcroFields().setField("txt", comanda.getFecha());

		stamper.close();
		pdfTemplate.close();

	}

	private static void imprimirHojaSolicitudMP(ObjSolicitudMP solicitud,
			int numeroPagina) throws IOException, DocumentException {

		String templatePath = String.format(tempPath,
				solicitud.getTemplateName());

		PdfReader pdfTemplate = new PdfReader(templatePath);
		String pdfResultPath = String.format(resultPath,
				solicitud.getNombreArchivo() + "_" + numeroPagina);
		FileOutputStream pdfOut = new FileOutputStream(pdfResultPath);
		PdfStamper stamper = getStamper(pdfTemplate, pdfOut);

		// boolean a = stamper.getAcroFields().setField("txt",
		// solicitud.getFecha());

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

	private static void llenarStamperItinerario(ObjItinerario itinerario,
			int numeroPagina, int totalHojas, PdfStamper stamper)
			throws IOException, DocumentException {
		llenarCabecera(itinerario, stamper);
		double total = llenarItinerario(itinerario, numeroPagina, stamper);
		llenarPie(itinerario, stamper, total, numeroPagina, totalHojas);
	}

	private static void llenarCabecera(ObjItinerario itinerario,
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
		int desde = (numeroPagina - 1) * itinerario.getMaxPaginacion();
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
