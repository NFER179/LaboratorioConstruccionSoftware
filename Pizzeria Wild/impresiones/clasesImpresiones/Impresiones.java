package clasesImpresiones;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import dto.ProductoEnVentaDTO;

public class Impresiones {

	private static String path = "C:/%s.pdf";
	private static final Font[] fuentes = {
			new Font(FontFamily.TIMES_ROMAN, 12),
			new Font(FontFamily.TIMES_ROMAN, 18),
			new Font(FontFamily.TIMES_ROMAN, 24),
			new Font(FontFamily.TIMES_ROMAN, 24, Font.BOLD) };

	public static void main(String[] args) throws FileNotFoundException,
			IOException, com.lowagie.text.DocumentException, DocumentException {
		// testReporteDiario();
		itinerarioTest();
	}

	private static void itinerarioTest() throws IOException,
			com.lowagie.text.DocumentException, DocumentException {
		ObjItinerario itinerario = new ObjItinerario("Itinerario", "12/12/12",
				33);
		ImprimirItinerario(itinerario);
	}

	private static void testReporteDiario() throws IOException,
			DocumentException {
		ObjReporteDiario reporte = new ObjReporteDiario("SomeName", "ff", 4);
		reporte.fecha = "13/10/2015";
		reporte.nombre = "REPORTE DIARIO";
		reporte.total = 340.4;
		reporte.productos = new ArrayList<ProductoEnVentaDTO>();
		reporte.productos.add(new ProductoEnVentaDTO("Pizza", "Fugazetta", 2));
		reporte.productos.add(new ProductoEnVentaDTO("Faina", "Simple", 14));
		reporte.productos.add(new ProductoEnVentaDTO("Empanada", "Carne", 8));
		reporte.productos.add(new ProductoEnVentaDTO("Pizza", "Muzza", 3));
		ImprimirReporteDiario(reporte);
	}

	public static void ImprimirReporteDiario(ObjReporteDiario reporte)
			throws FileNotFoundException, IOException, DocumentException {
		Document objDocumento = getDocument(reporte);
		Paragraph objParagrafoFecha = getParrafoFecha(reporte);

		objDocumento.add(objParagrafoFecha);

		objDocumento.close();
	}

	public static void ImprimirComandaTicket(ObjComandaTicket comanda) {

	}

	public static void ImprimirSolicitudMP(ObjSolicitudMP solicitud) {
	}

	public static void ImprimirItinerario(ObjItinerario itinerario)
			throws IOException, com.lowagie.text.DocumentException,
			DocumentException {
		buildHtml(itinerario);

		buildPDF(itinerario);
	}

	private static void buildPDF(ObjItinerario itinerario)
			throws DocumentException, FileNotFoundException, IOException {
		Document objDocument = new Document();
		PdfWriter objPdfWriter = PdfWriter.getInstance(objDocument,
				new FileOutputStream(itinerario.getRuta()));
		objDocument.open();
		InputStream fis = new FileInputStream("C:\\" + itinerario.getTipo()
				+ "Temp.html");
		XMLWorkerHelper.getInstance()
				.parseXHtml(objPdfWriter, objDocument, fis);
		objDocument.close();
	}

	private static void buildHtml(ObjItinerario itinerario)
			throws FileNotFoundException, IOException,
			UnsupportedEncodingException {
		String textoHtml = getHtmlText(itinerario.getTipo());
		// Debe agregar las filas que sean necesarias
		
		textoHtml = String.format(textoHtml, itinerario.getParametros());

		PrintWriter writer = new PrintWriter("C:\\" + itinerario.getTipo()
				+ "Temp.html", "UTF-8");
		writer.println(textoHtml);
		writer.close();
	}

	private static String getHtmlText(String tipo)
			throws FileNotFoundException, IOException {
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader("C:\\" + tipo
				+ ".html"));
		String textoHtml = "";
		while ((sCurrentLine = br.readLine()) != null) {
			textoHtml += sCurrentLine.trim();
		}
		return textoHtml;
	}

	private static Document getDocument(ObjModel reporte)
			throws FileNotFoundException, DocumentException {
		Document objDocumento = new Document(PageSize.A4, 50, 50, 50, 50);
		String newPath = String.format(path, reporte.getNombreArchivo());
		FileOutputStream fos = new FileOutputStream(newPath);
		PdfWriter.getInstance(objDocumento, fos);
		objDocumento.open();
		return objDocumento;
	}

	private static Paragraph getParrafoPizzeriaWild() {
		Paragraph ret = new Paragraph("Pizzeria Wild", fuentes[3]);
		return ret;
	}

	private static Paragraph getParrafoFecha(ObjModel reporte) {
		String fecha = "Fecha: " + reporte.getFecha();
		Paragraph ret = new Paragraph(fecha, fuentes[0]);
		return ret;
	}

	private static Paragraph getParrafoId(ObjModel model) {
		String fecha = "N° " + model.getId();
		return new Paragraph(fecha, fuentes[2]);
	}
}
