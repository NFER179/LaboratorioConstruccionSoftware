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

	public ProductosDeVentasVista(JDialog Dialog){
		
		super(Dialog, true);
		
		this.setTitle("Agregar Producto");
		this.setBounds(100, 100, 298, 264);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(10, 11, 76, 14);
		this.contentPanel.add(lblProducto);
		
		this.txtIdproducto = new JTextField();
		this.txtIdproducto.setEditable(false);
		this.txtIdproducto.setEnabled(false);
		this.txtIdproducto.setBounds(71, 8, 86, 20);
		this.contentPanel.add(txtIdproducto);
		this.txtIdproducto.setColumns(10);
		
		this.btnBusqueda = new JButton("Busqueda");
		this.btnBusqueda.setBounds(167, 7, 89, 23);
		this.contentPanel.add(btnBusqueda);
		
		this.txtDescrProducto = new JTextField();
		this.txtDescrProducto.setEnabled(false);
		this.txtDescrProducto.setEditable(false);
		this.txtDescrProducto.setBounds(10, 36, 270, 20);
		this.contentPanel.add(txtDescrProducto);
		this.txtDescrProducto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 270, 93);
		this.contentPanel.add(scrollPane);
		
		this.modelSabores = new WDefaultTableModel(null, this.nombreColunmnas);
		this.table = new WTable(this.modelSabores);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 171, 76, 14);
		contentPanel.add(lblCantidad);
		
		this.txtCantidad = new JTextField();
		this.txtCantidad.setBounds(71, 168, 86, 20);
		this.contentPanel.add(txtCantidad);
		this.txtCantidad.setColumns(10);
		
		this.btnAceptar = new JButton("Aceptar");
		this.btnAceptar.setBounds(92, 199, 89, 23);
		this.contentPanel.add(btnAceptar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(191, 199, 89, 23);
		this.contentPanel.add(btnCancelar);
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