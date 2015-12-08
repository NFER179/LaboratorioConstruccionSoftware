package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import dto.ComboDTO;

import modelo.ComboModelo;

import utilidades.Msj;
import vista.ArmadoVentaVista;
import vista.SeleccionadorCombosVista;

public class ControladorSeleccionadorCombo implements ActionListener {

	private ControladorArmadoVenta ctr;
	private SeleccionadorCombosVista vtSeleccion;
	private ComboModelo mdlCombo;
	private ArmadoVentaVista vtArmadoVenta;

	public ControladorSeleccionadorCombo(ControladorArmadoVenta Ctr,
			ArmadoVentaVista Vista) {
		this.ctr = Ctr;
		this.vtArmadoVenta = Vista;
		this.vtSeleccion = new SeleccionadorCombosVista(Vista);
		this.vtSeleccion.getBtnAgregar().addActionListener(this);
		this.vtSeleccion.getBtnCancelar().addActionListener(this);

		this.mdlCombo = new ComboModelo();
	}

	public void Inicializar() {
		this.CargarTabla();
		this.vtArmadoVenta.Close();
		this.vtSeleccion.Open();
	}

	private void CargarTabla() {
		this.vtSeleccion.getModelTable().setRowCount(0);
		this.vtSeleccion.getModelTable().setColumnCount(0);
		this.vtSeleccion.getModelTable().setColumnIdentifiers(
				this.vtSeleccion.getNombreColumnas());
		for (ComboDTO c : this.mdlCombo.ObtenerCombosActivos()) {
			int precio = this.mdlCombo.ObtenerPrecioActual(c);
			String fecha = this.mdlCombo.ObtenerFechaActual(c);
			Object[] fila = { c.getId(), c.getDescripcion(), "$ " + precio,
					fecha };
			this.vtSeleccion.getModelTable().addRow(fila);
		}
		this.vtSeleccion.getTable().setModel(this.vtSeleccion.getModelTable());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtSeleccion.getBtnAgregar()) {
			this.Agregar();
		} else if (arg0.getSource() == this.vtSeleccion.getBtnCancelar()) {
			this.Cancelar();
		}
	}

	private void Agregar() {
		JTable t = this.vtSeleccion.getTable();
		int selected = t.getSelectedRow();
		if (selected >= 0) {
			String idS = t.getValueAt(selected, 0).toString().trim();
			int Id = Integer.parseInt(idS);

			String Descripcion = t.getValueAt(selected, 1).toString().trim();
			String Fecha = t.getValueAt(selected, 3).toString().trim();

			ComboDTO c = new ComboDTO(Id, Descripcion);

			String cantidadd = this.vtSeleccion.getTextField().getText().trim();
			if (cantidadd.equals("")) {
				Msj.error("Error", "Debe ingresar una cantidad");
				return;
			}
			int cantidad = 0;
			try {
				cantidad = Integer.parseInt(cantidadd);
				if (cantidad <= 0) {
					Msj.error("Error",
							"Debe seleccionar una cantidad mayor a cero");
					return;
				}

			} catch (Exception e) {
				Msj.error("Error", "Debe seleccionar una cantidad valida");
				return;
			}

			this.ctr.AgregarItemCombo(c, cantidad, Fecha);

			this.vtSeleccion.Close();
			this.vtArmadoVenta.Open();
		} else {
			Msj.error("Error de seleccion", "Debe seleccionar un producto");
			return;
		}
	}

	private void Cancelar() {
		this.vtSeleccion.Close();
		this.vtArmadoVenta.Open();
	}
}