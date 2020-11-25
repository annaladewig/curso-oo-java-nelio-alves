package application;

import java.util.Scanner;

import entities.Student;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Student stu = new Student();
		
		System.out.println("Name: ");
		stu.name = sc.nextLine();
		System.out.println("First Grade: ");
		stu.firstGrade = sc.nextDouble();
		System.out.println("Second Grade: ");
		stu.secondGrade = sc.nextDouble();
		System.out.println("Third Grade: ");
		stu.thirdGrade = sc.nextDouble();
		
		System.out.println();
		System.out.printf("FINAL GRADE = %.2f\n", stu.finalGrade());
		System.out.println(stu.status());
		
		sc.close();
	}

}
