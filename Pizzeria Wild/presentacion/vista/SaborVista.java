package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class SaborVista extends JDialog {
	
	private JTextField txtSabor;
	private JTextField txtPrecio;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;

	public SaborVista(ABMProductoVista Vista) {
		super(Vista, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SaborVista.class.getResource("/Iconos/pizza_1.PNG")));
		setTitle(" Sabor");
		setResizable(false);
		setBounds(100, 100, 338, 240);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblSabor = new JLabel("Sabor: ");
		lblSabor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSabor.setBounds(10, 11, 67, 25);
		getContentPane().add(lblSabor);
		
		txtSabor = new JTextField();
		txtSabor.setBounds(70, 11, 249, 25);
		getContentPane().add(txtSabor);
		txtSabor.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(10, 47, 67, 25);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(70, 47, 86, 25);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnAgregar = new JButton(" Agregar");
		btnAgregar.setIcon(new ImageIcon(SaborVista.class.getResource("/Iconos/OK.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(20, 157, 140, 40);
		getContentPane().add(btnAgregar);
		
		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(SaborVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(170, 157, 140, 40);
		getContentPane().add(btnCancelar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SaborVista.class.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(143, 11, 163, 135);
		getContentPane().add(lblNewLabel);
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