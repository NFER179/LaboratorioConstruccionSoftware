package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import modelo.SolicitudModelo;

import dto.SolicitudDTO;

import vista.SolicitudCompraVista;

public class ControladorSolicitud implements ActionListener {

	private Controlador ctr;
	private SolicitudCompraVista vtSolicitudCompra;
	private SolicitudModelo mdlSolicitud;

	public ControladorSolicitud(Controlador Controlador) {
		this.vtSolicitudCompra = new SolicitudCompraVista();
		this.vtSolicitudCompra.getBtnNuevaSolicitud().addActionListener(this);
		this.vtSolicitudCompra.getBtnModificar().addActionListener(this);
		this.vtSolicitudCompra.getBtnVolver().addActionListener(this);

		this.ctr = Controlador;
		this.mdlSolicitud = new SolicitudModelo();
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
			Object[] fila = {soli.getEffdt(), Integer.toString(soli.getNumPedido()), soli.GetEstado()};
			this.vtSolicitudCompra.getModelTable().addRow(fila);
		}
		this.vtSolicitudCompra.getTable().setModel(this.vtSolicitudCompra.getModelTable());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtSolicitudCompra.getBtnNuevaSolicitud()) {
			ControladorCreacionSolicitud ctrCreacionSolicitud = new ControladorCreacionSolicitud(this, this.vtSolicitudCompra);
			ctrCreacionSolicitud.Inicializar();
		} else if (arg0.getSource() == this.vtSolicitudCompra.getBtnModificar()) {
			ControladorCreacionSolicitud ctrCreacionSolicitud = new ControladorCreacionSolicitud(this, this.vtSolicitudCompra);
			
			JTable table = this.vtSolicitudCompra.getTable();
			int filaSeleccionada = table.getSelectedRow();
			String FechaSolicitud = table.getValueAt(filaSeleccionada, 0).toString().trim();
			String NumeroSolicitud = table.getValueAt(filaSeleccionada, 1).toString().trim();
			
			ctrCreacionSolicitud.InicializarModificacion(FechaSolicitud, NumeroSolicitud);
		} else if (arg0.getSource() == this.vtSolicitudCompra.getBtnVolver()) {
			this.ctr.Return();
			this.vtSolicitudCompra.Close();
		}
	}
}