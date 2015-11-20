package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CreacionMateriaPrimaVista extends JDialog {

	private JTextField txtMateriaprima;
	private String[] valoresComboBox = {"Kg","Lts","Unidad"};
	private JComboBox comboBox;
	private JButton btnCrear;
	private JButton btnCancelar;
//	private DefaultComboBoxModel modelCbxCategoria;
//	private String[] valoresCbxCategoria  = {"Ninguno"};
//	private JComboBox cbbCategoria;

//	public CreacionMateriaPrimaVista(MateriaPrimaVista MPV) {
	public CreacionMateriaPrimaVista(CategoriaDetalleVista CDV ) {
		super(CDV, true);
		
		this.setTitle("Nueva Materia Prima");
		this.setBounds(100, 100, 303, 190);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblMateriaPrima = new JLabel("Materia Prima:");
		lblMateriaPrima.setBounds(10, 11, 90, 14);
		getContentPane().add(lblMateriaPrima);
		
		this.txtMateriaprima = new JTextField();
		this.txtMateriaprima.setBounds(10, 36, 270, 20);
		getContentPane().add(this.txtMateriaprima);
		this.txtMateriaprima.setColumns(10);
		
		JLabel lblUnidad = new JLabel("Unidad:");
		lblUnidad.setBounds(10, 67, 90, 14);
		getContentPane().add(lblUnidad);
		
		this.comboBox = new JComboBox(this.valoresComboBox);
		this.comboBox.setBounds(10, 92, 90, 20);
		getContentPane().add(this.comboBox);
		
		this.btnCrear = new JButton("Crear");
		this.btnCrear.setBounds(92, 123, 89, 23);
		getContentPane().add(this.btnCrear);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(191, 123, 89, 23);
		getContentPane().add(this.btnCancelar);
		
//		JLabel lblCategoria = new JLabel("Categoria:");
//		lblCategoria.setBounds(110, 67, 90, 14);
//		getContentPane().add(lblCategoria);
//		
//		this.modelCbxCategoria = new DefaultComboBoxModel(this.valoresCbxCategoria);
//		
//		cbbCategoria = new JComboBox(this.modelCbxCategoria);
//		cbbCategoria.setSelectedIndex(0);
//		cbbCategoria.setBounds(110, 92, 170, 20);
//		getContentPane().add(cbbCategoria);
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

//	public String[] getValoresCbxCategoria() {
//		return valoresCbxCategoria;
//	}
//
//	public JComboBox getCbbCategoria() {
//		return cbbCategoria;
//	}
//
//	public DefaultComboBoxModel getModelCbxCategoria() {
//		return modelCbxCategoria;
//	}
	
}