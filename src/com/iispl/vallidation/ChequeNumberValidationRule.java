package com.iispl.vallidation;

import com.iispl.enums.ChequeStatus;
import com.iispl.exception.InvalidChequeNumberException;
import com.iispl.model.Cheque;

public class ChequeNumberValidationRule implements ChequeValidationRule {

	@Override
	public ChequeStatus validate(Cheque cheque) throws InvalidChequeNumberException {
		// TODO Auto-generated method stub
		if (cheque.getChequeNumber() == null || cheque.getChequeNumber().isBlank()) {
			throw new InvalidChequeNumberException();
		}
		return ChequeStatus.PENDING;
	}

}
