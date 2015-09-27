package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;

import modelo.ProductoModelo;

import dto.ProductoDTO;
import vista.ProductosBusquedaVista;

public class ControladorProductoBusqueda implements ActionListener{

	private ProductosBusquedaVista vtProductoBusqueda;
	private ControladorProductosDePedidos ctrPP;
	private List<ProductoDTO> lstProducto;
	private ProductoModelo mdlProducto;
	
	public ControladorProductoBusqueda(ControladorProductosDePedidos CtrPP, JDialog Dialog) {
		this.vtProductoBusqueda = new ProductosBusquedaVista(Dialog);
		this.vtProductoBusqueda.getBtnAceptar().addActionListener(this);
		this.vtProductoBusqueda.getBtnCancelar().addActionListener(this);
		
		this.ctrPP = CtrPP;
		this.mdlProducto = new ProductoModelo();
	}
	
	public void Iniciar() {
		this.CargarTabla();
		this.vtProductoBusqueda.Open();
	}
	
	private void CargarTabla() {
		this.vtProductoBusqueda.getModelTable().setRowCount(0);
		this.vtProductoBusqueda.getModelTable().setColumnCount(0);
		this.vtProductoBusqueda.getModelTable().setColumnIdentifiers(this.vtProductoBusqueda.getNombreColumnas());
		this.lstProducto = this.mdlProducto.GetProductos();
		
		for (ProductoDTO p:this.lstProducto) {
			Object[] fila = {p.getProductoId(), p.getDescipcion()};
			this.vtProductoBusqueda.getModelTable().addRow(fila);
		}
		this.vtProductoBusqueda.getTable().setModel(this.vtProductoBusqueda.getModelTable());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtProductoBusqueda.getBtnAceptar()) {
			if (this.vtProductoBusqueda.getTable().getSelectedRow() >= 0) {
				String IDProduc = (String)this.vtProductoBusqueda.getTable().getValueAt(this.vtProductoBusqueda.getTable().getSelectedRow(), 0);
				this.ctrPP.CargarProducto(IDProduc);
				this.vtProductoBusqueda.Close();
				this.ctrPP.ActualizarTabla();
			}
		}
		if (arg0.getSource() == this.vtProductoBusqueda.getBtnCancelar()) {
			this.vtProductoBusqueda.Close();
		}
	}
}
