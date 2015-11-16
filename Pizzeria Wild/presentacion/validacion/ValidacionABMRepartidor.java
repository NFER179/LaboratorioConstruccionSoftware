package validacion;

import javax.swing.JOptionPane;

import vista.ABMRepartidorVista;

public class ValidacionABMRepartidor {

	private ABMRepartidorVista vtABM;

	public ValidacionABMRepartidor(ABMRepartidorVista Vista) {
		this.vtABM = Vista;
	}

	public boolean GuardarValido() {
		boolean valido = true;

		if (this.vtABM.getTxtRepartidorid().getText().trim().equals("")) {
			valido = false;
		}

		if (this.vtABM.getTxtNombre().getText().trim().equals("")) {
			valido = false;
		}

		if (this.vtABM.getTxtApellido().getText().trim().equals("")) {
			valido = false;
		}

		if (this.vtABM.getTxtTel().getText().trim().equals("")) {
			valido = false;
		}

		if (this.vtABM.getTxtDireccion().getText().trim().equals("")) {
			valido = false;
		}

		if (this.vtABM.getTxtPatente().getText().trim().equals("")) {
			valido = false;
		}

		if (this.vtABM.getTxtTipo().getText().trim().equals("")) {
			valido = false;
		}

		if (this.vtABM.getTxtModelo().getText().trim().equals("")) {
			valido = false;
		}
		
		if(!valido) {
			String mensaje = "Debe Completar todos los campos.";
			String titulo = "Error";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		}

		return valido;
	}
}
