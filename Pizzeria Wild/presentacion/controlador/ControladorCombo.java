package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import dto.ComboDTO;

import modelo.ComboModelo;

import utilidades.Msj;
import vista.ComboVista;

public class ControladorCombo implements ActionListener {

	private ControladorVenta ctrVenta;
	private ComboVista vtCombo;
	private ComboModelo mdlCombo;

	public ControladorCombo(ControladorVenta Ctr) {
		this.ctrVenta = Ctr;

		this.vtCombo = new ComboVista();
		this.vtCombo.getBtnAgregar().addActionListener(this);
		this.vtCombo.getBtnInformacion().addActionListener(this);
		this.vtCombo.getBtnEliminar().addActionListener(this);
		this.vtCombo.getBtnAceptar().addActionListener(this);

		this.mdlCombo = new ComboModelo();
	}

	public void Inicializar() {
		this.CargarTabla();
		this.vtCombo.Open();
	}

	public void CargarTabla() {
		this.vtCombo.getModelTable().setRowCount(0);
		this.vtCombo.getModelTable().setColumnCount(0);
		this.vtCombo.getModelTable().setColumnIdentifiers(
				this.vtCombo.getNombreColumna());
		for (ComboDTO c : this.mdlCombo.ObtenerCombosActivos()) {
			Object[] fila = { c.getId(), c.getDescripcion() };
			this.vtCombo.getModelTable().addRow(fila);
		}
		this.vtCombo.getTable().setModel(this.vtCombo.getModelTable());
	}

	private void Agregar() {
		new ControladorABMCombo(this, this.vtCombo).InicializarCreacion();
	}

	private void ObtenerInformacion() {
		JTable t = this.vtCombo.getTable();
		int selectesRow = t.getSelectedRow();
		if (selectesRow < 0) {
			Msj.advertencia("Advertencia",
					"Debe seleccionar un combo para obtener su informacion");
			return;
		}
		String id = t.getValueAt(selectesRow, 0).toString().trim();
		String Descr = t.getValueAt(selectesRow, 1).toString().trim();

		ComboDTO c = new ComboDTO(Integer.parseInt(id), Descr);

		ControladorABMCombo ctr = new ControladorABMCombo(this, this.vtCombo);
		ctr.InicializarInformacion(c, selectesRow);
	}

	public void Eliminar() {
		// TODO;
	}

	private void Volver() {
		this.ctrVenta.Return();
		this.vtCombo.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCombo.getBtnAgregar()) {
			this.Agregar();
		} else if (arg0.getSource() == this.vtCombo.getBtnInformacion()) {
			this.ObtenerInformacion();
		} else if (arg0.getSource() == this.vtCombo.getBtnEliminar()) {
			this.Eliminar();
		} else if (arg0.getSource() == this.vtCombo.getBtnAceptar()) {
			this.Volver();
		}
	}
}
