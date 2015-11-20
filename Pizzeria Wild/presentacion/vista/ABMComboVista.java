package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ABMComboVista extends JDialog {
	private JTextField txtIdcombo;
	private JTextField txtDescripcion;
	private JTextField txtFechaInicio;
	private JTextField txtFechaHasta;
	private String[] nombreColumnas = {"Producto","Sabor","Cantidad","Precio"};
	private DefaultTableModel modelTable; 
	private JTable table;
	private JTextField txtPrecio;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public ABMComboVista(ComboVista Vista) {
		super(Vista, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ABMComboVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		setTitle(" Combo");
		setResizable(false);
		setBounds(100, 100, 701, 452);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblIdCombo = new JLabel("Id Combo: ");
		lblIdCombo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdCombo.setBounds(10, 8, 94, 25);
		getContentPane().add(lblIdCombo);
		
		txtIdcombo = new JTextField();
		txtIdcombo.setBounds(89, 8, 86, 25);
		getContentPane().add(txtIdcombo);
		txtIdcombo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcion.setBounds(10, 39, 94, 25);
		getContentPane().add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(89, 39, 253, 25);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDesde.setBounds(10, 75, 46, 25);
		getContentPane().add(lblDesde);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setBounds(89, 75, 86, 25);
		getContentPane().add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHasta.setBounds(202, 75, 68, 25);
		getContentPane().add(lblHasta);
		
		txtFechaHasta = new JTextField();
		txtFechaHasta.setBounds(249, 75, 86, 25);
		getContentPane().add(txtFechaHasta);
		txtFechaHasta.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 524, 245);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(10, 373, 94, 25);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(89, 373, 86, 25);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnAgregar = new JButton(" Agregar");
		btnAgregar.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/Agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(544, 206, 140, 40);
		getContentPane().add(btnAgregar);
		
		btnQuitar = new JButton(" Quitar");
		btnQuitar.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/Quitar.png")));
		btnQuitar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuitar.setBounds(544, 257, 140, 40);
		getContentPane().add(btnQuitar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/Guardar.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(394, 373, 140, 40);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(544, 373, 140, 40);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ABMComboVista.class.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(521, 8, 163, 167);
		getContentPane().add(lblNewLabel);

	}
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}
	public JTextField getTxtIdcombo() {
		return txtIdcombo;
	}
	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}
	public JTextField getTxtFechaInicio() {
		return txtFechaInicio;
	}
	public JTextField getTxtFechaHasta() {
		return txtFechaHasta;
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
	public JTextField getTxtPrecio() {
		return txtPrecio;
	}
	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	public JButton getBtnQuitar() {
		return btnQuitar;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
