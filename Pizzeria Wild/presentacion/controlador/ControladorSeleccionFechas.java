package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import utilidades.Fecha;
import utilidades.Msj;
import vista.ReporteVista;
import vista.SeleccionFechasVista;

public class ControladorSeleccionFechas implements ActionListener {

	private ControladorReporte ctrReporte;
	private SeleccionFechasVista vtSeleccion;

	public ControladorSeleccionFechas(ControladorReporte Ctr, ReporteVista Vista) {
		this.ctrReporte = Ctr;

		this.vtSeleccion = new SeleccionFechasVista(Vista);
		addListeners();
	}

	private void addListeners() {
		this.vtSeleccion.getRdbtnPorDia().addActionListener(this);
		this.vtSeleccion.getRdbtnRangoDeFechas().addActionListener(this);
		this.vtSeleccion.getBtnAceptar().addActionListener(this);
		this.vtSeleccion.getBtnCancelar().addActionListener(this);
		this.vtSeleccion.getRdbtnOtro().addActionListener(this);
		this.vtSeleccion.getRdbtnMes().addActionListener(this);
		this.vtSeleccion.getRdbtnSemana().addActionListener(this);
	}

	public void Inicializar() {
		this.GrisarTodo();
		this.vtSeleccion.getRdbtnPorDia().setSelected(true);
		this.vtSeleccion.getCbxDia().setEnabled(true);
		// this.CargarComboBox();

		this.vtSeleccion.Open();
	}

	// @SuppressWarnings("unchecked")
	// private void CargarComboBox() {
	// this.vtSeleccion.getCbxDia().removeAllItems();
	// DefaultComboBoxModel<String> cm = new DefaultComboBoxModel<String>();
	// DefaultComboBoxModel<String> cm1 = new DefaultComboBoxModel<String>();
	// DefaultComboBoxModel<String> cm2 = new DefaultComboBoxModel<String>();
	// for (String s : Fecha.Fechas()) {
	// cm.addElement(s);
	// cm1.addElement(s);
	// cm2.addElement(s);
	// }
	// this.vtSeleccion.getCbxDia().setModel(cm);
	// this.vtSeleccion.getCbxFrom().setModel(cm1);
	// this.vtSeleccion.getCbxTo().setModel(cm2);
	// }

	// REGION GRISAR
	private void GrisarTodo() {
		this.vtSeleccion.getCbxDia().setEnabled(false);

		this.vtSeleccion.getCbxFrom().setEnabled(false);
		this.vtSeleccion.getCbxTo().setEnabled(false);

		this.vtSeleccion.getRdbtnSemana().setEnabled(false);
		this.vtSeleccion.getRdbtnMes().setEnabled(false);
		this.vtSeleccion.getTxtAnio().setValue(Calendar.YEAR);
		this.vtSeleccion.getTxtMes().setMonth(Calendar.MONTH);
		// this.vtSeleccion.getTxtSemana().setText("");
		this.vtSeleccion.getTxtSemana().setEnabled(false);
		this.vtSeleccion.getTxtMes().setEnabled(false);
		this.vtSeleccion.getTxtAnio().setEnabled(false);
	}

	private void DesgrisarDia() {
		this.GrisarTodo();
		this.vtSeleccion.getCbxDia().setEnabled(true);
	}

	private void DesgrisarRango() {
		this.GrisarTodo();
		this.vtSeleccion.getCbxFrom().setEnabled(true);
		this.vtSeleccion.getCbxTo().setEnabled(true);
	}

	private void DesgrisarOtro() {
		this.GrisarTodo();
		this.vtSeleccion.getRdbtnSemana().setEnabled(true);
		this.vtSeleccion.getRdbtnMes().setEnabled(true);
		this.vtSeleccion.getTxtAnio().setEnabled(true);
		this.vtSeleccion.getTxtSemana().setEnabled(true);
	}

	private void DesgrisarSemana() {
		this.vtSeleccion.getTxtSemana().setEnabled(true);
		this.vtSeleccion.getTxtMes().setEnabled(false);

	}

	private void DesgrisarMes() {
		this.vtSeleccion.getTxtSemana().setEnabled(false);
		this.vtSeleccion.getTxtMes().setEnabled(true);

	}

	private void accionAceptar() {
		if (this.vtSeleccion.getRdbtnPorDia().isSelected()) {
			opcionDia();
		} else if (this.vtSeleccion.getRdbtnRangoDeFechas().isSelected()) {
			opcionRangoFechas();
		} else if (this.vtSeleccion.getRdbtnOtro().isSelected()) {
			opcionOtros();
		}
	}

	private void opcionOtros() {
		String[] fechas = null;
		int anio = this.vtSeleccion.getTxtAnio().getYear();
		if (this.vtSeleccion.getRdbtnSemana().isSelected()) {
			fechas = opcionSemana(anio);
		} else if (this.vtSeleccion.getRdbtnMes().isSelected()) {
			fechas = opcionMes(anio);
		} else {
			System.out.println("Estado ilegal en metodo opcionOtros");
			this.ctrReporte.NoEjecutarReporte();
		}
		String from = fechas[0];
		String to = fechas[1];
		this.ctrReporte.EjecutarReporte();
		this.ctrReporte.SetRangoFechas(from, to);
		this.vtSeleccion.Close();
	}

	private String[] opcionSemana(int anio) {
		int numeroSemana = Fecha.numSemana(this.vtSeleccion.getTxtSemana()
				.getDate());
		String[] fechas = Fecha.rangosPorSemana(anio, numeroSemana);
		return fechas;
	}

	private String[] opcionMes(int anio) {
		int numeroMes = this.vtSeleccion.getTxtMes().getMonth();
		String[] fechas = Fecha.rangosPorMes(anio, numeroMes);
		return fechas;
	}

	private void opcionRangoFechas() {
		Date fechaIni = this.vtSeleccion.getCbxFrom().getDate();
		Date fechaFin = this.vtSeleccion.getCbxTo().getDate();
		if (fechaIni.after(fechaFin)) {
			this.ctrReporte.NoEjecutarReporte();
			Msj.advertencia("Rango de Fechas",
					"La fecha de inicio no debe ser mayor que la fecha de fin");
			return;
		}
		String from = Fecha.format(fechaIni);
		String to = Fecha.format(fechaFin);
		this.ctrReporte.SetRangoFechas(from, to);
		this.ctrReporte.EjecutarReporte();
		this.vtSeleccion.Close();
	}

	private void opcionDia() {
		String from = Fecha.format(this.vtSeleccion.getCbxDia().getDate());
		String to = from;
		this.ctrReporte.SetRangoFechas(from, to);
		this.ctrReporte.EjecutarReporte();
		this.vtSeleccion.Close();
	}

	private void Cancelar() {
		this.ctrReporte.NoEjecutarReporte();
		this.vtSeleccion.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == this.vtSeleccion.getBtnCancelar()) {
			this.Cancelar();
		} else if (source == this.vtSeleccion.getRdbtnPorDia()) {
			this.DesgrisarDia();
		} else if (source == this.vtSeleccion.getRdbtnRangoDeFechas()) {
			this.DesgrisarRango();
		} else if (source == this.vtSeleccion.getRdbtnOtro()) {
			this.DesgrisarOtro();
		} else if (source == this.vtSeleccion.getBtnAceptar()) {
			this.accionAceptar();
		} else if (source == this.vtSeleccion.getRdbtnMes()) {
			this.DesgrisarMes();
		} else if (source == this.vtSeleccion.getRdbtnSemana()) {
			this.DesgrisarSemana();
		}
	}

}