package com.iispl.vallidation;

import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;

public class AccountNumberValidationRule implements ChequeValidationRule {

	@Override
	public ChequeStatus validate(Cheque cheque) {
		// TODO Auto-generated method stub
		if(cheque.getAccountNumber().isBlank()) {
			System.out.println("Account number should not be blank");
			return ChequeStatus.REJECTED;
		}
		return ChequeStatus.PENDING;
	}

}
