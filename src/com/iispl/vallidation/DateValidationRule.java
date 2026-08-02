package com.iispl.vallidation;


import java.time.LocalDate;

import com.iispl.enums.ChequeStatus;
import com.iispl.exception.InvalidDateException;
import com.iispl.model.Cheque;

public class DateValidationRule implements ChequeValidationRule {

	@Override
	public ChequeStatus validate(Cheque cheque) throws InvalidDateException {
		
		LocalDate chequeDate = cheque.getChequeDate();
		LocalDate presentedDate = cheque.getPresentedDate();
		
		if (chequeDate == null || presentedDate == null) {
			throw new InvalidDateException("Date can not be null");
		}
		
		if (chequeDate.isAfter(LocalDate.now())) {
			throw new InvalidDateException("Cheque date can not be in the future");
		}
		if (presentedDate.isAfter(LocalDate.now())) {
			throw new InvalidDateException("Presented date can not be in the future");
		}
		if (chequeDate.isAfter(presentedDate)) {
			throw new InvalidDateException("Presented date cannot be before cheque date");
		}

		return ChequeStatus.PENDING;
	}

}
