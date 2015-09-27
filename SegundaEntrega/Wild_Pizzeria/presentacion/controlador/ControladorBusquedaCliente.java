package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JDialog;

import vista.BusquedaClienteVista;
import dao.ClienteDAO;
import daoImplementacion.ClienteImp;
import dto.ClienteDTO;
import modelo.ClienteModelo;

public class ControladorBusquedaCliente implements ActionListener {
	
	private BusquedaClienteVista vtBusquedaCliente;
	private ControladorArmadoPedido ctrArmadoPedido;
	private List<ClienteDTO> lstCliente;
	private ClienteModelo mdlCliente;
	
	public ControladorBusquedaCliente(ControladorArmadoPedido CtrArmadoPedido, JDialog Dialog) {
		this.vtBusquedaCliente = new BusquedaClienteVista(Dialog);
		this.vtBusquedaCliente.getBtnAceptar().addActionListener(this);
		this.vtBusquedaCliente.getBtnCancelar().addActionListener(this);
		
		this.ctrArmadoPedido = CtrArmadoPedido;
		this.mdlCliente = new ClienteModelo();
	}
	
	public void Iniciar() {
		CargarClientes();
		this.vtBusquedaCliente.Open();
	}
	
	private void CargarClientes() {
		this.vtBusquedaCliente.getModelCliente().setRowCount(0);
		this.vtBusquedaCliente.getModelCliente().setColumnCount(0);
		this.vtBusquedaCliente.getModelCliente().setColumnIdentifiers(this.vtBusquedaCliente.getNombreColumnas());
		this.lstCliente = this.mdlCliente.getClientes();
		for (ClienteDTO c:this.lstCliente){
			Object[] fila = {Integer.toString(c.getClienteId()), c.getApellido() + " " + c.getNombre()}; 
			this.vtBusquedaCliente.getModelCliente().addRow(fila);
		}
		this.vtBusquedaCliente.getTable().setModel(this.vtBusquedaCliente.getModelCliente());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtBusquedaCliente.getBtnAceptar()){
			if (this.vtBusquedaCliente.getTable().getSelectedRow() >= 0){
				String idCliente = (String)(this.vtBusquedaCliente.getTable().getValueAt(this.vtBusquedaCliente.getTable().getSelectedRow(), 0));
				ClienteDAO cdao = new ClienteImp();
				this.ctrArmadoPedido.CargarDatosCliente(cdao.GetCliente(idCliente));
				this.vtBusquedaCliente.Close();
			}
		}
		else if (arg0.getSource() == this.vtBusquedaCliente.getBtnCancelar()){
			this.vtBusquedaCliente.Close();
		}
	}
}