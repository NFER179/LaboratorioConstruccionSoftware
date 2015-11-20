package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.ABMComboVista;
import vista.ComboVista;

public class ControladorABMCombo implements ActionListener {

	private ControladorCombo ctrCombo;
	private ABMComboVista vtCombo;
	
	public ControladorABMCombo(ControladorCombo Ctr, ComboVista Vista) {
		this.ctrCombo = Ctr;
		
		this.vtCombo = new ABMComboVista(Vista);
	}
	
	public void InicializarCreacion() {
		this.vtCombo.Open();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
