package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import dto.ProveedorDTO;

import modelo.ProveedorModelo;

import validacion.ValidacionProveedor;
import vista.ProveedorVista;

public class ControladorProveedor implements ActionListener {

	private ControladorVenta ctrVenta;
	private ProveedorVista vtProveedor;
	private ProveedorModelo mdlProveedor;
	private ValidacionProveedor vldProveedor;
	
	public ControladorProveedor(ControladorVenta Ctr) {
		this.ctrVenta = Ctr;
		
		this.vtProveedor = new ProveedorVista();
		this.vtProveedor.getBtnNuevoProveedor().addActionListener(this);
		this.vtProveedor.getBtnModificar().addActionListener(this);
		this.vtProveedor.getBtnVolver().addActionListener(this);
		
		this.mdlProveedor = new ProveedorModelo();
		this.vldProveedor = new ValidacionProveedor(this.vtProveedor);
	}
	
	public void Inicializar() {
		this.CargarTabla();
		this.vtProveedor.Open();
	}
	
	private void CargarTabla() {
		this.vtProveedor.getModelTable().setRowCount(0);
		this.vtProveedor.getModelTable().setColumnCount(0);
		this.vtProveedor.getModelTable().setColumnIdentifiers(this.vtProveedor.getNombreColumnas());
		for(ProveedorDTO p:this.mdlProveedor.ObtenerProveedores()) {
			Object[] fila = {p.getProveedorId(), p.getNombre(), ProveedorDTO.ParseActivoLongString(p.isActivo())};
			this.vtProveedor.getModelTable().addRow(fila);
		}
		this.vtProveedor.getTable().setModel(this.vtProveedor.getModelTable());
	}
	
	private void NuevoProveedor() {
		ControladorABMProveedor ctrABM = new ControladorABMProveedor(  this.vtProveedor);
		ctrABM.Inicializar();
	}

	private void ModificarProveedor() {
		ControladorABMProveedor ctrABM = new ControladorABMProveedor(  this.vtProveedor);
		
		JTable tabla = this.vtProveedor.getTable();
		int selectRow = tabla.getSelectedRow();
		String proveedorId = tabla.getValueAt(selectRow, 0).toString().trim();
		
		ctrABM.InicializarModificacion(proveedorId);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtProveedor.getBtnNuevoProveedor()) {
			this.NuevoProveedor();
		}else if(arg0.getSource() == this.vtProveedor.getBtnModificar()) {
			if(this.vldProveedor.ModificarValido()) {
				this.ModificarProveedor();
			}
		}else if(arg0.getSource() == this.vtProveedor.getBtnVolver()) {
			this.ctrVenta.Return();
			this.vtProveedor.Close();
		}
	}
}
