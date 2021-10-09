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
		*/
		
		mostraClientes();
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
		bo.listarClientes().forEach(cliente -> System.out.println(cliente));
	}
}
