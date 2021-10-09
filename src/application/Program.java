package application;

import java.sql.SQLException;
import java.util.Scanner;

import entities.bo.ClienteBO;
import entities.to.ClienteTO;

public class Program {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {
		/*
		ClienteBO bo = new ClienteBO();
		bo.create(cadastro());
		pesquisaCliente();
		removerCliente();
		atualizarDadosCliente();
		mostraClientes();
		*/
		while(true) {
			int selection = menu();
			while (selection < 1 && selection > 6) {
				System.out.println("OPÇÃO DIGITADA É INVÁLIDA...");
				selection = menu();
			}
			
			if (selection == 1) {
				cadastro();
			} else if (selection == 2) {
				mostraClientes();
			} else if (selection == 3) {
				pesquisaCliente();
			} else if (selection == 4) {
				atualizarDadosCliente();
			} else if (selection == 5) {
				removerCliente();
			} else {
				break;
			}
		}
		
	}
	
	public static int menu() {
		System.out.println("- - - - - SGDC: SISTEMA GERENCIADOR DE CLIENTES - - - - -");
		System.out.println("1 - CADASTRAR CLIENTE");
		System.out.println("2 - LISTAR CLIENTES CADASTRADOS");
		System.out.println("3 - PESQUISAR CLIENTE");
		System.out.println("4 - ATUALIZAR DADOS DE UM CLIENTE");
		System.out.println("5 - REMOVER CLIENTE");
		System.out.println("6 - SAIR");
		
		System.out.print("SELECIONE -> ");
		return sc.nextInt();
	}
	
	public static void cadastro() throws SQLException {
		ClienteBO bo = new ClienteBO();
		ClienteTO cliente = ClienteTO.getInstance();
		System.out.println("- - - - - CADASTRO DE CLIENTE - - - - -");
		System.out.print("NOME: ");
		cliente.setNome(sc.next());
		System.out.print("EMAIL: ");
		cliente.setEmail(sc.next());
		System.out.print("TELEFONE: ");
		cliente.setTelefone(sc.next());
		
		bo.create(cliente);
		System.out.println("CLIENTE CADASTRADO COM SUCESSO!");
	}
	
	public static void mostraClientes() throws SQLException {
		ClienteBO bo = new ClienteBO();
		System.out.println("- - - - - LISTAGEM DE CLIENTES - - - - -");
		bo.listarClientes().forEach(cliente -> System.out.println(cliente));
	}
	
	public static void pesquisaCliente() throws SQLException {
		ClienteBO bo = new ClienteBO();
		System.out.println("- - - - - BUSCA DE CLIENTES - - - - -");
		System.out.print("DIGITE O CÓDIGO DO CLIENTE QUE DESEJA BUSCAR: ");
		int code = sc.nextInt();
		ClienteTO cliente = bo.buscaCliente(code);
		System.out.println("RESULTADO DA PESQUISA:");
		if (cliente.getCode() == null) {
			System.out.println("CLIENTE INEXISTENTE...");
		}else {
			System.out.println(cliente);			
		}
	}
	
	public static void atualizarDadosCliente() throws SQLException {
		ClienteBO bo = new ClienteBO();
		System.out.println("- - - - - ATUALIZAÇÃO CADASTRAL DE CLIENTES - - - - -");
		System.out.print("DIGITE O CÓDIGO DO CLIENTE QUE DESEJA ATUALIZAR: ");
		int code = sc.nextInt();
		System.out.println("O CLIENTE QUE VOCÊ DESEJA ATUALIZAR É ESSE? -> " + bo.buscaCliente(code));
		System.out.print("[S/N]: ");
		char decisao = sc.next().toUpperCase().charAt(0);
		while (decisao != 'S' && decisao != 'N') {
			System.out.println("DIGITE SIM OU NÃO...");
			decisao = sc.next().toUpperCase().charAt(0);
		}
		
		if (decisao == 'S') {
			ClienteTO cliente = ClienteTO.getInstance();
			System.out.print("NOVO NOME: ");
			cliente.setNome(sc.next());
			System.out.print("NOVO EMAIL: ");
			cliente.setEmail(sc.next());
			System.out.print("NOVO TELEFONE: ");
			cliente.setTelefone(sc.next());
			
			bo.atualizaCliente(code, cliente);
			System.out.println("DADOS ATUALIZADOS COM SUCESSO!");
		} else {
			System.out.println("OPERAÇÃO CANCELADA!");
		}
		
	}
	
	public static void removerCliente() throws SQLException {
		ClienteBO bo = new ClienteBO();
		System.out.println("- - - - - REMOVER CLIENTE - - - - -");
		System.out.print("DIGITE O CÓDIGO DO CLIENTE QUE DESEJA REMOVER: ");
		int code = sc.nextInt();
		System.out.println("O CLIENTE QUE VOCÊ DESEJA REMOVER É ESSE? -> " + bo.buscaCliente(code));
		System.out.print("[S/N]: ");
		char decisao = sc.next().toUpperCase().charAt(0);
		while (decisao != 'S' && decisao != 'N') {
			System.out.println("DIGITE SIM OU NÃO...");
			decisao = sc.next().toUpperCase().charAt(0);
		}
		
		if (decisao == 'S') {
			bo.excluiCliente(code);
			System.out.println("USUÁRIO REMOVIDO COM SUCESSO!");
		} else {
			System.out.println("OPERAÇÃO CANCELADA!");
		}
	}
}
