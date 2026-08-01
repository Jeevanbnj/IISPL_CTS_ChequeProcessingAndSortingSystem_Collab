package com.iispl.vallidation;

import com.iispl.enums.ChequeStatus;
import com.iispl.exception.InvalidAccountNumberException;
import com.iispl.exception.InvalidAmountException;
import com.iispl.exception.InvalidChequeNumberException;
import com.iispl.exception.InvalidDateException;
import com.iispl.exception.InvalidDrawerNameException;
import com.iispl.exception.InvalidPresentingBankException;
import com.iispl.model.Cheque;

public interface ChequeValidationRule {
		
	ChequeStatus validate(Cheque cheque) throws InvalidChequeNumberException, InvalidAccountNumberException,
												InvalidAmountException, InvalidDateException, InvalidDrawerNameException,
												InvalidPresentingBankException;
	
}
