package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import validacion.ValidacionCreacionSolicitud;
import vista.CreacionSolicitudVista;
import vista.SolicitudCompraVista;

public class ControladorCreacionSolicitud implements ActionListener{

	private ControladorSolicitud ctrSolicitud;
	private CreacionSolicitudVista vtCreacionSolicitud;
	private ValidacionCreacionSolicitud vldCreacion;
	
	public ControladorCreacionSolicitud(ControladorSolicitud Ctr, SolicitudCompraVista vista){
		this.vtCreacionSolicitud = new CreacionSolicitudVista(vista);
		this.vtCreacionSolicitud.getBtnBuscar().addActionListener(this);
		this.vtCreacionSolicitud.getBtnAgregar().addActionListener(this);
		this.vtCreacionSolicitud.getBtnQuitar().addActionListener(this);
		this.vtCreacionSolicitud.getBtnVolver().addActionListener(this);
		
		this.ctrSolicitud = Ctr;
		this.vldCreacion = new ValidacionCreacionSolicitud(this.vtCreacionSolicitud);
	}
	
	public void Inicializar() {
		this.vtCreacionSolicitud.Open();
	}
	
	public String ObtenerProveedor() {
		return this.vtCreacionSolicitud.getTxtIdproveedor().getText().trim();
	}
	
	public void CargarProveedor(String ProveedorId, String Descripcion) {
		this.vtCreacionSolicitud.getTxtIdproveedor().setText(ProveedorId);
		this.vtCreacionSolicitud.getTxtDescrproveedor().setText(Descripcion);
	}
	

	public void AgregarMateriaPrima(String MateriaPrima, String Cantidad) {
		/* Si la materia prima esta debe sumar */
		Object[] fila = {MateriaPrima, Cantidad};
		this.vtCreacionSolicitud.getModelTable().addRow(fila);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtCreacionSolicitud.getBtnBuscar()) {
			ControladorSeleccionProveedor ctrSP = new ControladorSeleccionProveedor(this, this.vtCreacionSolicitud);
			ctrSP.Inicializar();
		}
		else if(arg0.getSource() == this.vtCreacionSolicitud.getBtnAgregar()) {
			if(this.vldCreacion.SeleccionMateriasPrimas()) {
				ControladorSeleccionMateriaPrimaSolicitud ctrSMPS = new ControladorSeleccionMateriaPrimaSolicitud(this, this.vtCreacionSolicitud);
				ctrSMPS.Inicializar();
			}
		}
		else if(arg0.getSource() == this.vtCreacionSolicitud.getBtnQuitar()) {
			
		}
		else if(arg0.getSource() == this.vtCreacionSolicitud.getBtnVolver()) {
			this.vtCreacionSolicitud.Close();
		}
	}
}