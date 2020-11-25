package entities;

public class Product {
	
	private String name;
	private double value;
	private int quantity;
	
	public Product() {
	}

	public Product(String name, double value, int quantity) {
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Double total() {
		return value * quantity;
	}
}
