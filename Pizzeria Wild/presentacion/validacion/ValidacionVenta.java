package validacion;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import modelo.VentaModelo;

import dto.VentaDTO;

import utilidades.Msj;
import utilidades.Str;
import vista.VentasVista;

public class ValidacionVenta {

	private VentasVista vtVenta;
	private VentaModelo mdlVenta;

	public ValidacionVenta(VentasVista arg0) {
		this.vtVenta = arg0;
		this.mdlVenta = new VentaModelo();
	}

	public boolean CancelarValido() {
		JTable tabla = this.vtVenta.getTableVentas();

		if (tabla.getSelectedRowCount() == 0) {
			String mensaje = "Debe Seleccionar al Menos una Venta para Poder Cancelar.";
			String titulo = "Información de Cancelación";
			JOptionPane.showMessageDialog(null, mensaje, titulo,
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean EntregarValido() {
		JTable tabla = this.vtVenta.getTableVentas();

		if (tabla.getSelectedRowCount() == 0) {
			String mensaje = "Debe Seleccionar al Menos una Venta para Poder Entregar.";
			String titulo = "Información de Entrega";
			JOptionPane.showMessageDialog(null, mensaje, titulo,
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean ModificarValido() {
		String mensaje = "Debe Seleccionar la Venta que Desea Modificar.";
		String titulo = "Informacion de Seleccion.";

		JTable tabla = this.vtVenta.getTableVentas();

		if (tabla.getSelectedRowCount() == 0) {
			Msj.error(titulo, mensaje);
			return false;
		}
		boolean seleccionoUno = tabla.getSelectedRowCount() == 1;
		if (seleccionoUno) {
			String estado = this.GetVentaSeleccionada().getEstado()
					.toUpperCase();
			if (estado.equals("VIAJE")) {
				mensaje = "No Puede Modificar Ventas que Esten en Viaje.";
				titulo = "Error";
				Msj.error(titulo, mensaje);
				return false;

			} else if (estado.equals("ARMADO")) {
				mensaje = "No Puede Modificar Ventas que Esten Armadas en Mostrador.";
				titulo = "Error";
				Msj.error(titulo, mensaje);
				return false;
			} else
				return true;// OK
		} else {
			mensaje = "Debe Seleccionar una Unica Fila.";
			titulo = "Informacion.";
			Msj.error(titulo, mensaje);
			return false;
		}
	}

	private VentaDTO GetVentaSeleccionada() {
		VentaDTO ret = null;

		int SelectedRows = this.vtVenta.getTableVentas().getSelectedRow();
		JTable table = this.vtVenta.getTableVentas();

		String fecha = Str.trim(table.getValueAt(SelectedRows, 0));
		int numVenta = Str.toInt(table.getValueAt(SelectedRows, 1));

		ret = this.mdlVenta.GetVenta(fecha, numVenta);
		return ret;
	}

	public boolean InformarValido() {
		boolean Informar = true;
		JTable tabla = this.vtVenta.getTableVentas();

		if (tabla.getSelectedRowCount() != 1) {
			String titulo = "Informacion de Seleccion";
			String mensaje = "Debe Seleccionar una Venta Para Ver su Informacion";
			JOptionPane.showMessageDialog(null, mensaje, titulo,
					JOptionPane.INFORMATION_MESSAGE);
			Informar = false;
		}

		return Informar;
	}
}