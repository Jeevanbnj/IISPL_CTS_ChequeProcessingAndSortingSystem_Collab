package com.iispl.vallidation;


import java.time.LocalDate;

import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;

public class DateValidationRule implements ChequeValidationRule {

	@Override
	public ChequeStatus validate(Cheque cheque) {
		
		LocalDate chequeDate = cheque.getChequeDate();
		LocalDate presentedDate = cheque.getPresentedDate();
		
		if (chequeDate == null) {
			System.out.println("Cheque date can not be null");
			return ChequeStatus.REJECTED;
		}
		if (presentedDate == null) {
			System.out.println("Presented date can not be null");
			return ChequeStatus.REJECTED;
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
			
		}

		return ChequeStatus.PENDING;
	}

}
