package controlador;

import dto.PedidoDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelo.PedidoModelo;

import vista.PedidoVista;
import controlador.Controlador;

public class ControladorPedido implements ActionListener{

	private PedidoVista pedido;
	private Controlador controlador;
	private PedidoModelo pedidoModel;
	private List<PedidoDTO> PedidosEnTabla;
	
	public ControladorPedido(Controlador controlador) {
		this.pedido = new PedidoVista();
		this.pedido.GetBtnNuevoPedido().addActionListener(this);
		
		this.controlador = controlador;
		this.pedidoModel = new PedidoModelo();
		this.PedidosEnTabla = null;
	}
	
	public void Inicializar() {
		this.llenarTabla();
		this.pedido.Open();
	}
	
	private String Delivery(boolean arg0) {
		if (arg0)
			return "Si";
		else
			return "No";
	}
	
	private void llenarTabla() {
		this.pedido.GetModelPedido().setRowCount(0); //Vacia la tabla
		this.pedido.GetModelPedido().setColumnCount(0);
		this.pedido.GetModelPedido().setColumnIdentifiers(this.pedido.GetNombreColumnas());
		this.PedidosEnTabla = this.pedidoModel.obtenerPedidosPendientes();
		for (PedidoDTO p:this.PedidosEnTabla) {
			Object[] fila = {Integer.toString(p.getNumPedido()), 
					p.getCliente(), 
					Integer.toString(p.getPrecio()) + " $", 
					p.getEstado(), 
					this.Delivery(p.isDelivery())};
			this.pedido.GetModelPedido().addRow(fila);
		}
		this.pedido.GetTable().setModel(this.pedido.GetModelPedido());
	}
	
	public void RecargarTabla() {
		this.llenarTabla();
	}
	
	private String toString(Boolean arg0) {
		if (arg0 == true)
			return "Y";
		else
			return "F";
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if ( arg0.getSource() == this.pedido.GetBtnNuevoPedido() ) {
			ControladorArmadoPedido ctrArmadoPedido = new ControladorArmadoPedido(this, this.pedido);
			ctrArmadoPedido.Inicializar();
		}
	}
}
