package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;

public class CostoSolicitudVista extends JDialog {
	
	private JTextField textField;
	private JButton btnRecepcionar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;

	public CostoSolicitudVista(SolicitudCompraVista Vista) {
		super(Vista, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CostoSolicitudVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		setTitle(" Costo Pedido");
		setBounds(100, 100, 319, 177);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(105, 25, 114, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnRecepcionar = new JButton("Recepcionar");
		btnRecepcionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRecepcionar.setBounds(10, 89, 140, 40);
		getContentPane().add(btnRecepcionar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(161, 89, 140, 40);
		getContentPane().add(btnCancelar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CostoSolicitudVista.class.getResource("/Iconos/dollar.png")));
		lblNewLabel.setBounds(66, 25, 29, 40);
		getContentPane().add(lblNewLabel);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTextField() {
		return textField;
	}

	public JButton getBtnRecepcionar() {
		return btnRecepcionar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
