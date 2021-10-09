package entities.bo;

import java.sql.SQLException;
import java.util.List;

import entities.dao.ClienteDaoImpl;
import entities.to.ClienteTO;

public class ClienteBO {
		
	public void create(ClienteTO cliente) throws SQLException {
		ClienteDaoImpl dao = new ClienteDaoImpl();
		dao.createCliente(cliente);
	}
	
	public List<ClienteTO> listarClientes() throws SQLException {
		ClienteDaoImpl dao = new ClienteDaoImpl();
		return dao.getClientes();
	}
}
