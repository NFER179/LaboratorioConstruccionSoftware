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

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDateChooser;

public class SeleccionFechasVista extends JDialog {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroupMesAnio = new ButtonGroup();
	private JRadioButton rdbtnPorDia;

	private JRadioButton rdbtnRangoDeFechas;

	private JRadioButton rdbtnOtro;

	private JButton btnAceptar;
	private JButton btnCancelar;

	private JLabel lblAo;

	private JRadioButton rdbtnMes;
	private JRadioButton rdbtnSemana;
	private JLabel lblNewLabel;
	private JMonthChooser txtMes;
	private JYearChooser txtAnio;

	private JDateChooser cbxDia;
	private JDateChooser txtSemana;

	private JDateChooser cbxFrom;
	private JDateChooser cbxTo;

	public SeleccionFechasVista(ReporteVista Vista) {
		super(Vista, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				SeleccionFechasVista.class.getResource("/Iconos/pizza_1.PNG")));

		setResizable(false);
		setTitle(" Seleccion Rango Fechas");
		setBounds(100, 100, 356, 401);
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

		rdbtnRangoDeFechas = new JRadioButton("Rango de Fechas");
		rdbtnRangoDeFechas.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnRangoDeFechas);
		rdbtnRangoDeFechas.setBounds(6, 64, 133, 23);
		getContentPane().add(rdbtnRangoDeFechas);

		JLabel lblDesde = new JLabel("Desde: ");
		lblDesde.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDesde.setBounds(30, 97, 85, 14);
		getContentPane().add(lblDesde);

		JLabel lblHasta = new JLabel("Hasta: ");
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHasta.setBounds(30, 128, 46, 14);
		getContentPane().add(lblHasta);

		btnAceptar = new JButton(" Aceptar");
		btnAceptar.setIcon(new ImageIcon(SeleccionFechasVista.class
				.getResource("/Iconos/OK.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(30, 318, 140, 40);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(SeleccionFechasVista.class
				.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(176, 318, 140, 40);
		getContentPane().add(btnCancelar);

		rdbtnOtro = new JRadioButton("Otro");
		rdbtnOtro.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnOtro.setBounds(6, 168, 109, 23);
		getContentPane().add(rdbtnOtro);
		buttonGroup.add(rdbtnOtro);

		lblAo = new JLabel("A\u00F1o:");
		lblAo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAo.setBounds(30, 198, 33, 14);
		getContentPane().add(lblAo);

		rdbtnMes = new JRadioButton("Mes");
		rdbtnMes.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroupMesAnio.add(rdbtnMes);
		rdbtnMes.setBounds(28, 232, 49, 23);
		getContentPane().add(rdbtnMes);

		rdbtnSemana = new JRadioButton("Semana");
		rdbtnSemana.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroupMesAnio.add(rdbtnSemana);
		rdbtnSemana.setBounds(30, 270, 76, 23);
		getContentPane().add(rdbtnSemana);
		rdbtnSemana.setSelected(true);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SeleccionFechasVista.class
				.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(215, 97, 163, 193);
		getContentPane().add(lblNewLabel);

		txtMes = new JMonthChooser();
		txtMes.setBounds(76, 232, 104, 20);
		getContentPane().add(txtMes);

		cbxDia = new JDateChooser();
		cbxDia.setBounds(67, 37, 178, 20);
		getContentPane().add(cbxDia);

		cbxFrom = new JDateChooser();
		cbxFrom.setBounds(67, 94, 178, 20);
		getContentPane().add(cbxFrom);

		cbxTo = new JDateChooser();
		cbxTo.setBounds(67, 122, 178, 20);
		getContentPane().add(cbxTo);

		txtAnio = new JYearChooser();
		txtAnio.setBounds(60, 195, 47, 20);
		// JTextFieldDateEditor editor = (JTextFieldDateEditor)
		// txtAnio.getDateEditor();
		// editor.setEditable(false);
		getContentPane().add(txtAnio);

		txtSemana = new JDateChooser();
		txtSemana.setBounds(106, 270, 169, 20);
		getContentPane().add(txtSemana);

	}

	public JYearChooser getTxtAnio() {
		return txtAnio;
	}

	public void setTxtAnio(JYearChooser txtAnio) {
		this.txtAnio = txtAnio;
	}

	public JMonthChooser getTxtMes() {
		return txtMes;
	}

	public void setTxtMes(JMonthChooser txtMes) {
		this.txtMes = txtMes;
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

	public JRadioButton getRdbtnRangoDeFechas() {
		return rdbtnRangoDeFechas;
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

	public JDateChooser getTxtSemana() {
		return txtSemana;
	}

	public void setTxtSemana(JDateChooser txtSemana) {
		this.txtSemana = txtSemana;
	}

	public JDateChooser getCbxDia() {
		return cbxDia;
	}

	public void setCbxDia(JDateChooser cbxDia) {
		this.cbxDia = cbxDia;
	}

	public JDateChooser getCbxFrom() {
		return cbxFrom;
	}

	public void setCbxFrom(JDateChooser cbxFrom) {
		this.cbxFrom = cbxFrom;
	}

	public JDateChooser getCbxTo() {
		return cbxTo;
	}

	public void setCbxTo(JDateChooser cbxTo) {
		this.cbxTo = cbxTo;
	}

	public JRadioButton getRdbtnSemana() {
		return rdbtnSemana;
	}

	public void setRdbtnSemana(JRadioButton rdbtnSemana) {
		this.rdbtnSemana = rdbtnSemana;
	}
}
