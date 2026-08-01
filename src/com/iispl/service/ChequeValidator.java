package com.iispl.service;


import java.util.ArrayList;
import java.util.List;
import com.iispl.enums.ChequeStatus;
import com.iispl.exception.InvalidAccountNumberException;
import com.iispl.exception.InvalidAmountException;
import com.iispl.exception.InvalidChequeNumberException;
import com.iispl.exception.InvalidDateException;
import com.iispl.exception.InvalidDrawerNameException;
import com.iispl.exception.InvalidPresentingBankException;
import com.iispl.model.Cheque;
import com.iispl.vallidation.AccountNumberValidationRule;
import com.iispl.vallidation.ChequeAmountValidationRule;
import com.iispl.vallidation.ChequeNumberValidationRule;
import com.iispl.vallidation.ChequeValidationRule;
import com.iispl.vallidation.DateValidationRule;
import com.iispl.vallidation.DrawerNameValidationRule;
import com.iispl.vallidation.PresentingBankValidationRule;


public class ChequeValidator {
	
	List<ChequeValidationRule> rules ;
	
	public ChequeValidator() {

		rules = new ArrayList<ChequeValidationRule>();
		
		rules.add(new ChequeNumberValidationRule());
		rules.add(new AccountNumberValidationRule());
		rules.add(new DrawerNameValidationRule());
		rules.add(new PresentingBankValidationRule());
		rules.add(new ChequeAmountValidationRule());
		rules.add(new DateValidationRule());

	}
	
	public void addRule(ChequeValidationRule rule) {
		
		rules.add(rule);
		
	}
	
	public ChequeStatus validate(Cheque cheque) {
		System.out.println("Validating cheque: " + cheque.getChequeNumber());
		for (ChequeValidationRule rule : rules) {
			
			try {
				ChequeStatus status = rule.validate(cheque);
				if (status.equals(ChequeStatus.REJECTED)) {
					return status;
				}
			} catch (InvalidAccountNumberException | InvalidAmountException | InvalidChequeNumberException |
					InvalidDateException | InvalidDrawerNameException | InvalidPresentingBankException e) {
				
				System.out.println(e.getMessage());
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

				return ChequeStatus.REJECTED;
			}
			
		}
		
		System.out.println("All validations are passed");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
		return ChequeStatus.ACCEPTED;
	}

}
