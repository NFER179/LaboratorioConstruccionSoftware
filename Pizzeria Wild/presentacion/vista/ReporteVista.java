package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ReporteVista extends JFrame {

	private JPanel contentPane;
	private JButton btnVentasDelDia;
	
	private JButton btnVolver;
	private JButton btnMejoresClientes;
	private JButton btnRepartidores;
	private JComboBox comboBox;
	private JButton btnVentas;
	private JLabel lblNewLabel;

	public ReporteVista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReporteVista.class.getResource("/Iconos/pizza_1.PNG")));
		setTitle(" Reportes");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 341, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		btnVentasDelDia = new JButton("Ventas del Dia");
		btnVentasDelDia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVentasDelDia.setBounds(10, 158, 140, 40);
		contentPane.add(btnVentasDelDia);
		
		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(ReporteVista.class.getResource("/Iconos/Volver.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(184, 302, 140, 40);
		contentPane.add(btnVolver);
		
		btnMejoresClientes = new JButton(" Top Clientes");
		btnMejoresClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMejoresClientes.setBounds(10, 229, 140, 40);
		contentPane.add(btnMejoresClientes);
		
		btnRepartidores = new JButton("Repartidores");
		btnRepartidores.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRepartidores.setBounds(10, 11, 140, 40);
		contentPane.add(btnRepartidores);
		
		btnVentas = new JButton("Ventas");
		btnVentas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVentas.setBounds(10, 81, 140, 40);
		contentPane.add(btnVentas);
		
		comboBox = new JComboBox();
		comboBox.setBounds(160, 11, 164, 40);
		contentPane.add(comboBox);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ReporteVista.class.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(167, 62, 168, 207);
		contentPane.add(lblNewLabel);
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
