package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractProcessingService {
	
	private PaymentService paymentService;
	
	public ContractProcessingService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, int numberInstallments) {
		double installmentBaseValue = contract.getTotalValue() / numberInstallments;
		for (int i = 1; i <= numberInstallments; i++) {
			double amount = paymentService.paymentProcessing(installmentBaseValue, i);
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installment(dueDate, amount));
		}
	}
	
	private Date addMonths(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n); 
		return calendar.getTime();
	}
}
