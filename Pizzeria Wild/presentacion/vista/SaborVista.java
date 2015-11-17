package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SaborVista extends JDialog {
	
	private JTextField txtSabor;
	private JTextField txtPrecio;
	private JButton btnAgregar;
	private JButton btnCancelar;

	public SaborVista(ABMProductoVista Vista) {
		super(Vista, true);
		setTitle("Sabor");
		setResizable(false);
		setBounds(100, 100, 450, 128);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblSabor = new JLabel("Sabor: ");
		lblSabor.setBounds(10, 11, 67, 14);
		getContentPane().add(lblSabor);
		
		txtSabor = new JTextField();
		txtSabor.setBounds(70, 8, 318, 20);
		getContentPane().add(txtSabor);
		txtSabor.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 36, 67, 14);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(70, 33, 86, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel label = new JLabel("$");
		label.setBounds(166, 36, 46, 14);
		getContentPane().add(label);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(246, 61, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(345, 61, 89, 23);
		getContentPane().add(btnCancelar);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtSabor() {
		return txtSabor;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}