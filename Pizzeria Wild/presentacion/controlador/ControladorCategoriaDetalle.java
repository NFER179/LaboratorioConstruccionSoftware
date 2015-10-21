package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;

import modelo.CategoriaModelo;

import vista.CategoriaDetalleVista;
import vista.CategoriaVista;

public class ControladorCategoriaDetalle implements ActionListener {

	private ControladorCategoria ctrCategoria;
	private CategoriaDetalleVista vtCategoriadetalle;
	private CategoriaModelo mdlCategoria;
	private boolean modificacion;
	
	public ControladorCategoriaDetalle(ControladorCategoria CtrCategoria, CategoriaVista VistaCategoria) {
		this.vtCategoriadetalle = new CategoriaDetalleVista(VistaCategoria);
		this.vtCategoriadetalle.getBtnAgregar().addActionListener(this);
		this.vtCategoriadetalle.getBtnQuitar().addActionListener(this);
		this.vtCategoriadetalle.getBtnGuardar().addActionListener(this);
		this.vtCategoriadetalle.getBtnCancelar().addActionListener(this);
		
		this.ctrCategoria = CtrCategoria;
		this.mdlCategoria = new CategoriaModelo();
	}
	
	public void InicializarNueva() {
		this.modificacion = false;
		this.CargarTabla();
		this.vtCategoriadetalle.Open();
	}
	
	public void InicializarModificacion(String Categoria) {
		this.vtCategoriadetalle.getTxtIdcategoria().setText(Categoria);
		this.vtCategoriadetalle.getTxtIdcategoria().setEditable(false);
		this.vtCategoriadetalle.getTxtIdcategoria().setEnabled(false);
		this.modificacion = true;
		this.CargarDescripcion(Categoria);
		this.CargarTablaPara(Categoria);
		this.vtCategoriadetalle.Open();
	}

	private void CargarTabla() {
		this.vtCategoriadetalle.getModelTable().setRowCount(0);
		this.vtCategoriadetalle.getModelTable().setColumnCount(0);
		this.vtCategoriadetalle.getModelTable().setColumnIdentifiers(this.vtCategoriadetalle.getNombreColumnas());
		
		this.vtCategoriadetalle.getTable().setModel(this.vtCategoriadetalle.getModelTable());
	}
	
	private void CargarDescripcion(String Categoria) {
		String descr = this.mdlCategoria.ObtenerDescripcion(Categoria);
		this.vtCategoriadetalle.getTxtDescr().setText(descr);
	}
	
	private void CargarTablaPara(String Categoria) {
		this.vtCategoriadetalle.getModelTable().setRowCount(0);
		this.vtCategoriadetalle.getModelTable().setColumnCount(0);
		this.vtCategoriadetalle.getModelTable().setColumnIdentifiers(this.vtCategoriadetalle.getNombreColumnas());
		
		for(MateriaPrimaDTO mt:this.mdlCategoria.ObtenerMateriasPrimasPara(Categoria)) {
			Object[] fila = {mt.getNombre()};
			this.vtCategoriadetalle.getModelTable().addRow(fila);
		}
		this.vtCategoriadetalle.getTable().setModel(this.vtCategoriadetalle.getModelTable());
	}
	
//	public String GetIdCategoria() {
//		return this.vtCategoriadetalle.getTxtIdcategoria().getText().trim();
//	}
	
	public List<MateriaPrimaDTO> MateriasPrimasEnTabla() {
		JTable tabla = this.vtCategoriadetalle.getTable();
		List<MateriaPrimaDTO> mt = new ArrayList<MateriaPrimaDTO>();
		
		for(int i = 0 ; i < tabla.getRowCount() ; i++) {
			mt.add(new MateriaPrimaDTO(tabla.getValueAt(i, 0).toString().trim(),""));
		}
		
		return mt;
	}
	
	public void AgregarMateriasPrimas(List<MateriaPrimaDTO> MateriasPrimas) {
		for(MateriaPrimaDTO mt:MateriasPrimas) {
			Object[] fila = {mt.getNombre()};
			this.vtCategoriadetalle.getModelTable().addRow(fila);
		}
		this.vtCategoriadetalle.getTable().setModel(this.vtCategoriadetalle.getModelTable());
	}
	
//	private void QuitarAsignacion() {
//		JTable tabla = this.vtCategoriadetalle.getTable();
//		int[] Seleccion = tabla.getSelectedRows();
//		
//		for(int i = 0 ; i < Seleccion.length ; i++) {
//			String materiaPrima = tabla.getValueAt(Seleccion[i], 0).toString().trim();
//			this.mdlCategoria.QuitarAsignacion(this.GetIdCategoria(), materiaPrima);
//		}
//	}
	private void QuitarAsignacion() {
		JTable tabla = this.vtCategoriadetalle.getTable();
		int[] Seleccion = tabla.getSelectedRows();
		
		for(int i = Seleccion.length - 1 ; i >= 0 ; i--) {
			this.vtCategoriadetalle.getModelTable().removeRow(Seleccion[i]);
		}
		tabla.setModel(this.vtCategoriadetalle.getModelTable());
	}
	
	private void Guardar() {
		String categoria = this.vtCategoriadetalle.getTxtIdcategoria().getText().trim();
		String descripcion = this.vtCategoriadetalle.getTxtDescr().getText().trim();
		CategoriaDTO c = new CategoriaDTO(categoria, descripcion);
		
		if (this.modificacion) {
			this.mdlCategoria.ActualizarDescripcion(c);
			this.mdlCategoria.QuitarAsignaciones(c);
		}
		else{
			this.mdlCategoria.CrearCategoria(c);
		}
		
		JTable tabla = this.vtCategoriadetalle.getTable();
		
		for(int i = 0 ; i < tabla.getRowCount() ; i++) {
			MateriaPrimaDTO materiaPrima = new MateriaPrimaDTO(tabla.getValueAt(i, 0).toString().trim(),"");
			this.mdlCategoria.AsignarMateriaPrima(c, materiaPrima);
		}
		
		this.ctrCategoria.ActualizarTabla();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCategoriadetalle.getBtnAgregar()) {
			ControladorSeleccionMateriaPrima ctrSMP = new ControladorSeleccionMateriaPrima(this, this.vtCategoriadetalle);
			ctrSMP.Inicializar();
		}
		else if(arg0.getSource() == this.vtCategoriadetalle.getBtnQuitar()) {
			this.QuitarAsignacion();
		}
		else if(arg0.getSource() == this.vtCategoriadetalle.getBtnGuardar()) {
			this.Guardar();
			this.vtCategoriadetalle.Close();
		}
		else if(arg0.getSource() == this.vtCategoriadetalle.getBtnCancelar()) {
			this.vtCategoriadetalle.Close();
		}
	}
}