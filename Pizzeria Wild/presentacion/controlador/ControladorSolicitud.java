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
		this.setVtSolicitudCompra(new SolicitudCompraVista());
		this.getVtSolicitudCompra().getBtnNuevaSolicitud().addActionListener(this);
		this.getVtSolicitudCompra().getBtnModificar().addActionListener(this);
		this.getVtSolicitudCompra().getBtnVolver().addActionListener(this);

		this.ctr = Controlador;
		this.mdlSolicitud = new SolicitudModelo();
		this.vldSolicitud = new ValidacionSolicitud(this.getVtSolicitudCompra());
	}

	public void Inicializar() {
		this.CargarTabla();
		this.getVtSolicitudCompra().Open();
	}

	public void CargarTabla() {
		this.getVtSolicitudCompra().getModelTable().setRowCount(0);
		this.getVtSolicitudCompra().getModelTable().setColumnCount(0);
		this.getVtSolicitudCompra().getModelTable().setColumnIdentifiers(this.getVtSolicitudCompra().getNombreColumnas());
		
		for(SolicitudDTO soli:this.mdlSolicitud.ObtenerSolicitudes()) {
			Object[] fila = {soli.getEffdt(), Integer.toString(soli.getNumPedido()), soli.GetEstado()};
			this.getVtSolicitudCompra().getModelTable().addRow(fila);
		}
		this.getVtSolicitudCompra().getTable().setModel(this.getVtSolicitudCompra().getModelTable());
	}

	private void modificar() {
		ControladorCreacionSolicitud ctrCreacionSolicitud = new ControladorCreacionSolicitud(this, this.getVtSolicitudCompra());
		
		JTable table = this.getVtSolicitudCompra().getTable();
		int filaSeleccionada = table.getSelectedRow();
		String FechaSolicitud = table.getValueAt(filaSeleccionada, 0).toString().trim();
		String NumeroSolicitud = table.getValueAt(filaSeleccionada, 1).toString().trim();
		
		ctrCreacionSolicitud.InicializarModificacion(FechaSolicitud, NumeroSolicitud);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.getVtSolicitudCompra().getBtnNuevaSolicitud()) {
			ControladorCreacionSolicitud ctrCreacionSolicitud = new ControladorCreacionSolicitud(this, this.getVtSolicitudCompra());
			ctrCreacionSolicitud.Inicializar();
		} else if (arg0.getSource() == this.getVtSolicitudCompra().getBtnModificar()) {
			if(this.vldSolicitud.ModificarValido()) {
				this.modificar();
			}
		} else if (arg0.getSource() == this.getVtSolicitudCompra().getBtnVolver()) {
			this.ctr.Return();
			this.getVtSolicitudCompra().Close();
		}
	}

	public SolicitudCompraVista getVtSolicitudCompra() {
		return vtSolicitudCompra;
	}

	public void setVtSolicitudCompra(SolicitudCompraVista vtSolicitudCompra) {
		this.vtSolicitudCompra = vtSolicitudCompra;
	}
}