package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ReporteVista extends JFrame {

	private JPanel contentPane;
	private JButton btnVentasDelDia;
	
	private JButton btnVolver;
	private JLabel lblNewLabel;

	public ReporteVista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReporteVista.class.getResource("/Iconos/pizza_1.PNG")));
		setResizable(false);
		setTitle(" Reportes");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 413, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		btnVentasDelDia = new JButton("Ventas del Dia");
		btnVentasDelDia.setIcon(new ImageIcon(ReporteVista.class.getResource("/Iconos/dollar.png")));
		btnVentasDelDia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVentasDelDia.setBounds(247, 32, 140, 40);
		contentPane.add(btnVentasDelDia);
		
		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(ReporteVista.class.getResource("/Iconos/Volver.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(247, 166, 140, 40);
		contentPane.add(btnVolver);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ReporteVista.class.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(31, 21, 171, 185);
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
}
