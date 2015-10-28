package clasesImpresiones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import clasesImpresiones.ObjDatosRepartidor;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import dto.ProductoEnVentaDTO;

public class Impresiones {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, com.lowagie.text.DocumentException, DocumentException {
		// testReporteDiario();
		itinerarioTest();
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

	public static void Imprimir(ObjImprimible objImprimible)
			throws IOException, com.lowagie.text.DocumentException,
			DocumentException {
		double puntosPorDocumento = 40;
		double cantidadPuntos = 1.0;
		double cantidadDocumentos = cantidadPuntos / puntosPorDocumento;
		String tempPath = "C:\\" + objImprimible.getTipo() + "Temp.html";
		System.out.println("Tengo " + cantidadPuntos + " y corresponden "
				+ cantidadDocumentos);
		for (int i = 0; i < cantidadDocumentos; i++) {
			buildTempFile(objImprimible, tempPath, 1);
			buildPDF(objImprimible, tempPath, 1);
			deleteTemporaryFile(tempPath);
		}
	}

	public static void ImprimirItinerario(ObjItinerario itinerario)
			throws IOException, com.lowagie.text.DocumentException,
			DocumentException {
		double puntosPorDocumento = 40;
		double cantidadPuntos = itinerario.getPuntos().size() * 1.0;
		double cantidadDocumentos = Math.ceil(cantidadPuntos
				/ puntosPorDocumento);
		String tempPath = "C:\\" + itinerario.getTipo() + "Temp.html";
		System.out.println("Tengo " + cantidadPuntos + " y corresponden "
				+ cantidadDocumentos);
		// for (int i = 0; i < cantidadDocumentos; i++) {
		buildTempFile(itinerario, tempPath, 1);
		buildPDF(itinerario, tempPath, 1);
		deleteTemporaryFile(tempPath);
		// }
	}

	private static void buildPDF(ObjImprimible itinerario, String tempPath,
			int numeroPagina) throws DocumentException, FileNotFoundException,
			IOException {
		Document objDocument = new Document();
		PdfWriter objPdfWriter = PdfWriter.getInstance(objDocument,
				new FileOutputStream(itinerario.getRuta(numeroPagina)));
		objDocument.open();
		InputStream fis = new FileInputStream(tempPath);
		// Magia
		XMLWorkerHelper.getInstance()
				.parseXHtml(objPdfWriter, objDocument, fis);
		objDocument.close();
	}

	private static void buildTempFile(ObjImprimible objImprimible,
			String tempPath, int numPagina) throws FileNotFoundException,
			IOException, UnsupportedEncodingException {
		String textoHtml = getHtmlText(objImprimible.getTipo());
		// Debe agregar las filas que sean necesarias

		textoHtml = String.format(textoHtml,
				(Object[]) objImprimible.getParametros(numPagina), numPagina
						+ "");
		PrintWriter writer = new PrintWriter(tempPath, "UTF-8");
		writer.println(textoHtml);
		writer.close();
	}

	private static void deleteTemporaryFile(String path) {
		new File(path).delete();
	}

	private static String getHtmlText(String tipo)
			throws FileNotFoundException, IOException {
		String sCurrentLine;
		// Reemplazar por una ruta fija de donde pueda sacar siempre el template
		BufferedReader br = new BufferedReader(new FileReader("C:\\" + tipo
				+ ".html"));
		String textoHtml = "";
		while ((sCurrentLine = br.readLine()) != null) {
			textoHtml += sCurrentLine.trim();
		}
		br.close();
		return textoHtml;
	}

}
