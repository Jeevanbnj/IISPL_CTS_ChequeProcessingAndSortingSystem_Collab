package com.iispl.vallidation;

import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;

public interface ChequeValidationRule {
		
	ChequeStatus validate(Cheque cheque);
	
}
