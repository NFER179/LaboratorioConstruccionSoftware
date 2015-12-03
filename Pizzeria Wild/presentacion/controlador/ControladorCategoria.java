package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import dto.CategoriaDTO;

import modelo.CategoriaModelo;

import utilidades.Msj;
import validacion.ValidacionCategoria;
import vista.CategoriaVista;

public class ControladorCategoria implements ActionListener {

	private ControladorVenta ctr;
	private CategoriaVista vtCategoria;
	private CategoriaModelo mdlCategoria;
	private ValidacionCategoria validCategoria;

	public ControladorCategoria(ControladorVenta Controlador) {
		this.vtCategoria = new CategoriaVista();
		this.vtCategoria.getBtnAgregar().addActionListener(this);
		this.vtCategoria.getBtnModificar().addActionListener(this);
		this.vtCategoria.getBtnEliminar().addActionListener(this);
		this.vtCategoria.getBtnVolver().addActionListener(this);

		this.ctr = Controlador;
		this.mdlCategoria = new CategoriaModelo();
		this.validCategoria = new ValidacionCategoria(this.vtCategoria);
	}

	public void Inicializar() {
		this.vtCategoria.Open();
		this.CargarTabla();
	}

	private void CargarTabla() {
		this.vtCategoria.getModelTable().setRowCount(0);
		this.vtCategoria.getModelTable().setColumnCount(0);
		this.vtCategoria.getModelTable().setColumnIdentifiers(
				this.vtCategoria.getNombreColumnas());

		for (CategoriaDTO categoria : this.mdlCategoria.ObtenerCategorias()) {
			Object[] fila = { categoria.getIdCategoria(),
					categoria.getDescripcion() };
			this.vtCategoria.getModelTable().addRow(fila);
		}
		this.vtCategoria.getTable().setModel(this.vtCategoria.getModelTable());
	}

	public void ActualizarTabla() {
		this.CargarTabla();
	}

	private void EliminarCategoria() {
		JTable tabla = this.vtCategoria.getTable();
		int FilaSeleccionada = tabla.getSelectedRow();
		if (FilaSeleccionada < 0) {
			Msj.error("Error de seleccion",
					"Debe seleccionar una categoria a eliminar");
		} else {

			String IdCategoria = tabla.getValueAt(FilaSeleccionada, 0)
					.toString().trim();
			String Descripcion = tabla.getValueAt(FilaSeleccionada, 1)
					.toString().trim();
			CategoriaDTO categoria = new CategoriaDTO(IdCategoria, Descripcion);

			this.mdlCategoria.QuitarAsignaciones(categoria);
			this.mdlCategoria.EliminarCategoria(categoria);

			this.CargarTabla();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCategoria.getBtnAgregar()) {
			accionAgregar();

		} else if (arg0.getSource() == this.vtCategoria.getBtnModificar()) {
			accionModificar();
		} else if (arg0.getSource() == this.vtCategoria.getBtnEliminar()) {
			accionEliminar();
		} else if (arg0.getSource() == this.vtCategoria.getBtnVolver()) {
			this.ctr.Return();
			this.vtCategoria.Close();
		}
	}

	private void accionEliminar() {
		if (this.validCategoria.SePuedeEliminar()) {
			this.EliminarCategoria();
		}
	}

	private void accionAgregar() {
		this.vtCategoria.Close();
		ControladorCategoriaDetalle ctrCategotiaDetalle = new ControladorCategoriaDetalle(
				this, this.vtCategoria);
		ctrCategotiaDetalle.InicializarNueva();
	}

	private void accionModificar() {
		ControladorCategoriaDetalle ctrCategotiaDetalle = new ControladorCategoriaDetalle(
				this, this.vtCategoria);
		JTable tabla = this.vtCategoria.getTable();
		int filaSeleccionada = tabla.getSelectedRow();
		if (filaSeleccionada < 0) {
			Msj.error("Error de seleccion",
					"Debe seleccionar una categoria a modificar");
		} else {
			String Categoria = tabla.getValueAt(filaSeleccionada, 0).toString()
					.trim();
			ctrCategotiaDetalle.InicializarModificacion(Categoria);
		}
	}

	public void Return() {
		this.vtCategoria.Open();
	}
}