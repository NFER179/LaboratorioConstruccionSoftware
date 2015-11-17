package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private void Agrgar() {
		// TODO Auto-generated method stub
		
	}

	private void Modificar() {
		// TODO Auto-generated method stub
		
	}

	private void Eliminar() {
		// TODO Auto-generated method stub
		
	}

	private void Volver() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtProducto.getBtnAgregar()) {
			this.Agrgar();
		}else if(arg0.getSource() == this.vtProducto.getBtnModificar()) {
			this.Modificar();
		}else if(arg0.getSource() == this.vtProducto.getBtnEliminar()) {
			this.Eliminar();
		}else if(arg0.getSource() == this.vtProducto.getBtnVolver()) {
			this.Volver();
		}
	}
}