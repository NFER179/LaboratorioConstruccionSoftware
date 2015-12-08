package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import modelo.CategoriaModelo;
import modelo.MateriaPrimaProveedorModelo;
import modelo.ProveedorModelo;

import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;
import dto.MateriaPrimaProveedorDTO;
import dto.ProveedorDTO;

import validacion.ValidacionABMProveedor;
import vista.ABMProveedorVista;
import vista.ProveedorVista;

public class ControladorABMProveedor implements ActionListener {

	private ControladorProveedor ctrProveedor;
	private ABMProveedorVista vtABMProveedor;
	private ValidacionABMProveedor vldABMProveedor;
	private ProveedorModelo mdlProveedor;
	private CategoriaModelo mdlCategoria;
	private MateriaPrimaProveedorModelo mdlMPProveedor;
	private boolean Modificar;
	private ProveedorVista vtProveedor;
	
	public ControladorABMProveedor(ControladorProveedor Ctr,
			ProveedorVista Vista) {
		this.ctrProveedor = Ctr;
		this.vtProveedor = Vista;
		this.vtABMProveedor = new ABMProveedorVista(Vista);
		addListeners();

		this.vldABMProveedor = new ValidacionABMProveedor(this.vtABMProveedor);
		this.mdlProveedor = new ProveedorModelo();
		this.mdlCategoria = new CategoriaModelo();
		this.mdlMPProveedor = new MateriaPrimaProveedorModelo();
	}

	private void addListeners() {
		this.vtABMProveedor.getBtnAgregarCategoria().addActionListener(this);
		this.vtABMProveedor.getBtnQuitarCategoria().addActionListener(this);
		// this.vtABMProveedor.getBtnAgregarMT().addActionListener(this);
		// this.vtABMProveedor.getBtnQuitarMT().addActionListener(this);
		this.vtABMProveedor.getBtnGuardar().addActionListener(this);
		this.vtABMProveedor.getBtnCancelar().addActionListener(this);
	}

	public void Inicializar() {
		this.Modificar = false;
		this.vtProveedor.Close();
		this.vtABMProveedor.Open();
	}

	public void InicializarModificacion(String ProveedorId) {
		this.Modificar = true;
		ProveedorDTO proveedor = this.mdlProveedor
				.ObtenerProveedor(ProveedorId);
		this.CargarDatosProveedor(proveedor);
		this.CargarCategoriasProveedor(proveedor);
		// this.CargarMTProveedor(proveedor);
		this.vtABMProveedor.Open();
	}

	private void CargarDatosProveedor(ProveedorDTO proveedor) {
		this.vtABMProveedor.getTxtProveedorid().setText(
				proveedor.getProveedorId());
		this.vtABMProveedor.getTxtProveedorid().setEditable(false);
		this.vtABMProveedor.getTxtProveedorid().setEnabled(false);
		this.vtABMProveedor.getChckbxActivo().setSelected(proveedor.isActivo());
		this.vtABMProveedor.getTxtNombreproveedor().setText(
				proveedor.getNombre());
		this.vtABMProveedor.getTxtTelefono().setText(proveedor.getTelefono());
		this.vtABMProveedor.getTxtMail().setText(proveedor.getMail());

	}

	private void CargarCategoriasProveedor(ProveedorDTO proveedor) {
		this.vtABMProveedor.getModelCategoria().setRowCount(0);
		this.vtABMProveedor.getModelCategoria().setColumnCount(0);
		this.vtABMProveedor.getModelCategoria().setColumnIdentifiers(
				this.vtABMProveedor.getNombreColumnasCategoria());
		for (CategoriaDTO c : this.mdlProveedor.ObtenerCategorias(proveedor
				.getProveedorId())) {
			Object[] fila = { c.getIdCategoria(), c.getDescripcion() };
			this.vtABMProveedor.getModelCategoria().addRow(fila);
		}
		this.vtABMProveedor.getTblCategoria().setModel(
				this.vtABMProveedor.getModelCategoria());
	}

	// private void CargarMTProveedor(ProveedorDTO proveedor) {
	// this.vtABMProveedor.getModelMT().setRowCount(0);
	// this.vtABMProveedor.getModelMT().setColumnCount(0);
	// this.vtABMProveedor.getModelMT().setColumnIdentifiers(
	// this.vtABMProveedor.getNombreColumnasMT());
	// for (MateriaPrimaDTO mp : this.mdlProveedor
	// .ObtenerMateriasPrimasDeProveedor(proveedor.getProveedorId())) {
	// Object[] fila = { mp.getNombre() };
	// this.vtABMProveedor.getModelMT().addRow(fila);
	// }
	// this.vtABMProveedor.getTblMateriaPrima().setModel(
	// this.vtABMProveedor.getModelMT());
	// }

	public List<CategoriaDTO> ObtenerCategorias() {
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
		JTable t = this.vtABMProveedor.getTblCategoria();

		for (int i = 0; i < t.getRowCount(); i++) {
			String IdCategoria = t.getValueAt(i, 0).toString().trim();
			String Descripcion = t.getValueAt(i, 1).toString().trim();

			categorias.add(new CategoriaDTO(IdCategoria, Descripcion));
		}

		return categorias;
	}

	// public List<MateriaPrimaDTO> ObteberMateriasPrimas() {
	// List<MateriaPrimaDTO> MTs = new ArrayList<MateriaPrimaDTO>();
	// JTable t = this.vtABMProveedor.getTblMateriaPrima();
	//
	// for (int i = 0; i < t.getRowCount(); i++) {
	// String nombre = t.getValueAt(i, 0).toString().trim();
	//
	// MTs.add(this.mdlMT.ObtenerMateriaPrima(nombre));
	// }
	//
	// return MTs;
	// }

	public void AgregarCategoria(List<CategoriaDTO> categorias) {
		for (CategoriaDTO c : categorias) {
			Object[] fila = { c.getIdCategoria(), c.getDescripcion() };
			this.vtABMProveedor.getModelCategoria().addRow(fila);
		}
		this.vtABMProveedor.getTblCategoria().setModel(
				this.vtABMProveedor.getModelCategoria());
	}

	// public void AgregarMateriaPrima(List<MateriaPrimaDTO> MTs) {
	// for (MateriaPrimaDTO mt : MTs) {
	// Object[] fila = { mt.getNombre() };
	// this.vtABMProveedor.getModelMT().addRow(fila);
	// }
	// this.vtABMProveedor.getTblMateriaPrima().setModel(
	// this.vtABMProveedor.getModelMT());
	// }

	private void AgregarCategoria() {
		ControladorBusquedaCategoriasProveedor ctr = new ControladorBusquedaCategoriasProveedor(
				this, this.vtABMProveedor);
		ctr.Inicializar();
	}

	private void QuitarCategoria() {
		JTable t = this.vtABMProveedor.getTblCategoria();
		int[] rowSelection = t.getSelectedRows();

		for (int i = rowSelection.length - 1; i >= 0; i--) {
			// String categoriID = t.getValueAt(rowSelection[i], 0).toString()
			// .trim();
			// String desripcion = t.getValueAt(rowSelection[i], 1).toString()
			// .trim();

			// CategoriaDTO c = new CategoriaDTO(categoriID, desripcion);

			// /* Elimina las materias primas pertenecientes a esa categoria. */
			// for (int j = this.vtABMProveedor.getModelMT().getRowCount() - 1;
			// j >= 0; j--) {
			// String mp = this.vtABMProveedor.getModelMT().getValueAt(j, 0)
			// .toString().trim();
			// if (MateriaPrimaModelo.SeEncuentraEn(mp, this.mdlCategoria
			// .ObtenerMateriasPrimasPara(c.getIdCategoria()))) {
			// this.vtABMProveedor.getModelMT().removeRow(j);
			// }
			// }

			this.vtABMProveedor.getModelCategoria().removeRow(rowSelection[i]);
		}
		this.vtABMProveedor.getTblCategoria().setModel(
				this.vtABMProveedor.getModelCategoria());
	}

	// private void AgregarMateriaPrima() {
	// ControladorBusquedaMPProveedor ctr = new ControladorBusquedaMPProveedor(
	// this, this.vtABMProveedor);
	// ctr.Inicializar();
	// }

	// private void QuitarMateriaPrima() {
	// JTable t = this.vtABMProveedor.getTblMateriaPrima();
	// int[] rowSelection = t.getSelectedRows();
	//
	// for (int i = rowSelection.length - 1; i >= 0; i--) {
	// this.vtABMProveedor.getModelMT().removeRow(rowSelection[i]);
	// }
	// }

	private void Guardar(boolean modificar) {
		String ProveedorId = this.vtABMProveedor.getTxtProveedorid().getText()
				.trim();
		String Nombre = this.vtABMProveedor.getTxtNombreproveedor().getText()
				.trim();
		String Telefono = this.vtABMProveedor.getTxtTelefono().getText().trim();
		String Mail = this.vtABMProveedor.getTxtMail().getText().trim();
		boolean Activo = this.vtABMProveedor.getChckbxActivo().isSelected();

		ProveedorDTO pr = new ProveedorDTO(ProveedorId, Nombre, Telefono, Mail,
				Activo);

		if (modificar) {
			this.mdlProveedor.Actualizar(pr);
			this.mdlMPProveedor.EliminarDatosPara(pr);
		} else {
			this.mdlProveedor.CrearProveedor(pr);
		}

		List<MateriaPrimaProveedorDTO> mtProveedor = new ArrayList<MateriaPrimaProveedorDTO>();

		for (CategoriaDTO cdto : this.ObtenerCategorias()) {
			for (MateriaPrimaDTO mdto : this.mdlCategoria
					.ObtenerMateriasPrimasPara(cdto.getIdCategoria())) {
				// if (MateriaPrimaModelo.SeEncuentraEn(mdto.getNombre(),
				// this.ObteberMateriasPrimas())) {
				String Categoria = cdto.getIdCategoria();
				String MateriaPrima = mdto.getNombre();

				MateriaPrimaProveedorDTO mpp = new MateriaPrimaProveedorDTO(
						pr.getProveedorId(), Categoria, MateriaPrima);

				mtProveedor.add(mpp);
				// }
			}
		}

		for (MateriaPrimaProveedorDTO mppDTO : mtProveedor) {
			this.mdlMPProveedor.CargarMateriasPrimas(mppDTO);
		}
		this.ctrProveedor.RecargarTabla();
		this.vtABMProveedor.Close();
		this.ctrProveedor.Return();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtABMProveedor.getBtnAgregarCategoria()) {
			this.AgregarCategoria();
		} else if (arg0.getSource() == this.vtABMProveedor
				.getBtnQuitarCategoria()) {
			if (this.vldABMProveedor.QuitarCategoriaValido()) {
				this.QuitarCategoria();
			}
			// } else if (arg0.getSource() ==
			// this.vtABMProveedor.getBtnAgregarMT()) {
			// this.AgregarMateriaPrima();
			// } else if (arg0.getSource() ==
			// this.vtABMProveedor.getBtnQuitarMT()) {
			// if (this.vldABMProveedor.QuitarMTValido()) {
			// this.QuitarMateriaPrima();
			// }
		} else if (arg0.getSource() == this.vtABMProveedor.getBtnGuardar()) {
			if (this.vldABMProveedor.GuardarValido(this.Modificar)) {
				this.Guardar(this.Modificar);
			}
		} else if (arg0.getSource() == this.vtABMProveedor.getBtnCancelar()) {
			this.vtABMProveedor.Close();
			this.ctrProveedor.Return();
		}
	}
}