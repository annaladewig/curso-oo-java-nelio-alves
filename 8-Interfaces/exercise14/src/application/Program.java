package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractProcessingService;
import services.Paypal;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter number of installments: ");
		Integer numberInstallments = sc.nextInt();
		ContractProcessingService contractProcessing = new ContractProcessingService(new Paypal());
		contractProcessing.processContract(contract, numberInstallments);
		
		System.out.println("Installments:");
		for (Installment installment : contract.getInstallments()) {
			System.out.print(sdf.format(installment.getDueDate())); 
			System.out.printf(" - %.2f\n", installment.getAmount());
		}
	sc.close();
	}
}
