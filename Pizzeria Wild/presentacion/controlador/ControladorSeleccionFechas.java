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
	private ReporteVista vtReporte;

	public ControladorSeleccionFechas(ControladorReporte Ctr, ReporteVista Vista) {
		this.vtReporte = Vista;
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
		this.vtSeleccion.getRdbtnMes().setSelected(true);
		this.vtReporte.Close();
		this.vtSeleccion.Open();
	}

	// REGION GRISAR
	private void GrisarTodo() {
		this.vtSeleccion.getCbxDia().setEnabled(false);
		this.vtSeleccion.getCbxDia().getComponent(0).setEnabled(false);
		this.vtSeleccion.getCbxDia().getComponent(1).setEnabled(false);

		this.vtSeleccion.getCbxFrom().setEnabled(false);
		this.vtSeleccion.getCbxFrom().getComponent(0).setEnabled(false);
		this.vtSeleccion.getCbxFrom().getComponent(1).setEnabled(false);

		this.vtSeleccion.getCbxTo().setEnabled(false);
		this.vtSeleccion.getCbxTo().getComponent(0).setEnabled(false);
		this.vtSeleccion.getCbxTo().getComponent(1).setEnabled(false);

		this.vtSeleccion.getRdbtnSemana().setEnabled(false);
		this.vtSeleccion.getRdbtnMes().setEnabled(false);

		Calendar c = Calendar.getInstance();
		this.vtSeleccion.getTxtAnio().setValue(c.get(Calendar.YEAR));
		this.vtSeleccion.getTxtMes().setMonth(c.get(Calendar.MONTH));
		//
		this.vtSeleccion.getTxtSemana().setEnabled(false);
		this.vtSeleccion.getTxtSemana().getComponent(0).setEnabled(false);
		this.vtSeleccion.getTxtSemana().getComponent(1).setEnabled(false);

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
		this.vtSeleccion.getCbxFrom().getComponent(0).setEnabled(true);
		this.vtSeleccion.getCbxFrom().getComponent(1).setEnabled(true);

		this.vtSeleccion.getCbxTo().setEnabled(true);
		this.vtSeleccion.getCbxTo().getComponent(0).setEnabled(true);
		this.vtSeleccion.getCbxTo().getComponent(1).setEnabled(true);
	}

	private void DesgrisarOtro() {
		this.GrisarTodo();
		this.vtSeleccion.getRdbtnSemana().setEnabled(true);
		this.vtSeleccion.getRdbtnMes().setEnabled(true);
		this.vtSeleccion.getTxtAnio().setEnabled(true);
		this.vtSeleccion.getTxtMes().setEnabled(true);
	}

	private void DesgrisarSemana() {
		this.vtSeleccion.getTxtSemana().setEnabled(true);
		this.vtSeleccion.getTxtMes().setEnabled(false);
		this.vtSeleccion.getTxtSemana().getComponent(0).setEnabled(true);
		this.vtSeleccion.getTxtSemana().getComponent(1).setEnabled(true);
		this.vtSeleccion.getTxtAnio().setEnabled(false);

	}

	private void DesgrisarMes() {
		this.vtSeleccion.getTxtSemana().setEnabled(false);
		this.vtSeleccion.getTxtMes().setEnabled(true);
		this.vtSeleccion.getTxtSemana().getComponent(0).setEnabled(false);
		this.vtSeleccion.getTxtSemana().getComponent(1).setEnabled(false);

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
			return;
		}
		String from = fechas[0];
		String to = fechas[1];
		this.ctrReporte.EjecutarReporte();
		this.ctrReporte.SetRangoFechas(from, to);
		this.vtSeleccion.Close();
		this.ctrReporte.Return();
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
		this.ctrReporte.Return();
	}

	private void opcionDia() {
		String from = Fecha.format(this.vtSeleccion.getCbxDia().getDate());
		String to = from;
		this.ctrReporte.SetRangoFechas(from, to);
		this.ctrReporte.EjecutarReporte();
		this.vtSeleccion.Close();
		this.ctrReporte.Return();
	}

	private void Cancelar() {
		this.ctrReporte.NoEjecutarReporte();
		this.vtSeleccion.Close();
		this.ctrReporte.Return();
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