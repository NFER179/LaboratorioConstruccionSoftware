package clasesImpresiones;
 
import java.io.ByteArrayOutputStream; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.util.ArrayList;

import clasesImpresiones.ObjDatosRepartidor;
 
import com.itextpdf.text.DocumentException; 
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper; 

import dto.ProductoEnVentaDTO;

public class Impresiones {

	public static void main(String[] args) {
		try {
			itinerarioTest();
		} catch (Exception e) {
			System.out.println("MACANAS");
		}
	}

	private static void itinerarioTest() throws IOException,
			com.lowagie.text.DocumentException, DocumentException {
		ObjItinerario itinerario = new ObjItinerario("Itinerarioioo",
				"12/12/12", 33);
		ObjDatosRepartidor repartidor = new ObjDatosRepartidor("Pepe",
				"CCC 888", "0303456");
		itinerario.setRepartidor(repartidor);
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

	public static void ImprimirReporteDiario(ObjReporteDiario reporte) {

	}

	public static void ImprimirComandaTicket(ObjComandaTicket comanda) {

	}

	public static void ImprimirSolicitudMP(ObjSolicitudMP solicitud) {
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

	public static void ImprimirItinerario(ObjItinerario itinerario)
			throws IOException, DocumentException {
		int maxItems = itinerario.getMaxPaginacion();
		Object cantidadHojas = itinerario.getPuntos().size();
		for (int i = 0; i < maxItems; i++) {
			imprimirHojaItinerario(itinerario, i);
		}

	}

	private static void imprimirHojaItinerario(ObjItinerario itinerario,
			int numeroPagina) throws IOException, DocumentException {
		PdfReader pdfTemplate = new PdfReader(
				"Templates/template_itinerario.pdf");
		FileOutputStream pdfOut = new FileOutputStream("reportesImpresiones/"
				+ itinerario.getFecha() + ".pdf");
		PdfStamper stamper = new PdfStamper(pdfTemplate, pdfOut);
		stamper.setFormFlattening(false);

		boolean a = stamper.getAcroFields().setField("txtFecha",
				itinerario.getFecha());
		boolean b = stamper.getAcroFields().setField("txtId",
				itinerario.getId() + "");
		boolean c = stamper.getAcroFields().setField("txtFecha",
				itinerario.getFecha());
		boolean d = stamper.getAcroFields().setField("txtFecha",
				itinerario.getFecha());
		stamper.close();
		pdfTemplate.close();
	}
}
