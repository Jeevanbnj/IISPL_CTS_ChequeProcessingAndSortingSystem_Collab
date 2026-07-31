package com.iispl.vallidation;

import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;

public class PresentingBankValidationRule implements ChequeValidationRule {

	@Override
	public ChequeStatus validate(Cheque cheque) {
	
		if(cheque.getPresentingBank()==null) {
			
			System.out.println("Presenting bank Cannot be Null");
			return ChequeStatus.REJECTED;
			
		}
		
		if (cheque.getPresentingBank().trim().isEmpty()) {
			System.out.println("Presenting bank should not be Blank");
		    return ChequeStatus.REJECTED;
		}
		return ChequeStatus.PENDING;
	}

}
	
