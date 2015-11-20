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
	private String[] nombreColumna = {"Id", "Descripcion", "Activo"};
	private DefaultTableModel modelTable;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;

	public ComboVista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ComboVista.class.getResource("/Iconos/pizza_1.PNG")));
		setResizable(false);
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
		
		btnModificar = new JButton(" Modificar");
		btnModificar.setIcon(new ImageIcon(ComboVista.class.getResource("/Iconos/Quitar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(375, 87, 140, 40);
		contentPane.add(btnModificar);
		
		btnAceptar = new JButton(" Aceptar");
		btnAceptar.setIcon(new ImageIcon(ComboVista.class.getResource("/Iconos/OK.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(225, 335, 140, 40);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(ComboVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(375, 335, 140, 40);
		contentPane.add(btnCancelar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ComboVista.class.getResource("/Iconos/Logo Pizzeria Wild 96x96.png")));
		lblNewLabel.setBounds(397, 178, 98, 96);
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
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
