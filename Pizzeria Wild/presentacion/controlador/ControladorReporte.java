package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import clasesImpresiones.Impresiones;
import clasesImpresiones.ObjReporteMejoresClientes;
import clasesImpresiones.ObjReporteReparto;
import clasesImpresiones.ObjReporteVentas;

import dto.ClienteReporteDTO;
import dto.RepartidoReporteDTO;
import dto.VentaReporteDTO;

import modelo.ReportesModelo;

import vista.ReporteVista;

public class ControladorReporte implements ActionListener {

	private ControladorVenta ctr;
	private ReporteVista vtReporte;
	private ReportesModelo reportes;

	public ControladorReporte(ControladorVenta Ctr) {
		this.ctr = Ctr;
		this.vtReporte = new ReporteVista();
		addListeners();
	}

	private void addListeners() {
		this.vtReporte.getBtnVentasDelDia().addActionListener(this);
		this.vtReporte.getBtnMejoresClientes().addActionListener(this);
		this.vtReporte.getBtnRepartidores().addActionListener(this);
		this.vtReporte.getBtnVentas().addActionListener(this);
		this.vtReporte.getBtnVolver().addActionListener(this);
	}

	public void Inicializar() {
		this.vtReporte.Open();
	}

	private void accionVentasDelDia() {
		ControladorVentasDia ctrVentasDia = new ControladorVentasDia(
				this.vtReporte);
		ctrVentasDia.inicializar();
	}

	private void ReporteMejoresClientes(String fechaDesde, String fechaHasta) {
		List<ClienteReporteDTO> lista = reportes.GetMejoresClientes(fechaDesde,
				fechaHasta);
		ObjReporteMejoresClientes reporte = new ObjReporteMejoresClientes(
				fechaDesde, fechaHasta, lista);
		try {
			Impresiones.ImprimirReporteMejoresClientes(reporte);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ReporteRepartidores(String fecha, int idRepartidor,
			String nombreRepartidor) {
		List<RepartidoReporteDTO> lista = reportes.GetRepartidores(fecha,
				idRepartidor);

		ObjReporteReparto reporte = new ObjReporteReparto(fecha, idRepartidor,
				nombreRepartidor);
		reporte.setRepartos(lista);
		try {
			Impresiones.ImprimirReporteReparto(reporte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ReporteVentas(String fecha, String familia, int dia,
			int semana, String[] condiciones) {
		List<VentaReporteDTO> lista = reportes.GetVentas(condiciones);
		ObjReporteVentas reporte = new ObjReporteVentas(fecha, familia, dia,
				semana);
		reporte.setProductos(lista);
		try {
			Impresiones.ImprimirReporteVentas(reporte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void accionVolver() {
		this.ctr.Return();
		this.vtReporte.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == this.vtReporte.getBtnVentasDelDia()) {
			accionVentasDelDia();
		} else if (source == this.vtReporte.getBtnMejoresClientes()) {
			// NICOF aca, fecha desde y fechaHasta
			this.ReporteMejoresClientes("fechaDesde", "FechaHasta");
		} else if (source == this.vtReporte.getBtnRepartidores()) {
			int id_repartidor = 1;
			this.ReporteRepartidores("fecha", id_repartidor,
					"nombreDelReparidro");
		} else if (source == this.vtReporte.getBtnVentas()) {
			int dia = 0;
			int semana = 0;
			String[] condiciones = new String[2];
			this.ReporteVentas("fecha", "familia", dia, semana, condiciones);
		} else if (source == this.vtReporte.getBtnVolver()) {
			accionVolver();
		}
	}
}
