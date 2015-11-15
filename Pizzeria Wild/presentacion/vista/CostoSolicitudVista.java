package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CostoSolicitudVista extends JDialog {
	
	private JTextField textField;
	private JButton btnRecepcionar;
	private JButton btnCancelar;

	public CostoSolicitudVista(SolicitudCompraVista Vista) {
		super(Vista, true);
		
		setTitle("Costo Pedido");
		setBounds(100, 100, 252, 105);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("$");
		label.setBounds(66, 14, 46, 14);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(76, 11, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnRecepcionar = new JButton("Recepcionar");
		btnRecepcionar.setBounds(10, 36, 106, 23);
		getContentPane().add(btnRecepcionar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(128, 36, 106, 23);
		getContentPane().add(btnCancelar);
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
