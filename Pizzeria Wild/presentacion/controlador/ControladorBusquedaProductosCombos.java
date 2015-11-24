package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import dto.ProductoDTO;
import dto.SaborDTO;

import modelo.ProductoModelo;
import modelo.SaborModelo;

import utilidades.Msj;
import validacionesCampos.Valida;
import vista.ABMComboVista;
import vista.BusquedaProductosCombosVista;

public class ControladorBusquedaProductosCombos implements ActionListener {

	private ControladorABMCombo ctr;
	private BusquedaProductosCombosVista vtBusqueda;
	private ProductoModelo mdlProducto;
	private SaborModelo mdlSabor;

	public ControladorBusquedaProductosCombos(ControladorABMCombo Ctr,
			ABMComboVista Vista) {
		this.ctr = Ctr;

		this.vtBusqueda = new BusquedaProductosCombosVista(Vista);
		this.vtBusqueda.getComboBox().addActionListener(this);
		this.vtBusqueda.getBtnAceptar().addActionListener(this);
		this.vtBusqueda.getBtnCancelar().addActionListener(this);

		this.mdlProducto = new ProductoModelo();
		this.mdlSabor = new SaborModelo();
	}

	public void Inicializar() {
		this.CargarComboBox();
		String product = this.vtBusqueda.getComboBox().getSelectedItem()
				.toString().trim();
		String desc = this.mdlProducto.ObtenerDescr(product);
		this.vtBusqueda.getTxtDescripcion().setText(desc);
		this.vtBusqueda.getTxtDescripcion().setEnabled(false);
		this.CargarTabla(product);

		this.vtBusqueda.Open();
	}

	private void CargarComboBox() {
		this.vtBusqueda.getModelCbx().removeAllElements();
		for (ProductoDTO p : this.mdlProducto.ObtenerProductos()) {
			this.vtBusqueda.getModelCbx().addElement(p.getProductoId());
		}
		this.vtBusqueda.getComboBox().setModel(this.vtBusqueda.getModelCbx());
	}

	private void CargarTabla(String producto) {
		this.vtBusqueda.getModelTable().setRowCount(0);
		this.vtBusqueda.getModelTable().setColumnCount(0);
		this.vtBusqueda.getModelTable().setColumnIdentifiers(
				this.vtBusqueda.getNombreColumna());
		for (SaborDTO s : this.mdlSabor.ObtenerSabores(producto)) {
			Object[] fila = { s.getNombre() };
			this.vtBusqueda.getModelTable().addRow(fila);
		}
		this.vtBusqueda.getTable().setModel(this.vtBusqueda.getModelTable());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtBusqueda.getComboBox()) {
			this.RecargarTabla();
		} else if (arg0.getSource() == this.vtBusqueda.getBtnAceptar()) {
			this.AceptarProducto();
		} else if (arg0.getSource() == this.vtBusqueda.getBtnCancelar()) {
			this.CancelarBusqueda();
		}
	}

	private void RecargarTabla() {
		if (this.vtBusqueda.getModelCbx().getSize() > 0) {
			String p = this.vtBusqueda.getComboBox().getSelectedItem()
					.toString().trim();
			String desc = this.mdlProducto.ObtenerDescr(p);
			this.vtBusqueda.getTxtDescripcion().setText(desc);
			this.CargarTabla(p);
		}
	}

	private void AceptarProducto() {
		String producto = this.vtBusqueda.getComboBox().getSelectedItem()
				.toString().trim();
		String sabor = "";
		int cantidad = 0;
		JTable t = this.vtBusqueda.getTable();
		int selectedRow = t.getSelectedRow();
		if (selectedRow >= 0) {
			sabor = t.getValueAt(selectedRow, 0).toString().trim();
		} else {
			Msj.advertencia("Advertencia",
					"Debe seleccionar un producto de la lista");
			return;
		}
		if (Valida.esEnteroPositivo(this.vtBusqueda.getTxtCantidad().getText())) {
			cantidad = Integer.parseInt(this.vtBusqueda.getTxtCantidad()
					.getText().trim());
		} else {
			Msj.error("Error",
					"El valor de cantidad debe ser un numero entero positivo");
			return;
		}
		this.ctr.AgregarProductoALista(producto, sabor, cantidad);

		this.vtBusqueda.Close();
	}

	private void CancelarBusqueda() {
		this.vtBusqueda.Close();
	}
}