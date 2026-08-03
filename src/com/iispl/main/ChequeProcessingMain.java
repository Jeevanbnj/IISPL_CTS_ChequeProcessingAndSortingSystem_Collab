package com.iispl.main;

import java.util.List;
import java.util.Scanner;

import com.iispl.model.Cheque;
import com.iispl.service.ChequeService;
import com.iispl.service.ChequeServiceImpl;

public class ChequeProcessingMain {
	
	private static Scanner scanner = new Scanner(System.in);
    private static ChequeService chequeService = new ChequeServiceImpl();

    public static void main(String[] args) {
    	
    	for (Cheque cheque : chequeService.getPendingCheques()) {
    		chequeService.validateCheque(cheque);
    	}

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
            System.out.println("10. Sort by Clearing Zone and Amount");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            List<Cheque> cheques;
            switch (choice) {

            case 1:
                cheques = chequeService.getAllCheques();
                displayCheques(cheques);
                break;

            case 2:
            	cheques = chequeService.sortByChequeNumber();
            	displayCheques(cheques);
                break;

            case 3:
                cheques = chequeService.sortByAmountAscending();
                displayCheques(cheques);
                break;

            case 4:
                cheques = chequeService.sortByAmountDescending();
                displayCheques(cheques);
                break;

            case 5:
                cheques = chequeService.sortByChequeDate();
                displayCheques(cheques);
                break;

            case 6:
                cheques = chequeService.sortByBankAndAmount();
                displayCheques(cheques);
                break;

            case 7:
                cheques = chequeService.sortByPriority();
                displayCheques(cheques);
                break;
                
            case 8:
            	cheques = chequeService.sortByStatus();
            	displayCheques(cheques);
            	break;

            case 9:
                List<Cheque> highValueCheques = chequeService.getHighValueCheques();
                displayCheques(highValueCheques);
                break;
            
            case 10:
            	cheques = chequeService.sortByClearingZoneAndAmount();
            	displayCheques(cheques);
            	break;
            case 11:
                System.out.println("Thank you for using Cheque Management System.");
                scanner.close();
                System.exit(0);

            default:
                System.out.println("Invalid choice! Please enter a number between 1 and 10.");
            }
        }
    }
    
    public static void displayCheques(List<Cheque> cheques) {

        System.out.printf("%-15s %-15s %-20s %-20s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                "Cheque No", "Account No", "Drawer Name", "Presenting Bank",
                "Amount", "Cheque Date", "Presented Date", "Priority", "Status","Clearing Zone");

        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------");

        for (Cheque cheque : cheques) {

            System.out.printf("%-15s %-15s %-20s %-20s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                    cheque.getChequeNumber(),
                    cheque.getAccountNumber(),
                    cheque.getDrawerName(),
                    cheque.getPresentingBank(),
                    cheque.getChequeAmount(),
                    cheque.getChequeDate(),
                    cheque.getPresentedDate(),
                    cheque.getPriority(),
                    cheque.getStatus(),
                    cheque.getClearingZone());
        }
    }

}
