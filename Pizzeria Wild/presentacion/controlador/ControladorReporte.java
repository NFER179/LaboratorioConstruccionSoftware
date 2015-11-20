package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import clasesImpresiones.Impresiones;
import clasesImpresiones.ObjReporteMejoresClientes;
import clasesImpresiones.ObjReporteReparto;
import clasesImpresiones.ObjReporteVentas;
import dto.ClienteReporteDTO;
import dto.RepartidoReporteDTO;
import dto.RepartidorDTO;
import dto.VentaReporteDTO;
import modelo.RepartidorModelo;
import modelo.ReportesModelo;
import utilidades.Fecha;
import utilidades.Msj;
import vista.ReporteVista;

public class ControladorReporte implements ActionListener {

	private ControladorVenta ctr;
	private ReporteVista vtReporte;
	private ReportesModelo reportes = new ReportesModelo();
	private String datefrom = "";
	private String dateTo = "";
	private RepartidorModelo mdlRepartidor;
	private boolean ejecutarReporte;

	public ControladorReporte(ControladorVenta Ctr) {
		this.ctr = Ctr;
		this.vtReporte = new ReporteVista();
		addListeners();

		this.mdlRepartidor = new RepartidorModelo();
	}

	private void addListeners() {
		this.vtReporte.getBtnVentasDelDia().addActionListener(this);
		this.vtReporte.getBtnMejoresClientes().addActionListener(this);
		this.vtReporte.getBtnRepartidores().addActionListener(this);
		this.vtReporte.getBtnVentas().addActionListener(this);
		this.vtReporte.getBtnVolver().addActionListener(this);
	}

	public void Inicializar() {
		this.CargarComboBox();
		this.vtReporte.Open();
	}

	@SuppressWarnings("unchecked")
	private void CargarComboBox() {
		/* Cargar repartidores */
		this.vtReporte.getComboBox().removeAllItems();

		DefaultComboBoxModel<String> modelCombo = new DefaultComboBoxModel<>();
		for (RepartidorDTO r : this.mdlRepartidor.ObtenerRepartidoresActivos()) {
			modelCombo.addElement(Integer.toString(r.getRepartidorId()));
		}
		this.vtReporte.getComboBox().setModel(modelCombo);
	}

	// REGION COMPARTIDA
	public void SetRangoFechas(String From, String To) {
		this.datefrom = From;
		this.dateTo = To;
	}

	public void NoEjecutarReporte() {
		this.ejecutarReporte = false;
	}

	// REGION ACCIONES
	private void accionVentasDelDia() {
		ControladorVentasDia ctrVentasDia = new ControladorVentasDia(
				this.vtReporte);
		ctrVentasDia.inicializar();
	}

	private void accionReporteMejoresClientes() {
		ControladorSeleccionFechas ctr = new ControladorSeleccionFechas(this,
				this.vtReporte);
		ctr.Inicializar();
		if (this.ejecutarReporte) {
			List<ClienteReporteDTO> lista;
			try {
				lista = reportes.GetMejoresClientes(this.datefrom, this.dateTo);
				if (lista.size() == 0) {
					Msj.info("Informacion",
							"El rango de fechas seleccionadas no devolvieron datos");
				} else {
					ObjReporteMejoresClientes reporte = new ObjReporteMejoresClientes(
							this.datefrom, this.dateTo, lista);
					try {
						Impresiones.ImprimirReporteMejoresClientes(reporte);
					} catch (Exception e) {
						Msj.error("Error de impresion",
								"La aplicacion a tenido problemas para imprimir el documento");
					}
				}
			} catch (Exception e) {
				Msj.error("Error de coneccion",
						"La aplicacion a tenido problemas para conectarse a la base de datos");
			}
		}
	}

	private void accionReporteRepartidores() {
		ControladorSeleccionFechas ctr = new ControladorSeleccionFechas(this,
				this.vtReporte);
		ctr.Inicializar();
		if (this.ejecutarReporte) {
			// NICOF
			int idRepartidor = Integer.parseInt(this.vtReporte.getComboBox()
					.getSelectedItem().toString().trim());
			RepartidorModelo rm = new RepartidorModelo();
			String nombreRepartidor = rm.ObtenerRepartidor(idRepartidor)
					.getApellido()
					+ " "
					+ rm.ObtenerRepartidor(idRepartidor).getNombre();
			List<RepartidoReporteDTO> lista = null;
			try {
				lista = reportes.GetRepartidores(this.datefrom, this.dateTo,
						idRepartidor);
				ObjReporteReparto reporte = new ObjReporteReparto(
						Fecha.CurrentDate(), nombreRepartidor, lista);
				if (lista.size() == 0) {
					Msj.info("Informacion",
							"El rango de fecha y el repartidor seleccionados no devolvieron datos");
				} else {
					try {
						Impresiones.ImprimirReporteReparto(reporte);
					} catch (Exception e) {
						Msj.error("Error de impresion",
								"La aplicacion a tenido problemas para imprimir el documento");
					}
				}

			} catch (Exception e) {
				Msj.error("Error de coneccion",
						"La aplicacion a tenido problemas para conectarse a la base de datos");
			}
		}
	}

	private void accionReporteVentas() {
		ControladorSeleccionFechas ctr = new ControladorSeleccionFechas(this,
				this.vtReporte);
		ctr.Inicializar();
		if (this.ejecutarReporte) {

			try {
				List<VentaReporteDTO> lista = reportes.GetVentas(this.datefrom,
						this.dateTo);
				if (lista.size() == 0) {
					Msj.info("Informacion",
							"El rango de fechas seleccionadas no devolvieron datos");
				} else {
					ObjReporteVentas reporte = new ObjReporteVentas(
							this.datefrom, this.dateTo, lista);
					try {
						Impresiones.ImprimirReporteVentas(reporte);
					} catch (Exception e) {
						Msj.error("Error de impresion",
								"La aplicacion a tenido problemas para imprimir el documento");
					}
				}
			} catch (Exception e) {
				Msj.error("Error de coneccion",
						"La aplicacion a tenido problemas para conectarse a la base de datos");
			}
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

}
