package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class ProductosBusquedaVista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"Producto", "Descipcion"};
	private JTable table;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public ProductosBusquedaVista(JDialog Dialog) {
		super(Dialog, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProductosBusquedaVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		this.setTitle(" Productos");
		this.setBounds(100, 100, 327, 430);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 299, 323);
		this.contentPanel.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas); 
		this.table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		this.btnAceptar = new JButton(" Aceptar");
		btnAceptar.setIcon(new ImageIcon(ProductosBusquedaVista.class.getResource("/Iconos/OK.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnAceptar.setBounds(10, 345, 140, 40);
		this.contentPanel.add(btnAceptar);
		
		this.btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(ProductosBusquedaVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnCancelar.setBounds(169, 345, 140, 40);
		this.contentPanel.add(btnCancelar);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}