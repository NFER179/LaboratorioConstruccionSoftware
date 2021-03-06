package vista;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class BuscadorRepartidorVista extends JDialog {

	private DefaultTableModel modelTable;
	private String[] NombreColumnas = { "ID", "Nombre" };
	private JTable table;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public BuscadorRepartidorVista(JDialog Dialog) {
		super(Dialog, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				BuscadorRepartidorVista.class
						.getResource("/Iconos/pizza_1.PNG")));

		this.setTitle(" Repartidores");
		this.setBounds(100, 100, 333, 301);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 305, 187);
		this.getContentPane().add(scrollPane);

		this.modelTable = new WDefaultTableModel(null, this.NombreColumnas);

		this.table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setIcon(new ImageIcon(BuscadorRepartidorVista.class
				.getResource("/Iconos/OK.png")));
		this.btnAceptar.setBounds(20, 216, 140, 40);
		this.getContentPane().add(btnAceptar);

		this.btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setIcon(new ImageIcon(BuscadorRepartidorVista.class
				.getResource("/Iconos/salir.png")));
		this.btnCancelar.setBounds(175, 216, 140, 40);
		this.getContentPane().add(btnCancelar);
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
		return NombreColumnas;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}