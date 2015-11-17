package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.ClienteDTO;

import modelo.ClienteModelo;

import vista.ABMClienteVista;
import vista.ClienteVista;

public class ControladorABMCliente implements ActionListener{

	private ControladorCliente ctrCliente;
	private ABMClienteVista vtCliente;
	private ClienteModelo mdlCliente;
	boolean crear;
	
	public ControladorABMCliente(ControladorCliente Ctr, ClienteVista Vista) {
		this.ctrCliente = Ctr;
		
		this.vtCliente = new ABMClienteVista(Vista);
		this.vtCliente.getBtnGuardar().addActionListener(this);
		this.vtCliente.getBtnCancalar().addActionListener(this);
		
		this.mdlCliente = new ClienteModelo();
	}
	
	public void InicializarCreacion() {
		int NumCliente = this.mdlCliente.ObtenerNuevoId();
		this.vtCliente.getTxtIdcliente().setText(Integer.toString(NumCliente));
		
		this.crear = true;
		
		this.vtCliente.Open();
	}
	
	public void InicializarModificacion(ClienteDTO Cliente) {
		this.vtCliente.getTxtIdcliente().setText(Integer.toString(Cliente.getClienteId()));
		this.vtCliente.getTxtNombres().setText(Cliente.getNombre());
		this.vtCliente.getTxtApellido().setText(Cliente.getApellido());
		this.vtCliente.getTxtDireccion().setText(Cliente.getDireccion());
		this.vtCliente.getTxtTel().setText(Cliente.getTel());
		
		this.crear = false;
		
		this.vtCliente.Open();
	}
	
	private void Guardar() {
		int ClienteId = Integer.parseInt(this.vtCliente.getTxtIdcliente().getText().trim());
		String Nombre = this.vtCliente.getTxtNombres().getText().trim();
		String Apellido = this.vtCliente.getTxtApellido().getText().trim();
		String Direccion = this.vtCliente.getTxtDireccion().getText().trim();
		String Tel = this.vtCliente.getTxtTel().getText().trim();
		
		ClienteDTO c = new ClienteDTO(ClienteId, Nombre, Apellido, Direccion, Tel);
		
		if(this.crear) {
			this.mdlCliente.CrearCliente(c);
		}
		else {
			this.mdlCliente.ModificarCliente(c);
		}
		
		this.ctrCliente.ActualizarTabla();
		this.vtCliente.Close();
	}

	private void Cancelar() {
		this.vtCliente.Close();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtCliente.getBtnGuardar()) {
			this.Guardar();
		}else if(arg0.getSource() == this.vtCliente.getBtnCancalar()) {
			this.Cancelar();
		}
	}
}
