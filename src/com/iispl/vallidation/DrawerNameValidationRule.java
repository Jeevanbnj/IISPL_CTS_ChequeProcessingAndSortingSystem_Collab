package com.iispl.vallidation;

import com.iispl.enums.ChequeStatus;
import com.iispl.exception.InvalidDrawerNameException;
import com.iispl.model.Cheque;

public class DrawerNameValidationRule implements ChequeValidationRule{

	@Override
	public ChequeStatus validate(Cheque cheque) throws InvalidDrawerNameException {
		if(cheque.getDrawerName()==null || cheque.getDrawerName().trim().isEmpty()) {
			throw new InvalidDrawerNameException();
		}
		return ChequeStatus.PENDING;
	}

}
