package modelo;

import java.util.List;

import dto.ClienteDTO;
import dao.ClienteDAO;
import daoImplementacion.ClienteImp;

public class ClienteModelo {

	private ClienteDAO cliente;
	
	public ClienteModelo() {
		this.cliente = new ClienteImp();
	}
	
	public List<ClienteDTO> ObtenerClientes() {
		return this.cliente.GetClientes();
	}
	
	public ClienteDTO ObtenerCliente(String Cliente_ID) {
		return this.cliente.GetCliente(Cliente_ID);
	}

	public int ObtenerNuevoId() {
		return this.cliente.GetNewId();
	}

	public void CrearCliente(ClienteDTO cliente) {
		this.cliente.Insert(cliente);	
	}

	public void ModificarCliente(ClienteDTO cliente) {
		this.cliente.Modify(cliente);
	}
}
