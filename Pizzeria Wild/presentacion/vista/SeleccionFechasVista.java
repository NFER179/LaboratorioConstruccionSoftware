package vista;

import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

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
	private JLabel lblNewLabel;

	public SeleccionFechasVista(ReporteVista Vista) {
		super(Vista, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeleccionFechasVista.class.getResource("/Iconos/pizza_1.PNG")));

		setResizable(false);
		setTitle(" Seleccion Rango Fechas");
		setBounds(100, 100, 356, 430);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		rdbtnPorDia = new JRadioButton("Por dia");
		rdbtnPorDia.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnPorDia);
		rdbtnPorDia.setBounds(6, 7, 109, 23);
		getContentPane().add(rdbtnPorDia);

		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(30, 34, 85, 25);
		getContentPane().add(lblFecha);

		cbxDia = new JComboBox<Object>();
		cbxDia.setEditable(false);
		cbxDia.setBounds(85, 34, 109, 25);
		getContentPane().add(cbxDia);

		rdbtnRangoDeFechas = new JRadioButton("Rango de Fechas");
		rdbtnRangoDeFechas.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnRangoDeFechas);
		rdbtnRangoDeFechas.setBounds(6, 64, 133, 23);
		getContentPane().add(rdbtnRangoDeFechas);

		JLabel lblDesde = new JLabel("Desde: ");
		lblDesde.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDesde.setBounds(30, 97, 85, 14);
		getContentPane().add(lblDesde);

		cbxFrom = new JComboBox<Object>();
		cbxFrom.setEditable(false);
		cbxFrom.setBounds(85, 94, 109, 20);
		getContentPane().add(cbxFrom);

		JLabel lblHasta = new JLabel("Hasta: ");
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHasta.setBounds(30, 140, 46, 14);
		getContentPane().add(lblHasta);

		cbxTo = new JComboBox<Object>();
		cbxTo.setEditable(false);
		cbxTo.setBounds(86, 137, 109, 20);
		getContentPane().add(cbxTo);

		btnAceptar = new JButton(" Aceptar");
		btnAceptar.setIcon(new ImageIcon(SeleccionFechasVista.class.getResource("/Iconos/OK.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(54, 344, 140, 40);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(SeleccionFechasVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(200, 344, 140, 40);
		getContentPane().add(btnCancelar);

		rdbtnOtro = new JRadioButton("Otro");
		rdbtnOtro.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnOtro.setBounds(6, 168, 109, 23);
		getContentPane().add(rdbtnOtro);
		buttonGroup.add(rdbtnOtro);

		lblAo = new JLabel("A\u00F1o:");
		lblAo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAo.setBounds(47, 198, 33, 14);
		getContentPane().add(lblAo);

		rdbtnMes = new JRadioButton("Mes");
		rdbtnMes.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroupMesAnio.add(rdbtnMes);
		rdbtnMes.setBounds(47, 257, 62, 23);
		getContentPane().add(rdbtnMes);

		rdbtnSemana = new JRadioButton("Semana");
		rdbtnSemana.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroupMesAnio.add(rdbtnSemana);
		rdbtnSemana.setBounds(47, 227, 79, 23);
		getContentPane().add(rdbtnSemana);
		rdbtnSemana.setSelected(true);

		txtMes = new JTextField();
		txtMes.setBounds(126, 256, 26, 24);
		getContentPane().add(txtMes);
		txtMes.setColumns(10);

		txtSemana = new JTextField();
		txtSemana.setBounds(126, 227, 26, 23);
		getContentPane().add(txtSemana);
		txtSemana.setColumns(10);

		txtAnio = new JTextField();
		txtAnio.setBounds(76, 194, 39, 23);
		getContentPane().add(txtAnio);
		txtAnio.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SeleccionFechasVista.class.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(177, 150, 163, 193);
		getContentPane().add(lblNewLabel);

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
