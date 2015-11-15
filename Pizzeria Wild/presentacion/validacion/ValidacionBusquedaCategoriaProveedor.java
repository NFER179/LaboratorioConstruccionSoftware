package validacion;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import modelo.CategoriaModelo;

import controlador.ControladorBusquedaCategoriasProveedor;
import vista.BusquedaCategoriasProveedorVista;

public class ValidacionBusquedaCategoriaProveedor {

	private ControladorBusquedaCategoriasProveedor ctrBusqueda;
	private BusquedaCategoriasProveedorVista vtBusqueda;

	public ValidacionBusquedaCategoriaProveedor(
			ControladorBusquedaCategoriasProveedor Ctr,
			BusquedaCategoriasProveedorVista Vista) {
		this.ctrBusqueda = Ctr;
		this.vtBusqueda = Vista;
	}

	public boolean AsignarValido() {
		boolean valido = true;

		JTable t = this.vtBusqueda.getTblCategorias();

		if (t.getSelectedRowCount() == 0) {
			String mensaje = "Debe Seleccionar Categorias para Asignar";
			String titulo = "Informacion de Asignacion";
			JOptionPane.showMessageDialog(null, mensaje, titulo,
					JOptionPane.INFORMATION_MESSAGE);
			valido = false;
		}

		if (CategoriaModelo.HayRepetidas(
				this.ctrBusqueda.CategoriasYaAsigandas(),
				this.ctrBusqueda.CategoriasSeleccionadas())) {
			String mensaje = "Hay Categorias ya Asignadas";
			String titulo = "Error de Asignación";
			JOptionPane.showMessageDialog(null, mensaje, titulo,
					JOptionPane.ERROR_MESSAGE);
			valido = false;
		}

		return valido;
	}
}
