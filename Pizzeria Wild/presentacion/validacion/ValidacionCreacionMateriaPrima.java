package validacion;

import java.awt.Color;

import modelo.MateriaPrimaModelo;

import utilidades.Msj;
import utilidades.Str;
import validacionesCampos.Valida;
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

		if (Valida.esNullOVacio(this.vtCreacion.getTxtMateriaprima().getText())) {
			creacionValida = false;
			String mensaje = "Debe Ingresar el Nombre de la Materia Prima.";
			String titulo = "Error Campo Incompleto";
			Msj.error(titulo, mensaje);
			this.vtCreacion.getTxtMateriaprima().setBackground(Color.RED);
		} else
			this.vtCreacion.getTxtMateriaprima().setBackground(null);

		String NombreMT = Str.trim(vtCreacion.getTxtMateriaprima().getText());

		if (this.mdlMateriaPrima.Existe(NombreMT)) {
			creacionValida = false;
			String mensaje = "La Materia Prima ya fue Creada.";
			String titulo = "Error Duplicidad";
			Msj.error(titulo, mensaje);
		}

		return creacionValida;
	}
}
