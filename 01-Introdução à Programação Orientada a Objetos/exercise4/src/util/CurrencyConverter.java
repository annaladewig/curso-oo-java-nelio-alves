package util;

public class CurrencyConverter {

	public static double dollarToReal(double dollarPrice, double quantity) {
		return dollarPrice * quantity + (dollarPrice * quantity * 0.06);
	}
}
