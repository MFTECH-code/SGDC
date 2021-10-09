package entities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;

import confidencial.Credencials;
import entities.dao.intefaces.ClienteDao;
import entities.to.ClienteTO;

public class ClienteDaoImpl implements ClienteDao {
	private String strConn = "jdbc:mysql://localhost:3306/FMNTDB?useLegacyDatetimeCode=false&serverTimezone=UTC";
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
	public List<ClienteTO> getClientes() throws SQLException {
		List<ClienteTO> clientes = new ArrayList<>();
		String sql = "SELECT * FROM CLIENTE";
		ResultSet rs = conn.createStatement().executeQuery(sql);
		
		while(rs.next()) {
			ClienteTO cliente = new ClienteTO();
			cliente.setCode(rs.getInt("CODIGO"));
			cliente.setNome(rs.getString("NOME"));
			cliente.setEmail(rs.getString("EMAIL"));
			cliente.setTelefone(rs.getString("TELEFONE"));
			
			clientes.add(cliente);
		}
		
		rs.close();
		return clientes;
	}

	@Override
	public ClienteTO getCliente(int code) throws SQLException {
		ClienteTO cliente = ClienteTO.getInstance();
		String sql = "SELECT * FROM CLIENTE WHERE CODIGO = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, code);
		ps.execute();
		
		while (ps.getResultSet().next()) {
			cliente.setCode(ps.getResultSet().getInt("CODIGO"));
			cliente.setNome(ps.getResultSet().getString("NOME"));
			cliente.setEmail(ps.getResultSet().getString("EMAIL"));
			cliente.setTelefone(ps.getResultSet().getString("TELEFONE"));			
		}
		
		
		ps.close();;
		return cliente;
		
	}

	@Override
	public void setCliente(int code, ClienteTO cliente) throws SQLException {
		String sql = "UPDATE CLIENTE SET NOME=?, EMAIL=?, TELEFONE=? WHERE CODIGO = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getEmail());
		ps.setString(3, cliente.getTelefone());
		ps.setInt(4, code);
		
		ps.execute();
		ps.close();
	}

	@Override
	public void deleteCliente(int code) throws SQLException {
		String sql = "DELETE FROM CLIENTE WHERE CODIGO = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, code);
		
		ps.execute();
		ps.close();
		
	}

}
