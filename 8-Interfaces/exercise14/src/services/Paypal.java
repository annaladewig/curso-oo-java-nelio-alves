package services;

public class Paypal implements PaymentService {

	private static final double PAYMENT_FEE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;
	
	@Override
	public double paymentProcessing(Double amount, int installmentNumber) {	
		double monthlySimpleInterest = amount * MONTHLY_INTEREST * installmentNumber;
		double paymentFee = (amount + monthlySimpleInterest) * PAYMENT_FEE;
		return amount + monthlySimpleInterest + paymentFee;
	}
}
