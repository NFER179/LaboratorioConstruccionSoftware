package controlador;

import dto.PedidoDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.PedidoModelo;

import vista.PedidoVista;
import controlador.Controlador;

public class ControladorPedido implements ActionListener{

	private PedidoVista pedido;
	private Controlador controlador;
	private PedidoModelo mdlPedido;
	private List<PedidoDTO> PedidosEnTabla;
	
	public ControladorPedido(Controlador controlador) {
		this.pedido = new PedidoVista();
		this.pedido.GetBtnModificar().addActionListener(this);
		this.pedido.GetBtnEnMostrador().addActionListener(this);
		this.pedido.GetBtnNuevoPedido().addActionListener(this);
		this.pedido.GetBtnCancelarPedido().addActionListener(this);
		this.pedido.GetBtnPedidoEntregado().addActionListener(this);
		this.pedido.GetBtnVolverInicio().addActionListener(this);
		
		this.controlador = controlador;
		this.mdlPedido = new PedidoModelo();
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
		this.PedidosEnTabla = this.mdlPedido.GetPedidoSinFacturar();
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
	
	private void CancelarPedidos() {
		int[] SelectedRows = this.pedido.GetTable().getSelectedRows();
		
		for (int i = 0 ; i < SelectedRows.length ; i++) {
			this.mdlPedido.cancelarPedido(Integer.parseInt((String)this.pedido.GetTable().getValueAt(SelectedRows[i], 0)));
		}
		this.llenarTabla();
	}
	
	private void FinalizarPedidos() {
		int[] SelectedRows = this.pedido.GetTable().getSelectedRows();
		
		for ( int i = 0 ; i < SelectedRows.length ; i++ ) {
			this.mdlPedido.FinalizarPedido(Integer.parseInt(this.pedido.GetTable().getValueAt(SelectedRows[i], 0).toString()));
		}
		this.llenarTabla();
	}
	
	private void PedidoEnMostrador() {
		int[] SelectedRows = this.pedido.GetTable().getSelectedRows();
		
		for (int i = 0 ; i < SelectedRows.length ; i++ ) {
			this.mdlPedido.PedidoArmado(Integer.parseInt(this.pedido.GetTable().getValueAt(SelectedRows[i], 0).toString()));
		}
		this.llenarTabla();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if ( arg0.getSource() == this.pedido.GetBtnEnMostrador() ) {
			this.PedidoEnMostrador();
		}
		else if (arg0.getSource() == this.pedido.GetBtnModificar()) {
			if (this.pedido.GetTable().getSelectedRow() >= 0 && this.pedido.GetTable().getSelectedRows().length == 1) { 
				ControladorArmadoPedido ctrArmadoPedido = new ControladorArmadoPedido(this, this.pedido, 
						Integer.parseInt(
							(String)this.pedido.GetTable().getValueAt(this.pedido.GetTable().getSelectedRow(), 0)));
				ctrArmadoPedido.Inicializar();
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar un Unico Pedido.");
			}
		}
		else if ( arg0.getSource() == this.pedido.GetBtnNuevoPedido() ) {
			ControladorArmadoPedido ctrArmadoPedido = new ControladorArmadoPedido(this, this.pedido);
			ctrArmadoPedido.Inicializar();
		}
		else if ( arg0.getSource() == this.pedido.GetBtnCancelarPedido() ) {
			this.CancelarPedidos();
		} 
		else if ( arg0.getSource() == this.pedido.GetBtnPedidoEntregado() ) {
			this.FinalizarPedidos();
		}
		else if ( arg0.getSource() == this.pedido.GetBtnVolverInicio() ) {
			this.controlador.Inicializar();
			this.pedido.Close();
		}
	}
}
