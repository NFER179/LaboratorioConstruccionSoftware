package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JTable;

import dto.RepartidorDTO;

import modelo.RepartidorModelo;

import validacion.ValidacionRepartidor;
import vista.RepartidorVista;

public class ControladorRepartidor implements ActionListener {

	private ControladorVenta ctrVenta;
	private RepartidorVista vtRepartidor;
	private ValidacionRepartidor vldRepartidor;
	private RepartidorModelo mdlRepartidor;
	private boolean vistaActivos;
	
	public ControladorRepartidor(ControladorVenta Ctr) {
		this.ctrVenta = Ctr;
		
		this.vtRepartidor = new RepartidorVista();
		this.vtRepartidor.getBtnAgregar().addActionListener(this);
		this.vtRepartidor.getBtnModificar().addActionListener(this);
		this.vtRepartidor.getBtnTodos().addActionListener(this);
		this.vtRepartidor.getBtnVolver().addActionListener(this);
		
		this.vldRepartidor = new ValidacionRepartidor(this.vtRepartidor);
		this.mdlRepartidor = new RepartidorModelo();
		this.vistaActivos = true;
	}
	
	public void Inicializar() {
		this.CargarTablaActivos();
		this.vtRepartidor.Open();
	}
	
	private void CargarTablaActivos() {
		this.vtRepartidor.getModelTable().setRowCount(0);
		this.vtRepartidor.getModelTable().setColumnCount(0);
		this.vtRepartidor.getModelTable().setColumnIdentifiers(this.vtRepartidor.getNombreColumnas());
		for(RepartidorDTO r:this.mdlRepartidor.ObtenerRepartidoresActivos()) {
			Object[] fila = {r.getRepartidorId(), r.getApellido() + " " + r.getNombre(), r.GetLongStringActivo()};
			this.vtRepartidor.getModelTable().addRow(fila);
		}
		this.vtRepartidor.getTable().setModel(this.vtRepartidor.getModelTable());
	}
	
	public void ActualizarTabla() {
		if(this.vistaActivos) {
			this.CargarTablaActivos();
		}
		else{
			this.CargarTablaTodosRepartidores();
		}
	}
	
	private void AgregarRepartidor() {
		ControladorABMRepartidor ctr = new ControladorABMRepartidor(this, this.vtRepartidor);
		ctr.InicializarCreacion();
	}

	private void ModificarRepartidor() {
		ControladorABMRepartidor ctr = new ControladorABMRepartidor(this, this.vtRepartidor);
		
		JTable t = this.vtRepartidor.getTable();
		int selectedRow = t.getSelectedRow();
		
		int idRepartidor = Integer.parseInt(t.getValueAt(selectedRow, 0).toString().trim());
		
		ctr.InicializarModificacion(idRepartidor);
	}
	
	private void CambiarVistaRepartidores() {
		if(this.vistaActivos) {
			this.vistaActivos = false;
			this.vtRepartidor.getLblReoartidoresActivos().setText("Todos los Proveedores:");
			this.vtRepartidor.getBtnTodos().setText("Activos");
			this.CargarTablaTodosRepartidores();
		}
		else{
			this.vistaActivos = true;
			this.vtRepartidor.getLblReoartidoresActivos().setText("Proveedores Avtivos:");
			this.vtRepartidor.getBtnTodos().setText("Todos");
			this.CargarTablaActivos();
		}
	}

	private void CargarTablaTodosRepartidores() {
		this.vtRepartidor.getModelTable().setRowCount(0);
		this.vtRepartidor.getModelTable().setColumnCount(0);
		this.vtRepartidor.getModelTable().setColumnIdentifiers(this.vtRepartidor.getNombreColumnas());
		for(RepartidorDTO r: this.mdlRepartidor.ObtenerTodosLosRepartidores()) {
			Object[] fila = {r.getRepartidorId(), r.getApellido() + " " + r.getNombre(), r.GetLongStringActivo()};
			this.vtRepartidor.getModelTable().addRow(fila);
		}
		this.vtRepartidor.getTable().setModel(this.vtRepartidor.getModelTable());
	}

	private void Volver() {
		this.ctrVenta.Return();
		this.vtRepartidor.Close();
	}
	
	public void Return() {
		this.vtRepartidor.Open();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtRepartidor.getBtnAgregar()) {
			if(this.vistaActivos) {
				this.AgregarRepartidor();
			}
		}else if(arg0.getSource() == this.vtRepartidor.getBtnModificar()) {
			if(this.vldRepartidor.ModificarValido()) {
				this.ModificarRepartidor();
			}
		}else if(arg0.getSource() == this.vtRepartidor.getBtnTodos()) {
			this.CambiarVistaRepartidores();
		}else if(arg0.getSource() == this.vtRepartidor.getBtnVolver()) {
			this.Volver();
		}
	}
}
