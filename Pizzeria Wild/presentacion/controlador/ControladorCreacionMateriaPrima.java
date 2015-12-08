package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dto.MateriaPrimaDTO;

import utilidades.Msj;
import validacionesCampos.Valida;
import vista.CategoriaDetalleVista;
import vista.CreacionMateriaPrimaVista;

public class ControladorCreacionMateriaPrima implements ActionListener {

	private ControladorCategoriaDetalle ctrCategoria;
	private CreacionMateriaPrimaVista vtCreacion;
	private boolean creacion;
	private MateriaPrimaDTO antiguaMP = null;

	public ControladorCreacionMateriaPrima(ControladorCategoriaDetalle Ctr,
			CategoriaDetalleVista Vista) {

		this.ctrCategoria = Ctr;

		this.vtCreacion = new CreacionMateriaPrimaVista(Vista);
		this.vtCreacion.getBtnCrear().addActionListener(this);
		this.vtCreacion.getBtnCancelar().addActionListener(this);

		// this.mdlMateriaPrima = new MateriaPrimaModelo();
		// this.mdlCategoria = new CategoriaModelo();
		// this.ctrMateriaPrima = CtrMP;
	}

	// private MateriaPrimaModelo mdlMateriaPrima;
	// private ControladorMateriaPrima ctrMateriaPrima;
	// private CategoriaModelo mdlCategoria;

	// public ControladorCreacionMateriaPrima(ControladorMateriaPrima CtrMP,
	// MateriaPrimaVista MPV) {
	// this.vtCreacion = new CreacionMateriaPrimaVista(MPV);

	public void InicializarCreacion() {
		// this.CargarCbxCategoria();
		this.creacion = true;
		this.vtCreacion.Open();
	}

	public void InicializarModificacion(MateriaPrimaDTO mp) {
		this.creacion = false;
		this.antiguaMP = mp;

		this.vtCreacion.getTxtMateriaprima().setText(mp.getNombre());
		this.vtCreacion.getComboBox().setSelectedItem(mp.getUnidad());

		this.vtCreacion.Open();
	}

	// @SuppressWarnings("unchecked")
	// private void CargarCbxCategoria() {
	// this.vtCreacion.getModelCbxCategoria().removeAllElements();
	// this.vtCreacion.getModelCbxCategoria().addElement("Ninguna");
	// for (CategoriaDTO c : this.mdlCategoria.ObtenerCategorias()) {
	// this.vtCreacion.getModelCbxCategoria().addElement(
	// c.getIdCategoria());
	// }
	// this.vtCreacion.getCbbCategoria().setModel(
	// this.vtCreacion.getModelCbxCategoria());
	// }

	// private void CargarNuevaMateriaPrima() {
	// String nombre = this.vtCreacion.getTxtMateriaprima().getText().trim();
	// String unidad = this.vtCreacion.getComboBox().getSelectedItem()
	// .toString().trim();
	//
	// MateriaPrimaDTO mt = new MateriaPrimaDTO(nombre, unidad);
	//
	// this.mdlMateriaPrima.RegistrarMateriaPrima(mt);
	//
	// if (!this.vtCreacion.getCbbCategoria().getSelectedItem().toString()
	// .trim().toUpperCase().equals("NINGUNA")) {
	// String cString = this.vtCreacion.getCbbCategoria()
	// .getSelectedItem().toString().trim();
	// CategoriaDTO categoria = this.mdlCategoria
	// .ObtenerCategoria(cString);
	// this.mdlCategoria.AsignarMateriaPrima(categoria, mt);
	// }
	// }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCreacion.getBtnCrear()) {
			accionGuardar();
		} else if (arg0.getSource() == this.vtCreacion.getBtnCancelar()) {
			this.Cancelar();
		}
	}

	private void accionGuardar() {
		if (!Valida
				.esNullOVacio(this.vtCreacion.getTxtMateriaprima().getText())) {
			this.vtCreacion.getTxtMateriaprima().setBackground(null);
			if (!Valida.esNullOVacio(vtCreacion.getComboBox().getSelectedItem()
					.toString()))
				this.Guardar();
			else {
				Msj.error("Error", "Debe seleccionar una unidad");
			}
		} else {
			Msj.error("Error Campo Incompleto",
					"Debe Ingresar el Nombre de la Materia Prima.");
			this.vtCreacion.getTxtMateriaprima().setBackground(Color.RED);
		}
	}

	private void Guardar() {
		String nombre = this.vtCreacion.getTxtMateriaprima().getText().trim();
		String unidad = this.vtCreacion.getComboBox().getSelectedItem()
				.toString().trim();

		MateriaPrimaDTO mp = new MateriaPrimaDTO(nombre, unidad);

		if (this.creacion) {
			if (this.ctrCategoria.AgregarMT(mp)) {
				this.vtCreacion.Close();
				this.ctrCategoria.Return();
			} else {
				String mensaje = "Ya Agrego esa materia prima";
				String titulo = "Error";
				JOptionPane.showMessageDialog(null, mensaje, titulo,
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			if (this.ctrCategoria.ModificarMateriaPrima(this.antiguaMP, mp)) {
				this.vtCreacion.Close();
				this.ctrCategoria.Return();
			} else {
				String mensaje = "Ya eciste esa materiaprima";
				String titulo = "Error";
				JOptionPane.showMessageDialog(null, mensaje, titulo,
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void Cancelar() {
		this.vtCreacion.Close();
		this.ctrCategoria.Return();
	}
}