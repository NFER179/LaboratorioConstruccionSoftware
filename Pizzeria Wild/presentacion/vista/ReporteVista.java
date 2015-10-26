package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ReporteVista extends JFrame {

	private JPanel contentPane;
	private JButton btnVentasDelDia;
	
	private JButton btnVolver;

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
