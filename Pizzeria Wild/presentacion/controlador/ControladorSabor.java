package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utilidades.Msj;
import vista.ABMProductoVista;
import vista.SaborVista;

public class ControladorSabor implements ActionListener {

	private ControladorABMProducto ctrABM;
	private SaborVista vtSabor;
	private ABMProductoVista vtABM;

	public ControladorSabor(ControladorABMProducto Ctr, ABMProductoVista Vista) {
		this.ctrABM = Ctr;

		this.vtABM = Vista;
		this.vtSabor = new SaborVista(Vista);
		this.vtSabor.getBtnAgregar().addActionListener(this);
		this.vtSabor.getBtnCancelar().addActionListener(this);
	}

	public void Inicializar() {
		this.vtABM.Close();
		this.vtSabor.Open();
	}

	private void Agregar() {
		String sabor = this.vtSabor.getTxtSabor().getText().trim();
		String precio = this.vtSabor.getTxtPrecio().getText().trim();
		if (sabor.equals("")) {
			Msj.error("Error", "Debe ingresar un sabor");
			return;
		}
		if (precio.equals("")) {
			Msj.error("Error", "Debe ingresar un precio");
			return;
		}
		int valorPrecio = 0;
		try {
			valorPrecio = Integer.parseInt(precio);
			if (valorPrecio <= 0) {
				Msj.error("Error de valor",
						"Debe ingresar un precio mayor a cero");
				return;
			}
		} catch (Exception e) {
			Msj.error("Error", "Debe ingresar un precio valido");
			return;
		}
		if (this.ctrABM.Agregar(sabor, valorPrecio)) {
			this.vtSabor.Close();
		}

		this.vtSabor.Close();
		this.ctrABM.Return();
	}

	private void Cancelar() {
		this.vtSabor.Close();
		this.ctrABM.Return();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtSabor.getBtnAgregar()) {
			this.Agregar();
		} else if (arg0.getSource() == this.vtSabor.getBtnCancelar()) {
			this.Cancelar();
		}
	}
}
