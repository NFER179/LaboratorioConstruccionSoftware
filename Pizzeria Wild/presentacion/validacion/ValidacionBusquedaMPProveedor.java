package validacion;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import modelo.MateriaPrimaModelo;

import controlador.ControladorBusquedaMPProveedor;
import vista.BusquedaMPProveedorVista;

public class ValidacionBusquedaMPProveedor {

	private ControladorBusquedaMPProveedor ctrBusqueda;
	private BusquedaMPProveedorVista vtBusqueda;
	
	public ValidacionBusquedaMPProveedor(ControladorBusquedaMPProveedor Ctr, BusquedaMPProveedorVista Vista) {
		this.ctrBusqueda = Ctr;
		this.vtBusqueda = Vista;
	}

	public boolean AsignarValido() {
		boolean valido = true;
		
		JTable t = this.vtBusqueda.getTblMT();
		
		if(t.getSelectedRowCount() == 0) {
			String mensaje = "Debe seleccionar las Materias Primas que Desea Asignar.";
			String titulo = "Informacion de asignacion.";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
			valido = false;
		}
		
		if(MateriaPrimaModelo.HayRepetidos(this.ctrBusqueda.ObtenerMPAsignadas(), this.ctrBusqueda.ObtenerMPSeleccionadas())) {
			String mensaje = "Ya hay materias primas Asignadas que se Encuentras en su Seleccion.";
			String titulo = "Error de Asignacion";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
			valido = false;
		}
		
		return valido;
	}
}
