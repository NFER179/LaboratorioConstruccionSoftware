package validacion;

import java.awt.Color;

import javax.swing.JOptionPane;

import modelo.MateriaPrimaModelo;

import vista.CreacionMateriaPrimaVista;

public class ValidacionCreacionMateriaPrima {

	private CreacionMateriaPrimaVista vtCreacion;
	private MateriaPrimaModelo mdlMateriaPrima;
	
	public ValidacionCreacionMateriaPrima(CreacionMateriaPrimaVista Vista) {
		this.vtCreacion = Vista;
		this.mdlMateriaPrima = new MateriaPrimaModelo();
	}
	
	public boolean CreacionValida() {
		boolean creacionValida = true;
		
		if(this.vtCreacion.getTxtMateriaprima().getText().trim().equals("")) {
			creacionValida = false;
			String mensaje = "Debe Ingresar el Nombre de la Materia Prima.";
			String titulo = "Error Campo Incompleto";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
			this.vtCreacion.getTxtMateriaprima().setBackground(Color.RED);
		}
		else
			this.vtCreacion.getTxtMateriaprima().setBackground(null);
		
		String NombreMT = this.vtCreacion.getTxtMateriaprima().getText().trim();
		
		if(this.mdlMateriaPrima.Existe(NombreMT)){
			creacionValida = false;
			String mensaje = "La Materia Prima ya fue Creada.";
			String titulo = "Error Duplicidad";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		}
		
		return creacionValida;
	}
}
