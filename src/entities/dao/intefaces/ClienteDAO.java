package entities.dao.intefaces;

import java.util.List;

import entities.to.ClienteTO;

public interface ClienteDAO {
	public void createCliente(ClienteTO cliente);
	
	public List<ClienteTO> getClientes();
	
	public ClienteTO getCliente(Integer code);
	
	public void setCliente(ClienteTO cliente);
	
	public void deleteCliente(ClienteTO cliente);
}
