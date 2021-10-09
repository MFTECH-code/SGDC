package entities.to;

public class ClienteTO {
	private String nome;
	private String email;
	private String telefone;
	
	private static ClienteTO cto = new ClienteTO();
	
	private ClienteTO() {
		
	}
	
	public static ClienteTO getInstance() {
		return cto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "[nome:" + this.nome 
				+ ", email:" + this.email
				+", telefone:" + this.telefone
				+ "]";
	}

}
