package entities;

public class Company extends TaxPayer {
	
	private Integer numberEmployees;
	
	public Company() {
		super();
	}
	
	public Company(String name, Double anualIncome, Integer numberEmployees) {
		super(name, anualIncome);
		this.numberEmployees = numberEmployees;
	}

	public Integer getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public Double taxPaid() {
		if(numberEmployees > 10) {
			return anualIncome * 0.14;
		} else {
			return anualIncome * 0.16;
		}
	}
	
}
