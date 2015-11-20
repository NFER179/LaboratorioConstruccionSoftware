package vista;

import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SeleccionFechasVista extends JDialog {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroupMesAnio = new ButtonGroup();
	private JRadioButton rdbtnPorDia;

	private JComboBox cbxDia;

	private JRadioButton rdbtnRangoDeFechas;

	private JComboBox cbxFrom;
	private JComboBox cbxTo;

	private JRadioButton rdbtnOtro;

	private JButton btnAceptar;
	private JButton btnCancelar;

	private JLabel lblAo;

	private JRadioButton rdbtnMes;
	private JTextField txtMes;

	private JTextField txtSemana;
	private JRadioButton rdbtnSemana;

	private JTextField txtAnio;

	public SeleccionFechasVista(ReporteVista Vista) {
		super(Vista, true);

		setResizable(false);
		setTitle("Seleccion Rango Fechas");
		setBounds(100, 100, 615, 382);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		rdbtnPorDia = new JRadioButton("Por dia");
		buttonGroup.add(rdbtnPorDia);
		rdbtnPorDia.setBounds(6, 7, 109, 23);
		getContentPane().add(rdbtnPorDia);

		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(30, 37, 85, 14);
		getContentPane().add(lblFecha);

		cbxDia = new JComboBox<Object>();
		cbxDia.setEditable(false);
		cbxDia.setBounds(85, 34, 109, 20);
		getContentPane().add(cbxDia);

		rdbtnRangoDeFechas = new JRadioButton("Rango de Fechas");
		buttonGroup.add(rdbtnRangoDeFechas);
		rdbtnRangoDeFechas.setBounds(6, 64, 133, 23);
		getContentPane().add(rdbtnRangoDeFechas);

		JLabel lblDesde = new JLabel("Desde: ");
		lblDesde.setBounds(30, 97, 85, 14);
		getContentPane().add(lblDesde);

		cbxFrom = new JComboBox<Object>();
		cbxFrom.setEditable(false);
		cbxFrom.setBounds(85, 94, 109, 20);
		getContentPane().add(cbxFrom);

		JLabel lblHasta = new JLabel("Hasta: ");
		lblHasta.setBounds(204, 97, 46, 14);
		getContentPane().add(lblHasta);

		cbxTo = new JComboBox<Object>();
		cbxTo.setEditable(false);
		cbxTo.setBounds(260, 94, 109, 20);
		getContentPane().add(cbxTo);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(411, 319, 89, 23);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(510, 319, 89, 23);
		getContentPane().add(btnCancelar);

		rdbtnOtro = new JRadioButton("Otro");
		rdbtnOtro.setBounds(6, 124, 109, 23);
		getContentPane().add(rdbtnOtro);
		buttonGroup.add(rdbtnOtro);

		lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(47, 154, 33, 14);
		getContentPane().add(lblAo);

		rdbtnMes = new JRadioButton("Mes");
		buttonGroupMesAnio.add(rdbtnMes);
		rdbtnMes.setBounds(47, 213, 62, 23);
		getContentPane().add(rdbtnMes);

		rdbtnSemana = new JRadioButton("Semana");
		buttonGroupMesAnio.add(rdbtnSemana);
		rdbtnSemana.setBounds(47, 183, 79, 23);
		getContentPane().add(rdbtnSemana);
		rdbtnSemana.setSelected(true);

		txtMes = new JTextField();
		txtMes.setBounds(126, 212, 26, 24);
		getContentPane().add(txtMes);
		txtMes.setColumns(10);

		txtSemana = new JTextField();
		txtSemana.setBounds(126, 183, 26, 23);
		getContentPane().add(txtSemana);
		txtSemana.setColumns(10);

		txtAnio = new JTextField();
		txtAnio.setBounds(76, 150, 39, 23);
		getContentPane().add(txtAnio);
		txtAnio.setColumns(10);

	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JRadioButton getRdbtnPorDia() {
		return rdbtnPorDia;
	}

	public JComboBox getCbxDia() {
		return cbxDia;
	}

	public JRadioButton getRdbtnRangoDeFechas() {
		return rdbtnRangoDeFechas;
	}

	public JComboBox getCbxFrom() {
		return cbxFrom;
	}

	public JComboBox getCbxTo() {
		return cbxTo;
	}

	public JRadioButton getRdbtnOtro() {
		return rdbtnOtro;
	}

	public void setRdbtnOtro(JRadioButton rdbtnMesOAo) {
		this.rdbtnOtro = rdbtnMesOAo;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JRadioButton getRdbtnMes() {
		return rdbtnMes;
	}

	public void setRdbtnMes(JRadioButton rdbtnMes) {
		this.rdbtnMes = rdbtnMes;
	}

	public JTextField getTxtMes() {
		return txtMes;
	}

	public void setTxtMes(JTextField txtMes) {
		this.txtMes = txtMes;
	}

	public JTextField getTxtSemana() {
		return txtSemana;
	}

	public void setTxtSemana(JTextField txtSemana) {
		this.txtSemana = txtSemana;
	}

	public JRadioButton getRdbtnSemana() {
		return rdbtnSemana;
	}

	public void setRdbtnSemana(JRadioButton rdbtnSemana) {
		this.rdbtnSemana = rdbtnSemana;
	}

	public JTextField getTxtAnio() {
		return txtAnio;
	}

	public void setTxtAnio(JTextField txtAnio) {
		this.txtAnio = txtAnio;
	}
}
