package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.ABMProductoVista;
import vista.SaborVista;

public class ControladorSabor implements ActionListener {
	
	private ControladorABMProducto ctrABM;
	private SaborVista vtSabor;
	
	public ControladorSabor(ControladorABMProducto Ctr, ABMProductoVista Vista) {
		this.ctrABM = Ctr;
		
		this.vtSabor = new SaborVista(Vista);
		this.vtSabor.getBtnAgregar().addActionListener(this);
		this.vtSabor.getBtnCancelar().addActionListener(this);
	}
	
	public void Inicializar() {
		this.vtSabor.Open();
	}
	
	private void Agregar() {
		String sabor = this.vtSabor.getTxtSabor().getText().trim();
		String precio = this.vtSabor.getTxtPrecio().getText().trim();
		
		if(this.ctrABM.Agregar(sabor, precio)) {
			this.vtSabor.Close();
		}
		
		this.vtSabor.Close();
	}

	private void Cancelar() {
		this.vtSabor.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtSabor.getBtnAgregar()) {
			this.Agregar();
		}else if(arg0.getSource() == this.vtSabor.getBtnCancelar()) {
			this.Cancelar();
		}
	}
}
