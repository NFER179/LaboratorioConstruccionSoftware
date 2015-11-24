package vista;
 

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

public class ABMComboVista extends JDialog {
	private JTextField txtIdcombo;
	private JTextField txtDescripcion;
	private JButton btnEdit;
	private JPanel panel;
	private JButton btnAnterior;
	private JLabel lblFila;
	private JButton btnSiguiente;
	private JDateChooser dateChooser;
	private JCheckBox chckbxActivo;
	private String[] nombreColumnas = {"Producto","Sabor","Cantidad","Precio"};
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnAgregarProducto;
	private JButton btnEliminarProducto;
	private JTextField txtPrecio;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JTextField txtFecha;

	public ABMComboVista(ComboVista Vista) {
		super(Vista, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ABMComboVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		setTitle(" Combo");
		setResizable(false);
		setBounds(100, 100, 738, 560);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblIdCombo = new JLabel("Id Combo: ");
		lblIdCombo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdCombo.setBounds(10, 8, 94, 25);
		getContentPane().add(lblIdCombo);
		
		txtIdcombo = new JTextField();
		txtIdcombo.setEnabled(false);
		txtIdcombo.setEditable(false);
		txtIdcombo.setBounds(89, 8, 86, 25);
		getContentPane().add(txtIdcombo);
		txtIdcombo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcion.setBounds(10, 39, 94, 25);
		getContentPane().add(lblDescripcion);
		
		btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/modificar.png")));
		btnEdit.setBounds(357, 38, 37, 29);
		getContentPane().add(btnEdit);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEnabled(false);
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(89, 39, 253, 25);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 75, 525, 368);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnterior.setBounds(15, 16, 115, 29);
		panel.add(btnAnterior);
		
		lblFila = new JLabel("Fila");
		lblFila.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFila.setHorizontalAlignment(SwingConstants.CENTER);
		lblFila.setBounds(222, 20, 69, 20);
		panel.add(lblFila);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSiguiente.setBounds(395, 16, 115, 29);
		panel.add(btnSiguiente);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(15, 61, 96, 20);
		panel.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setEditable(false);
		txtFecha.setBounds(84, 56, 146, 25);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(84, 55, 188, 26);
		panel.add(dateChooser);
		
		chckbxActivo = new JCheckBox("Activo");
		chckbxActivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxActivo.setEnabled(false);
		chckbxActivo.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxActivo.setBounds(371, 57, 139, 29);
		panel.add(chckbxActivo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 97, 367, 216);
		panel.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnAgregarProducto = new JButton("Agregar");
		btnAgregarProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregarProducto.setBounds(395, 133, 115, 40);
		panel.add(btnAgregarProducto);
		
		btnEliminarProducto = new JButton("Eliminar");
		btnEliminarProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarProducto.setBounds(395, 184, 115, 40);
		panel.add(btnEliminarProducto);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(15, 329, 69, 20);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(84, 326, 146, 26);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnAgregar = new JButton(" Agregar");
		btnAgregar.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/Agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(560, 201, 140, 40);
		getContentPane().add(btnAgregar);
		
		btnModificar = new JButton(" Modificar");
		btnModificar.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/modificar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(560, 268, 140, 40);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton(" Quitar");
		btnEliminar.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/Quitar.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(560, 331, 140, 40);
		getContentPane().add(btnEliminar);
		
		btnVolver = new JButton(" Volver");
		btnVolver.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/Volver.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(573, 481, 140, 40);
		getContentPane().add(btnVolver);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/Guardar.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(423, 481, 140, 40);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(573, 481, 140, 40);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(550, 8, 163, 167);
		getContentPane().add(lblNewLabel);
	}
	
	public void Open() {
		 this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}
	
	public void EliminarComponente(Component arg0) {
		this.getContentPane().remove(arg0);
	}
	
	public void AgregarComponente(Component arg0) {
		this.getContentPane().add(arg0);
	}

	public JTextField getTxtIdcombo() {
		return txtIdcombo;
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	public JLabel getLblFila() {
		return lblFila;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public JCheckBox getChckbxActivo() {
		return chckbxActivo;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAgregarProducto() {
		return btnAgregarProducto;
	}

	public JButton getBtnEliminarProducto() {
		return btnEliminarProducto;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}
}