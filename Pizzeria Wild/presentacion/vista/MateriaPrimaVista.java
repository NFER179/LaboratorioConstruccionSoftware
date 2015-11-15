package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class MateriaPrimaVista extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"Materia Prima","Unidad"};
	private JTable table;
	private JButton btnAgregar;
	private JButton btnVolver;

	public MateriaPrimaVista() {
		this.setTitle("Materia Prima");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(100, 100, 327, 284);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 298, 194);
		this.contentPane.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		this.table = new WTable(this.modelTable);
		scrollPane.setViewportView(this.table);
		
		this.btnAgregar = new JButton("Agregar");
		this.btnAgregar.setBounds(121, 215, 89, 23);
		this.contentPane.add(this.btnAgregar);
		
		this.btnVolver = new JButton("Volver");
		this.btnVolver.setBounds(220, 215, 89, 23);
		this.contentPane.add(this.btnVolver);
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

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}