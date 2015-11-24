package validacion;

import java.awt.Color;
import javax.swing.JOptionPane;
import vista.SeleccionMateriaPrimaSolicitudVista;

public class ValidacionSeleccionMateriaPrimaSolicitud {

	private SeleccionMateriaPrimaSolicitudVista vista;
	private String tituloMensaje;
	private String mensaje;

	public ValidacionSeleccionMateriaPrimaSolicitud(
			SeleccionMateriaPrimaSolicitudVista Vista) {
		this.vista = Vista;
		this.tituloMensaje = "Informacion";
	}

	public boolean Valido() {
		this.mensaje = "";

		if (this.SeleccionMateriaPrima() & this.CantidadProducto())
			if (this.ValorCantidadCorrecto())
				return true;

		JOptionPane.showMessageDialog(null, this.mensaje, this.tituloMensaje,
				JOptionPane.INFORMATION_MESSAGE);
		return false;
	}

	private boolean SeleccionMateriaPrima() {
		if (this.vista.getTable().getSelectedRow() >= 0)
			return true;
		else {
			this.mensaje = this.mensaje + "- Debe Seleccionar Materia Prima.";
			return false;
		}
	}

	private boolean CantidadProducto() {
		if (this.vista.getTxtCantidad().getText().trim().equals("")) {
			this.AgregarMensaje("Debe Seleccionar una Cantidad de la Materia Prima.");
			this.ErrorCampoCantidad(true);
			return false;
		} else {
			this.ErrorCampoCantidad(false);
			return true;
		}
	}

	private boolean ValorCantidadCorrecto() {
		try {
			int valor = Integer.parseInt(this.vista.getTxtCantidad().getText()
					.trim());
			if (valor <= 0) {
				this.ErrorCampoCantidad(true);
				this.AgregarMensaje("Valor Numerico Incorrecto.");
				return false;
			} else {
				this.ErrorCampoCantidad(false);
				return true;
			}
		} catch (Exception e) {
			this.ErrorCampoCantidad(true);
			this.AgregarMensaje("Valor Numerico Incorrecto.");
			return false;
		}
	}

	private void AgregarMensaje(String Mensaje) {
		if (this.mensaje.equals(""))
			this.mensaje = "- " + Mensaje;
		else
			this.mensaje = this.mensaje + "\n- " + Mensaje;
	}

	private void ErrorCampoCantidad(boolean arg0) {
		if (arg0)
			this.vista.getTxtCantidad().setBackground(Color.RED);
		else
			this.vista.getTxtCantidad().setBackground(null);
	}
}