package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;

import modelo.CategoriaModelo;
import modelo.MateriaPrimaModelo;

import validacion.ValidacionCreacionMateriaPrima;
import vista.CreacionMateriaPrimaVista;
import vista.MateriaPrimaVista;

public class ControladorCreacionMateriaPrima implements ActionListener {

	private ValidacionCreacionMateriaPrima vldMT;
	private CreacionMateriaPrimaVista vtCreacion;
	private MateriaPrimaModelo mdlMateriaPrima;
	private ControladorMateriaPrima ctrMateriaPrima;
	private CategoriaModelo mdlCategoria;
	
	public ControladorCreacionMateriaPrima (ControladorMateriaPrima CtrMP, MateriaPrimaVista MPV) {
		this.vtCreacion = new CreacionMateriaPrimaVista(MPV);
		this.vtCreacion.getBtnCrear().addActionListener(this);
		this.vtCreacion.getBtnCancelar().addActionListener(this);
		
		this.vldMT = new ValidacionCreacionMateriaPrima(this.vtCreacion);
		this.mdlMateriaPrima = new MateriaPrimaModelo();
		this.mdlCategoria = new CategoriaModelo();
		this.ctrMateriaPrima = CtrMP;
	}
	
	public void Inicializar() {
		this.CargarCbxCategoria();
		this.vtCreacion.Open();
	}
	
	private void CargarCbxCategoria() {
		this.vtCreacion.getModelCbxCategoria().removeAllElements();
		this.vtCreacion.getModelCbxCategoria().addElement("Ninguna");
		for(CategoriaDTO c:this.mdlCategoria.ObtenerCategorias()) {
			this.vtCreacion.getModelCbxCategoria().addElement(c.getIdCategoria());
		}
		this.vtCreacion.getCbbCategoria().setModel(this.vtCreacion.getModelCbxCategoria());
	}

	private void CargarNuevaMateriaPrima() {
		String nombre = this.vtCreacion.getTxtMateriaprima().getText().trim();
		String unidad = this.vtCreacion.getComboBox().getSelectedItem().toString().trim();
		
		MateriaPrimaDTO mt = new MateriaPrimaDTO(nombre, unidad);
		
		this.mdlMateriaPrima.RegistrarMateriaPrima(mt);
		
		if(!this.vtCreacion.getCbbCategoria().getSelectedItem().toString().trim().toUpperCase().equals("NINGUNA")) {
			String cString = this.vtCreacion.getCbbCategoria().getSelectedItem().toString().trim(); 
			CategoriaDTO categoria = this.mdlCategoria.ObtenerCategoria(cString);
			this.mdlCategoria.AsignarMateriaPrima(categoria, mt);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCreacion.getBtnCrear()) {
			if(this.vldMT.CreacionValida()){
				this.CargarNuevaMateriaPrima();
				this.ctrMateriaPrima.ActualizarTabla();
				this.vtCreacion.Close();
			}
		}
		else if (arg0.getSource() == this.vtCreacion.getBtnCancelar()) {
			this.vtCreacion.Close();
		}
	}
}