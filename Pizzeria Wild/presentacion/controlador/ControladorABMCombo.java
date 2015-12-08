package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import dto.ComboActivoDTO;
import dto.ComboDTO;
import dto.ComboProductoDTO;

import modelo.ComboModelo;
import modelo.SaborModelo;

import utilidades.Fecha;
import utilidades.Msj;
import validacionesCampos.Valida;
import vista.ABMComboVista;
import vista.ComboVista;

public class ControladorABMCombo implements ActionListener {

	private ControladorCombo ctrCombo;
	private ABMComboVista vtComboABM;
	private ComboModelo mdlCombo;
	private SaborModelo mdlSabor;
	private List<ComboActivoDTO> cActivoList;
	private int Pos;
	private boolean creacion;
	private boolean close;
	private ComboVista vtCombo;

	public ControladorABMCombo(ControladorCombo Ctr, ComboVista Vista) {
		this.ctrCombo = Ctr;
		this.vtCombo = Vista;
		this.vtComboABM = new ABMComboVista(Vista);
		this.vtComboABM.getBtnEdit().addActionListener(this);
		this.vtComboABM.getBtnAnterior().addActionListener(this);
		this.vtComboABM.getBtnSiguiente().addActionListener(this);
		this.vtComboABM.getBtnAgregarProducto().addActionListener(this);
		this.vtComboABM.getBtnEliminarProducto().addActionListener(this);
		this.vtComboABM.getBtnAgregar().addActionListener(this);
		this.vtComboABM.getBtnModificar().addActionListener(this);
		this.vtComboABM.getBtnEliminar().addActionListener(this);
		this.vtComboABM.getBtnGuardar().addActionListener(this);
		this.vtComboABM.getBtnCancelar().addActionListener(this);
		this.vtComboABM.getBtnVolver().addActionListener(this);

		this.mdlCombo = new ComboModelo();
		this.mdlSabor = new SaborModelo();
		this.cActivoList = new ArrayList<ComboActivoDTO>();
		this.Pos = 0;
		this.close = false;
	}

	public void InicializarCreacion() {
		this.creacion = true;
		this.close = true;

		int numCombo = this.mdlCombo.ObtenerNuevoIdCombo();
		this.vtComboABM.getTxtIdcombo().setText(Integer.toString(numCombo));

		this.vtComboABM.getTxtDescripcion().setEditable(true);
		this.vtComboABM.getTxtDescripcion().setEnabled(true);

		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnEdit());

		this.vtComboABM.getPanel().remove(this.vtComboABM.getBtnAnterior());
		this.vtComboABM.getLblFila().setText("1 / 1");
		this.vtComboABM.getPanel().remove(this.vtComboABM.getBtnSiguiente());
		this.vtComboABM.getPanel().remove(this.vtComboABM.getTxtFecha());

		this.vtComboABM.getChckbxActivo().setEnabled(true);

		this.vtComboABM.getTxtPrecio().setEditable(true);
		this.vtComboABM.getTxtPrecio().setEnabled(true);

		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnAgregar());
		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnModificar());
		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnEliminar());
		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnVolver());
		this.vtCombo.Close();
		this.vtComboABM.Open();
	}

	public void InicializarInformacion(ComboDTO combo, int selectesRow) {
		this.creacion = false;

		this.vtComboABM.getTxtIdcombo().setText(combo.getId() + "");
		this.vtComboABM.getTxtDescripcion().setText(combo.getDescripcion());

		this.cActivoList = this.mdlCombo.ObtenerCombosEnAdelante(combo);

		this.vtComboABM.getLblFila().setText(
				(this.Pos + 1) + " de " + this.cActivoList.size());

		this.vtComboABM.getChckbxActivo().setSelected(
				this.cActivoList.get(this.Pos).isActivo());
		this.vtComboABM.getTxtFecha().setText(
				this.cActivoList.get(this.Pos).getEfft());
		this.vtComboABM.getDateChooser().setVisible(false);

		this.CargarProductosPara(this.cActivoList.get(this.Pos));

		this.vtComboABM.getPanel().remove(
				this.vtComboABM.getBtnAgregarProducto());
		this.vtComboABM.getPanel().remove(
				this.vtComboABM.getBtnEliminarProducto());

		this.CalcularPrecioTotal();
		this.vtComboABM.getTxtPrecio().setText(
				this.cActivoList.get(this.Pos).getPrecio() + "");

		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnGuardar());
		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnCancelar());
		this.vtCombo.Close();
		this.vtComboABM.Open();
	}

	private void CargarProductosPara(ComboActivoDTO cActivo) {
		this.vtComboABM.getModelTable().setRowCount(0);
		this.vtComboABM.getModelTable().setColumnCount(0);
		this.vtComboABM.getModelTable().setColumnIdentifiers(
				this.vtComboABM.getNombreColumnas());
		for (ComboProductoDTO cp : this.mdlCombo.ObtenerProductosPara(cActivo)) {
			int precioTotal = cp.getCantidad()
					* this.mdlSabor.ObtenerPrecio(cp.getProducto(),
							cp.getSabor());
			Object[] fila = { cp.getProducto(), cp.getSabor(),
					cp.getCantidad(), this.AgregarMoneda(precioTotal) };
			this.vtComboABM.getModelTable().addRow(fila);
		}
		this.vtComboABM.getTable().setModel(this.vtComboABM.getModelTable());
	}

	public void AgregarProductoALista(String producto, String sabor,
			int cantidad) {
		int precioparcial = this.mdlSabor.ObtenerPrecio(producto, sabor);

		int precioTotal = precioparcial * cantidad;

		Object[] fila = { producto, sabor, cantidad,
				this.AgregarMoneda(precioTotal) };
		boolean debeAgregar = true;
		for (int i = 0; i < this.vtComboABM.getModelTable().getRowCount(); i++) {
			String tipo = this.vtComboABM.getModelTable().getValueAt(i, 0)
					.toString();
			String prod = this.vtComboABM.getModelTable().getValueAt(i, 1)
					.toString();
			String cant = this.vtComboABM.getModelTable().getValueAt(i, 2)
					.toString();

			// a = (Object[]) a;
			if (tipo.equals(producto) && prod.equals(sabor)) {
				debeAgregar = false;
				int nuevaCantidad = Integer.parseInt(cant) + cantidad;
				this.vtComboABM.getModelTable().setValueAt(nuevaCantidad, i, 2);
				this.vtComboABM.getModelTable()
						.setValueAt(
								this.AgregarMoneda(precioparcial
										* nuevaCantidad), i, 3);
			}
		}
		if (debeAgregar) {
			this.vtComboABM.getModelTable().addRow(fila);
		}
		this.vtComboABM.getTable().setModel(this.vtComboABM.getModelTable());

		this.CalcularPrecioTotal();
	}

	private void CalcularPrecioTotal() {
		JTable t = this.vtComboABM.getTable();
		int precioTotal = 0;
		for (int i = 0; i < t.getRowCount(); i++) {
			precioTotal += this.QuitarMondeda(t.getValueAt(i, 3).toString()
					.trim());
		}

		this.vtComboABM.getTxtPrecioTotal().setText("" + precioTotal);
	}

	private String AgregarMoneda(int arg0) {
		return "$ " + Integer.toString(arg0);
	}

	private int QuitarMondeda(String arg0) {
		return Integer.parseInt(arg0.split(" ")[1]);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtComboABM.getBtnEdit()) {
			this.EditarDescripcion();
		} else if (arg0.getSource() == this.vtComboABM.getBtnAnterior()) {
			this.AnteriorEffdt();
		} else if (arg0.getSource() == this.vtComboABM.getBtnSiguiente()) {
			this.SiguienteEffdt();
		} else if (arg0.getSource() == this.vtComboABM.getBtnAgregarProducto()) {
			this.AgregarProducto();
		} else if (arg0.getSource() == this.vtComboABM.getBtnEliminarProducto()) {
			this.EliminarProducto();
		} else if (arg0.getSource() == this.vtComboABM.getBtnAgregar()) {
			this.AgregarEffdt();
		} else if (arg0.getSource() == this.vtComboABM.getBtnModificar()) {
			this.ModificarEffdt();
		} else if (arg0.getSource() == this.vtComboABM.getBtnEliminar()) {
			this.Eliminar();
		} else if (arg0.getSource() == this.vtComboABM.getBtnGuardar()) {
			this.Guardar();
		} else if (arg0.getSource() == this.vtComboABM.getBtnCancelar()) {
			this.Cancelar();
		} else if (arg0.getSource() == this.vtComboABM.getBtnVolver()) {
			this.Volver();
		}
	}

	private void EditarDescripcion() {
		String Ndescr = JOptionPane.showInputDialog(null, "Nueva Descripcion",
				this.vtComboABM.getTxtDescripcion().getText());
		if (Ndescr == null || Ndescr.trim().equals("")) {
			return;
		}
		int Id = Integer.parseInt(this.vtComboABM.getTxtIdcombo().getText()
				.trim());
		ComboDTO c = new ComboDTO(Id, Ndescr);

		this.mdlCombo.ModificarDescripcion(c);
		this.vtComboABM.getTxtDescripcion().setText(Ndescr);
		this.ctrCombo.CargarTabla();
	}

	private void AnteriorEffdt() {
		if (this.Pos > 0)
			this.Pos--;
		this.RepaintEffdt(this.cActivoList.get(this.Pos));
	}

	private void SiguienteEffdt() {
		if (this.Pos < this.cActivoList.size() - 1)
			this.Pos++;
		this.RepaintEffdt(this.cActivoList.get(this.Pos));
	}

	private void RepaintEffdt(ComboActivoDTO ca) {
		this.vtComboABM.getLblFila().setText(
				(this.Pos + 1) + " de " + this.cActivoList.size());

		this.vtComboABM.getTxtFecha().setText(ca.getEfft());
		this.vtComboABM.getChckbxActivo().setSelected(ca.isActivo());

		this.CargarProductosPara(ca);

		this.CalcularPrecioTotal();

		this.vtComboABM.getTxtPrecio().setText(ca.getPrecio() + "");
	}

	private void AgregarProducto() {
		new ControladorBusquedaProductosCombos(this, this.vtComboABM)
				.Inicializar();
	}

	private void EliminarProducto() {
		JTable t = this.vtComboABM.getTable();
		int[] selected = t.getSelectedRows();

		for (int i = selected.length - 1; i >= 0; i--) {
			this.vtComboABM.getModelTable().removeRow(selected[i]);
		}

		t.setModel(this.vtComboABM.getModelTable());

		this.CalcularPrecioTotal();
	}

	private void AgregarEffdt() {
		this.creacion = true;
		this.close = false;
		this.ModoCreacion(true);
	}

	private void ModificarEffdt() {
		this.close = false;
		this.ModoCreacion(false);
	}

	private void ModoCreacion(boolean creacion) {
		this.vtComboABM.getLblFila().setText("");

		this.vtComboABM.getPanel().remove(this.vtComboABM.getBtnAnterior());
		this.vtComboABM.getPanel().remove(this.vtComboABM.getBtnSiguiente());

		if (creacion) {
			String IdS = this.vtComboABM.getTxtIdcombo().getText().trim();
			int Id = Integer.parseInt(IdS);
			String Descripcion = this.vtComboABM.getTxtDescripcion().getText()
					.trim();

			ComboDTO c = new ComboDTO(Id, Descripcion);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				this.vtComboABM.getDateChooser().setDate(
						sdf.parse(this.mdlCombo.ObtenerSiguienteFecha(c)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.vtComboABM.getPanel().remove(this.vtComboABM.getTxtFecha());
			this.vtComboABM.getDateChooser().setVisible(true);
		}

		this.vtComboABM.getPanel().add(this.vtComboABM.getBtnAgregarProducto());
		this.vtComboABM.getPanel()
				.add(this.vtComboABM.getBtnEliminarProducto());

		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnAgregar());
		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnModificar());
		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnEliminar());
		this.vtComboABM.EliminarComponente(this.vtComboABM.getBtnVolver());

		this.vtComboABM.add(this.vtComboABM.getBtnGuardar());
		this.vtComboABM.add(this.vtComboABM.getBtnCancelar());

		this.vtComboABM.getChckbxActivo().setEnabled(true);
		this.vtComboABM.getTxtPrecio().setEditable(true);
		this.vtComboABM.getTxtPrecio().setEnabled(true);

		this.vtComboABM.repaint();
	}

	private void ModoInformacion() {
		this.vtComboABM.getLblFila().setText(
				(this.Pos + 1) + " de " + this.cActivoList.size());

		this.vtComboABM.getTxtDescripcion().setEditable(false);
		this.vtComboABM.getTxtDescripcion().setEditable(false);

		this.vtComboABM.getPanel().add(this.vtComboABM.getBtnAnterior());
		this.vtComboABM.getPanel().add(this.vtComboABM.getBtnSiguiente());

		this.vtComboABM.getPanel().add(this.vtComboABM.getTxtFecha());
		this.vtComboABM.getDateChooser().setVisible(false);

		this.vtComboABM.getPanel().remove(
				this.vtComboABM.getBtnAgregarProducto());
		this.vtComboABM.getPanel().remove(
				this.vtComboABM.getBtnEliminarProducto());

		this.vtComboABM.add(this.vtComboABM.getBtnAgregar());
		this.vtComboABM.add(this.vtComboABM.getBtnModificar());
		this.vtComboABM.add(this.vtComboABM.getBtnEliminar());
		this.vtComboABM.add(this.vtComboABM.getBtnVolver());

		this.vtComboABM.remove(this.vtComboABM.getBtnGuardar());
		this.vtComboABM.remove(this.vtComboABM.getBtnCancelar());

		this.vtComboABM.getChckbxActivo().setEnabled(false);
		this.vtComboABM.getTxtPrecio().setEditable(false);
		this.vtComboABM.getTxtPrecio().setEnabled(false);

		this.CalcularPrecioTotal();

		this.vtComboABM.repaint();
	}

	private void Eliminar() {
		if (this.cActivoList.size() > 1) {
			this.mdlCombo.EliminarEffdt(this.cActivoList.get(this.Pos));

			int ComboId = Integer.parseInt(this.vtComboABM.getTxtIdcombo()
					.getText().trim());
			String Effdt = this.vtComboABM.getTxtFecha().getText().trim();

			ComboDTO combo = new ComboDTO(ComboId, Effdt);

			this.cActivoList = this.mdlCombo.ObtenerCombosEnAdelante(combo);
		}
		this.AnteriorEffdt();
	}

	private void Guardar() {
		String IdS = this.vtComboABM.getTxtIdcombo().getText().trim();
		int Id = Integer.parseInt(IdS);

		String Descripcion = this.vtComboABM.getTxtDescripcion().getText()
				.trim();
		if (Descripcion.equals("")) {
			Msj.error("Error", "La decripcion no puede estar vacia");
			return;
		}
		if (Descripcion.length() > 30) {
			Msj.error("Error",
					"La decripcion puede contener a lo sumo 30 caracteres");
			return;
		}
		ComboDTO c = new ComboDTO(Id, Descripcion);
		if (this.vtComboABM.getTable().getRowCount() <= 0) {
			Msj.advertencia("Advertencia", "La lista de productos esta vacia");
			return;
		}
		if (this.mdlCombo.NoExisteCombo(c)) {
			this.mdlCombo.CrearCombo(c);
		}

		String Effdt = "";
		if (this.creacion) {
			Effdt = Fecha.format(this.vtComboABM.getDateChooser().getDate());
			this.vtComboABM.getTxtFecha().setText(Effdt);
		} else {
			Effdt = this.vtComboABM.getTxtFecha().getText().trim();
		}

		String PrecioS = this.vtComboABM.getTxtPrecio().getText().trim();
		if (!Valida.esEnteroPositivo(PrecioS)) {
			Msj.error("Error", "Debe asignar un precio final valido al combo");
			return;
		}
		int Precio = Integer.parseInt(PrecioS);
		boolean Activo = this.vtComboABM.getChckbxActivo().isSelected();

		ComboActivoDTO cActivo = new ComboActivoDTO(Id, Effdt, Precio, Activo);

		List<ComboProductoDTO> cProductoList = new ArrayList<ComboProductoDTO>();

		JTable t = this.vtComboABM.getTable();
		for (int i = 0; i < t.getRowCount(); i++) {
			String Producto = t.getValueAt(i, 0).toString().trim();
			String Sabor = t.getValueAt(i, 1).toString().trim();
			String cantidadS = t.getValueAt(i, 2).toString().trim();
			int Cantidad = Integer.parseInt(cantidadS);
			ComboProductoDTO cProducto = new ComboProductoDTO(Id, Effdt,
					Producto, Sabor, Cantidad);
			cProductoList.add(cProducto);
		}

		if (this.creacion) {
			this.mdlCombo.CrearFechaEffdt(cActivo);
		} else {
			this.mdlCombo.ModificarEffdt(cActivo);
			this.mdlCombo.EliminarProductosDe(cActivo);
		}

		for (ComboProductoDTO cp : cProductoList) {
			this.mdlCombo.AgregarProducto(cp);
		}

		this.ctrCombo.CargarTabla();

		this.creacion = false;
		this.cActivoList = this.mdlCombo.ObtenerCombosEnAdelante(c);
		this.AnteriorEffdt();
		this.ModoInformacion();
	}

	private void Cancelar() {
		if (this.close) {
			this.vtComboABM.Close();
			this.vtCombo.Open();
		} else {
			this.AnteriorEffdt();
			this.SiguienteEffdt();
			this.ModoInformacion();
		}
	}

	private void Volver() {
		this.vtComboABM.Close();
		this.vtCombo.Open();
	}
}