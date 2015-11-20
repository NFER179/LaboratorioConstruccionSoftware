package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.ComboDTO;

import modelo.ComboModelo;

import vista.ComboVista;

public class ControladorCombo implements ActionListener {

	private ControladorVenta ctrVenta;
	private ComboVista vtCombo;
	private ComboModelo mdlCombo;
	
	public ControladorCombo(ControladorVenta Ctr) {
		this.ctrVenta = Ctr;
		
		this.vtCombo = new ComboVista();
		this.vtCombo.getBtnAgregar().addActionListener(this);
		this.vtCombo.getBtnModificar().addActionListener(this);
		this.vtCombo.getBtnAceptar().addActionListener(this);
		
		this.mdlCombo = new ComboModelo();
	}
	
	public void Inicializar() {
		this.CargarTabla();
		this.vtCombo.Open();
	}
	
	public void CargarTabla(){
		this.vtCombo.getModelTable().setRowCount(0);
		this.vtCombo.getModelTable().setColumnCount(0);
		this.vtCombo.getModelTable().setColumnIdentifiers(this.vtCombo.getNombreColumna());
		for(ComboDTO c:this.mdlCombo.ObtenerCombosActivos()) {
			Object[] fila = {c.getComboId(), c.getDescripcion()};
			this.vtCombo.getModelTable().addRow(fila);
		}
		this.vtCombo.getTable().setModel(this.vtCombo.getModelTable());
	}
	
	private void Agregar() {
		ControladorABMCombo ctr = new ControladorABMCombo(this, this.vtCombo);
		ctr.InicializarCreacion();
	}

	private void Modificar() {
		// TODO Auto-generated method stub
		
	}

	private void Volver() {
		this.ctrVenta.Return();
		this.vtCombo.Close();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtCombo.getBtnAgregar()) {
			this.Agregar();
		}else if(arg0.getSource() == this.vtCombo.getBtnModificar()) {
			this.Modificar();
		}else if(arg0.getSource() == this.vtCombo.getBtnAceptar()) {
			this.Volver();
		}
	}
}
