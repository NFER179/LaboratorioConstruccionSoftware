package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CreacionMateriaPrimaVista extends JDialog {

	private JTextField txtMateriaprima;
	private String[] valoresComboBox = {"Kg","Lts","Unidad"};
	private JComboBox comboBox;
	private JButton btnCrear;
	private JButton btnCancelar;
	private DefaultComboBoxModel modelCbxCategoria;
	private String[] valoresCbxCategoria  = {"Ninguno"};
	private JComboBox cbbCategoria;
	private JLabel lblNewLabel;

	public CreacionMateriaPrimaVista(MateriaPrimaVista MPV) {
		super(MPV, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreacionMateriaPrimaVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		this.setTitle(" Nueva Materia Prima");
		this.setBounds(100, 100, 437, 241);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblMateriaPrima = new JLabel("Materia Prima:");
		lblMateriaPrima.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMateriaPrima.setBounds(10, 11, 90, 14);
		getContentPane().add(lblMateriaPrima);
		
		this.txtMateriaprima = new JTextField();
		this.txtMateriaprima.setBounds(10, 36, 270, 25);
		getContentPane().add(this.txtMateriaprima);
		this.txtMateriaprima.setColumns(10);
		
		JLabel lblUnidad = new JLabel("Unidad:");
		lblUnidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUnidad.setBounds(10, 67, 90, 14);
		getContentPane().add(lblUnidad);
		
		this.comboBox = new JComboBox(this.valoresComboBox);
		this.comboBox.setBounds(10, 92, 90, 25);
		getContentPane().add(this.comboBox);
		
		this.btnCrear = new JButton("Crear");
		btnCrear.setIcon(new ImageIcon(CreacionMateriaPrimaVista.class.getResource("/Iconos/OK.png")));
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnCrear.setBounds(119, 155, 140, 40);
		getContentPane().add(this.btnCrear);
		
		this.btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(CreacionMateriaPrimaVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnCancelar.setBounds(269, 155, 140, 40);
		getContentPane().add(this.btnCancelar);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategoria.setBounds(110, 67, 90, 14);
		getContentPane().add(lblCategoria);
		
		this.modelCbxCategoria = new DefaultComboBoxModel(this.valoresCbxCategoria);
		
		cbbCategoria = new JComboBox(this.modelCbxCategoria);
		cbbCategoria.setSelectedIndex(0);
		cbbCategoria.setBounds(110, 92, 170, 25);
		getContentPane().add(cbbCategoria);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CreacionMateriaPrimaVista.class.getResource("/Iconos/Logo Pizzeria Wild 96x96.png")));
		lblNewLabel.setBounds(303, 12, 106, 105);
		getContentPane().add(lblNewLabel);
	}

	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}
	
	public JTextField getTxtMateriaprima() {
		return txtMateriaprima;
	}

	public String[] getValoresComboBox() {
		return valoresComboBox;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public String[] getValoresCbxCategoria() {
		return valoresCbxCategoria;
	}

	public JComboBox getCbbCategoria() {
		return cbbCategoria;
	}

	public DefaultComboBoxModel getModelCbxCategoria() {
		return modelCbxCategoria;
	}
	
}