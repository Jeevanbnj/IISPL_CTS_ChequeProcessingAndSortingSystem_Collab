package com.iispl.service;


import java.util.List;
import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;
import com.iispl.vallidation.ChequeValidationRule;


public class ChequeValidator {
	
	List<ChequeValidationRule> rules ;
	
	public ChequeValidator() {
		//Initialize the rules list and add all the rules
	}
	
	public void addRule(ChequeValidationRule rule) {
		
		
	}
	
	public ChequeStatus validate(Cheque cheque) {
		return null;
	}

}
