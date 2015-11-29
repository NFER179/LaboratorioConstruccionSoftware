package vista;

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
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RepartidorVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblReoartidoresActivos;
	private String[] nombreColumnas = { "Id", "Nombre", "Activo" };
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnTodos;
	private JButton btnVolver;

	public RepartidorVista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				RepartidorVista.class.getResource("/Iconos/pizza_1.PNG")));
		setResizable(false);
		setTitle(" Repartidores");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 502, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblReoartidoresActivos = new JLabel("Repartidores Activos:");
		lblReoartidoresActivos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReoartidoresActivos.setBounds(10, 11, 196, 14);
		contentPane.add(lblReoartidoresActivos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 317, 221);
		contentPane.add(scrollPane);

		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		btnAgregar = new JButton(" Agregar");
		btnAgregar.setIcon(new ImageIcon(RepartidorVista.class
				.getResource("/Iconos/Agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(346, 37, 140, 40);
		contentPane.add(btnAgregar);

		btnModificar = new JButton(" Modificar");
		btnModificar.setIcon(new ImageIcon(RepartidorVista.class
				.getResource("/Iconos/modificar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(346, 88, 140, 40);
		contentPane.add(btnModificar);

		btnTodos = new JButton(" Todos");
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTodos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTodos.setBounds(346, 139, 140, 40);
		contentPane.add(btnTodos);

		btnVolver = new JButton(" Volver");
		btnVolver.setIcon(new ImageIcon(RepartidorVista.class
				.getResource("/Iconos/Volver.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(346, 217, 140, 40);
		contentPane.add(btnVolver);
		this.setLocationRelativeTo(null);
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

	public JLabel getLblReoartidoresActivos() {
		return lblReoartidoresActivos;
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

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnTodos() {
		return btnTodos;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}