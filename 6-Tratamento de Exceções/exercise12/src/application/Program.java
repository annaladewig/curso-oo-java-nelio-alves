package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial Balance: R$ ");
		Double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: R$ ");
		Double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, initialBalance, withdrawLimit);

		System.out.println();
		System.out.print("Enter amount for withdraw: R$ ");
		Double amount = sc.nextDouble();
		account.withdraw(amount);
		System.out.print("New balance: R$ " + String.format("%.2f", account.getBalance()));
		
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		} finally {
			sc.close();
		}
	}

}
