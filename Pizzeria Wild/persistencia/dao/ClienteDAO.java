package dao;

import dto.ClienteDTO;

import java.util.List;

public interface ClienteDAO {
	
	/* Trae los clientes de la base. */
	public List<ClienteDTO> GetClientes();
	/* busca clientes por ID. */
	public ClienteDTO GetCliente(String ClienteID);
	/*Obtiene el Un nuevo Id de Cliente*/
	public int GetNewId();
	/* Ingresa nuevo Cliente en la Base. */
	public void Insert(ClienteDTO cliente);
	/* Modifica los datos del cliente. */
	public void Modify(ClienteDTO cliente);
}
