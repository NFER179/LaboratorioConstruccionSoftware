/** Nicolas Daniel Fernandez, 29/09/2015 - Creacion de la clase. **/
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import clasesImpresiones.Impresiones;
import clasesImpresiones.ObjDatosRepartidor;
import clasesImpresiones.ObjReporteItinerario;

//import clasesImpresiones.ImpresionDocx;
import modelo.DeliveryModelo;
import modelo.VentaModelo;
import modelo.RepartidorModelo;
import dto.VentaDTO;
import dto.RepartidorDTO;
import utilidades.Fecha;
import utilidades.Msj;
import utilidades.Str;
import validacionesCampos.*;
import vista.AsignacionRepartidoresVista;

public class ControladorAsignacionRepartidor implements ActionListener {

	private AsignacionRepartidoresVista vtAsignacionRepartidores;
	private ControladorVenta ctrVenta;
	private List<VentaDTO> lVentas;
	private VentaModelo mdlPedido;
	private DeliveryModelo mdlDelivery;

	public ControladorAsignacionRepartidor(ControladorVenta ControladorVenta,
			JFrame Frame, List<VentaDTO> LVentas) {
		this.vtAsignacionRepartidores = new AsignacionRepartidoresVista(Frame);

		setDateAndHour();

		this.vtAsignacionRepartidores.getTxtNumdelivery().setText("NEXT");

		addListeners();

		this.ctrVenta = ControladorVenta;
		this.lVentas = LVentas;
		new RepartidorModelo();
		this.mdlPedido = new VentaModelo();
		this.mdlDelivery = new DeliveryModelo();
	}

	public void Inicializar() {
		this.CargarTabla();
		this.vtAsignacionRepartidores.Open();
	}

	private void CargarTabla() {
		this.vtAsignacionRepartidores.getModelTable().setRowCount(0);
		this.vtAsignacionRepartidores.getModelTable().setColumnCount(0);
		this.vtAsignacionRepartidores.getModelTable().setColumnIdentifiers(
				this.vtAsignacionRepartidores.getNombreColumnas());
		for (VentaDTO v : this.lVentas) {
			Object[] fila = { v.getFecha(), Integer.toString(v.getNumVenta()),
					v.getDireccion(), v.getObservacionDelivery() };
			this.vtAsignacionRepartidores.getModelTable().addRow(fila);
		}
		this.vtAsignacionRepartidores.getTable().setModel(
				this.vtAsignacionRepartidores.getModelTable());
	}

	public void CargarRepartidor(RepartidorDTO Repartidor) {
		this.vtAsignacionRepartidores.getTxtRepartidor().setText(
				Integer.toString(Repartidor.getRepartidorId()));
		this.vtAsignacionRepartidores.getTxtNombrerepartidor().setText(
				Repartidor.getApellido() + " " + Repartidor.getNombre());
	}

	/**
	 * -> Inicio, Nicolas Fernandez, 07-Oct-2015, Se comenta porque para la
	 * impresion de direcciones se van a pedir mas datos que unicamente la
	 * direccion.
	 */
	// private List<String> ListaDireccones() {
	// List<String> direcciones = new ArrayList<String>();
	// for (VentaDTO pedido : this.lVentas) {
	// direcciones.add(pedido.getDireccion());
	// }
	//
	// return direcciones;
	// }

	/**
	 * Se comenta porque para el nombre del archivo se va a utilizar el id del
	 * delivery.
	 */
	// private String FechaDelDia() {
	// String fecha = "";
	// Calendar c = Calendar.getInstance();
	// fecha = fecha + c.get(Calendar.YEAR) + "-";
	// fecha = fecha + c.get(Calendar.MONTH) + "-";
	// fecha = fecha + c.get(Calendar.DATE) + " ";
	// fecha = fecha + c.get(Calendar.HOUR) + "_";
	// fecha = fecha + c.get(Calendar.MINUTE);
	//
	// return fecha;
	// }
	/**
	 * <- Fin, Nicolas Fernandez, 07-Oct-2015.
	 */

	/** JNVR - Agrega los listeners a los botones */
	private void addListeners() {
		this.vtAsignacionRepartidores.getBtnBuscarrepartidor()
				.addActionListener(this);
		this.vtAsignacionRepartidores.getBtnAsignar().addActionListener(this);
		this.vtAsignacionRepartidores.getBtnCancelar().addActionListener(this);
	}

	/** JNVR - Setea la fecha y hora en los TextBox's */
	private void setDateAndHour() {
		String fecha = Fecha.CurrentDate();
		String hora = Fecha.CurrentTime();
		this.vtAsignacionRepartidores.getTxtFecha().setText(fecha);
		this.vtAsignacionRepartidores.getTxtHora().setText(hora);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		/** BEGIN JNVR CLEAN CODE */
		AsignacionRepartidoresVista vista = this.vtAsignacionRepartidores;

		if (source == vista.getBtnBuscarrepartidor())
			accionRepartidorBusqueda();
		else if (source == vista.getBtnAsignar())
			accionRepartidorAsignar();
		else if (source == vista.getBtnCancelar())
			accionRepartidorCancelar();
		else
			System.out.println("ESTADO ILEGAL"); // NO HAY MAS BOTONES
		/** END JNVR CLEAN CODE */
	}

	private void accionRepartidorBusqueda() {
		ControladorBuscadorRepartidor ctrBuscadorRepartidor = new ControladorBuscadorRepartidor(
				this, this.vtAsignacionRepartidores);
		ctrBuscadorRepartidor.Inicializar();
	}

	private void accionRepartidorCancelar() {
		this.ctrVenta.Inicializar();
		this.vtAsignacionRepartidores.Close();
	}

	private void accionRepartidorAsignar() {
		String textoRepartidor = this.vtAsignacionRepartidores
				.getTxtRepartidor().getText();
		if (!Valida.esNullOVacio(textoRepartidor)) {
			// this.mdlRepartidor.AsignarPedidos(Integer.parseInt(textoRepartidor),
			// this.lVentas);
			String fecha = Str.trim(this.vtAsignacionRepartidores.getTxtFecha()
					.getText());
			int numDelivery = this.mdlDelivery.NumNuevoDeliverry(fecha);
			int repartidorId = Integer.parseInt(this.vtAsignacionRepartidores
					.getTxtRepartidor().getText().trim());
			String hora = this.vtAsignacionRepartidores.getTxtHora().getText()
					.trim();
			String obs = this.vtAsignacionRepartidores.getTxtObservacion()
					.getText().trim();
			this.mdlDelivery.IngresarNuevodelivery(fecha, numDelivery,
					repartidorId, hora, obs);

			this.mdlDelivery.AgregarVentas(fecha, numDelivery, this.lVentas);

			/* Pone las ventas en estado de viaje. */
			this.mdlPedido.VentasEnViaje(this.lVentas);
			/* Recarga la tabla en la vista de Ventas generales. */
			this.ctrVenta.RecargarTabla();
			ObjReporteItinerario itinerario = construirItinerario(numDelivery);
			try {
				Impresiones.ImprimirItinerario(itinerario);
			} catch (Exception e) {
				e.getStackTrace();
			}
			this.vtAsignacionRepartidores.Close();
		} else {
			Msj.advertencia("Atencion", "Debe seleccionar a un repartidor");
		}
	}

	private ObjReporteItinerario construirItinerario(int numDelivery) {
		String descripcion = " ";
		ObjDatosRepartidor repartidor = new ObjDatosRepartidor(
				vtAsignacionRepartidores.getTxtNombrerepartidor().getText(),
				"datos del vehiculo", "numero de tel");
		ObjReporteItinerario itinerario = new ObjReporteItinerario(
				this.vtAsignacionRepartidores.getTxtFecha().getText(),
				numDelivery, repartidor, descripcion);
		for (VentaDTO venta : this.lVentas) {
			itinerario.addPunto(venta.getDireccion(),
					venta.getObservacionDelivery(), venta.getNumVenta(),
					venta.getPrecio());
		}
		return itinerario;
	}
}