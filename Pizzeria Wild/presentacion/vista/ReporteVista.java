package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ReporteVista extends JFrame {

	private JPanel contentPane;
	private JButton btnVentasDelDia;
	
	private JButton btnVolver;
	private JButton btnMejoresClientes;
	private JButton btnRepartidores;
	private JComboBox comboBox;
	private JButton btnVentas;

	public ReporteVista() {
		setResizable(false);
		setTitle("Reportes");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		btnVentasDelDia = new JButton("Ventas del Dia");
		btnVentasDelDia.setBounds(10, 11, 114, 23);
		contentPane.add(btnVentasDelDia);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(345, 234, 89, 23);
		contentPane.add(btnVolver);
		
		btnMejoresClientes = new JButton("Mejores Clientes");
		btnMejoresClientes.setBounds(10, 45, 114, 23);
		contentPane.add(btnMejoresClientes);
		
		btnRepartidores = new JButton("Repartidores");
		btnRepartidores.setBounds(10, 77, 114, 23);
		contentPane.add(btnRepartidores);
		
		btnVentas = new JButton("Ventas");
		btnVentas.setBounds(10, 111, 114, 23);
		contentPane.add(btnVentas);
		
		comboBox = new JComboBox();
		comboBox.setBounds(134, 78, 145, 20);
		contentPane.add(comboBox);
	}

	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JButton getBtnVentasDelDia() {
		return btnVentasDelDia;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public JButton getBtnMejoresClientes() {
		return btnMejoresClientes;
	}

	public JButton getBtnRepartidores() {
		return btnRepartidores;
	}

	public JButton getBtnVentas() {
		return btnVentas;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
}
