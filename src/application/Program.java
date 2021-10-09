package application;

import entities.to.ClienteTO;

public class Program {
	public static void main(String[] args) {
		ClienteTO cliente = ClienteTO.getInstance();
		ClienteTO cliente1 = ClienteTO.getInstance();
		ClienteTO cliente2 = ClienteTO.getInstance();
		
		System.out.println(cliente);
		System.out.println(cliente1);
		System.out.println(cliente2);
		
	}
}
