package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import utilidades.Fecha;
import vista.ReporteVista;
import vista.SeleccionFechasVista;

public class ControladorSeleccionFechas implements ActionListener {

	private ControladorReporte ctrReporte;
	private SeleccionFechasVista vtSeleccion;
	
	public ControladorSeleccionFechas(ControladorReporte Ctr, ReporteVista Vista) {
		this.ctrReporte = Ctr;
		
		this.vtSeleccion = new SeleccionFechasVista(Vista);
		this.vtSeleccion.getRdbtnPorDia().addActionListener(this);
		this.vtSeleccion.getRdbtnRangoDeFechas().addActionListener(this);
		this.vtSeleccion.getBtnAceptar().addActionListener(this);
		this.vtSeleccion.getBtnCancelar().addActionListener(this);
	}
	
	public void Inicializar() {
		this.GrisarTodo();
		this.vtSeleccion.getRdbtnPorDia().setSelected(true);
		this.vtSeleccion.getCbxDia().setEnabled(true);
		
		this.CargarComboBox();
		
		this.vtSeleccion.Open();
	}
	
	@SuppressWarnings("unchecked")
	private void CargarComboBox() {
		this.vtSeleccion.getCbxDia().removeAllItems();
		DefaultComboBoxModel<String> cm = new DefaultComboBoxModel<String>();
		DefaultComboBoxModel<String> cm1 = new DefaultComboBoxModel<String>();
		DefaultComboBoxModel<String> cm2 = new DefaultComboBoxModel<String>();
		for(String s:Fecha.Fechas()) {
			cm.addElement(s);
			cm1.addElement(s);
			cm2.addElement(s);
		}
		this.vtSeleccion.getCbxDia().setModel(cm);
		this.vtSeleccion.getCbxFrom().setModel(cm1);
		this.vtSeleccion.getCbxTo().setModel(cm2);
	}

	private void GrisarTodo() {
		this.vtSeleccion.getCbxDia().setEnabled(false);
		
		this.vtSeleccion.getCbxFrom().setEnabled(false);
		
		this.vtSeleccion.getCbxTo().setEnabled(false);
	}
	
	private void DesgrisarDia() {
		this.GrisarTodo();
		this.vtSeleccion.getCbxDia().setEnabled(true);
		this.vtSeleccion.getCbxDia().setEditable(true);
	}

	private void DesgrisarRango() {
		this.GrisarTodo();
		
		this.vtSeleccion.getCbxFrom().setEnabled(true);
		
		this.vtSeleccion.getCbxTo().setEnabled(true);
	}
	
	private void Aceptar() {
		if(this.vtSeleccion.getRdbtnPorDia().isSelected()) {
			String fecha = this.vtSeleccion.getCbxDia().getSelectedItem().toString().trim();
			this.ctrReporte.SetRangoFechas(fecha, fecha);
		}else if(this.vtSeleccion.getRdbtnRangoDeFechas().isSelected()) {
			String from = this.vtSeleccion.getCbxFrom().getSelectedItem().toString().trim();
			String to = this.vtSeleccion.getCbxTo().getSelectedItem().toString().trim();
			this.ctrReporte.SetRangoFechas(from, to);
		}
		
		this.vtSeleccion.Close();
	}
	
	private void Cancelar() {
		this.ctrReporte.NoEjecutarReporte();
		this.vtSeleccion.Close();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtSeleccion.getRdbtnPorDia()) {
			this.DesgrisarDia();
		}else if(arg0.getSource() == this.vtSeleccion.getRdbtnRangoDeFechas()) {
			this.DesgrisarRango();
		}else if(arg0.getSource() == this.vtSeleccion.getBtnAceptar()) {
			this.Aceptar();
		}else if(arg0.getSource() == this.vtSeleccion.getBtnCancelar()) {
			this.Cancelar();
		}
	}
}