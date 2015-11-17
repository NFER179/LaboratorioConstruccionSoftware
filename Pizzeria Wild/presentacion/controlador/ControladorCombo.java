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
		this.vtCombo.getBtnCancelar().addActionListener(this);
		
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
			Object[] fila = {c.getComboId(), c.getDescripcion(), c.getLongActivo()};
			this.vtCombo.getModelTable().addRow(fila);
		}
		this.vtCombo.getTable().setModel(this.vtCombo.getModelTable());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtCombo.getBtnAgregar()) {
			
		}else if(arg0.getSource() == this.vtCombo.getBtnModificar()) {
			
		}else if(arg0.getSource() == this.vtCombo.getBtnAceptar()) {
			
		}else if(arg0.getSource() == this.vtCombo.getBtnCancelar()) {
			
		}
	}

}
