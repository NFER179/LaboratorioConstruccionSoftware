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
	private boolean ejecutarReporte = true;

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
			String element = r.getNombre() + ", " + r.getApellido() + " - "
					+ Integer.toString(r.getRepartidorId());
			modelCombo.addElement(element);
		}
		this.vtReporte.getComboBox().setModel(modelCombo);
	}

	// REGION COMPARTIDA
	public void fechaFin(String From, String To) {
		this.datefrom = From;
		this.dateTo = To;
	}

	public void NoEjecutarReporte() {
		this.ejecutarReporte = false;
	}

	public void EjecutarReporte() {
		this.ejecutarReporte = true;
	}

	// REGION ACCIONES
	private void accionVentasDelDia() {
		new ControladorVentasDia(this.vtReporte).inicializar();
	}

	private void accionReporteMejoresClientes() {
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
		if (this.ejecutarReporte) {
			Object item = this.vtReporte.getComboBox().getSelectedItem();
			if (item != null) {
				String id = item.toString().trim().split(" - ")[1];
				int idRepartidor = Integer.parseInt(id);
				RepartidorModelo rm = new RepartidorModelo();
				String nombreRepartidor = rm.ObtenerRepartidor(idRepartidor)
						.getApellido()
						+ " "
						+ rm.ObtenerRepartidor(idRepartidor).getNombre();
				List<RepartidoReporteDTO> lista = null;
				try {
					lista = reportes.GetRepartidores(this.datefrom,
							this.dateTo, idRepartidor);
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
			} else
				Msj.error("Error de repartidores",
						"Debe ingresar un repartidor antes de poder realizar el reporte");
		}
	}

	private void accionReporteVentas() {
		if (this.ejecutarReporte) {

			try {
				List<VentaReporteDTO> lista = reportes.GetVentas(this.datefrom,
						this.dateTo);
				boolean laListaEstaVacia = lista.size() == 0;
				if (laListaEstaVacia) {
					Msj.info("Informacion",
							"El rango de fechas seleccionadas no devolvieron datos");
				} else {
					imprimirReporteVentas(lista);
				}
			} catch (Exception e) {
				Msj.error("Error de coneccion",
						"La aplicacion a tenido problemas para conectarse a la base de datos");
			}
		}
	}

	private void imprimirReporteVentas(List<VentaReporteDTO> lista) {
		ObjReporteVentas reporte = new ObjReporteVentas(this.datefrom,
				this.dateTo, lista);
		try {
			Impresiones.ImprimirReporteVentas(reporte);
		} catch (Exception e) {
			Msj.error("Error de impresion",
					"La aplicacion a tenido problemas para imprimir el documento");
		}
	}

	private void accionVolver() {
		this.ctr.Return();
		this.vtReporte.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == this.vtReporte.getBtnVolver()) {
			accionVolver();
			return;
		}
		if (source == this.vtReporte.getBtnVentasDelDia()) {
			this.accionVentasDelDia();
		} else {
			new ControladorSeleccionFechas(this, this.vtReporte).Inicializar();
			if (source == this.vtReporte.getBtnMejoresClientes()) {
				this.accionReporteMejoresClientes();
			} else if (source == this.vtReporte.getBtnRepartidores()) {
				this.accionReporteRepartidores();
			} else if (source == this.vtReporte.getBtnVentas()) {
				this.accionReporteVentas();
			}
		}

	}

	public void SetRangoFechas(String from, String to) {
		this.datefrom = from;
		this.dateTo = to;
	}

	public void Return() {
		this.vtReporte.Open();
	}

}
