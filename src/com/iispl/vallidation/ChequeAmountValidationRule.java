package com.iispl.vallidation;

import java.math.BigDecimal;

import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;

public class ChequeAmountValidationRule implements ChequeValidationRule {

	@Override
	public ChequeStatus validate(Cheque cheque) {
		// TODO Auto-generated method stub
		if(cheque.getChequeAmount().compareTo(BigDecimal.ZERO) <= 0 || cheque.getChequeAmount() == null) {
			System.out.println("Cheque amount should not be null or zero");
			return ChequeStatus.REJECTED;
		}
		return ChequeStatus.PENDING;
	}

}
