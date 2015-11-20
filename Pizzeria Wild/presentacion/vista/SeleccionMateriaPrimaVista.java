package vista;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SeleccionMateriaPrimaVista extends JDialog {

	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"Materias Primas"};
	private JTable table;
	private JButton btnAsignar;
	private JButton btnCancelar;

	public SeleccionMateriaPrimaVista(CategoriaDetalleVista CategoriaDetalle) {
		super(CategoriaDetalle, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeleccionMateriaPrimaVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		setTitle("Seleccion Materias Primas");
		setBounds(100, 100, 380, 453);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 352, 346);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnAsignar = new JButton(" Asignar");
		btnAsignar.setIcon(new ImageIcon(SeleccionMateriaPrimaVista.class.getResource("/Iconos/OK.png")));
		btnAsignar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAsignar.setBounds(10, 368, 140, 40);
		getContentPane().add(btnAsignar);
		
		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(SeleccionMateriaPrimaVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(222, 368, 140, 40);
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

	public JButton getBtnAsignar() {
		return btnAsignar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}