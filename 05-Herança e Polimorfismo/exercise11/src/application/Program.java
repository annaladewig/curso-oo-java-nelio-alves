package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List <TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Tax payer #" + (i+1) + " data:");
			System.out.print("Individual or company (i/c): ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: R$ ");
			Double anualIncome = sc.nextDouble();
			if(type == 'i') {
				System.out.print("Health expenditures: R$ ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			if(type == 'c') {
				System.out.print("Number of employees: ");
				Integer numberEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberEmployees));
			}
		}

		System.out.println();
		System.out.println("TAXES PAID:");
		for(TaxPayer taxPayer : list) {
			System.out.print(taxPayer.getName() 
					+ ": R$ " 
					+ String.format("%.2f\n", taxPayer.taxPaid()));
		}
		
		double sum = 0.0;
		for(TaxPayer taxPayer : list) {
			sum += taxPayer.taxPaid();
		}
		System.out.println();
		System.out.printf("TOTAL TAXES: R$ %.2f", sum);
		
	}

}
