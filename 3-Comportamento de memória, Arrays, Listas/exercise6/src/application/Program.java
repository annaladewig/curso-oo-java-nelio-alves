package application;

import java.util.Scanner;

import entities.Rent;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] room = new String[10];
		
		System.out.print("How many rooms will be rented?");
		int quantity = sc.nextInt();
		System.out.println();
		
		Rent[] rent = new Rent[10];
		
		for (int i = 0; i < quantity; i++) {
			System.out.println("Rent #" + i+1 + ":");
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Email:");
			String email = sc.nextLine();
			System.out.print("Room:");
			int chosenRoom = sc.nextInt();
			System.out.println();
			
			room[chosenRoom] = "Occupied";
			rent[chosenRoom] = new Rent(name, email, chosenRoom);
		}
		
		System.out.println("----------------------");
		System.out.println("Busy rooms:");
		for (int i = 0; i < room.length; i++) {
			if(room[i] != null) {
				System.out.printf(i + ": " + rent[i].getName() + ", " + rent[i].getEmail());
				System.out.println();
			}
		}
		
		sc.close();

	}

}
