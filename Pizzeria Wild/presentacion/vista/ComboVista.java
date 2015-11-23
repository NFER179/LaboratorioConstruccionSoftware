package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ComboVista extends JFrame {

	private JPanel contentPane;
	private String[] nombreColumna = {"Id", "Descripcion"};
	private DefaultTableModel modelTable;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JButton btnInformacion;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JLabel lblNewLabel;

	public ComboVista() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ComboVista.class.getResource("/Iconos/pizza_1.PNG")));
		setTitle(" Combo");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 534, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblCombos = new JLabel("Combos:");
		lblCombos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCombos.setBounds(10, 11, 98, 25);
		contentPane.add(lblCombos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 355, 288);
		contentPane.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumna);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton(" Agregar");
		btnAgregar.setIcon(new ImageIcon(ComboVista.class.getResource("/Iconos/Agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(375, 36, 140, 40);
		contentPane.add(btnAgregar);
		
		btnInformacion = new JButton("Informacion");
		btnInformacion.setIcon(new ImageIcon(ComboVista.class.getResource("/Iconos/Quitar.png")));
		btnInformacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInformacion.setBounds(375, 87, 140, 40);
		contentPane.add(btnInformacion);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(380, 143, 115, 29);
		contentPane.add(btnEliminar);
		
		btnAceptar = new JButton(" Volver");
		btnAceptar.setIcon(new ImageIcon(ComboVista.class.getResource("/Iconos/Volver.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(375, 338, 140, 40);
		contentPane.add(btnAceptar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ComboVista.class.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(365, 151, 163, 158);
		contentPane.add(lblNewLabel);
	}
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public String[] getNombreColumna() {
		return nombreColumna;
	}
	public DefaultTableModel getModelTable() {
		return modelTable;
	}
	public JTable getTable() {
		return table;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	public JButton getBtnInformacion() {
		return btnInformacion;
	}
	public JButton getBtnEliminar() {
		return this.btnEliminar;
	}
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
}
