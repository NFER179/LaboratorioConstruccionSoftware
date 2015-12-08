package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

import modelo.ProveedorModelo;
import dto.ProveedorDTO;
import utilidades.Msj;
import vista.CreacionSolicitudVista;
import vista.SeleccionProveedorVista;

public class ControladorSeleccionProveedor implements ActionListener {

	private SeleccionProveedorVista vtSeleccion;
	private ControladorCreacionSolicitud ctrCreacion;
	private ProveedorModelo mdlProveedor;

	public ControladorSeleccionProveedor(
			ControladorCreacionSolicitud Controlador,
			CreacionSolicitudVista Vista) {
		this.vtSeleccion = new SeleccionProveedorVista(Vista);
		this.vtSeleccion.getBtnSeleccionar().addActionListener(this);
		this.vtSeleccion.getBtnCancelar().addActionListener(this);

		this.ctrCreacion = Controlador;
		this.mdlProveedor = new ProveedorModelo();
	}

	public void Inicializar() {
		this.CargarTabla();
		this.vtSeleccion.Open();
	}

	private void CargarTabla() {
		this.vtSeleccion.getModelTable().setRowCount(0);
		this.vtSeleccion.getModelTable().setColumnCount(0);
		this.vtSeleccion.getModelTable().setColumnIdentifiers(
				this.vtSeleccion.getNombreColumnas());
		for (ProveedorDTO proveedor : this.mdlProveedor
				.ObtenerProveedoresActivos()) {
			Object[] fila = { proveedor.getProveedorId(), proveedor.getNombre() };
			this.vtSeleccion.getModelTable().addRow(fila);
		}
		this.vtSeleccion.getTable().setModel(this.vtSeleccion.getModelTable());
	}

	private void SeleccionarProveedor() {
		JTable table = this.vtSeleccion.getTable();
		int filaSeleccionada = table.getSelectedRow();
		if (filaSeleccionada < 0) {
			Msj.error("Error", "Debe seleccionar al menos un proveedor");
		} else {
			String IdProveedor = table.getValueAt(filaSeleccionada, 0)
					.toString().trim();
			String Descripcion = table.getValueAt(filaSeleccionada, 1)
					.toString().trim();
			this.ctrCreacion.CargarProveedor(IdProveedor, Descripcion);
			this.vtSeleccion.Close();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtSeleccion.getBtnSeleccionar()) {
			this.SeleccionarProveedor();
		} else if (arg0.getSource() == this.vtSeleccion.getBtnCancelar()) {
			this.vtSeleccion.Close();
		}
	}
}