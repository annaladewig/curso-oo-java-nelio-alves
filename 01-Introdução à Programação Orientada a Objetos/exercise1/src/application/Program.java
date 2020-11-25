package application;

import java.util.Scanner;

import entities.Rectangle;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Rectangle rectangle = new Rectangle();
		System.out.println("Enter rectangle width and hegiht:");
		rectangle.width = sc.nextDouble();
		rectangle.height = sc.nextDouble();

		System.out.printf("Area = %.2f\n", rectangle.area());
		System.out.printf("Perimeter = %.2f\n", rectangle.perimeter());
		System.out.printf("Diagonal = %.2f\n", rectangle.diagonal());

		sc.close();
	}

}
