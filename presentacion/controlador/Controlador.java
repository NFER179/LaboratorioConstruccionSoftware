package controlador;

import vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

	private Vista vista;
//	private Log log;
	private ControladorVentasCocina ctrPedidosCocina;
	
	public Controlador(Vista vista) {
		this.vista = vista;
		this.vista.getBtnPedidos().addActionListener(this);
		this.vista.getBtnMateriasPrimas().addActionListener(this);
		this.vista.getBtnCategorias().addActionListener(this);
		this.vista.getBtnSolicitud().addActionListener(this);
		
		this.ctrPedidosCocina = ControladorVentasCocina.GetInstancia();
	}
	
	public void Inicializar() {
		this.ctrPedidosCocina.Inicializar();
//		this.vista.Close();
		this.vista.Open();
//		this.log = new Log();
//		this.log.Open();
	}
	
	public void Return() {
		this.vista.Open();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vista.getBtnPedidos()) {
			ControladorVenta cp = new ControladorVenta(this);
			cp.Inicializar();
			this.vista.Close();
		}
		else if (arg0.getSource() == this.vista.getBtnMateriasPrimas()) {
			ControladorMateriaPrima ctrMP = new ControladorMateriaPrima(this);
			ctrMP.Inicializar();
			this.vista.Close();
		}
		else if (arg0.getSource() == this.vista.getBtnCategorias()) {
			ControladorCategoria ctrCategoria = new ControladorCategoria(this);
			ctrCategoria.Inicializar();
			this.vista.Close();
		}
		else if(arg0.getSource() == this.vista.getBtnSolicitud()) {
			ControladorSolicitud ctrSolicitud = new ControladorSolicitud(this);
			ctrSolicitud.Inicializar();
			this.vista.Close();
		}
	}
}