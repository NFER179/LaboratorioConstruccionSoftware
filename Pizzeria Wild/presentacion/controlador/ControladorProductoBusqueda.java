package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.ProductoModelo;

import dto.ProductoDTO;
import vista.ProductosBusquedaVista;
import vista.ProductosDeVentasVista;

public class ControladorProductoBusqueda implements ActionListener {

	private ProductosBusquedaVista vtProductoBusqueda;
	private ControladorProductosDeVenta ctrPP;
	private List<ProductoDTO> lstProducto;
	private ProductoModelo mdlProducto;
	private ProductosDeVentasVista vtProdVenta;

	public ControladorProductoBusqueda(ControladorProductosDeVenta CtrPP,
			ProductosDeVentasVista vista) {
		this.vtProdVenta = vista;
		this.vtProductoBusqueda = new ProductosBusquedaVista(vista);
		this.vtProductoBusqueda.getBtnAceptar().addActionListener(this);
		this.vtProductoBusqueda.getBtnCancelar().addActionListener(this);

		this.ctrPP = CtrPP;
		this.mdlProducto = new ProductoModelo();
	}

	public void Iniciar() {
		this.CargarTabla();
		this.vtProdVenta.Close();
		this.vtProductoBusqueda.Open();
	}

	private void CargarTabla() {
		this.vtProductoBusqueda.getModelTable().setRowCount(0);
		this.vtProductoBusqueda.getModelTable().setColumnCount(0);
		this.vtProductoBusqueda.getModelTable().setColumnIdentifiers(
				this.vtProductoBusqueda.getNombreColumnas());
		this.lstProducto = this.mdlProducto.ObtenerProductos();

		for (ProductoDTO p : this.lstProducto) {
			Object[] fila = { p.getProductoId(), p.getDescipcion() };
			this.vtProductoBusqueda.getModelTable().addRow(fila);
		}
		this.vtProductoBusqueda.getTable().setModel(
				this.vtProductoBusqueda.getModelTable());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtProductoBusqueda.getBtnAceptar()) {
			if (this.vtProductoBusqueda.getTable().getSelectedRow() >= 0) {
				String IDProduc = (String) this.vtProductoBusqueda.getTable()
						.getValueAt(
								this.vtProductoBusqueda.getTable()
										.getSelectedRow(), 0);
				this.ctrPP.CargarProducto(IDProduc);
				this.ctrPP.ActualizarTabla();
				this.vtProductoBusqueda.Close();
				this.vtProdVenta.Open();
			} 
			else {
				JOptionPane.showMessageDialog(null,
						"Debe buscar un tipo de producto",
						"Error de Busqueda de Tipos",
						JOptionPane.WARNING_MESSAGE);
			}
			/** Fin Diego ,4 octubre 2015 **/
		}
		if (arg0.getSource() == this.vtProductoBusqueda.getBtnCancelar()) {
			this.vtProductoBusqueda.Close();
			this.vtProdVenta.Open();
		}
	}
}
