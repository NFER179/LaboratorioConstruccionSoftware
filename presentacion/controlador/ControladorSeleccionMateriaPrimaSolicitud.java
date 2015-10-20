package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.MateriaPrimaDTO;
import dto.ProveedorModelo;

import vista.CreacionSolicitudVista;
import vista.SeleccionMateriaPrimaSolicitudVista;

public class ControladorSeleccionMateriaPrimaSolicitud implements ActionListener {
	
	private SeleccionMateriaPrimaSolicitudVista vtSMPS;
	private ControladorCreacionSolicitud ctrCreacionSolicitud;
	private ProveedorModelo mdlProveedor;
	private String proveedor;
	
	public ControladorSeleccionMateriaPrimaSolicitud(ControladorCreacionSolicitud arg0, CreacionSolicitudVista arg1) {
		this.vtSMPS = new SeleccionMateriaPrimaSolicitudVista(arg1);
		this.vtSMPS.getBtnAceptar().addActionListener(this);
		this.vtSMPS.getBtnCancelar().addActionListener(this);
		
		this.ctrCreacionSolicitud = arg0;
		this.mdlProveedor = new ProveedorModelo();
		this.proveedor = this.ctrCreacionSolicitud.ObtenerProveedor();
	}
	
	public void Inicializar() {
		this.CargarTabla();
		this.vtSMPS.Open();
	}
	
	private void CargarTabla() {
		this.vtSMPS.getModelTable().setRowCount(0);
		this.vtSMPS.getModelTable().setColumnCount(0);
		this.vtSMPS.getModelTable().setColumnIdentifiers(this.vtSMPS.getNombreColumnas());
		
		for(MateriaPrimaDTO mt:this.mdlProveedor.ObtenerMateriasPrimasDeProveedor(this.proveedor)){
			Object[] fila = {mt.getNombre(), mt.getUnidad()};
			this.vtSMPS.getModelTable().addRow(fila);
		}
		this.vtSMPS.getTable().setModel(this.vtSMPS.getModelTable());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtSMPS.getBtnAceptar()) {
			
		}
		else if(arg0.getSource() == this.vtSMPS.getBtnCancelar()) {
			this.vtSMPS.Close();
		}
	}
}