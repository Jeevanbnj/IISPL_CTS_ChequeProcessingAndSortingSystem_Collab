package com.iispl.main;

import java.util.Scanner;

import com.iispl.service.ChequeService;
import com.iispl.service.ChequeServiceImpl;

public class ChequeProcessingMain {
	private static Scanner scanner = new Scanner(System.in);
    private static ChequeService chequeService = new ChequeServiceImpl();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== CHEQUE MANAGEMENT SYSTEM ==========");
            System.out.println("1. Display all Cheques");
            System.out.println("2. Sort by Cheque Number");
            System.out.println("3. Sort by Cheque Amount (Ascending)");
            System.out.println("4. Sort by Cheque Amount (Descending)");
            System.out.println("5. Sort by Cheque Date");
            System.out.println("6. Sort by Presenting Bank and Amount");
            System.out.println("7. Sort by Priority");
            System.out.println("8. Sort by Status");
            System.out.println("9. Display High Value Cheques");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

            case 1:
                chequeService.getAllCheques();
                break;

            case 2:
                chequeService.sortByChequeNumber();
                break;

            case 3:
                chequeService.sortByAmountAscending();
                break;

            case 4:
                chequeService.sortByAmountAscending();
                break;

            case 5:
                chequeService.sortByChequeDate();
                break;

            case 6:
                chequeService.sortByBankAndAmount();
                break;

            case 7:
                chequeService.sortByPriority();
                break;
                
            case 8:
            	chequeService.sortByStatus();
            	break;

            case 9:
                chequeService.getHighValueCheques();
                break;

            case 10:
                System.out.println("Thank you for using Cheque Management System.");
                scanner.close();
                System.exit(0);

            default:
                System.out.println("Invalid choice! Please enter a number between 1 and 9.");
            }
        }
    }

}
