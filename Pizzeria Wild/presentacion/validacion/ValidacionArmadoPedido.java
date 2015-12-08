package validacion;

import java.awt.Color;

import javax.swing.JOptionPane;

import vista.ArmadoVentaVista;

public class ValidacionArmadoPedido {

	private ArmadoVentaVista vista;

	public ValidacionArmadoPedido(ArmadoVentaVista vtArmadoPedido) {
		this.vista = vtArmadoPedido;
	}

	public boolean ArmadoValido() {
		boolean valido = true;

		String titulo = "";
		String mensaje = "";

		/* Error de Crear con delivery y sin direccion. */
		String direccion = this.vista.getTxtDireccion().getText().trim();
		String tel = this.vista.getTxtTel().getText().trim();
		if (this.vista.getChckbxDelivery().isSelected()) {
			if (direccion.equals("")) {
				titulo = "Error Direccion";
				mensaje = "Si el Pedido va a ser Enviado, es Necesario Ingresar una Direccion donde Entregarlo.";
				this.vista.getTxtDireccion().setBackground(Color.RED);
				this.vista.getTxtDireccion().setFocusable(true);
				valido = false;
			} else
				this.vista.getTxtDireccion().setBackground(
						this.vista.getTxtrObservacion().getBackground());
			if (tel.equals("")) {
				titulo = "Error";
				mensaje = "Si el Pedido va a ser Enviado, es Necesario Ingresar un numero de telefono";
				this.vista.getTxtTel().setBackground(Color.RED);
				this.vista.getTxtTel().setFocusable(true);
				valido = false;
			} else {
				this.vista.getTxtTel().setBackground(
						this.vista.getTxtrObservacion().getBackground());
			}
		}

		/* Error de crear sin ingresar productos. */
		if (this.vista.getTblProductos().getRowCount() == 0
				& this.vista.getTblCombo().getRowCount() == 0) {
			titulo = "Error Producto" + titulo.replaceAll("Error", ",");
			mensaje = "No se Pueden Crear Pedidos Vacios(Debe Ingresar al Menos un Producto o un Combo).\n"
					+ mensaje;
			valido = false;
		}

		/* Error de intentar armar sin ingresar clientes. */
		String cliente = this.vista.getTxtCliente().getText().trim();
		if (cliente.equals("")) {
			titulo = "Error Cliente" + titulo.replaceAll("Error", ",");
			mensaje = "Debe Ingresar un Cliente a Quien Entregar el Pedido.\n"
					+ mensaje;
			this.vista.getTxtCliente().setBackground(Color.RED);
			this.vista.getTxtCliente().setFocusable(true);
			valido = false;
		} else
			this.vista.getTxtCliente().setBackground(
					this.vista.getTxtrObservacion().getBackground());

		if (cliente.length() > 80) {
			valido = false;
			titulo = "Error Cliente" + titulo.replaceAll("Error", ",");
			mensaje = "El nombre del cliente puede contener a lo sumo 80 caraceteres.\n"
					+ mensaje;
		}
		if (tel.length() > 20) {
			valido = false;
			titulo = "Error Cliente" + titulo.replaceAll("Error", ",");
			mensaje = "El numero de telefono del cliente puede contener a lo sumo 20 caraceteres.\n"
					+ mensaje;
		}
		if (direccion.length() > 50) {
			valido = false;
			titulo = "Error Cliente" + titulo.replaceAll("Error", ",");
			mensaje = "La direccion del cliente puede contener a lo sumo 50 caraceteres.\n"
					+ mensaje;
		}
		if (!valido)
			JOptionPane.showMessageDialog(null, mensaje, titulo,
					JOptionPane.ERROR_MESSAGE);

		return valido;
	}
}
