package controlador;

import vista.ArmadoPedidoVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;

import modelo.PedidoModelo;
import modelo.SaborModelo;

import dto.ClienteDTO;
import dto.EstadoPedido;
import dto.PedidoDTO;

public class ControladorArmadoPedido implements ActionListener{

	private ArmadoPedidoVista vtArmadoPedido;
	private ControladorPedido ctrPedido;
	private SaborModelo mdlSabor;
	private PedidoModelo mdlPedido;
	
	public ControladorArmadoPedido(ControladorPedido ControladorPedido, JFrame Frame) {
		this.vtArmadoPedido = new ArmadoPedidoVista(Frame);
		this.vtArmadoPedido.getTxtNumpedido().setText("NEXT");
		this.vtArmadoPedido.getBtnBusquedaCliente().addActionListener(this);
		this.vtArmadoPedido.getBtnAgregar().addActionListener(this);
		this.vtArmadoPedido.getBtnQuitar().addActionListener(this);
		this.vtArmadoPedido.getBtnCancelar().addActionListener(this);
		this.vtArmadoPedido.getBtnArmar().addActionListener(this);
		this.vtArmadoPedido.getBtnCancelar().addActionListener(this);
		
		this.ctrPedido = ControladorPedido;
		this.mdlSabor = new SaborModelo();
		this.mdlPedido = new PedidoModelo();
	}
	
	public void Inicializar() {
		/*ver de cambiar el pedido.*/
		CargarFecha();
		this.vtArmadoPedido.Open();
	}
	
	private void CargarFecha() {
		Calendar c = Calendar.getInstance();
		String fecha = "";
		
		fecha = fecha + c.get(Calendar.YEAR);
		fecha = fecha + "/" + c.get(Calendar.MONTH);
		fecha = fecha + "/" + c.get(Calendar.DATE);
		fecha = fecha + " " + c.get(Calendar.HOUR);
		fecha = fecha + ":" + c.get(Calendar.MINUTE);
		fecha = fecha + ":" + c.get(Calendar.SECOND);
		
		this.vtArmadoPedido.getTxtFecha().setText(fecha);
	}
	
	public void CargarDatosCliente(ClienteDTO Cliente) {
		this.vtArmadoPedido.getTxtCliente().setText(Cliente.getApellido() + " " +Cliente.getNombre());
		this.vtArmadoPedido.getTxtDireccion().setText(Cliente.getDireccion());
		this.vtArmadoPedido.getTxtTel().setText(Cliente.getTel());
	}
	
	public void AgregarProducto(String Producto, String Sabor, int Cantidad) {
		int PreUnid = this.mdlSabor.GerPrecio(Producto, Sabor);
		Object[] fila = {Producto, Sabor, Integer.toString(Cantidad), Integer.toString(PreUnid), Integer.toString(Cantidad * PreUnid)};
		this.vtArmadoPedido.getModelProductos().addRow(fila);
		this.vtArmadoPedido.getTblProductos().setModel(this.vtArmadoPedido.getModelProductos());
		ActualizarPrecio();
	}
	
	private void ActualizarPrecio() {
		int precio = 0;
		for (int i = 0 ; i < this.vtArmadoPedido.getTblProductos().getRowCount(); i++) {
			precio = precio + Integer.parseInt(this.vtArmadoPedido.getTblProductos().getValueAt(i, 4).toString());
		}
		this.vtArmadoPedido.getTxtPrecio().setText(Integer.toString(precio));
	}
	
	private void QuitarProducto() {
		int[] FilasBorrar = this.vtArmadoPedido.getTblProductos().getSelectedRows();
		for (int i = 0 ; i < FilasBorrar.length ; i++) {
			this.vtArmadoPedido.getModelProductos().removeRow(FilasBorrar[i]);
		}
		this.vtArmadoPedido.getTblProductos().setModel(this.vtArmadoPedido.getModelProductos());
		ActualizarPrecio();
	}
	
	private boolean CheckDelivery() {
		if (this.vtArmadoPedido.getChckbxDelivery().isSelected())
			return true;
		else
			return false;
	}
	
	private void ArmarPedido() {
		int NumPedido = this.mdlPedido.GetNuevoNumeroPedido();
		PedidoDTO NewPedido = new PedidoDTO(NumPedido, 
				this.vtArmadoPedido.getTxtCliente().getText(), 
				this.vtArmadoPedido.getTxtDireccion().getText(), 
				Integer.parseInt(this.vtArmadoPedido.getTxtPrecio().getText()),
				this.vtArmadoPedido.getTxtFecha().getText(), 
				"Pendiente", 
				this.vtArmadoPedido.getTxtrObservacion().getText(), 
				CheckDelivery());
		this.mdlPedido.agregarPedido(NewPedido);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtArmadoPedido.getBtnBusquedaCliente()) {
			ControladorBusquedaCliente ctrBusquedaCliente = new ControladorBusquedaCliente(this, this.vtArmadoPedido);
			ctrBusquedaCliente.Iniciar();
		}
		else if(arg0.getSource() == this.vtArmadoPedido.getBtnAgregar()) {
			ControladorProductosDePedidos ctrPP = new ControladorProductosDePedidos(this, this.vtArmadoPedido);
			ctrPP.Iniciar();
		}
		else if(arg0.getSource() == this.vtArmadoPedido.getBtnQuitar()){
			QuitarProducto();
		}
		else if(arg0.getSource() == this.vtArmadoPedido.getBtnArmar()) {
			this.ArmarPedido();
			this.ctrPedido.RecargarTabla();
			this.vtArmadoPedido.Close();
		}
		else if(arg0.getSource() == this.vtArmadoPedido.getBtnCancelar()) {
			this.vtArmadoPedido.Close();
		}
	}
}