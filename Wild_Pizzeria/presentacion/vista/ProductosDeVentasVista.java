package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class ProductosDeVentasVista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdproducto;
	private JTextField txtDescrProducto;
	private DefaultTableModel modelSabores;
	private String[] nombreColunmnas = {"Sabor","Precio Unidad"};
	private JTable table;
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnBusqueda;
	private JLabel lblNewLabel;

	public ProductosDeVentasVista(JDialog Dialog){
		
		super(Dialog, true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProductosDeVentasVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		this.setTitle(" Agregar Producto");
		this.setBounds(300, 145, 442, 585);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		//this.setLocationRelativeTo(null);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setAutoscrolls(true);
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProducto.setBounds(10, 12, 76, 14);
		this.contentPanel.add(lblProducto);
		
		this.txtIdproducto = new JTextField();
		this.txtIdproducto.setEditable(false);
		this.txtIdproducto.setEnabled(false);
		this.txtIdproducto.setBounds(71, 8, 208, 25);
		this.contentPanel.add(txtIdproducto);
		this.txtIdproducto.setColumns(10);
		
		this.btnBusqueda = new JButton("Busqueda");
		btnBusqueda.setIcon(new ImageIcon(ProductosDeVentasVista.class.getResource("/Iconos/Buscar.png")));
		btnBusqueda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBusqueda.setAutoscrolls(true);
		this.btnBusqueda.setBounds(289, 8, 131, 59);
		this.contentPanel.add(btnBusqueda);
		
		this.txtDescrProducto = new JTextField();
		this.txtDescrProducto.setEnabled(false);
		this.txtDescrProducto.setEditable(false);
		this.txtDescrProducto.setBounds(20, 42, 259, 25);
		this.contentPanel.add(txtDescrProducto);
		this.txtDescrProducto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 75, 400, 375);
		this.contentPanel.add(scrollPane);
		
		this.modelSabores = new WDefaultTableModel(null, this.nombreColunmnas);
		this.table = new WTable(this.modelSabores);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setBounds(194, 469, 76, 14);
		contentPanel.add(lblCantidad);
		
		this.txtCantidad = new JTextField();
		this.txtCantidad.setBounds(280, 464, 140, 25);
		this.contentPanel.add(txtCantidad);
		this.txtCantidad.setColumns(10);
		
		this.btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(ProductosDeVentasVista.class.getResource("/Iconos/OK.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnAceptar.setBounds(130, 500, 140, 40);
		this.contentPanel.add(btnAceptar);
		
		this.btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(ProductosDeVentasVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnCancelar.setBounds(280, 500, 140, 40);
		this.contentPanel.add(btnCancelar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ProductosDeVentasVista.class.getResource("/Iconos/Logo Pizzeria Wild 2.png")));
		lblNewLabel.setBounds(20, 468, 64, 72);
		contentPanel.add(lblNewLabel);
	}

	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtIdproducto() {
		return txtIdproducto;
	}

	public JTextField getTxtDescrProducto() {
		return txtDescrProducto;
	}

	public DefaultTableModel getModelSabores() {
		return modelSabores;
	}

	public String[] getNombreColunmnas() {
		return nombreColunmnas;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnBusqueda() {
		return btnBusqueda;
	}
}