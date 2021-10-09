package entities.to;

public class ClienteTO {
	private Integer code;
	private String nome;
	private String email;
	private String telefone;
	
	private static ClienteTO cto = new ClienteTO();
	
	private ClienteTO() {
		
	}
	
	public static ClienteTO getInstance() {
		return cto;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
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
