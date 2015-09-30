package controlador;

import vista.ArmadoPedidoVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.PedidoModelo;
import modelo.SaborModelo;

import dto.ClienteDTO;
import dto.PedidoDTO;
import dto.ProductoEnPedidoDTO;

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
	
	public ControladorArmadoPedido(ControladorPedido ControladorPedido, JFrame Frame, int NumPedido) {
		this.vtArmadoPedido = new ArmadoPedidoVista(Frame);
		this.vtArmadoPedido.getTxtNumpedido().setText(Integer.toString(NumPedido));
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
		if (this.vtArmadoPedido.getTxtNumpedido().getText().equals("NEXT")) {
			this.CargarFecha();
			this.vtArmadoPedido.Open();
		}
		else {
			this.CargarPedido();
			this.vtArmadoPedido.Open();
		}
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
	
	private void CargarPedido() {
		PedidoDTO p = this.mdlPedido.GetPedido(Integer.parseInt(this.vtArmadoPedido.getTxtNumpedido().getText().toString()));
		
		this.vtArmadoPedido.getTxtFecha().setText(p.getFecha_hora());
		this.vtArmadoPedido.getTxtCliente().setText(p.getCliente());
		this.vtArmadoPedido.getTxtCliente().setEnabled(false);
		this.vtArmadoPedido.getChckbxDelivery().setSelected(p.isDelivery());
		this.vtArmadoPedido.getTxtDireccion().setText(p.getDireccion());
		this.vtArmadoPedido.getTxtTel().setText(p.getTel());
		this.vtArmadoPedido.getTxtrObservacion().setText(p.getObservacion());
		
		/* Carga la tabla de los prductos. */
		this.vtArmadoPedido.getModelProductos().setRowCount(0);
		this.vtArmadoPedido.getModelProductos().setColumnCount(0);
		this.vtArmadoPedido.getModelProductos().setColumnIdentifiers(this.vtArmadoPedido.getNombreColumnas());
		for (ProductoEnPedidoDTO pp:p.getProductos()) {
			int PrecioUnidad = this.mdlSabor.GetPrecio(pp.getProducto(), pp.getSabor());
			Object[] fila = {pp.getProducto(), pp.getSabor(), pp.getCantidad(), Integer.toString(PrecioUnidad), Integer.toString(pp.getCantidad() * PrecioUnidad)};
			this.vtArmadoPedido.getModelProductos().addRow(fila);
		}
		this.vtArmadoPedido.getTblProductos().setModel(this.vtArmadoPedido.getModelProductos());
		
		this.ActualizarPrecio();
	}
	
	public void CargarDatosCliente(ClienteDTO Cliente) {
		this.vtArmadoPedido.getTxtCliente().setText(Cliente.getApellido() + " " +Cliente.getNombre());
		this.vtArmadoPedido.getTxtDireccion().setText(Cliente.getDireccion());
		this.vtArmadoPedido.getTxtTel().setText(Cliente.getTel());
	}
	
	public void AgregarProducto(String Producto, String Sabor, int Cantidad) {
		int PreUnid = this.mdlSabor.GetPrecio(Producto, Sabor);
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
		if (this.vtArmadoPedido.getTxtNumpedido().getText().equals("NEXT")) {
			int NumPedido = this.mdlPedido.GetNuevoNumeroPedido();
			PedidoDTO NewPedido = new PedidoDTO(NumPedido, 
					this.vtArmadoPedido.getTxtCliente().getText(), 
					this.vtArmadoPedido.getTxtDireccion().getText(), 
					this.vtArmadoPedido.getTxtTel().getText(),
					Integer.parseInt(this.vtArmadoPedido.getTxtPrecio().getText()),
					this.vtArmadoPedido.getTxtFecha().getText(), 
					"Pendiente", 
					this.vtArmadoPedido.getTxtrObservacion().getText(), 
					CheckDelivery());
			
			for (int i = 0 ; i < this.vtArmadoPedido.getModelProductos().getRowCount() ; i++) {
				NewPedido.agregarProducto(this.vtArmadoPedido.getTblProductos().getValueAt(i, 0).toString(), 
						this.vtArmadoPedido.getTblProductos().getValueAt(i, 1).toString(),
						Integer.parseInt(this.vtArmadoPedido.getTblProductos().getValueAt(i, 2).toString()));
			}
			
			this.mdlPedido.agregarPedido(NewPedido);
		}
		else {
			PedidoDTO OldPedido = new PedidoDTO(Integer.parseInt(this.vtArmadoPedido.getTxtNumpedido().getText()), 
					this.vtArmadoPedido.getTxtCliente().getText(), 
					this.vtArmadoPedido.getTxtDireccion().getText(),
					this.vtArmadoPedido.getTxtTel().getText(),
					Integer.parseInt(this.vtArmadoPedido.getTxtPrecio().getText()),
					this.vtArmadoPedido.getTxtFecha().getText(), 
					"Pendiente", 
					this.vtArmadoPedido.getTxtrObservacion().getText(), 
					CheckDelivery());
			
			for (int i = 0 ; i < this.vtArmadoPedido.getModelProductos().getRowCount() ; i++) {
				OldPedido.agregarProducto(this.vtArmadoPedido.getTblProductos().getValueAt(i, 0).toString(), 
						this.vtArmadoPedido.getTblProductos().getValueAt(i, 1).toString(),
						Integer.parseInt(this.vtArmadoPedido.getTblProductos().getValueAt(i, 2).toString()));
			}
			
			this.mdlPedido.ModificarPedido(OldPedido);
		}
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
			if (this.vtArmadoPedido.getModelProductos().getRowCount() > 0) {
				this.ArmarPedido();
				this.ctrPedido.RecargarTabla();
				this.vtArmadoPedido.Close();
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe Ingresar al Menos un Producto.");
			}
		}
		else if(arg0.getSource() == this.vtArmadoPedido.getBtnCancelar()) {
			this.vtArmadoPedido.Close();
		}
	}
}