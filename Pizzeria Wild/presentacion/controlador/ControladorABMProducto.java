package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import modelo.ProductoModelo;
import modelo.SaborModelo;

import dto.ProductoDTO;
import dto.SaborDTO;

import vista.ABMProductoVista;
import vista.ProductoVista;

public class ControladorABMProducto implements ActionListener {

	private ControladorProducto ctrProducto;
	private ABMProductoVista vtABM;
	private ProductoModelo mdlProducto;
	private SaborModelo mdlSabor;
	boolean crear;
	
	public ControladorABMProducto(ControladorProducto Ctr, ProductoVista Vista) {
		this.ctrProducto = Ctr;
		
		this.vtABM = new ABMProductoVista(Vista);
		this.vtABM.getBtnAgregar().addActionListener(this);
		this.vtABM.getBtnEliminar().addActionListener(this);
		this.vtABM.getBtnGuardar().addActionListener(this);
		this.vtABM.getBtnCancelar().addActionListener(this);
		
		this.mdlProducto = new ProductoModelo();
		this.mdlSabor = new SaborModelo();
	}
	
	public void InicializarCreacion() {
		this.crear = true;
		this.vtABM.Open();
	}
	
	public void InicializarModificacion(ProductoDTO producto) {
		this.crear = false;
		
		this.vtABM.getTxtIdproducto().setEditable(false);
		this.vtABM.getTxtIdproducto().setEnabled(false);
		this.vtABM.getTxtIdproducto().setText(producto.getProductoId());
		
		this.vtABM.getTxtDescipcion().setText(producto.getDescipcion());
		this.vtABM.getChckbxEleboraCocina().setSelected(producto.isElaboraCocina());
		
		this.CargarSabores(producto);
		
		this.vtABM.Open();
	}
	
	private void CargarSabores(ProductoDTO Producto) {
		this.vtABM.getModelTable().setRowCount(0);
		this.vtABM.getModelTable().setColumnCount(0);
		this.vtABM.getModelTable().setColumnIdentifiers(this.vtABM.getNombreColumnas());
		for(SaborDTO s:this.mdlSabor.ObtenerSabores(Producto.getProductoId())) {
			Object[] fila = {s.getNombre(), s.getPrecio()};
			this.vtABM.getModelTable().addRow(fila);
		}
		this.vtABM.getTable().setModel(this.vtABM.getModelTable());
	}
	
	public boolean Agregar(String sabor, String precio) {
		//hay que validar que el sabor no se repita.
		
		Object[] fila = {sabor, precio};
		this.vtABM.getModelTable().addRow(fila);
		this.vtABM.getTable().setModel(this.vtABM.getModelTable());
		
		return true;
	}
	
	private void Agregar() {
		ControladorSabor ctr = new ControladorSabor(this, this.vtABM);
		ctr.Inicializar();
	}

	private void Eliminar() {
		JTable t = this.vtABM.getTable();
		int[] selectedRows = t.getSelectedRows();
		
		for(int i = selectedRows.length -1 ; i >= 0 ; i--) {
			this.vtABM.getModelTable().removeRow(selectedRows[i]);
		}
		this.vtABM.getTable().setModel(this.vtABM.getModelTable());
	}

	private void Guardar() {
		String ProductoId = this.vtABM.getTxtIdproducto().getText().trim();
		String Descripcion = this.vtABM.getTxtDescipcion().getText().trim();
		boolean ElaboraCocina = this.vtABM.getChckbxEleboraCocina().isSelected();
		
		ProductoDTO p = new ProductoDTO(ProductoId, Descripcion, false, ElaboraCocina);
		
		if(this.crear) {
			this.mdlProducto.CrearProducto(p);
		}
		else{
			this.mdlProducto.ModificarProducto(p);
		}
		
		this.mdlSabor.ElimnarPara(p);
		
		
		JTable t = this.vtABM.getTable();
		for(int i = 0 ; i < t.getRowCount() ; i++) {
			String Nombre = t.getValueAt(i, 0).toString().trim();
			String pString = t.getValueAt(i, 1).toString().trim();
			int Precio = Integer.parseInt(pString);
			
			SaborDTO s =  new SaborDTO(Nombre, Precio);
			
			this.mdlSabor.AgregarSabor(p, s);
		}
		
		this.ctrProducto.RecargarTabla();
		this.vtABM.Close();
	}

	private void Cancelar() {
		this.vtABM.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtABM.getBtnAgregar()) {
			this.Agregar();
		}else if(arg0.getSource() == this.vtABM.getBtnEliminar()) {
			this.Eliminar();
		}else if(arg0.getSource() == this.vtABM.getBtnGuardar()) {
			this.Guardar();
		}else if(arg0.getSource() == this.vtABM.getBtnCancelar()) {
			this.Cancelar();
		}
	}
}