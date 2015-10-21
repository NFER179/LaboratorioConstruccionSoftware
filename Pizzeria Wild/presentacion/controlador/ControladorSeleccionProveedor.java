package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import dto.ProveedorDTO;
import dto.ProveedorModelo;
import vista.CreacionSolicitudVista;
import vista.SeleccionProveedorVista;

public class ControladorSeleccionProveedor implements ActionListener {

	private SeleccionProveedorVista vtSeleccion;
	private ControladorCreacionSolicitud ctrCreacion;
	private ProveedorModelo mdlProveedor;
	
	public ControladorSeleccionProveedor(ControladorCreacionSolicitud Controlador, CreacionSolicitudVista Vista) {
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
		this.vtSeleccion.getModelTable().setColumnIdentifiers(this.vtSeleccion.getNombreColumnas());
		for(ProveedorDTO proveedor:this.mdlProveedor.ObtenerProveedores()) {
			Object[] fila = {proveedor.getProveedorId(), proveedor.getNombre()};
			this.vtSeleccion.getModelTable().addRow(fila);
		}
		this.vtSeleccion.getTable().setModel(this.vtSeleccion.getModelTable());
	}
	
	private void SeleccionarProveedor() {
		JTable table = this.vtSeleccion.getTable();
		int filaSeleccionada = table.getSelectedRow();
		
		String IdProveedor = table.getValueAt(filaSeleccionada, 0).toString().trim();
		String Descripcion = table.getValueAt(filaSeleccionada, 1).toString().trim();
		this.ctrCreacion.CargarProveedor(IdProveedor,Descripcion);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtSeleccion.getBtnSeleccionar()) {
			this.SeleccionarProveedor();
			this.vtSeleccion.Close();
		}
		else if(arg0.getSource() == this.vtSeleccion.getBtnCancelar()) {
			this.vtSeleccion.Close();
		}
	}
}