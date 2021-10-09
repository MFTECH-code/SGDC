package entities.bo;

import java.sql.SQLException;

import entities.dao.ClienteDaoImpl;
import entities.to.ClienteTO;

public class ClienteBO {
		
	public void create(ClienteTO cliente) throws SQLException {
		ClienteDaoImpl dao = new ClienteDaoImpl();
		dao.createCliente(cliente);
	}
}
