package controlador;

import vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

	private Vista vista;
	// private Log log;
	private ControladorVentasCocina ctrPedidosCocina;

	public Controlador(Vista vista) {
		this.vista = vista;
		addListeners();
		this.ctrPedidosCocina = ControladorVentasCocina.GetInstancia();
	}

	private void addListeners() {
		this.vista.getBtnPedidos().addActionListener(this);
		this.vista.getBtnMateriasPrimas().addActionListener(this);
		this.vista.getBtnCategorias().addActionListener(this);
		this.vista.getBtnSolicitud().addActionListener(this);
		this.vista.getBtnReportes().addActionListener(this);
	}

	public void Inicializar() {
		this.ctrPedidosCocina.Inicializar();
		// this.vista.Close();
		this.vista.Open();
		// this.log = new Log();
		// this.log.Open();
	}

	public void Return() {
		this.vista.Open();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == this.vista.getBtnPedidos()) {
			accionPedidos();
		} else if (source == this.vista.getBtnMateriasPrimas()) {
			accionMateriaPrima();
		} else if (source == this.vista.getBtnCategorias()) {
			accionCategorias();
		} else if (source == this.vista.getBtnSolicitud()) {
			accionSolicitud();
		} else if (source == this.vista.getBtnReportes()) {
			accionReportes();
		}
	}

	private void accionPedidos() {
		ControladorVenta cp = new ControladorVenta(this);
		cp.Inicializar();
		this.vista.Close();
	}

	private void accionMateriaPrima() {
		ControladorMateriaPrima ctrMP = new ControladorMateriaPrima(this);
		ctrMP.Inicializar();
		this.vista.Close();
	}

	private void accionCategorias() {
		ControladorCategoria ctrCategoria = new ControladorCategoria(this);
		ctrCategoria.Inicializar();
		this.vista.Close();
	}

	private void accionSolicitud() {
		ControladorSolicitud ctrSolicitud = new ControladorSolicitud(this);
		ctrSolicitud.Inicializar();
		this.vista.Close();
	}

	private void accionReportes() {
		ControladorReporte ctrReporte = new ControladorReporte(this);
		ctrReporte.Inicializar();
		this.vista.Close();
	}
}