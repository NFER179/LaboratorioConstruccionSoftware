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

	public ComboVista() {
		setResizable(false);
		setTitle("Combo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblCombos = new JLabel("Combos:");
		lblCombos.setBounds(10, 11, 98, 14);
		contentPane.add(lblCombos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 516, 180);
		contentPane.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumna);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(536, 30, 89, 23);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(536, 64, 89, 23);
		contentPane.add(btnModificar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(437, 227, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(536, 227, 89, 23);
		contentPane.add(btnCancelar);
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
