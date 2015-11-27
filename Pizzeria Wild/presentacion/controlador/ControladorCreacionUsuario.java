package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Sistema;

import utilidades.Msj;
import vista.CreacionUsuarioVista;

public class ControladorCreacionUsuario implements ActionListener {

	private CreacionUsuarioVista vtCreacion;

	public ControladorCreacionUsuario() {
		this.vtCreacion = new CreacionUsuarioVista();
		addListeners();
	}

	private void addListeners() {
		this.vtCreacion.getOkButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == this.vtCreacion.getOkButton()) {
			String usuario = this.vtCreacion.getTxtUsuario().getText().trim();
			char[] contras1 = this.vtCreacion.getTxtContra1().getPassword();
			char[] contras2 = this.vtCreacion.getTxtContra2().getPassword();
			String contra1 = "";
			for (Character c : contras1)
				contra1 += c.toString();
			String contra2 = "";
			for (Character c : contras2)
				contra2 += c.toString();
			contra1 = contra1.trim();
			contra2 = contra2.trim();
			if ("".equals(usuario)) {
				Msj.error("Error", "El nombre de usuario no puede ser vacio");
				this.vtCreacion.getTxtUsuario().setBackground(Color.RED);
				return;
			}
			if ("".equals(contra1)) {
				Msj.error("Error", "La contraseņa no puede ser vacia");
				this.vtCreacion.getTxtContra1().setBackground(Color.RED);
				return;
			}
			if ("".equals(contra2)) {
				Msj.error("Error", "La contraseņa no puede ser vacia");
				this.vtCreacion.getTxtContra2().setBackground(Color.RED);
				return;
			}
			if (!contra1.equals(contra2)) {
				Msj.error("Error de contraseņas",
						"Las contraseņas deben coincidir");
				return;
			}
			Sistema.newUsuario(usuario, contra1);
			this.vtCreacion.Close();
		}
	}

}
