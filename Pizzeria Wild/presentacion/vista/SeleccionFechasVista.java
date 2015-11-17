package vista;

import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class SeleccionFechasVista extends JDialog {
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnPorDia;
	private JComboBox cbxDia;
	private JRadioButton rdbtnRangoDeFechas;
	private JComboBox cbxFrom;
	private JComboBox cbxTo;
	private JButton btnAceptar;
	private JButton btnCancelar;

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
	
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
