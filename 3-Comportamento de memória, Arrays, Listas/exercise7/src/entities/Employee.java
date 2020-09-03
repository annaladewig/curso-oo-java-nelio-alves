package entities;

public class Employee {

	//Atributos
	private int id;
	private String name;
	private double salary;
	
	//Construtor
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	//M�todos Getters e Setters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}
	
	//M�todos
	public void increaseSalary(double percentage) {
		salary += salary * percentage/100;
	}
	
	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
	}
}
