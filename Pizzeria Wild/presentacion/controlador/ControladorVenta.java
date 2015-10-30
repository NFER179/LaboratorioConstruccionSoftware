package controlador;

import dto.VentaDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import modelo.VentaModelo;
import utilidades.Msj;
import utilidades.Str;
import validacion.ValidacionVenta;
import vista.VentasVista;
import controlador.Controlador;

public class ControladorVenta implements ActionListener {

	private VentasVista vtVenta;
	private Controlador controlador;
	private VentaModelo mdlVenta;
	private List<VentaDTO> ventasEnTabla;
	private ControladorVentasCocina ctrVentasCocina;
	private ValidacionVenta vldVenta;
	private static int columnaFecha = 0;
	private static int columnaNVenta = 1;

	public ControladorVenta(Controlador controlador) {
		this.vtVenta = new VentasVista();
		addListeners();

		this.controlador = controlador;
		this.mdlVenta = new VentaModelo();
		this.ventasEnTabla = null;
		this.vldVenta = new ValidacionVenta(this.vtVenta);
		this.ctrVentasCocina = ControladorVentasCocina.GetInstancia();
	}

	public void Inicializar() {
		this.llenarTabla();
		this.vtVenta.Open();
	}

	private void addListeners() {
		this.vtVenta.GetBtnEnviar().addActionListener(this);
		this.vtVenta.GetBtnEnViaje().addActionListener(this);
		this.vtVenta.GetBtnModificar().addActionListener(this);
		this.vtVenta.GetBtnEnMostrador().addActionListener(this);
		this.vtVenta.GetBtnNuevaVenta().addActionListener(this);
		this.vtVenta.GetBtnCancelarVenta().addActionListener(this);
		this.vtVenta.GetBtnVentaEntregada().addActionListener(this);
		this.vtVenta.GetBtnVolverInicio().addActionListener(this);
		/** JNVR - agrego eventos para los items del menu */
//		this.vtVenta.getMntmReporteDiario().addActionListener(this);
//		this.vtVenta.getMntmReporteSemanal().addActionListener(this);
//		this.vtVenta.getMntmReporteMensual().addActionListener(this);
//		this.vtVenta.getMntmBusquedaDeProveedores().addActionListener(this);
//		this.vtVenta.getMntmNuevoProveedor().addActionListener(this);
//		this.vtVenta.getMntmEditarSolicitudesGuardadas()
//				.addActionListener(this);
//		this.vtVenta.getMntmNuevaSolicitud().addActionListener(this);

	}

	private String Delivery(boolean arg0) {
		if (arg0)
			return "Si";
		else
			return "No";
	}

	private void llenarTabla() {
		this.vtVenta.GetModelVenta().setRowCount(0); // Vacia la tabla
		this.vtVenta.GetModelVenta().setColumnCount(0);
		this.vtVenta.GetModelVenta().setColumnIdentifiers(
				this.vtVenta.GetNombreColumnas());
		this.ventasEnTabla = this.mdlVenta.GetVentaSinFacturar();
		for (VentaDTO p : this.ventasEnTabla) {
			Object[] fila = { p.getFecha(), Integer.toString(p.getNumVenta()),
					p.getCliente(), Integer.toString(p.getPrecio()) + " $",
					p.getEstado(), this.Delivery(p.isDelivery()) };
			this.vtVenta.GetModelVenta().addRow(fila);
		}
		this.vtVenta.GetTable().setModel(this.vtVenta.GetModelVenta());
	}

	public void RecargarTabla() {
		this.llenarTabla();
	}

	// private String toString(Boolean arg0) {
	// if (arg0 == true)
	// return "Y";
	// else
	// return "F";
	// }

	private void CancelarVentas(List<VentaDTO> Ventas) {
		// int[] SelectedRows = this.pedido.GetTable().getSelectedRows();
		//
		// for (int i = 0 ; i < SelectedRows.length ; i++) {
		// this.mdlPedido.cancelarPedido(Integer.parseInt((String)this.pedido.GetTable().getValueAt(SelectedRows[i],
		// 0)));
		// }

		for (VentaDTO venta : Ventas) {
			this.mdlVenta.CancelarVenta(venta.getFecha(), venta.getNumVenta());
		}
		this.llenarTabla();
	}

	private void FinalizarVentas(List<VentaDTO> Ventas) {
		// int[] SelectedRows = this.pedido.GetTable().getSelectedRows();
		//
		// for ( int i = 0 ; i < SelectedRows.length ; i++ ) {
		// this.mdlPedido.FinalizarPedido(Integer.parseInt(this.pedido.GetTable().getValueAt(SelectedRows[i],
		// 0).toString()));
		// }

		for (VentaDTO venta : Ventas) {
			this.mdlVenta.FinalizarVenta(venta.getFecha(), venta.getNumVenta());
		}
		this.llenarTabla();
	}

	private void VentasEnMostrador(List<VentaDTO> Ventas) {
		// int[] SelectedRows = this.pedido.GetTable().getSelectedRows();
		//
		// for (int i = 0 ; i < SelectedRows.length ; i++ ) {
		// this.mdlPedido.PedidoArmado(Integer.parseInt(this.pedido.GetTable().getValueAt(SelectedRows[i],
		// 0).toString()));
		// }

		for (VentaDTO venta : Ventas) {
			this.mdlVenta.VentaArmado(venta.getFecha(), venta.getNumVenta());
		}
		this.llenarTabla();
	}

	private List<VentaDTO> GetVentasSeleccionadas() {
		List<VentaDTO> ventas = new ArrayList<VentaDTO>();
		int[] SelectedRows = this.vtVenta.GetTable().getSelectedRows();
		JTable table = this.vtVenta.GetTable();
		for (int i = 0; i < SelectedRows.length; i++) {
			int numFila = SelectedRows[i];
			String fecha = Str.trim(table.getValueAt(numFila, columnaFecha));
			int numVenta = Str.toInt(table.getValueAt(numFila, columnaNVenta));
			VentaDTO venta = this.mdlVenta.GetVenta(fecha, numVenta);
			ventas.add(venta);
		}
		return ventas;
	}

	private VentaDTO GetVentaSeleccionada() {
		VentaDTO ret = null;
		int SelectedRows = this.vtVenta.GetTable().getSelectedRow();
		JTable table = this.vtVenta.GetTable();
		String fecha = Str.trim(table.getValueAt(SelectedRows, columnaFecha));
		int numVenta = Str.toInt(table.getValueAt(SelectedRows, columnaNVenta));
		ret = this.mdlVenta.GetVenta(fecha, numVenta);
		return ret;
	}

	private boolean NoTieneVentasEnViaje(List<VentaDTO> Ventas) {
		boolean NoViajes = true;
		for (VentaDTO venta : Ventas) {
			if (esVentaEnViaje(venta)) {
				NoViajes = false;
			}
		}
		return NoViajes;
	}

	private boolean esVentaEnViaje(VentaDTO venta) {
		return venta.getEstado().toUpperCase().equals("VIAJE");
	}

//	private boolean SinVentasPendientes(List<VentaDTO> Ventas) {
//		boolean sinPendientes = true;
//		for (VentaDTO venta : Ventas) {
//			if (!esVentaPendiente(venta)) {
//				sinPendientes = false;
//			}
//		}
//		return sinPendientes;
//	}

	private boolean esVentaPendiente(VentaDTO venta) {
		return venta.getEstado().toUpperCase().equals("PENDIENTE");
	}

	private boolean TieneVentasDeDelivery(List<VentaDTO> Ventas) {
		boolean ventasDelivery = true;
		for (VentaDTO venta : Ventas)
			if (!venta.isDelivery())
				ventasDelivery = false;
		return ventasDelivery;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		VentasVista vista = this.vtVenta;
		Object source = arg0.getSource();
		if (source == vista.GetBtnEnviar()) {
			accionEnviar();
		} else if (source == vista.GetBtnEnViaje()) {
			accionEnViaje();
		} else if (source == vista.GetBtnEnMostrador()) {
			accionEnMostrador();
		} else if (source == vista.GetBtnModificar()) {
			if(this.vldVenta.ModificarValido()) {
				accionModificar();
			}
		} else if (source == vista.GetBtnNuevaVenta()) {
			accionNuevaVenta();
		} else if (source == vista.GetBtnCancelarVenta()) {
			if(this.vldVenta.CancelarValido()) {
				accionCancelarVenta();
			}
		} else if (source == vista.GetBtnVentaEntregada()) {
			if(this.vldVenta.EntregarValido()) {
				accionVentaEntregada();
			}
		} else if (source == vista.GetBtnVolverInicio()) {
			accionVolverInicio();
		}
//		} else if (source == vista.getMntmReporteDiario()) {
//			accionReporteDiario();
//		} else if (source == vista.getMntmReporteSemanal()) {
//			accionReporteSemanal();
//		} else if (source == vista.getMntmReporteMensual()) {
//			accionReporteMensual();
//		} else if (source == vista.getMntmBusquedaDeProveedores()) {
//			accionBusquedaDeProveedores();
//		} else if (source == vista.getMntmNuevoProveedor()) {
//			accionNuevoProveedor();
//		} else if (source == vista.getMntmNuevaSolicitud()) {
//			accionNuevaSolicitud();
//		} else if (source == vista.getMntmEditarSolicitudesGuardadas()) {
//			accionEditarSolicitudesGuardadas();
//		} else {
//			System.out.println("ESTADO ILEGAL");
//		}
	}

//	private void accionEditarSolicitudesGuardadas() {
//	}
//
//	private void accionNuevaSolicitud() {
//	}
//
//	private void accionNuevoProveedor() {
//	}
//
//	private void accionBusquedaDeProveedores() {
//	}
//
//	private void accionReporteMensual() {
//	}
//
//	private void accionReporteSemanal() {
//	}
//
//	private void accionReporteDiario() {
//	}

	private void accionVolverInicio() {
		this.controlador.Return();
		this.vtVenta.Close();
	}

	/**
	 * Boton para indicar que las ventas fueron entregas(solo por mostrador).
	 */
	private void accionVentaEntregada() {
		List<VentaDTO> ventas = this.GetVentasSeleccionadas();
		if (this.NoTieneVentasEnViaje(ventas)) {
			this.FinalizarVentas(ventas);
			this.ctrVentasCocina.RecargarTablas();
		} else {
			Msj.error("Error en Entregar Venta",
					"Las Ventas que Estan en Viaje no Pueden Entregarse por Mostrador.");
		}
	}

	/** Boton para cancelar las ventas. */
	private void accionCancelarVenta() {
		List<VentaDTO> ventas = this.GetVentasSeleccionadas();
		if (this.NoTieneVentasEnViaje(ventas)) {
			this.CancelarVentas(ventas);
			this.ctrVentasCocina.RecargarTablas();
		} else {
			Msj.error("Error al Cancelar",
					"No Puede Cancelar Ventas que Estan en Viaje");
		}
	}

	/** Boton para generar una nueva venta. */
	private void accionNuevaVenta() {
		ControladorArmadoVenta ctrArmadoVenta = new ControladorArmadoVenta(
				this, this.vtVenta);
		ctrArmadoVenta.Inicializar();

	}

	/** Boton para poder modificar una venta. */
	private void accionModificar() {
//		JTable tabla = this.vtVenta.GetTable();
		// Si marco una fila ??
//		boolean seleccionoUnaVenta = tabla.getSelectedRow() >= 0;
		// Si es exactamente una
//		seleccionoUnaVenta = seleccionoUnaVenta
//				&& tabla.getSelectedRows().length == 1;
//		if (seleccionoUnaVenta) {
			revisarVentaEnViaje();
//		} else {
//			Msj.advertencia("Atencion", "Debe Seleccionar una Unica Venta.");
//		}

	}

	private void revisarVentaEnViaje() {
//		VentaDTO ventaMarcada = GetVentaSeleccionada();
//		boolean noEstaEnViaje = !esVentaEnViaje(ventaMarcada);
//		if (noEstaEnViaje) {
			verificarVentaPendiente();
//		} else {
//			Msj.error("Error de Modificación",
//					"No Puede Modificar Ventas que Esten en Viaje");
//		}
	}

	private void verificarVentaPendiente() {
//		VentaDTO ventaMarcada = GetVentaSeleccionada();
//		if (!esVentaPendiente(ventaMarcada)) {
			modificarVenta();
//		} else {
//			Msj.error("Error Estado Ventas",
//					"No se pueden modificar las Ventas Armadas.");
//		}
	}

	private void modificarVenta() {
		JTable tabla = this.vtVenta.GetTable();
		String fecha = Str.trim(tabla.getValueAt(tabla.getSelectedRow(),
				columnaFecha));
		int numVenta = Str.toInt(tabla.getValueAt(tabla.getSelectedRow(),
				columnaNVenta));
		ControladorArmadoVenta ctrArmadoVenta = new ControladorArmadoVenta(
				this, this.vtVenta, fecha, numVenta);
		ctrArmadoVenta.Inicializar();
	}

	/** Boton para asignar las ventas que estan en el mostrador. */
	private void accionEnMostrador() {
		List<VentaDTO> ventas = this.GetVentasSeleccionadas();
		if (this.NoTieneVentasEnViaje(ventas)) {
			this.VentasEnMostrador(ventas);
			this.ctrVentasCocina.RecargarTablas();
		} else {
			Msj.error("Error Seleccion de Ventas",
					"No Puede Usar esta Funcionalidad Para Ventas que esten en Viaje");
			// JOptionPane
			// .showMessageDialog(
			// null,
			// "No Puede Usar esta Funcionalidad Para Ventas que esten en Viaje",
			// "Error Seleccion de Ventas",
			// JOptionPane.ERROR_MESSAGE);
		}

	}

	/** Boton para ver las ventas que estan en viaje. */
	private void accionEnViaje() {
		ControladorVentasEnViaje ctrVentasEnViaje = new ControladorVentasEnViaje(
				this, this.vtVenta);
		ctrVentasEnViaje.Iniciar();

	}

	private void accionEnviar() {
		List<VentaDTO> lventa = this.GetVentasSeleccionadas();
		boolean tieneVentas = lventa.size() > 0;
		if (tieneVentas) {
			revisarVentasDelivery(lventa);
		} else {
			Msj.error("Error Seleccion Venta",
					"Debe Seleccionar al Menos una Venta.");
		}
	}

	private void revisarVentasDelivery(List<VentaDTO> lventa) {
		if (TieneVentasDeDelivery(lventa)) {
			revisarVentasEnViaje(lventa);
		} else {
			Msj.error("Error de delivery",
					"No puede Asignar Ventas que no Sean a Domicilio.");
		}
	}

	/**
	 * JNVR - Si la lista ingresada por parametros no tiene ventas en viaje,
	 * envia todas las ventas
	 */
	private void revisarVentasEnViaje(List<VentaDTO> lventa) {
		if (this.NoTieneVentasEnViaje(lventa)) {
			ControladorAsignacionRepartidor ctrAsignarRepartidor = new ControladorAsignacionRepartidor(
					this, this.vtVenta, lventa);
			ctrAsignarRepartidor.Inicializar();
			this.ctrVentasCocina.RecargarTablas();

		} else {
			Msj.error("Error Estado Ventas",
					"No puede Asigar Ventas en Estado 'Viaje'");
		}
	}

	private void accionEnviarOLD() {
		List<VentaDTO> lventa = this.GetVentasSeleccionadas();
		boolean tieneVentas = lventa.size() > 0;
		if (tieneVentas) {
			if (TieneVentasDeDelivery(lventa)) {
				if (this.NoTieneVentasEnViaje(lventa)) {
					ControladorAsignacionRepartidor ctrAsignarRepartidor = new ControladorAsignacionRepartidor(
							this, this.vtVenta, lventa);
					ctrAsignarRepartidor.Inicializar();
					this.ctrVentasCocina.RecargarTablas();

				} else {
					Msj.error("Error Estado Ventas",
							"No puede Asigar Ventas en Estado 'Viaje'");
				}
			} else {
				Msj.error("Error de delivery",
						"No puede Asignar Ventas que no Sean a Domicilio.");

			}
		} else {
			Msj.error("Error Seleccion Venta",
					"Debe Seleccionar al Menos una Venta.");

		}

	}
}