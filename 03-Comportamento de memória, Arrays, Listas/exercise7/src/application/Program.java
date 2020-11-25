package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered?");
		int quantity = sc.nextInt();
		System.out.println();
		
		
		for (int i = 0; i < quantity; i++) {
			System.out.println("Employee #" + i+1 + ":");
			System.out.print("Id:");
			int id = sc.nextInt();
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary:");
			double salary = sc.nextDouble();
			System.out.println();
			
			Employee emp = new Employee(id,name,salary);
			list.add(emp);
		}
		
		System.out.println("Enter the employee id that will have salary increase: ");
		int idToIncreaseSalary = sc.nextInt();
		
		Integer position = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == idToIncreaseSalary) {
				position = i;
				break;
			} else {
				position = null;
			}
		}
		
		if(position != null) {
			System.out.println("Enter the percentage: ");
			double percentage = sc.nextDouble();
			list.get(position).increaseSalary(percentage);
		} else {
			System.out.println("This id does not exist.");
		}
		
		System.out.println();
		System.out.println("----------------------");
		System.out.println("List of employees:");
		for (Employee emp :list) {
				System.out.println(emp);
		}
		
		sc.close();

	}

}
