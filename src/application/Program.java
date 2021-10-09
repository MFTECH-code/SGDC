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
		mostraClientes();
		*/
		pesquisaCliente();
		
	}
	
	public static ClienteTO cadastro() {
		ClienteTO cliente = ClienteTO.getInstance();
		System.out.println("- - - - - CADASTRO DE CLIENTE - - - - -");
		System.out.print("NOME: ");
		cliente.setNome(sc.next());
		System.out.print("EMAIL: ");
		cliente.setEmail(sc.next());
		System.out.print("TELEFONE: ");
		cliente.setTelefone(sc.next());
		
		return cliente;
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
		ClienteTO cliente = bo.buscaCliente(sc.nextInt());
		System.out.println("RESULTADO DA PESQUISA:");
		System.out.println(cliente);
	}
}
