package entities;

public class Student {
	
	public String name;
	public double firstGrade;
	public double secondGrade;
	public double thirdGrade;
	
	public double finalGrade() {
		return firstGrade + secondGrade + thirdGrade;
	}
	
	public String status() {
		if (finalGrade() >= 60.00) {
			return "PASS";
		} else {
			double missing = 60.00 - finalGrade(); 
			return "FAILED\n"
					+ "MISSING "
					+ String.format("%.2f ",missing)
					+ "POINTS";
		}
	
	}
}
