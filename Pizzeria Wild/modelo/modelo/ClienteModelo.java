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
	
	public List<ClienteDTO> getClientes() {
		return this.cliente.GetClientes();
	}
	
	public ClienteDTO GetCliente(String Cliente_ID) {
		return this.cliente.GetCliente(Cliente_ID);
	}
}
