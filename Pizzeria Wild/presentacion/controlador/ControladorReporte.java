package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import clasesImpresiones.Impresiones;
import clasesImpresiones.ObjReporteMejoresClientes;
import clasesImpresiones.ObjReporteReparto;
import clasesImpresiones.ObjReporteVentas;

import dto.ClienteReporteDTO;
import dto.RepartidoReporteDTO;
import dto.VentaReporteDTO;

import modelo.ReportesModelo;

import utilidades.Msj;
import vista.ReporteVista;

public class ControladorReporte implements ActionListener {

	private ControladorVenta ctr;
	private ReporteVista vtReporte;
	private ReportesModelo reportes = new ReportesModelo();
	private String datefrom = "";
	private String dateTo = "";
	private boolean ejecutarReporte;

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

	public void SetRangoFechas(String From, String To) {
		this.datefrom = From;
		this.dateTo = To;
	}

	private void accionVentasDelDia() {
		ControladorVentasDia ctrVentasDia = new ControladorVentasDia(
				this.vtReporte);
		ctrVentasDia.inicializar();
	}

	public void NoEjecutarReporte() {
		this.ejecutarReporte = false;
	}

	private void accionReporteMejoresClientes() {
		this.ejecutarReporte = true;
		ControladorSeleccionFechas ctr = new ControladorSeleccionFechas(this,
				this.vtReporte);
		ctr.Inicializar();
		// NICOF aca, fecha desde y fechaHasta
		// String fechaDesde = "";
		// String fechaHasta = "";
		if (this.ejecutarReporte) {
			List<ClienteReporteDTO> lista;
			try {
				lista = reportes.GetMejoresClientes(this.datefrom, this.dateTo);
				ObjReporteMejoresClientes reporte = new ObjReporteMejoresClientes(
						this.datefrom, this.dateTo, lista);
				try {
					Impresiones.ImprimirReporteMejoresClientes(reporte);
				} catch (Exception e) {
					Msj.error("Error de impresion",
							"La aplicacion a tenido problemas para imprimir el documento");
				}
			} catch (Exception e) {
				Msj.error("Error de coneccion",
						"La aplicacion a tenido problemas para conectarse a la base de datos");
			}
		}
	}

	private void accionReporteRepartidores() {
		// NICOF
		String fecha = "fecha";
		int idRepartidor = 1;
		String nombreRepartidor = "nombreDelReparidro";
		List<RepartidoReporteDTO> lista = null;
		try {
			lista = reportes.GetRepartidores(fecha, idRepartidor);
			ObjReporteReparto reporte = new ObjReporteReparto(fecha,
					nombreRepartidor, lista);
			try {
				Impresiones.ImprimirReporteReparto(reporte);
			} catch (Exception e) {
				Msj.error("Error de impresion",
						"La aplicacion a tenido problemas para imprimir el documento");
			}
		} catch (Exception e) {
			Msj.error("Error de coneccion",
					"La aplicacion a tenido problemas para conectarse a la base de datos");
		}

	}

	private void accionReporteVentas() {

		List<VentaReporteDTO> lista = null;
		try {
			// NICOF
			String condiciones = elegirCondicionesSql();
			lista = reportes.GetVentas(condiciones);
			// NICOF
			String fecha = "";
			String familia = "";
			int dia = 0;
			int semana = 0;
			ObjReporteVentas reporte = new ObjReporteVentas(fecha, familia,
					dia, semana, lista);
			try {
				Impresiones.ImprimirReporteVentas(reporte);
			} catch (Exception e) {
				Msj.error("Error de impresion",
						"La aplicacion a tenido problemas para imprimir el documento");
			}
		} catch (Exception e) {
			Msj.error("Error de coneccion",
					"La aplicacion a tenido problemas para conectarse a la base de datos");
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
			this.accionReporteMejoresClientes();
		} else if (source == this.vtReporte.getBtnRepartidores()) {
			this.accionReporteRepartidores();
		} else if (source == this.vtReporte.getBtnVentas()) {
			this.accionReporteVentas();
		} else if (source == this.vtReporte.getBtnVolver()) {
			accionVolver();
		}
	}

	private static String elegirCondicionesSql() {
		String ret = "";

		return ret;
	}
}
