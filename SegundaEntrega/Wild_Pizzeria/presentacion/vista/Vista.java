package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JButton;

public class Vista {
	
	private JFrame frame;
	private JButton btnPedidos;
	
	public Vista() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		this.frame.setLocationRelativeTo(null);
		
		this.btnPedidos = new JButton("Pedidos");
		this.btnPedidos.setBounds(10, 11, 89, 23);
		this.frame.getContentPane().add(btnPedidos);
	}
	
	public void Open() {
		this.frame.setVisible(true);
	}
	
	public void Close() {
		this.frame.setVisible(false);
	}
	
	public JButton GetBtnPedidos() {
		return this.btnPedidos;
	}
}