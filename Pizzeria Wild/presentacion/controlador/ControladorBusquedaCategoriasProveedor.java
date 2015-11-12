package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import modelo.CategoriaModelo;

import dto.CategoriaDTO;

import validacion.ValidacionBusquedaCategoriaProveedor;
import vista.ABMProveedorVista;
import vista.BuscadorRepartidorVista;
import vista.BusquedaCategoriasProveedorVista;

public class ControladorBusquedaCategoriasProveedor implements ActionListener {

	private ControladorABMProveedor ctrABM;
	private BusquedaCategoriasProveedorVista vtBusquedaC;
	private CategoriaModelo mdlCategoria;
	private ValidacionBusquedaCategoriaProveedor vldBusqueda;
	
	public ControladorBusquedaCategoriasProveedor(ControladorABMProveedor Ctr, ABMProveedorVista Vista) {
		this.ctrABM = Ctr;
		
		this.vtBusquedaC = new BusquedaCategoriasProveedorVista(Vista);
		this.vtBusquedaC.getBtnAsignar().addActionListener(this);
		this.vtBusquedaC.getBtnCancelar().addActionListener(this);
		
		this.mdlCategoria = new CategoriaModelo();
		this.vldBusqueda = new ValidacionBusquedaCategoriaProveedor(this, this.vtBusquedaC);
	}
	
	public void Inicializar() {
		this.CargatTabla();
		this.vtBusquedaC.Open();
	}
	
	private void CargatTabla() {
		this.vtBusquedaC.getModelTable().setRowCount(0);
		this.vtBusquedaC.getModelTable().setColumnCount(0);
		this.vtBusquedaC.getModelTable().setColumnIdentifiers(this.vtBusquedaC.getNombrecolumnas());
		for(CategoriaDTO c:this.mdlCategoria.ObtenerCategorias()) {
			Object[] fila = {c.getIdCategoria(), c.getDescripcion()};
			this.vtBusquedaC.getModelTable().addRow(fila);
		}
		this.vtBusquedaC.getTblCategorias().setModel(this.vtBusquedaC.getModelTable());
	}
	
	public List<CategoriaDTO> CategoriasSeleccionadas() {
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
			
		JTable t = this.vtBusquedaC.getTblCategorias();
		int[] rowSelection = t.getSelectedRows();
			
		for(int i = 0 ; i < rowSelection.length ; i++) {
			String IDCategoria = t.getValueAt(rowSelection[i], 0).toString().trim();
			String Descripcion = t.getValueAt(rowSelection[i], 1).toString().trim();
				
			categorias.add(new CategoriaDTO(IDCategoria, Descripcion));
		}
			
		return categorias;
	}
	
	public List<CategoriaDTO> CategoriasYaAsigandas() {
		return this.ctrABM.ObtenerCategorias();
	}

	private void Asignar() {
		this.ctrABM.AgregarCategoria(this.CategoriasSeleccionadas());
		this.vtBusquedaC.Close();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtBusquedaC.getBtnAsignar()) {
			if (this.vldBusqueda.AsignarValido()){
				this.Asignar();
			}
		}else if(arg0.getSource() == this.vtBusquedaC.getBtnCancelar()) {
			this.vtBusquedaC.Close();
		}
	}
}
