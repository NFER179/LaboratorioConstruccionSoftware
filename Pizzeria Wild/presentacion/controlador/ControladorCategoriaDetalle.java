package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;

import modelo.CategoriaModelo;
import modelo.MateriaPrimaModelo;
import modelo.ProveedorModelo;

import utilidades.Msj;
import vista.CategoriaDetalleVista;
import vista.CategoriaVista;

public class ControladorCategoriaDetalle implements ActionListener {

	private ControladorCategoria ctrCategoria;
	private CategoriaDetalleVista vtCategoriadetalle;
	private ProveedorModelo mdlProveedor;
	private CategoriaModelo mdlCategoria;
	private MateriaPrimaModelo mdlMT;
	private boolean modificacion;
	private CategoriaVista vtCategoria;

	public ControladorCategoriaDetalle(ControladorCategoria CtrCategoria,
			CategoriaVista VistaCategoria) {
		this.vtCategoria = VistaCategoria;
		this.vtCategoriadetalle = new CategoriaDetalleVista(VistaCategoria);
		this.vtCategoriadetalle.getBtnAgregar().addActionListener(this);
		this.vtCategoriadetalle.getBtnModificarMt().addActionListener(this);
		this.vtCategoriadetalle.getBtnQuitar().addActionListener(this);
		// this.vtCategoriadetalle.getBtnCambiarMt().addActionListener(this);
		this.vtCategoriadetalle.getBtnGuardar().addActionListener(this);
		this.vtCategoriadetalle.getBtnCancelar().addActionListener(this);

		this.ctrCategoria = CtrCategoria;
		this.mdlProveedor = new ProveedorModelo();
		this.mdlCategoria = new CategoriaModelo();
		this.mdlMT = new MateriaPrimaModelo();
	}

	public void InicializarNueva() {
		this.modificacion = false;
		this.CargarTabla();
		this.vtCategoria.Close();
		this.vtCategoriadetalle.Open();
	}

	public void InicializarModificacion(String Categoria) {
		this.vtCategoriadetalle.getTxtIdcategoria().setText(Categoria);
		this.vtCategoriadetalle.getTxtIdcategoria().setEditable(false);
		this.vtCategoriadetalle.getTxtIdcategoria().setEnabled(false);
		this.modificacion = true;
		this.CargarDescripcion(Categoria);
		this.CargarTablaPara(Categoria);
		this.vtCategoria.Close();
		this.vtCategoriadetalle.Open();
	}

	private void CargarTabla() {
		this.vtCategoriadetalle.getModelTable().setRowCount(0);
		this.vtCategoriadetalle.getModelTable().setColumnCount(0);
		this.vtCategoriadetalle.getModelTable().setColumnIdentifiers(
				this.vtCategoriadetalle.getNombreColumnas());

		this.vtCategoriadetalle.getTable().setModel(
				this.vtCategoriadetalle.getModelTable());
	}

	private void CargarDescripcion(String Categoria) {
		String descr = this.mdlCategoria.ObtenerDescripcion(Categoria);
		this.vtCategoriadetalle.getTxtDescr().setText(descr);
	}

	private void CargarTablaPara(String Categoria) {
		this.vtCategoriadetalle.getModelTable().setRowCount(0);
		this.vtCategoriadetalle.getModelTable().setColumnCount(0);
		this.vtCategoriadetalle.getModelTable().setColumnIdentifiers(
				this.vtCategoriadetalle.getNombreColumnas());

		for (MateriaPrimaDTO mt : this.mdlCategoria
				.ObtenerMateriasPrimasPara(Categoria)) {
			Object[] fila = { mt.getNombre(), mt.getUnidad() };
			this.vtCategoriadetalle.getModelTable().addRow(fila);
		}
		this.vtCategoriadetalle.getTable().setModel(
				this.vtCategoriadetalle.getModelTable());
	}

	// public String GetIdCategoria() {
	// return this.vtCategoriadetalle.getTxtIdcategoria().getText().trim();
	// }

	public List<MateriaPrimaDTO> MateriasPrimasEnTabla() {
		JTable tabla = this.vtCategoriadetalle.getTable();
		List<MateriaPrimaDTO> mt = new ArrayList<MateriaPrimaDTO>();

		for (int i = 0; i < tabla.getRowCount(); i++) {
			mt.add(new MateriaPrimaDTO(
					tabla.getValueAt(i, 0).toString().trim(), tabla
							.getValueAt(i, 1).toString().trim()));
		}

		return mt;
	}

	// public void AgregarMateriasPrimas(List<MateriaPrimaDTO> MateriasPrimas) {
	// for(MateriaPrimaDTO mt:MateriasPrimas) {
	// Object[] fila = {mt.getNombre()};
	// this.vtCategoriadetalle.getModelTable().addRow(fila);
	// }
	// this.vtCategoriadetalle.getTable().setModel(this.vtCategoriadetalle.getModelTable());
	// }

	// private void QuitarAsignacion() {
	// JTable tabla = this.vtCategoriadetalle.getTable();
	// int[] Seleccion = tabla.getSelectedRows();
	//
	// for(int i = 0 ; i < Seleccion.length ; i++) {
	// String materiaPrima = tabla.getValueAt(Seleccion[i],
	// 0).toString().trim();
	// this.mdlCategoria.QuitarAsignacion(this.GetIdCategoria(), materiaPrima);
	// }
	// }

	private void Agregar() {
		this.vtCategoriadetalle.Close();
		ControladorCreacionMateriaPrima ctr = new ControladorCreacionMateriaPrima(
				this, this.vtCategoriadetalle);
		ctr.InicializarCreacion();

	}

	private void Modificar() {
		JTable t = this.vtCategoriadetalle.getTable();
		int selected = t.getSelectedRow();
		if (selected < 0) {
			Msj.error("Error", "Debe seleccionar una categoria");
		} else {
			String Nombre = t.getValueAt(selected, 0).toString().trim();
			String Unidad = t.getValueAt(selected, 1).toString().trim();

			MateriaPrimaDTO mp = new MateriaPrimaDTO(Nombre, Unidad);
			ControladorCreacionMateriaPrima ctr = new ControladorCreacionMateriaPrima(
					this, this.vtCategoriadetalle);
			ctr.InicializarModificacion(mp);
		}

	}

	private void QuitarAsignacion() {

		String IdCategoria = this.vtCategoriadetalle.getTxtIdcategoria()
				.getText().trim();
		String Descripcion = this.vtCategoriadetalle.getTxtDescr().getText()
				.trim();
		CategoriaDTO cat = new CategoriaDTO(IdCategoria, Descripcion);

		JTable tabla = this.vtCategoriadetalle.getTable();
		int[] Seleccion = tabla.getSelectedRows();

		for (int i = Seleccion.length - 1; i >= 0; i--) {

			String Nombre = this.vtCategoriadetalle.getTable()
					.getValueAt(Seleccion[i], 0).toString().trim();
			String Unidad = this.vtCategoriadetalle.getTable()
					.getValueAt(Seleccion[i], 1).toString().trim();
			MateriaPrimaDTO mp = new MateriaPrimaDTO(Nombre, Unidad);

			this.mdlProveedor.ElinarAsignacionMP(cat, mp);
			this.mdlCategoria.EliminarAsignacionMP(mp);
			this.mdlMT.Eliminar(mp);
			this.vtCategoriadetalle.getModelTable().removeRow(Seleccion[i]);
		}
		tabla.setModel(this.vtCategoriadetalle.getModelTable());
	}

	private void Guardar() {
		String categoria = this.vtCategoriadetalle.getTxtIdcategoria()
				.getText().trim().toUpperCase();
		String descripcion = this.vtCategoriadetalle.getTxtDescr().getText()
				.trim();
		if (categoria.equals("")) {
			Msj.error("Error", "La categoria no puede ser vacia");
			return;
		} else if (descripcion.equals("")) {
			Msj.error("Error", "La descripcion no puede ser vacia");
			return;
		}
		JTable tabla = this.vtCategoriadetalle.getTable();
		if (tabla.getRowCount() == 0) {
			Msj.error("Error", "La lista de materias primas esta vacia");
			return;
		}

		if (categoria.length() > 8) {
			Msj.error("Error",
					"El nombre de la categoria debe contener como mucho 8 caracateres");
			return;
		} else if (descripcion.length() > 100) {
			Msj.error("Error",
					"La descripcion debe contener como mucho 100 caracateres");
			return;
		} else {
			CategoriaDTO c = new CategoriaDTO(categoria, descripcion);

			if (this.modificacion) {
				this.mdlCategoria.ActualizarDescripcion(c);
			} else {
				this.mdlCategoria.CrearCategoria(c);
			}

			for (int i = 0; i < tabla.getRowCount(); i++) {
				JTable t = this.vtCategoriadetalle.getTable();
				String Nombre = t.getValueAt(i, 0).toString().trim();
				String Unidad = t.getValueAt(i, 1).toString().trim();

				MateriaPrimaDTO MateriaPrima = new MateriaPrimaDTO(Nombre,
						Unidad);
				if (!this.mdlMT.Existe(Nombre)) {
					this.mdlMT.RegistrarMateriaPrima(MateriaPrima);
					this.mdlCategoria.AsignarMateriaPrima(c, MateriaPrima);
				}
			}

			this.ctrCategoria.ActualizarTabla();
			this.vtCategoriadetalle.Close();
			this.ctrCategoria.Return();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCategoriadetalle.getBtnAgregar()) {
			this.Agregar();
		} else if (arg0.getSource() == this.vtCategoriadetalle
				.getBtnModificarMt()) {
			this.Modificar();
		} else if (arg0.getSource() == this.vtCategoriadetalle.getBtnQuitar()) {
			this.QuitarAsignacion();
		} else if (arg0.getSource() == this.vtCategoriadetalle.getBtnGuardar()) {
			this.Guardar();
		} else if (arg0.getSource() == this.vtCategoriadetalle.getBtnCancelar()) {
			this.vtCategoriadetalle.Close();
			this.ctrCategoria.Return();
		}
	}

	public boolean AgregarMT(MateriaPrimaDTO mp) {
		boolean agrega = true;

		for (MateriaPrimaDTO mpDTO : this.MateriasPrimasEnTabla()) {
			if (mpDTO.getNombre().toUpperCase().trim()
					.equals(mp.getNombre().toUpperCase().trim())) {
				agrega = false;
			}
		}

		if (agrega) {
			Object[] fila = { mp.getNombre(), mp.getUnidad() };
			this.vtCategoriadetalle.getModelTable().addRow(fila);
			this.vtCategoriadetalle.getTable().setModel(
					this.vtCategoriadetalle.getModelTable());
		}

		return agrega;
	}

	public boolean ModificarMateriaPrima(MateriaPrimaDTO antiguaMP,
			MateriaPrimaDTO mp) {
		boolean modifica = true;

		List<MateriaPrimaDTO> filas = this.MateriasPrimasEnTabla();
		this.vtCategoriadetalle.getModelTable().setRowCount(0);
		this.vtCategoriadetalle.getModelTable().setColumnCount(0);
		this.vtCategoriadetalle.getModelTable().setColumnIdentifiers(
				this.vtCategoriadetalle.getNombreColumnas());
		for (MateriaPrimaDTO mpDTO : filas) {
			if (!mpDTO.getNombre().toUpperCase().trim()
					.equals(antiguaMP.getNombre().toUpperCase().trim())) {
				Object[] fila = { mpDTO.getNombre(), mpDTO.getUnidad() };
				this.vtCategoriadetalle.getModelTable().addRow(fila);
			}
		}
		this.vtCategoriadetalle.getTable().setModel(
				this.vtCategoriadetalle.getModelTable());

		if (this.AgregarMT(mp)) {
			String IdCategoria = this.vtCategoriadetalle.getTxtIdcategoria()
					.getText().trim();
			String Descripcion = this.vtCategoriadetalle.getTxtDescr()
					.getText().trim();
			CategoriaDTO cat = new CategoriaDTO(IdCategoria, Descripcion);

			this.mdlProveedor.ElinarAsignacionMP(cat, antiguaMP);
			this.mdlCategoria.EliminarAsignacionMP(antiguaMP);
			this.mdlMT.Eliminar(antiguaMP);
		} else {
			modifica = false;
			Object[] fila = { antiguaMP.getNombre(), antiguaMP.getUnidad() };
			this.vtCategoriadetalle.getModelTable().addRow(fila);
			this.vtCategoriadetalle.getTable().setModel(
					this.vtCategoriadetalle.getModelTable());
		}

		return modifica;
	}

	public void Return() {
		this.vtCategoriadetalle.Open();
	}
}