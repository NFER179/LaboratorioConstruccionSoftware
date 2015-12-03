package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import modelo.ProveedorModelo;

import dto.MateriaPrimaDTO;

import validacion.ValidacionSeleccionMateriaPrimaSolicitud;
import vista.CreacionSolicitudVista;
import vista.SeleccionMateriaPrimaSolicitudVista;

public class ControladorSeleccionMateriaPrimaSolicitud implements
		ActionListener {

	private ValidacionSeleccionMateriaPrimaSolicitud vldSeleccion;
	private SeleccionMateriaPrimaSolicitudVista vtSMPS;
	private ControladorCreacionSolicitud ctrCreacionSolicitud;
	private ProveedorModelo mdlProveedor;
	private String proveedor;

	public ControladorSeleccionMateriaPrimaSolicitud(
			ControladorCreacionSolicitud arg0, CreacionSolicitudVista arg1) {
		this.vtSMPS = new SeleccionMateriaPrimaSolicitudVista(arg1);
		addListeners();

		this.vldSeleccion = new ValidacionSeleccionMateriaPrimaSolicitud(
				this.vtSMPS);
		this.ctrCreacionSolicitud = arg0;
		this.mdlProveedor = new ProveedorModelo();
		this.proveedor = this.ctrCreacionSolicitud.ObtenerProveedor();
	}

	private void addListeners() {
		this.vtSMPS.getBtnAceptar().addActionListener(this);
		this.vtSMPS.getBtnCancelar().addActionListener(this);
	}

	public void Inicializar() {
		this.CargarTabla();
		boolean emptyList = this.vtSMPS.getTable().getRowCount() == 0;
		if (emptyList) {
			vtSMPS.getScrollPane()
					.setToolTipText(
							"La lista de materias primas esta vacia, esto se debe a que no se han asignado materias primas a las categorias del proveedor");
		} else {
			vtSMPS.getScrollPane().setToolTipText("");
		}
		this.vtSMPS.Open();

	}

	private void CargarTabla() {
		this.vtSMPS.getModelTable().setRowCount(0);
		this.vtSMPS.getModelTable().setColumnCount(0);
		this.vtSMPS.getModelTable().setColumnIdentifiers(
				this.vtSMPS.getNombreColumnas());

		for (MateriaPrimaDTO mt : this.mdlProveedor
				.ObtenerMateriasPrimasDeProveedor(this.proveedor)) {
			Object[] fila = { mt.getNombre(), mt.getUnidad() };
			this.vtSMPS.getModelTable().addRow(fila);
		}
		this.vtSMPS.getTable().setModel(this.vtSMPS.getModelTable());
	}

	private void CargarMateriaPrimaSolicitud() {
		JTable tabla = this.vtSMPS.getTable();
		int FilaSeleccionada = tabla.getSelectedRow();

		String materiaPrima = tabla.getValueAt(FilaSeleccionada, 0).toString()
				.trim();
		String cantidad = this.vtSMPS.getTxtCantidad().getText().trim();
		String unidad = tabla.getValueAt(FilaSeleccionada, 1).toString().trim();

		this.ctrCreacionSolicitud.AgregarMateriaPrima(materiaPrima, cantidad,
				unidad);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtSMPS.getBtnAceptar()) {
			if (this.vldSeleccion.Valido()) {
				this.CargarMateriaPrimaSolicitud();
				this.vtSMPS.Close();
			}
		} else if (arg0.getSource() == this.vtSMPS.getBtnCancelar()) {
			this.vtSMPS.Close();
		}
	}
}