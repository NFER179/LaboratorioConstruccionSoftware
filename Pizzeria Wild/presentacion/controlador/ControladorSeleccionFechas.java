package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

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

		this.CargarComboBox();

		this.vtSeleccion.Open();
	}

	@SuppressWarnings("unchecked")
	private void CargarComboBox() {
		this.vtSeleccion.getCbxDia().removeAllItems();
		DefaultComboBoxModel<String> cm = new DefaultComboBoxModel<String>();
		DefaultComboBoxModel<String> cm1 = new DefaultComboBoxModel<String>();
		DefaultComboBoxModel<String> cm2 = new DefaultComboBoxModel<String>();
		for (String s : Fecha.Fechas()) {
			cm.addElement(s);
			cm1.addElement(s);
			cm2.addElement(s);
		}
		this.vtSeleccion.getCbxDia().setModel(cm);
		this.vtSeleccion.getCbxFrom().setModel(cm1);
		this.vtSeleccion.getCbxTo().setModel(cm2);
	}

	// REGION GRISAR
	private void GrisarTodo() {
		this.vtSeleccion.getCbxDia().setEnabled(false);

		this.vtSeleccion.getCbxFrom().setEnabled(false);
		this.vtSeleccion.getCbxTo().setEnabled(false);

		this.vtSeleccion.getRdbtnSemana().setEnabled(false);
		this.vtSeleccion.getRdbtnMes().setEnabled(false);
		this.vtSeleccion.getTxtAnio().setText("");
		this.vtSeleccion.getTxtMes().setText("");
		this.vtSeleccion.getTxtSemana().setText("");
		this.vtSeleccion.getTxtSemana().setEnabled(false);
		this.vtSeleccion.getTxtMes().setEnabled(false);
		this.vtSeleccion.getTxtAnio().setEnabled(false);
	}

	private void DesgrisarDia() {
		this.GrisarTodo();
		this.vtSeleccion.getCbxDia().setEnabled(true);
		this.vtSeleccion.getCbxDia().setEditable(true);
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

	private void Aceptar() {
		String from = "";
		String to = "";
		if (this.vtSeleccion.getRdbtnPorDia().isSelected()) {
			from = this.vtSeleccion.getCbxDia().getSelectedItem().toString()
					.trim();
			to = from;
		} else if (this.vtSeleccion.getRdbtnRangoDeFechas().isSelected()) {
			from = this.vtSeleccion.getCbxFrom().getSelectedItem().toString()
					.trim();
			to = this.vtSeleccion.getCbxTo().getSelectedItem().toString()
					.trim();
		} else if (this.vtSeleccion.getRdbtnOtro().isSelected()) {
			if (esAnioValido(this.vtSeleccion.getTxtAnio().getText())) {
				String[] fechas = null;
				int anio = Integer.parseInt(this.vtSeleccion.getTxtAnio()
						.getText().trim());
				if (this.vtSeleccion.getRdbtnSemana().isSelected()) {
					if (enteroPositivo(this.vtSeleccion.getTxtSemana()
							.getText())) {
						int numeroSemana = Integer.parseInt(this.vtSeleccion
								.getTxtSemana().getText().trim());
						fechas = Fecha.rangosPorSemana(anio, numeroSemana);

					} else {
						Msj.error("Error",
								"Debe ingresar un numero de semana valido");
						return;
					}
				} else if (this.vtSeleccion.getRdbtnMes().isSelected()) {
					if (esMesValido(this.vtSeleccion.getTxtMes().getText())) {
						int numeroMes = Integer.parseInt(this.vtSeleccion
								.getTxtMes().getText().trim());
						fechas = Fecha.rangosPorMes(anio, numeroMes);
					} else {
						Msj.error("Error", "Debe ingresar un mes valido");
						return;
					}
				}
				from = fechas[0];
				to = fechas[1];
			} else {
				Msj.error("Error", "Debe ingresar un año valido");
				return;
			}

		}
		this.ctrReporte.SetRangoFechas(from, to);
		this.vtSeleccion.Close();
	}

	private void Cancelar() {
		this.ctrReporte.NoEjecutarReporte();
		this.vtSeleccion.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == this.vtSeleccion.getRdbtnPorDia()) {
			this.DesgrisarDia();
		} else if (source == this.vtSeleccion.getRdbtnRangoDeFechas()) {
			this.DesgrisarRango();
		} else if (source == this.vtSeleccion.getRdbtnOtro()) {
			this.DesgrisarOtro();
		} else if (source == this.vtSeleccion.getBtnAceptar()) {
			this.Aceptar();
		} else if (source == this.vtSeleccion.getBtnCancelar()) {
			this.Cancelar();
		} else if (source == this.vtSeleccion.getRdbtnMes()) {
			this.DesgrisarMes();
		} else if (source == this.vtSeleccion.getRdbtnSemana()) {
			this.DesgrisarSemana();
		}
	}

	// REGION UTILS
	private static boolean esMesValido(String mes) {
		if (enteroPositivo(mes)) {
			int valorMes = Integer.parseInt(mes);
			if (valorMes <= 12) {
				return true; // [1,12]
			}
		}
		return false;
	}

	private static boolean esAnioValido(String anio) {
		if (enteroPositivo(anio)) {
			int valorAnio = Integer.parseInt(anio);
			if (valorAnio <= 2200) {
				return true; // [1,12]
			}
		}
		return false;
	}

	private static boolean enteroPositivo(String anio) {
		if (anio != null) {
			anio = anio.trim();
			if (anio != "") {
				try {
					int valorAnio = Integer.parseInt(anio);
					if (valorAnio > 0) {
						return true;
					}
				} catch (Exception e) {
				}
			}
		}
		return false;
	}

}