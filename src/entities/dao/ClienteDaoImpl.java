package entities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;

import confidencial.Credencials;
import entities.dao.intefaces.ClienteDao;
import entities.to.ClienteTO;

public class ClienteDaoImpl implements ClienteDao {
	private String strConn = "jdbc:mysql://localhost:3306/FMNTDB";
	private Connection conn;
	
	
	public ClienteDaoImpl() throws SQLException {
		MysqlDataSource dtsrc = new MysqlDataSource();
		dtsrc.setUrl(strConn);
		dtsrc.setUser(Credencials.user);
		dtsrc.setPassword(Credencials.password);
		conn = dtsrc.getConnection();
	}

	@Override
	public void createCliente(ClienteTO cliente) throws SQLException {
		String sql = "INSERT INTO CLIENTE (NOME, EMAIL, TELEFONE) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getEmail());
		ps.setString(3, cliente.getTelefone());
		
		ps.execute();
		ps.close();
	}

	@Override
	public List<ClienteTO> getClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteTO getCliente(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCliente(ClienteTO cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCliente(ClienteTO cliente) {
		// TODO Auto-generated method stub
		
	}

}
