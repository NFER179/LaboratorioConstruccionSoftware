package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;

import modelo.CategoriaModelo;
import modelo.MateriaPrimaModelo;

import validacion.ValidacionBusquedaMPProveedor;
import vista.ABMProveedorVista;
import vista.BusquedaMPProveedorVista;

public class ControladorBusquedaMPProveedor implements ActionListener {

	private ControladorABMProveedor ctrABM;
	private BusquedaMPProveedorVista vtBusqueda;
	private ValidacionBusquedaMPProveedor vldBusqueda;
	private CategoriaModelo mdlCategoria;
	private MateriaPrimaModelo mdlMP;
	
	public ControladorBusquedaMPProveedor(ControladorABMProveedor Ctr, ABMProveedorVista Vista) {
		this.ctrABM = Ctr;
		
		this.vtBusqueda = new BusquedaMPProveedorVista(Vista);
		this.vtBusqueda.getBtnAsignar().addActionListener(this);
		this.vtBusqueda.getBtnCancelar().addActionListener(this);
		
		this.vldBusqueda = new ValidacionBusquedaMPProveedor(this, this.vtBusqueda);
		this.mdlCategoria = new CategoriaModelo();
		this.mdlMP = new MateriaPrimaModelo();
	}
	
	public void Inicializar() {
		this.CargarTabla();
		this.vtBusqueda.Open();
	}
	
	private void CargarTabla() {
		this.vtBusqueda.getModelTable().setRowCount(0);
		this.vtBusqueda.getModelTable().setColumnCount(0);
		this.vtBusqueda.getModelTable().setColumnIdentifiers(this.vtBusqueda.getNombreColumnas());
		for(CategoriaDTO c:this.ctrABM.ObtenerCategorias()) {
			for(MateriaPrimaDTO mp:this.mdlCategoria.ObtenerMateriasPrimasPara(c.getIdCategoria())) {
				Object[] fila = {mp.getNombre()};
				this.vtBusqueda.getModelTable().addRow(fila);
			}
		}
		this.vtBusqueda.getTblMT().setModel(this.vtBusqueda.getModelTable());
	}
	
	public List<MateriaPrimaDTO> ObtenerMPAsignadas() {
		return this.ctrABM.ObteberMateriasPrimas();
	}
	
	public List<MateriaPrimaDTO> ObtenerMPSeleccionadas() {
		List<MateriaPrimaDTO> mp = new ArrayList<MateriaPrimaDTO>();
		
		JTable t = this.vtBusqueda.getTblMT();
		int[] rowSelection = t.getSelectedRows();
		
		for(int i = 0 ; i < rowSelection.length ; i++) {
			String materiaPrima = t.getValueAt(rowSelection[i], 0).toString().trim();
			mp.add(this.mdlMP.ObtenerMateriaPrima(materiaPrima));
		}
		
		return mp;
	}
	
	private void Asignar() {
		this.ctrABM.AgregarMateriaPrima(this.ObtenerMPSeleccionadas());
		this.vtBusqueda.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtBusqueda.getBtnAsignar()) {
			if(this.vldBusqueda.AsignarValido()) {
				this.Asignar();
			}
		}else if(arg0.getSource() == this.vtBusqueda.getBtnCancelar()) {
			this.vtBusqueda.Close();
		}
	}
}
