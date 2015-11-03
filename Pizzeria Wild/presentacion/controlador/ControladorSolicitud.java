package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import modelo.SolicitudModelo;

import dto.SolicitudDTO;

import validacion.ValidacionSolicitud;
import vista.SolicitudCompraVista;

public class ControladorSolicitud implements ActionListener {

	private Controlador ctr;
	private SolicitudCompraVista vtSolicitudCompra;
	private SolicitudModelo mdlSolicitud;
	private ValidacionSolicitud vldSolicitud;

	public ControladorSolicitud(Controlador Controlador) {
		this.vtSolicitudCompra = new SolicitudCompraVista();
		this.vtSolicitudCompra.getBtnNuevaSolicitud().addActionListener(this);
		this.vtSolicitudCompra.getBtnModificar().addActionListener(this);
		this.vtSolicitudCompra.getBtnInformacion().addActionListener(this);
		this.vtSolicitudCompra.getBtnSolicitudEntregada().addActionListener(this);
		this.vtSolicitudCompra.getBtnTodasSolicitudes().addActionListener(this);
		this.vtSolicitudCompra.getBtnVolver().addActionListener(this);

		this.ctr = Controlador;
		this.mdlSolicitud = new SolicitudModelo();
		this.vldSolicitud = new ValidacionSolicitud(this.vtSolicitudCompra);
	}

	public void Inicializar() {
		this.CargarTabla();
		this.vtSolicitudCompra.Open();
	}

	public void CargarTabla() {
		this.vtSolicitudCompra.getModelTable().setRowCount(0);
		this.vtSolicitudCompra.getModelTable().setColumnCount(0);
		this.vtSolicitudCompra.getModelTable().setColumnIdentifiers(this.vtSolicitudCompra.getNombreColumnas());
		
		for(SolicitudDTO soli:this.mdlSolicitud.ObtenerSolicitudes()) {
			Object[] fila = {soli.getEffdt(), Integer.toString(soli.getNumPedido()), soli.getEstado()};
			this.vtSolicitudCompra.getModelTable().addRow(fila);
		}
		this.vtSolicitudCompra.getTable().setModel(this.vtSolicitudCompra.getModelTable());
	}

	private void modificar() {
		ControladorCreacionSolicitud ctrCreacionSolicitud = new ControladorCreacionSolicitud(this, this.vtSolicitudCompra);
		
		JTable table = this.vtSolicitudCompra.getTable();
		int filaSeleccionada = table.getSelectedRow();
		String FechaSolicitud = table.getValueAt(filaSeleccionada, 0).toString().trim();
		String NumeroSolicitud = table.getValueAt(filaSeleccionada, 1).toString().trim();
		
		ctrCreacionSolicitud.InicializarModificacion(FechaSolicitud, NumeroSolicitud);
	}
	
	private void Informacion() {
		boolean enviado = false;
		JTable tabla = this.vtSolicitudCompra.getTable();
		int filaSeleccionada = tabla.getSelectedRow();
		
		String FechaSolicitud = tabla.getValueAt(filaSeleccionada, 0).toString().trim();
		String NumeroSolicitud = tabla.getValueAt(filaSeleccionada, 1).toString().trim();
		String Estado = tabla.getValueAt(filaSeleccionada, 2).toString().trim();
		
		if(Estado.toUpperCase().equals("ENVIADO")){
			enviado = true;
		}
		
		ControladorCreacionSolicitud ctrCreacionSolicitud = new ControladorCreacionSolicitud(this, this.vtSolicitudCompra);
		ctrCreacionSolicitud.InicializarInformacionPedido(FechaSolicitud, NumeroSolicitud, enviado);
	}
	
	private void SolicitudRecepcionada() {
		ControladorCostoSolicitud ctrCosto = new ControladorCostoSolicitud(this, this.vtSolicitudCompra);
		ctrCosto.Inicializar();
	}
	
	public void InicializarRecepcionamiento(int Costo) {
		JTable tabla = this.vtSolicitudCompra.getTable();
		int filaSeleccionada = tabla.getSelectedRow();
		
		String fecha = tabla.getValueAt(filaSeleccionada, 0).toString().trim();
		String numSolicitud = tabla.getValueAt(filaSeleccionada, 1).toString().trim();
		
		this.mdlSolicitud.RecepcionarSolicitud(fecha, numSolicitud, Costo);
		
		this.CargarTabla();
	}
	
	private void CambiarTabla() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtSolicitudCompra.getBtnNuevaSolicitud()) {
			ControladorCreacionSolicitud ctrCreacionSolicitud = new ControladorCreacionSolicitud(this, this.vtSolicitudCompra);
			ctrCreacionSolicitud.Inicializar();
		} else if (arg0.getSource() == this.vtSolicitudCompra.getBtnModificar()) {
			if(this.vldSolicitud.ModificarValido()) {
				this.modificar();
			}
		} else if(arg0.getSource() == this.vtSolicitudCompra.getBtnInformacion()) {
			this.Informacion();
		} else if(arg0.getSource() == this.vtSolicitudCompra.getBtnSolicitudEntregada()) {
			if(this.vldSolicitud.SolicitudEntregadaValida()) {
				this.SolicitudRecepcionada();
			}
		} else if(arg0.getSource() == this.vtSolicitudCompra.getBtnTodasSolicitudes()) {
			this.CambiarTabla();
		} else if (arg0.getSource() == this.vtSolicitudCompra.getBtnVolver()) {
			this.ctr.Return();
			this.vtSolicitudCompra.Close();
		}
	}
}