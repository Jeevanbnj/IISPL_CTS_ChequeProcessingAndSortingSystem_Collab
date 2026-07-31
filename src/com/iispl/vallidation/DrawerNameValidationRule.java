package com.iispl.vallidation;

import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;

public class DrawerNameValidationRule implements ChequeValidationRule{

	@Override
	public ChequeStatus validate(Cheque cheque) {
		// TODO Auto-generated method stub
		if(cheque.getDrawerName()==null) {
			System.out.println("DrawerName Should not be Null ");
			return ChequeStatus.REJECTED;
		}
		if (cheque.getDrawerName().trim().isEmpty()) {
			System.out.println(" Drawer Name should not be Blank");
		    return ChequeStatus.REJECTED;
		}
		return ChequeStatus.PENDING;
	}

}
