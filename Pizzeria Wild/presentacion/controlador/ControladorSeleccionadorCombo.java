package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import dto.ComboActivoDTO;
import dto.ComboDTO;

import modelo.ComboModelo;

import vista.ArmadoVentaVista;
import vista.SeleccionadorCombosVista;

public class ControladorSeleccionadorCombo implements ActionListener {

	private ControladorArmadoVenta ctr;
	private SeleccionadorCombosVista vtSeleccion;
	private ComboModelo mdlCombo;
	
	public ControladorSeleccionadorCombo(ControladorArmadoVenta Ctr, ArmadoVentaVista Vista) {
		this.ctr = Ctr;
		
		this.vtSeleccion = new SeleccionadorCombosVista(Vista);
		this.vtSeleccion.getBtnAgregar().addActionListener(this);
		this.vtSeleccion.getBtnCancelar().addActionListener(this);
		
		this.mdlCombo = new ComboModelo();
	}
	
	public void Inicializar() {
		this.CargarTabla();
		this.vtSeleccion.Open();
	}
	
	private void CargarTabla() {
		this.vtSeleccion.getModelTable().setRowCount(0);
		this.vtSeleccion.getModelTable().setColumnCount(0);
		this.vtSeleccion.getModelTable().setColumnIdentifiers(this.vtSeleccion.getNombreColumnas());
		for(ComboDTO c:this.mdlCombo.ObtenerCombosActivos()){
			int precio = this.mdlCombo.ObtenerPrecioActual(c);
			Object[] fila = {c.getId(), c.getDescripcion(), "$ " + precio};
			this.vtSeleccion.getModelTable().addRow(fila);
		}
		this.vtSeleccion.getTable().setModel(this.vtSeleccion.getModelTable());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtSeleccion.getBtnAgregar()) {
			this.Agregar();
		}else if(arg0.getSource() == this.vtSeleccion.getBtnCancelar()) {
			this.Cancelar();
		}
	}

	private void Agregar() {
		JTable t = this.vtSeleccion.getTable();
		int selected = t.getSelectedRow();
		
		String idS = t.getValueAt(selected, 0).toString().trim();
		int Id = Integer.parseInt(idS);
		
		String Descripcion = t.getValueAt(selected, 1).toString().trim();
		
		ComboDTO c = new ComboDTO(Id, Descripcion);
		
		int cantidad = Integer.parseInt(this.vtSeleccion.getTextField().getText().trim());
		
		this.ctr.AgregarItemCombo(c, cantidad);
		
		this.vtSeleccion.Close();
	}

	private void Cancelar() {
		this.vtSeleccion.Close();
	}
}