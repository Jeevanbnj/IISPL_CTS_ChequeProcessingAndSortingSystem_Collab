package com.iispl.vallidation;

import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;

public class ChequeNumberValidationRule implements ChequeValidationRule {

	@Override
	public ChequeStatus validate(Cheque cheque) {
		// TODO Auto-generated method stub
		String ChequeNumber=cheque.getChequeNumber();
		
		if(ChequeNumber==null || ChequeNumber.isBlank()) {
			System.out.println("ChequeNumber Should not be Null or Empty");
			return ChequeStatus.REJECTED;
		}
		if(ChequeNumber.length() <= 0 ) {
			System.out.println("Cheque Number length Should be greater then zero");
			return ChequeStatus.REJECTED;	
		}
		return ChequeStatus.PENDING;
	}

}
