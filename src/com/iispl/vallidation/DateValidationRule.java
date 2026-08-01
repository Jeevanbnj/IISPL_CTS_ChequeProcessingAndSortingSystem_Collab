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
			throw new InvalidDateException();
		}
		
		if (chequeDate.isAfter(LocalDate.now())) {
			System.out.println("Cheque Date can not be in the future");
			return ChequeStatus.REJECTED;
		}
		if (presentedDate.isAfter(LocalDate.now())) {
			System.out.println("Presented Date can not be in the future");
			return ChequeStatus.REJECTED;
		}
		if (chequeDate.isAfter(presentedDate)) {
			System.out.println("Presented date cannot be before cheque date");
			return ChequeStatus.REJECTED;
			
		}

		return ChequeStatus.PENDING;
	}

}
