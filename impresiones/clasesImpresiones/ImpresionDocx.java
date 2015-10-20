package clasesImpresiones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import clasesImpresiones.ObjItinerario.objPuntoItinerario;
import clasesImpresiones.ObjSolicitudMP.ObjMateriaPrima;
import clasesImpresiones.ObjTicketCliente.ObjProductoTicket;
import dto.ProductoEnVentaDTO;

public class ImpresionDocx {

	private static String mascaraProducto = "PRODUCTO:  %s , SABOR:  %s, CANTIDAD:  %s";

	public static void ImprimirReporteDiario(ObjReporte reporte) {
		try {
			@SuppressWarnings("resource")
			XWPFDocument documento = new XWPFDocument();
			XWPFParagraph parrafoTitulo = documento.createParagraph();
			XWPFRun runTitulo = parrafoTitulo.createRun();
			parrafoTitulo.setAlignment(ParagraphAlignment.CENTER);
			runTitulo.setFontFamily("Calisto MT");
			runTitulo.setFontSize(30);
			runTitulo.setText("REPORTE DIARIO DEL " + reporte.fecha);

			XWPFParagraph parrafoListado = documento.createParagraph();
			XWPFRun run = parrafoListado.createRun();
			run.setFontSize(18);
			run.setText("Listado del productos vendidos el dia de la fecha:");
			run.addBreak();

			XWPFParagraph parrafoProductos = documento.createParagraph();
			XWPFRun runProductos = parrafoProductos.createRun();
			for (ProductoEnVentaDTO producto : reporte.productos) {
				String prod = "* " + String.format(mascaraProducto, producto.getProducto(), producto.getSabor(),
						producto.getCantidad());
				runProductos.setText(prod);
				runProductos.addBreak();
			}
			XWPFParagraph parrafoTotal = documento.createParagraph();
			XWPFRun runTotal = parrafoTotal.createRun();
			parrafoTotal.setAlignment(ParagraphAlignment.CENTER);
			runTotal.setBold(true);
			runTotal.setFontSize(20);
			runTotal.addBreak();
			runTotal.setText("TOTAL = " + reporte.total);

			FileOutputStream fos = crearFOS(reporte.nombre);
			documento.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ImprimirComanda(ObjComanda comanda) {
		try {
			XWPFDocument documento = new XWPFDocument();
			XWPFParagraph parrafoTitulo = documento.createParagraph();// crearParagrafo(documento);
			parrafoTitulo.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun runTitulo = parrafoTitulo.createRun();
			runTitulo.setBold(true);
			runTitulo.setShadow(true);
			runTitulo.setFontSize(30);
			runTitulo.setFontFamily("Calisto MT");
			runTitulo.setText("PIZZERIA WILD");

			XWPFParagraph parrafoFecha = documento.createParagraph();
			XWPFRun runFecha = parrafoFecha.createRun();
			runFecha.setBold(true);
			runFecha.setItalic(true);
			runFecha.setFontSize(16);
			runFecha.setText(comanda.fecha);
			runFecha.addBreak();
			runFecha.setText(comanda.hora);

			escribirTablaProductos(comanda, documento);

			XWPFParagraph parrafoDescripcion = crearParagrafo(documento);
			parrafoDescripcion.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun runDescripcion = parrafoDescripcion.createRun();
			runDescripcion.setFontSize(14);
			runDescripcion.setItalic(true);
			runDescripcion.setText("OBSERVACIONES : ");
			runDescripcion.addBreak();
			runDescripcion.setText(comanda.observaciones);
			FileOutputStream fos = crearFOS(comanda.nombre);
			documento.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ImprimirTicketCliente(ObjTicketCliente ticketCliente) {
		try {
			@SuppressWarnings("resource")
			XWPFDocument documento = new XWPFDocument();
			XWPFParagraph parrafoTitulo = documento.createParagraph();// crearParagrafo(documento);
			parrafoTitulo.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun runTitulo = parrafoTitulo.createRun();
			runTitulo.setBold(true);
			runTitulo.setShadow(true);
			runTitulo.setFontSize(30);
			runTitulo.setFontFamily("Calisto MT");
			runTitulo.setText("PIZZERIA WILD");
			runTitulo.addBreak();
			runTitulo.setText("----------------------------------------");

			XWPFParagraph parrafoFecha = documento.createParagraph();
			XWPFRun runFecha = parrafoFecha.createRun();
			runFecha.setBold(true);
			runFecha.setItalic(true);
			runFecha.setFontSize(16);
			runFecha.setText("Fecha: " + ticketCliente.fecha);
			runFecha.addBreak();
			runFecha.setText("Email : wildprizzeria@gmail.com");
			runFecha.addBreak();
			runFecha.setText("--------------------------------------------------------------------------------------");

			XWPFTable tabla = documento.createTable();
			XWPFTableRow filaCabecera = tabla.getRow(0);
			filaCabecera.getCell(0).setText("DESCRIPCION");
			filaCabecera.addNewTableCell().setText("CANTIDAD");
			filaCabecera.addNewTableCell().setText("PRECIO");
			filaCabecera.addNewTableCell().setText("TOTAL");
			for (int i = 0; i < ticketCliente.productos.size(); i++) {
				ObjProductoTicket producto = ticketCliente.productos.get(i);
				XWPFTableRow nuevaFila = tabla.createRow();
				nuevaFila.getCell(0).setText(producto.producto);
				nuevaFila.getCell(1).setText(producto.cantidad + "");
				nuevaFila.getCell(2).setText(producto.precio + "");
				nuevaFila.getCell(3).setText(producto.total + "");
			}

			XWPFParagraph parrafoTotal = documento.createParagraph();
			parrafoTotal.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun runTotal = parrafoTotal.createRun();
			runTotal.setBold(true);
			runTotal.setFontSize(18);
			runTotal.setText("TOTAL FACTURA ");
			runTotal.addTab();
			runTotal.setText(ticketCliente.totalFinal + "");

			FileOutputStream fos = crearFOS(ticketCliente.nombreDocumento);
			documento.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ImprimirSolicitudMP(ObjSolicitudMP solicitud) {
		try {
			XWPFDocument documento = new XWPFDocument();
			XWPFParagraph parrafoTitulo = documento.createParagraph();
			parrafoTitulo.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun runTitulo = parrafoTitulo.createRun();
			runTitulo.setBold(true);
			runTitulo.setShadow(true);
			runTitulo.setFontSize(30);
			runTitulo.setFontFamily("Calisto MT");
			runTitulo.setText("PIZZERIA WILD");
			runTitulo.addBreak();
			runTitulo.setText("Solicitud de Materias Primas N°" + solicitud.numSolicitud);

			XWPFParagraph parrafoFecha = documento.createParagraph();
			XWPFRun runFecha = parrafoFecha.createRun();
			runFecha.setBold(true);
			runFecha.setItalic(true);
			runFecha.setFontSize(16);
			runFecha.setText(solicitud.fecha);
			runFecha.addBreak();
			runFecha.setText(solicitud.hora);

			XWPFParagraph parrafoMateriasPrimas = documento.createParagraph();
			XWPFRun runDescripcion = parrafoMateriasPrimas.createRun();
			runDescripcion.setFontSize(14);
			runDescripcion.setItalic(true);
			String mascara = "MATERIA PRIMA:  %s , CANTIDAD:  %s";
			for (ObjMateriaPrima a : solicitud.materiasPrimas) {

				String nuevo = String.format(mascara, a.nombre, a.cantidad);
				runDescripcion.setText(nuevo);
				runDescripcion.addBreak();
			}
			FileOutputStream fos = crearFOS(solicitud.NombreArchivo);
			documento.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ImprimirItinerario(ObjItinerario itinerario) {
		try {
			@SuppressWarnings("resource")
			XWPFDocument documento = new XWPFDocument();
			XWPFParagraph parrafo = documento.createParagraph();
			XWPFRun run = parrafo.createRun();

			for (objPuntoItinerario punto : itinerario.puntos) {
				escribirPunto(run, punto);
			}
			FileOutputStream fos = crearFOS(itinerario.nombreArchivo);
			documento.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void escribirTablaProductos(ObjComanda comanda, XWPFDocument documento) {
		XWPFTable tabla = documento.createTable();
		XWPFTableRow filaCabecera = tabla.getRow(0);
		filaCabecera.getCell(0).setText("CANTIDAD");
		filaCabecera.addNewTableCell().setText("PRODUCTO");
		filaCabecera.addNewTableCell().setText("SABOR");
		for (int i = 0; i < comanda.listaProductos.size(); i++) {
			ProductoEnVentaDTO producto = comanda.listaProductos.get(i);
			XWPFTableRow nuevaFila = tabla.createRow();
			nuevaFila.getCell(0).setText(producto.getCantidad() + "");
			nuevaFila.getCell(1).setText(producto.getProducto());
			nuevaFila.getCell(2).setText(producto.getSabor());
		}
	}

	private static XWPFParagraph crearParagrafo(XWPFDocument documento) {
		XWPFParagraph paragrafo = documento.createParagraph();
		paragrafo.setBorderBottom(Borders.BASIC_BLACK_DOTS);
		paragrafo.setBorderLeft(Borders.BASIC_BLACK_DOTS);
		paragrafo.setBorderRight(Borders.BASIC_BLACK_DOTS);
		paragrafo.setBorderTop(Borders.BASIC_BLACK_DOTS);
		return paragrafo;
	}

	private static void escribirPunto(XWPFRun run, objPuntoItinerario punto) {
		escribirDireccion(run, punto);
		escribirProductos(run, punto);
		run.setText("-----------------------------------------------------");
		run.addBreak();
	}

	private static void escribirDireccion(XWPFRun run, objPuntoItinerario punto) {
		String mascaraDir = "DIRECCION:  %s";
		run.setText(String.format(mascaraDir, punto.getDireccion()));
		run.addBreak();
	}

	private static void escribirProductos(XWPFRun run, objPuntoItinerario punto) {
		for (ProductoEnVentaDTO producto : punto.productos) {
			String textoProducto = String.format(mascaraProducto, producto.getProducto(), producto.getSabor(),
					producto.getCantidad());
			run.setText(textoProducto);
			run.addBreak();
		}
	}

	private static FileOutputStream crearFOS(String NombreArchivo) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(new File(NombreArchivo + ".docx"));
		return fos;
	}
}