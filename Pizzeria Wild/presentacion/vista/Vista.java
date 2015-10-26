package vista;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JButton;

public class Vista {
	
	private JFrame frame;
	private JButton btnPedidos;
	private JButton btnMateriasPrimas;
	private JButton btnCategorias;
	private JButton btnSolicitud;
	private JButton btnReportes;
	
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
		this.frame.setTitle("Wild Pizzeria");
		
		this.btnPedidos = new JButton("Pedidos");
		this.btnPedidos.setBounds(10, 11, 120, 23);
		this.frame.getContentPane().add(btnPedidos);
		
		btnMateriasPrimas = new JButton("Materias Primas");
		btnMateriasPrimas.setBounds(10, 45, 120, 23);
		frame.getContentPane().add(btnMateriasPrimas);
		
		btnCategorias = new JButton("Categorias");
		btnCategorias.setBounds(10, 79, 120, 23);
		frame.getContentPane().add(btnCategorias);
		
		btnSolicitud = new JButton("Solicitudes");
		btnSolicitud.setBounds(10, 113, 120, 23);
		frame.getContentPane().add(btnSolicitud);
		
		btnReportes = new JButton("Reportes");
		btnReportes.setBounds(10, 147, 120, 23);
		frame.getContentPane().add(btnReportes);
	}
	
	public void Open() {
		this.frame.setVisible(true);
	}
	
	public void Close() {
		this.frame.setVisible(false);
	}

	public JButton getBtnPedidos() {
		return btnPedidos;
	}

	public JButton getBtnMateriasPrimas() {
		return btnMateriasPrimas;
	}

	public JButton getBtnCategorias() {
		return btnCategorias;
	}

	public JButton getBtnSolicitud() {
		return btnSolicitud;
	}

	public JButton getBtnReportes() {
		return btnReportes;
	}
}