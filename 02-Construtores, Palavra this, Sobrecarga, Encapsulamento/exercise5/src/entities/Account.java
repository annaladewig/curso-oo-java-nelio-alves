package entities;

public class Account {

	//Atributos
	
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	//Métodos Construtores
	
	public Account(int accountNumber, String accountHolder, double initialDeposit) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		deposit(initialDeposit);
	}
	
	public Account(int accountNumber, String accountHolder) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
	}
	
	//Métodos Getters and Setters
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	//Métodos
	
	public String toString() {
		return String.format("Account: %d, Holder: %s, Balance: R$ %.2f", accountNumber, accountHolder, balance);
	}
	
	public void deposit(double depositValue) {
		balance += depositValue;
	}
	
	public void withdraw(double withdrawValue) {
		balance -= (withdrawValue + 5.00);
	}
	
	
	
}
