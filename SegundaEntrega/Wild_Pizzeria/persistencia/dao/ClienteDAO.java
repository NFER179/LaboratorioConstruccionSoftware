package dao;

import dto.ClienteDTO;

import java.util.List;

public interface ClienteDAO {
	
	/* Trae los clientes de la base. */
	public List<ClienteDTO> GetClientes();
	/* busca clientes por ID. */
	public ClienteDTO GetCliente(String ClienteID);
}
