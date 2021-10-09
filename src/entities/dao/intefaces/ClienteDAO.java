package entities.dao.intefaces;

import java.sql.SQLException;
import java.util.List;

import entities.to.ClienteTO;

public interface ClienteDao {
	public void createCliente(ClienteTO cliente)  throws SQLException;
	
	public List<ClienteTO> getClientes()  throws SQLException;
	
	public ClienteTO getCliente(int code)  throws SQLException;
	
	public void setCliente(int code, ClienteTO cliente)  throws SQLException;
	
	public void deleteCliente(int code)  throws SQLException;
}
