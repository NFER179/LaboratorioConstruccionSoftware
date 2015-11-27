package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private ABMComboVista vtCombo;
	private ComboModelo mdlCombo;
	private SaborModelo mdlSabor;
	private List<ComboActivoDTO> cActivoList;
	private int Pos;
	private boolean creacion;
	private boolean close;

	public ControladorABMCombo(ControladorCombo Ctr, ComboVista Vista) {
		this.ctrCombo = Ctr;

		this.vtCombo = new ABMComboVista(Vista);
		this.vtCombo.getBtnEdit().addActionListener(this);
		this.vtCombo.getBtnAnterior().addActionListener(this);
		this.vtCombo.getBtnSiguiente().addActionListener(this);
		this.vtCombo.getBtnAgregarProducto().addActionListener(this);
		this.vtCombo.getBtnEliminarProducto().addActionListener(this);
		this.vtCombo.getBtnAgregar().addActionListener(this);
		this.vtCombo.getBtnModificar().addActionListener(this);
		this.vtCombo.getBtnEliminar().addActionListener(this);
		this.vtCombo.getBtnGuardar().addActionListener(this);
		this.vtCombo.getBtnCancelar().addActionListener(this);
		this.vtCombo.getBtnVolver().addActionListener(this);

		this.mdlCombo = new ComboModelo();
		this.mdlSabor = new SaborModelo();
		this.cActivoList = new ArrayList<ComboActivoDTO>();
		this.close = false;
	}

	public void InicializarCreacion() {
		this.creacion = true;
		this.close = true;

		int numCombo = this.mdlCombo.ObtenerNuevoIdCombo();
		this.vtCombo.getTxtIdcombo().setText(Integer.toString(numCombo));

		this.vtCombo.getTxtDescripcion().setEditable(true);
		this.vtCombo.getTxtDescripcion().setEnabled(true);

		this.vtCombo.EliminarComponente(this.vtCombo.getBtnEdit());

		this.vtCombo.getPanel().remove(this.vtCombo.getBtnAnterior());
		this.vtCombo.getLblFila().setText("1 / 1");
		this.vtCombo.getPanel().remove(this.vtCombo.getBtnSiguiente());
		this.vtCombo.getPanel().remove(this.vtCombo.getTxtFecha());

		this.vtCombo.getChckbxActivo().setEnabled(true);

		this.vtCombo.getTxtPrecio().setEditable(true);
		this.vtCombo.getTxtPrecio().setEnabled(true);

		this.vtCombo.EliminarComponente(this.vtCombo.getBtnAgregar());
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnModificar());
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnEliminar());
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnVolver());

		this.vtCombo.Open();
	}

	public void InicializarInformacion(ComboDTO combo, int selectesRow) {
		this.creacion = false;

		this.vtCombo.getTxtIdcombo().setText(combo.getId() + "");
		this.vtCombo.getTxtDescripcion().setText(combo.getDescripcion());

		this.cActivoList = this.mdlCombo.ObtenerCombosEnAdelante(combo);

		this.Pos = 0;

		this.vtCombo.getLblFila().setText(
				(this.Pos + 1) + " de " + this.cActivoList.size());

		this.vtCombo.getChckbxActivo().setSelected(
				this.cActivoList.get(this.Pos).isActivo());
		this.vtCombo.getTxtFecha().setText(
				this.cActivoList.get(this.Pos).getEfft());
		this.vtCombo.getDateChooser().setVisible(false);

		this.CargarProductosPara(this.cActivoList.get(this.Pos));

		this.vtCombo.getPanel().remove(this.vtCombo.getBtnAgregarProducto());
		this.vtCombo.getPanel().remove(this.vtCombo.getBtnEliminarProducto());

		this.vtCombo.getTxtPrecio().setText(
				this.cActivoList.get(this.Pos).getPrecio() + "");

		this.vtCombo.EliminarComponente(this.vtCombo.getBtnGuardar());
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnCancelar());

		this.vtCombo.Open();
	}

	private void CargarProductosPara(ComboActivoDTO cActivo) {
		this.vtCombo.getModelTable().setRowCount(0);
		this.vtCombo.getModelTable().setColumnCount(0);
		this.vtCombo.getModelTable().setColumnIdentifiers(
				this.vtCombo.getNombreColumnas());
		for (ComboProductoDTO cp : this.mdlCombo.ObtenerProductosPara(cActivo)) {
			int precioTotal = cp.getCantidad()
					* this.mdlSabor.ObtenerPrecio(cp.getProducto(),
							cp.getSabor());
			Object[] fila = { cp.getProducto(), cp.getSabor(),
					cp.getCantidad(), precioTotal };
			this.vtCombo.getModelTable().addRow(fila);
		}
		this.vtCombo.getTable().setModel(this.vtCombo.getModelTable());
	}

	public void AgregarProductoALista(String producto, String sabor,
			int cantidad) {
		int precioparcial = this.mdlSabor.ObtenerPrecio(producto, sabor);

		double precioTotal = precioparcial * cantidad;

		Object[] fila = { producto, sabor, cantidad, "$ " + precioTotal };
		boolean debeAgregar = true;
		for (int i = 0; i < this.vtCombo.getModelTable().getRowCount(); i++) {
			String tipo = this.vtCombo.getModelTable().getValueAt(i, 0)
					.toString();
			String prod = this.vtCombo.getModelTable().getValueAt(i, 1)
					.toString();
			String cant = this.vtCombo.getModelTable().getValueAt(i, 2)
					.toString();

			// a = (Object[]) a;
			if (tipo.equals(producto) && prod.equals(sabor)) {
				debeAgregar = false;
				int nuevaCantidad = Integer.parseInt(cant) + cantidad;
				this.vtCombo.getModelTable().setValueAt(nuevaCantidad, i, 2);
				this.vtCombo.getModelTable().setValueAt(
						("$" + (precioparcial * nuevaCantidad)), i, 3);
			}
		}
		if (debeAgregar) {
			this.vtCombo.getModelTable().addRow(fila);
		}
		this.vtCombo.getTable().setModel(this.vtCombo.getModelTable());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCombo.getBtnEdit()) {
			this.EditarDescripcion();
		} else if (arg0.getSource() == this.vtCombo.getBtnAnterior()) {
			this.AnteriorEffdt();
		} else if (arg0.getSource() == this.vtCombo.getBtnSiguiente()) {
			this.SiguienteEffdt();
		} else if (arg0.getSource() == this.vtCombo.getBtnAgregarProducto()) {
			this.AgregarProducto();
		} else if (arg0.getSource() == this.vtCombo.getBtnEliminarProducto()) {
			this.EliminarProducto();
		} else if (arg0.getSource() == this.vtCombo.getBtnAgregar()) {
			this.AgregarEffdt();
		} else if (arg0.getSource() == this.vtCombo.getBtnModificar()) {
			this.ModificarEffdt();
		} else if (arg0.getSource() == this.vtCombo.getBtnEliminar()) {
			this.Eliminar();
		} else if (arg0.getSource() == this.vtCombo.getBtnGuardar()) {
			this.Guardar();
		} else if (arg0.getSource() == this.vtCombo.getBtnCancelar()) {
			this.Cancelar();
		} else if (arg0.getSource() == this.vtCombo.getBtnVolver()) {
			this.Volver();
		}
	}

	private void EditarDescripcion() {
		String Ndescr = JOptionPane.showInputDialog(null, "Nueva Descripcion",
				this.vtCombo.getTxtDescripcion().getText());
		if (Ndescr == null || Ndescr.trim().equals("")) {
			return;
		}
		int Id = Integer
				.parseInt(this.vtCombo.getTxtIdcombo().getText().trim());
		ComboDTO c = new ComboDTO(Id, Ndescr);

		this.mdlCombo.ModificarDescripcion(c);
		this.vtCombo.getTxtDescripcion().setText(Ndescr);
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
		this.vtCombo.getLblFila().setText(
				(this.Pos + 1) + " de " + this.cActivoList.size());

		this.vtCombo.getTxtFecha().setText(ca.getEfft());
		this.vtCombo.getChckbxActivo().setSelected(ca.isActivo());

		this.CargarProductosPara(ca);

		this.vtCombo.getTxtPrecio().setText(ca.getPrecio() + "");
	}

	private void AgregarProducto() {
		new ControladorBusquedaProductosCombos(this, this.vtCombo)
				.Inicializar();
	}

	private void EliminarProducto() {
		JTable t = this.vtCombo.getTable();
		int[] selected = t.getSelectedRows();

		for (int i = selected.length - 1; i >= 0; i--) {
			this.vtCombo.getModelTable().removeRow(selected[i]);
		}

		t.setModel(this.vtCombo.getModelTable());
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
		this.vtCombo.getLblFila().setText("");
		
		this.vtCombo.getPanel().remove(this.vtCombo.getBtnAnterior());
		this.vtCombo.getPanel().remove(this.vtCombo.getBtnSiguiente());
		
		if (creacion) {
			String IdS = this.vtCombo.getTxtIdcombo().getText().trim();
			int Id = Integer.parseInt(IdS);
			String Descripcion = this.vtCombo.getTxtDescripcion().getText().trim();
			
			ComboDTO c = new ComboDTO(Id, Descripcion);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try{
				this.vtCombo.getDateChooser().setDate(sdf.parse(this.mdlCombo.ObtenerSiguienteFecha(c)));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			this.vtCombo.getPanel().remove(this.vtCombo.getTxtFecha());
			this.vtCombo.getDateChooser().setVisible(true);
		}

		this.vtCombo.getPanel().add(this.vtCombo.getBtnAgregarProducto());
		this.vtCombo.getPanel().add(this.vtCombo.getBtnEliminarProducto());

		this.vtCombo.EliminarComponente(this.vtCombo.getBtnAgregar());
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnModificar());
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnEliminar());
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnVolver());

		this.vtCombo.add(this.vtCombo.getBtnGuardar());
		this.vtCombo.add(this.vtCombo.getBtnCancelar());

		this.vtCombo.getChckbxActivo().setEnabled(true);
		this.vtCombo.getTxtPrecio().setEditable(true);
		this.vtCombo.getTxtPrecio().setEnabled(true);

		this.vtCombo.repaint();
	}

	private void ModoInformacion() {
		this.vtCombo.getLblFila().setText(
				(this.Pos + 1) + " de " + this.cActivoList.size());
		
		this.vtCombo.getTxtDescripcion().setEditable(false);
		this.vtCombo.getTxtDescripcion().setEditable(false);

		this.vtCombo.getPanel().add(this.vtCombo.getBtnAnterior());
		this.vtCombo.getPanel().add(this.vtCombo.getBtnSiguiente());

		this.vtCombo.getPanel().add(this.vtCombo.getTxtFecha());
		this.vtCombo.getDateChooser().setVisible(false);

		this.vtCombo.getPanel().remove(this.vtCombo.getBtnAgregarProducto());
		this.vtCombo.getPanel().remove(this.vtCombo.getBtnEliminarProducto());

		this.vtCombo.add(this.vtCombo.getBtnAgregar());
		this.vtCombo.add(this.vtCombo.getBtnModificar());
		this.vtCombo.add(this.vtCombo.getBtnEliminar());
		this.vtCombo.add(this.vtCombo.getBtnVolver());

		this.vtCombo.remove(this.vtCombo.getBtnGuardar());
		this.vtCombo.remove(this.vtCombo.getBtnCancelar());

		this.vtCombo.getChckbxActivo().setEnabled(false);
		this.vtCombo.getTxtPrecio().setEditable(false);
		this.vtCombo.getTxtPrecio().setEnabled(false);

		this.vtCombo.repaint();
	}

	private void Eliminar() {
		if (this.cActivoList.size() > 1) {
			this.mdlCombo.EliminarEffdt(this.cActivoList.get(this.Pos));
			
			int ComboId = Integer.parseInt(this.vtCombo.getTxtIdcombo().getText().trim());
			String Effdt = this.vtCombo.getTxtFecha().getText().trim();
			
			ComboDTO combo = new ComboDTO(ComboId, Effdt);
			
			this.cActivoList = this.mdlCombo.ObtenerCombosEnAdelante(combo);
		}
		this.AnteriorEffdt();
	}

	private void Guardar() {
		String IdS = this.vtCombo.getTxtIdcombo().getText().trim();
		int Id = Integer.parseInt(IdS);

		String Descripcion = this.vtCombo.getTxtDescripcion().getText().trim();
		if (Descripcion.equals("")) {
			Msj.error("Error", "La decripcion no puede estar vacia");
			return;
		}
		ComboDTO c = new ComboDTO(Id, Descripcion);
		if (this.vtCombo.getTable().getRowCount() <= 0) {
			Msj.advertencia("Advertencia", "La lista de productos esta vacia");
			return;
		}
		if (this.mdlCombo.NoExisteCombo(c)) {
			this.mdlCombo.CrearCombo(c);
		}
		
		String Effdt = "";
		if (this.creacion) {
			Effdt = Fecha.format(this.vtCombo.getDateChooser().getDate());
			this.vtCombo.getTxtFecha().setText(Effdt);
		}
		else{
			Effdt = this.vtCombo.getTxtFecha().getText().trim();
		}
		
		String PrecioS = this.vtCombo.getTxtPrecio().getText().trim();
		if (!Valida.esEnteroPositivo(PrecioS)) {
			Msj.error("Error", "Debe asignar un precio final valido al combo");
			return;
		}
		int Precio = Integer.parseInt(PrecioS);
		boolean Activo = this.vtCombo.getChckbxActivo().isSelected();

		ComboActivoDTO cActivo = new ComboActivoDTO(Id, Effdt, Precio, Activo);

		List<ComboProductoDTO> cProductoList = new ArrayList<ComboProductoDTO>();

		JTable t = this.vtCombo.getTable();
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
			this.vtCombo.Close();
		} else {
			this.ModoInformacion();
		}
	}

	private void Volver() {
		this.vtCombo.Close();
	}
}