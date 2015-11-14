package vista;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class SeleccionProveedorVista extends JDialog {
	
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"ID Proveedor","Descripcion"};
	private JTable table;
	private JButton btnSeleccionar;
	private JButton btnCancelar;

	public SeleccionProveedorVista(CreacionSolicitudVista Vista) {
		super(Vista, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeleccionProveedorVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		setTitle(" Seleccion Proveedor");
		setBounds(100, 100, 350, 450);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 322, 344);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setIcon(new ImageIcon(SeleccionProveedorVista.class.getResource("/Iconos/Seleccion.png")));
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSeleccionar.setBounds(10, 365, 140, 40);
		getContentPane().add(btnSeleccionar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(SeleccionProveedorVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(192, 365, 140, 40);
		getContentPane().add(btnCancelar);

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

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}