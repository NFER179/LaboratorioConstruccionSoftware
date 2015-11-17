package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import dto.ProductoDTO;

import modelo.ProductoModelo;

import vista.ProductoVista;

public class ControladorProducto implements ActionListener {

	private ControladorVenta ctrVenta;
	private ProductoVista vtProducto;
	private ProductoModelo mdlProducto;
	
	public ControladorProducto(ControladorVenta Ctr) {
		this.ctrVenta = Ctr;
		
		this.vtProducto = new ProductoVista();
		this.vtProducto.getBtnAgregar().addActionListener(this);
		this.vtProducto.getBtnModificar().addActionListener(this);
		this.vtProducto.getBtnEliminar().addActionListener(this);
		this.vtProducto.getBtnVolver().addActionListener(this);
		
		this.mdlProducto = new ProductoModelo();
	}
	
	public void Inicializar() {
		this.CargarTabla();
		this.vtProducto.Open();
	}
	
	private void CargarTabla() {
		this.vtProducto.getModelTable().setRowCount(0);
		this.vtProducto.getModelTable().setColumnCount(0);
		this.vtProducto.getModelTable().setColumnIdentifiers(this.vtProducto.getNombreColumnas());
		for(ProductoDTO p:this.mdlProducto.ObtenerProductos()) {
			Object[] fila = {p.getProductoId(), p.getDescipcion()};
			this.vtProducto.getModelTable().addRow(fila);
		}
		this.vtProducto.getTable().setModel(this.vtProducto.getModelTable());
	}
	
	public void RecargarTabla() {
		this.CargarTabla();
	}
	
	private void Agregar() {
		ControladorABMProducto ctr = new ControladorABMProducto(this, this.vtProducto);
		ctr.InicializarCreacion();
	}

	private void Modificar() {
		JTable t = this.vtProducto.getTable();
		int selectted = t.getSelectedRow();
		
		String pr = t.getValueAt(selectted, 0).toString().trim();
		
		ProductoDTO producto = this.mdlProducto.ObtenerProducto(pr);
		
		ControladorABMProducto ctr = new ControladorABMProducto(this, this.vtProducto);
		ctr.InicializarModificacion(producto);
	}

	private void Eliminar() {
		JTable t = this.vtProducto.getTable();
		int selectedRow = t.getSelectedRow();
		
		String id = t.getValueAt(selectedRow, 0).toString().trim();
		
		this.mdlProducto.QuitarProducto(id);
		
		this.CargarTabla();
	}

	private void Volver() {
		this.ctrVenta.Return();
		this.vtProducto.Close();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtProducto.getBtnAgregar()) {
			this.Agregar();
		}else if(arg0.getSource() == this.vtProducto.getBtnModificar()) {
			this.Modificar();
		}else if(arg0.getSource() == this.vtProducto.getBtnEliminar()) {
			this.Eliminar();
		}else if(arg0.getSource() == this.vtProducto.getBtnVolver()) {
			this.Volver();
		}
	}
}