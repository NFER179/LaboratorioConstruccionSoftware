package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ClienteVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] nombreColumna = { "Id", "Nombre" };
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnCrear;
	private JButton btnModificar;
	private JButton btnVolver;
	private JLabel lblNewLabel;

	public ClienteVista() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ClienteVista.class.getResource("/Iconos/pizza_1.PNG")));
		setTitle(" Cliente");
		setResizable(false);
		setBounds(100, 100, 495, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClientes.setBounds(10, 11, 96, 25);
		contentPane.add(lblClientes);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 318, 349);
		contentPane.add(scrollPane);

		this.modelTable = new WDefaultTableModel(null, this.nombreColumna);
		
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		btnCrear = new JButton(" Crear");
		btnCrear.setIcon(new ImageIcon(ClienteVista.class
				.getResource("/Iconos/Agregar.png")));
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrear.setBounds(338, 36, 140, 40);
		contentPane.add(btnCrear);

		btnModificar = new JButton(" Modificar");
		btnModificar.setIcon(new ImageIcon(ClienteVista.class
				.getResource("/Iconos/modificar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(338, 87, 140, 40);
		contentPane.add(btnModificar);

		btnVolver = new JButton(" Volver");
		btnVolver.setIcon(new ImageIcon(ClienteVista.class
				.getResource("/Iconos/Volver.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(338, 347, 140, 40);
		contentPane.add(btnVolver);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClienteVista.class
				.getResource("/Iconos/Logo Pizzeria Wild 96x96.png")));
		lblNewLabel.setBounds(366, 171, 96, 105);
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

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}
