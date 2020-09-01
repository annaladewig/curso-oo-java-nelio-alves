package application;

import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int accountNumber;
		String accountHolder;
		char answer;
		double initialDeposit, depositValue, withdrawValue;
		Account acc;
		
		System.out.print("Enter account number: ");
		accountNumber = sc.nextInt();
		
		System.out.print("Enter account holder: ");
		sc.nextLine();
		accountHolder = sc.nextLine();
		
		System.out.print("Is there an initial deposit(y/n)? ");
		answer = sc.next().charAt(0);
		
		if (answer == 'y') {
			System.out.print("Enter initial deposit value: ");
			initialDeposit = sc.nextDouble();
			acc = new Account(accountNumber, accountHolder, initialDeposit); 
		} else {
			acc = new Account(accountNumber, accountHolder);	
		}
		
		System.out.println();
		System.out.println("Account data:");
		System.out.println(acc);
		
		System.out.println();
		System.out.print("Enter a deposit value: ");
		depositValue = sc.nextDouble();
		acc.deposit(depositValue);
		System.out.println("Update account data:");
		System.out.println(acc);
		
		System.out.println();
		System.out.print("Enter a withdraw value: ");
		withdrawValue = sc.nextDouble();
		acc.withdraw(withdrawValue);
		System.out.println("Update account data:");
		System.out.println(acc);
		
		sc.close();
		} 
		
		
	}
