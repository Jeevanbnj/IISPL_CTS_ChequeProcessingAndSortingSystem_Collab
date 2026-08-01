package com.iispl.vallidation;

import java.math.BigDecimal;

import com.iispl.enums.ChequeStatus;
import com.iispl.exception.InvalidAmountException;
import com.iispl.model.Cheque;

public class ChequeAmountValidationRule implements ChequeValidationRule {

	@Override
	public ChequeStatus validate(Cheque cheque) throws InvalidAmountException {
		// TODO Auto-generated method stub
		if(cheque.getChequeAmount().compareTo(BigDecimal.ZERO) <= 0 || cheque.getChequeAmount() == null) {
			throw new InvalidAmountException();
		}
		return ChequeStatus.PENDING;
	}

}
