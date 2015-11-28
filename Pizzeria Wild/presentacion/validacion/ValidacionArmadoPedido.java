package validacion;

import java.awt.Color;

import javax.swing.JOptionPane;

import vista.ArmadoVentaVista;

public class ValidacionArmadoPedido {

	private ArmadoVentaVista vista;
	
	public ValidacionArmadoPedido(ArmadoVentaVista vtArmadoPedido){
		this.vista = vtArmadoPedido;
	}
	
	public boolean ArmadoValido() {
		boolean valido = true;
		
		String titulo = "";
		String mensaje = "";
		
		/* Error de Crear con delivery y sin direccion. */
		if(this.vista.getChckbxDelivery().isSelected() & this.vista.getTxtDireccion().getText().trim().equals("")){
			titulo = "Error Direccion";
			mensaje = "Si el Pedido va a ser Enviado, es Necesario Ingresar una Direccion donde Entregarlo.";
			this.vista.getTxtDireccion().setBackground(Color.RED);
			this.vista.getTxtDireccion().setFocusable(true);
			valido = false;
		}
		else
			this.vista.getTxtDireccion().setBackground(this.vista.getTxtrObservacion().getBackground());
		
		/* Error de crear sin ingresar productos. */
		if(this.vista.getTblProductos().getRowCount() == 0 & this.vista.getTblCombo().getRowCount() == 0){
			titulo = "Error Producto" + titulo.replaceAll("Error", ",");
			mensaje = "No se Pueden Crear Pedidos Vacios(Debe Ingresar al Menos un Producto o un Combo).\n" + mensaje;
			valido = false;
		}
		
		/* Errot de intentar armar sin ingresar clientes. */
		if(this.vista.getTxtCliente().getText().trim().equals("")){
			titulo = "Error Cliente" + titulo.replaceAll("Error", ",");
			mensaje = "Debe Ingresar un Cliente a Quien Entregar el Pedido.\n" + mensaje;
			this.vista.getTxtCliente().setBackground(Color.RED);
			this.vista.getTxtCliente().setFocusable(true);
			valido = false;
		}
		else
			this.vista.getTxtCliente().setBackground(this.vista.getTxtrObservacion().getBackground());
		
		if(!valido)
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		
		return valido;
	}
}
