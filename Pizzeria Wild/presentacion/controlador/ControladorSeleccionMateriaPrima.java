package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTable;

import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;

import modelo.CategoriaModelo;
import modelo.MateriaPrimaModelo;

import vista.CategoriaDetalleVista;
import vista.SeleccionMateriaPrimaVista;

public class ControladorSeleccionMateriaPrima implements ActionListener {

	private ControladorCategoriaDetalle ctrCategoriaDetalle;
	private SeleccionMateriaPrimaVista vtSeleccionMT;
	private MateriaPrimaModelo mdlMateriaPrima;
	
	public ControladorSeleccionMateriaPrima(ControladorCategoriaDetalle CtrCategoriaDetalle, CategoriaDetalleVista CategoriaDetalle) {
		this.vtSeleccionMT = new SeleccionMateriaPrimaVista(CategoriaDetalle);
		this.vtSeleccionMT.getBtnAsignar().addActionListener(this);
		this.vtSeleccionMT.getBtnCancelar().addActionListener(this);
		
		this.ctrCategoriaDetalle = CtrCategoriaDetalle;
		this.mdlMateriaPrima = new MateriaPrimaModelo();
	}
	
	public void Inicializar() {
		this.CargarTabla();
		this.vtSeleccionMT.Open();
	}
	
	private void CargarTabla() {
		this.vtSeleccionMT.getModelTable().setRowCount(0);
		this.vtSeleccionMT.getModelTable().setColumnCount(0);
		this.vtSeleccionMT.getModelTable().setColumnIdentifiers(this.vtSeleccionMT.getNombreColumnas());
		
		for (MateriaPrimaDTO mt:this.mdlMateriaPrima.ObtenerMateriasPrimasSinAsignar()) {
			if (this.NoAsignada(mt.getNombre(), this.ctrCategoriaDetalle.MateriasPrimasEnTabla())) {
				Object[] fila = {mt.getNombre()};
				this.vtSeleccionMT.getModelTable().addRow(fila);
			}
		}
		this.vtSeleccionMT.getTable().setModel(this.vtSeleccionMT.getModelTable());
	}
	
	private boolean NoAsignada(String MateriaPrima, List<MateriaPrimaDTO> Asignadas) {
		boolean noAsignada = true;
		
		for (MateriaPrimaDTO mt:Asignadas) {
			if (mt.getNombre().equals(MateriaPrima))
				noAsignada = false;
		}
		
		return noAsignada;
	}
	
//	private void AsignarSeleccion() {
//		JTable tabla = this.vtSeleccionMT.getTable();
//		int[] Seleccion = tabla.getSelectedRows();
//		
//		for (int i = 0 ; i < Seleccion.length ; i++){
//			String MateriaPrima = tabla.getValueAt(Seleccion[i], 0).toString().trim();
//			this.mdlMateriaPrima.AsignarACategoria(MateriaPrima, this.ctrCategoriaDetalle.GetIdCategoria());
//		}
//		
//		this.CargarTabla();
//		this.ctrCategoriaDetalle.ActualizarTabla();
//	}
	private void AsignarSeleccion() {
		JTable tabla = this.vtSeleccionMT.getTable();
		int[] Seleccion = tabla.getSelectedRows();
		List<MateriaPrimaDTO> materiasPrimas = new ArrayList<MateriaPrimaDTO>();
		
		for (int i = 0 ; i < Seleccion.length ; i++) {
			String materiaPrima = tabla.getValueAt(Seleccion[i], 0).toString().trim();
			materiasPrimas.add(new MateriaPrimaDTO(materiaPrima,""));
		}
		
		for (int i = Seleccion.length - 1 ; i >= 0 ; i--) {
			this.vtSeleccionMT.getModelTable().removeRow(Seleccion[i]);
		}
		
		this.ctrCategoriaDetalle.AgregarMateriasPrimas(materiasPrimas);
		this.vtSeleccionMT.getTable().setModel(this.vtSeleccionMT.getModelTable());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtSeleccionMT.getBtnAsignar()) {
			this.AsignarSeleccion();
			this.vtSeleccionMT.Close();
		}
		else if (arg0.getSource() == this.vtSeleccionMT.getBtnCancelar()) {
			this.vtSeleccionMT.Close();
		}
	}
}