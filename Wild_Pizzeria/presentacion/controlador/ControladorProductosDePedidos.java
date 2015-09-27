package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;

import vista.ProductosDePedidosVista;
import dto.SaborDTO;
import modelo.*;

public class ControladorProductosDePedidos implements ActionListener {

	private ProductosDePedidosVista vtProPe;
	private List<SaborDTO> lstProducto;
	private SaborModelo mdlSabor;
	private ProductoModelo mdlProducto;
	private ControladorArmadoPedido ctrAP;
	
	public ControladorProductosDePedidos(ControladorArmadoPedido CtrAP, JDialog Dialog) {
		this.vtProPe = new ProductosDePedidosVista(Dialog);
		this.vtProPe.getBtnBusqueda().addActionListener(this);
		this.vtProPe.getBtnAceptar().addActionListener(this);
		this.vtProPe.getBtnCancelar().addActionListener(this);
		
		this.ctrAP = CtrAP;
		
		this.mdlSabor = new SaborModelo();
		this.mdlProducto = new ProductoModelo();
	}
	
	public void Iniciar() {
		this.vtProPe.Open();
	}
	
	public void CargarProducto(String Producto) {
		this.vtProPe.getTxtIdproducto().setText(Producto);
		this.vtProPe.getTxtDescrProducto().setText(this.mdlProducto.GetDescr(Producto));
	}
	
	public void ActualizarTabla() {
		this.vtProPe.getModelSabores().setRowCount(0);
		this.vtProPe.getModelSabores().setColumnCount(0);
		this.vtProPe.getModelSabores().setColumnIdentifiers(this.vtProPe.getNombreColunmnas());
		this.lstProducto = this.mdlSabor.GetSabores(this.vtProPe.getTxtIdproducto().getText());
		for (SaborDTO sabor:this.lstProducto) {
			Object[] fila = {sabor.getNombre(), sabor.getPrecio()};
			this.vtProPe.getModelSabores().addRow(fila);
		}
		this.vtProPe.getTable().setModel(this.vtProPe.getModelSabores());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtProPe.getBtnBusqueda()) {
			ControladorProductoBusqueda cpb = new ControladorProductoBusqueda(this, this.vtProPe);
			cpb.Iniciar();
		}
		else if (arg0.getSource() == this.vtProPe.getBtnAceptar()) {
			/* habria que ver de agregar al producto si ya esta en la talba. */
			if (this.vtProPe.getTable().getSelectedRow() >= 0 
					&& this.vtProPe.getTxtCantidad().getText().length() > 0) {
				this.ctrAP.AgregarProducto(this.vtProPe.getTxtIdproducto().getText(), 
						this.vtProPe.getTable().getValueAt(this.vtProPe.getTable().getSelectedRow(), 0).toString(),
						Integer.parseInt(this.vtProPe.getTxtCantidad().getText()));
				this.vtProPe.Close();
			}
		}
		else if (arg0.getSource() == this.vtProPe.getBtnCancelar()) {
			this.vtProPe.Close();
		}
	}
}