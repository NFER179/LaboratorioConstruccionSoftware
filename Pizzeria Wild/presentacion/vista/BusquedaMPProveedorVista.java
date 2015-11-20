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

public class BusquedaMPProveedorVista extends JDialog {
	
	private String[] nombreColumnas = {"Materia Prima"};
	private DefaultTableModel modelTable;
	private JTable tblMT;
	private JButton btnAsignar;
	private JButton btnCancelar;

	public BusquedaMPProveedorVista(ABMProveedorVista Vista) {
		super(Vista, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BusquedaMPProveedorVista.class.getResource("/Iconos/pizza_1.PNG")));
		setResizable(false);
		setTitle(" Busquer Materia Prima");
		setBounds(100, 100, 450, 325);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 422, 221);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		tblMT = new WTable(this.modelTable);
		scrollPane.setViewportView(tblMT);
		
		btnAsignar = new JButton("Asignar");
		btnAsignar.setIcon(new ImageIcon(BusquedaMPProveedorVista.class.getResource("/Iconos/OK.png")));
		btnAsignar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAsignar.setBounds(144, 242, 140, 40);
		getContentPane().add(btnAsignar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(BusquedaMPProveedorVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(294, 242, 140, 40);
		getContentPane().add(btnCancelar);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public JTable getTblMT() {
		return tblMT;
	}

	public JButton getBtnAsignar() {
		return btnAsignar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
