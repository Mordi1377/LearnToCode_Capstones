package com.pluralsight;
// hello world

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class FinancialApp {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        TransactionFileManager.loadTransactionList();
        displayMenu();
    }

    // Method to display options
    private static void displayOptions(String screenName, String... options) {
        System.out.println("\n" + screenName);
        for (String option : options) {
            System.out.println(option);
        }
    }

    // Method to display the main menu
    private static void displayMenu() {
        while (true) {
            displayOptions("Home Screen:", "D) Add Deposit", "P) Add Payment", "L) Display Ledger", "X) Exit", "Choose other option");
            String choose = SCANNER.nextLine().toUpperCase();

            switch (choose) {
                case "D" -> addDeposit();
                case "P" -> addPayment();
                case "L" -> displayLedger();
                case "X" -> {
                    System.out.println("Exiting the application");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }

    }

    //Method for adding deposit
    private static void addDeposit() {
        System.out.print("Enter deposit amount: ");
        double amount = Double.parseDouble(SCANNER.nextLine());
        System.out.print("Enter deposit description: ");
        String description = SCANNER.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = SCANNER.nextLine();
        TransactionFileManager.addTransaction(new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount));
        System.out.println("Deposit Successfully: ");
    }

    //Method for adding payment
    private static void addPayment() {
        System.out.print("Enter payment amount: ");
        double amount = Double.parseDouble(SCANNER.nextLine()) * -1;
        System.out.print("Enter payment description: ");
        String description = SCANNER.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = SCANNER.nextLine();
        TransactionFileManager.addTransaction(new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount));
        System.out.println("Payment Received");
    }

    //Method to display ledger
    private static void displayLedger() {
        displayOptions("Ledger:", "A) Display ALL Transactions", "D) Display Deposits", "P) Display Payments", "R) Reports", "X) Exit");
        String choose = SCANNER.nextLine().toUpperCase();

        switch (choose) {
            case "A" -> allEntries();
            case "D" -> deposit();
            case "P" -> paymentEntries();
            case "R" -> report();
            case "X" -> System.out.println("Return to main menu");
            default -> System.out.println("Invalid option.");
        }
    }

    // Method to display all transactions
    private static void allEntries() {
        System.out.println("ALL transactions: ");
        for (Transaction t : TransactionFileManager.getTransactions()) {
            System.out.println(t);
        }
    }

    // Maaike help Method to display deposits
    private static void deposit() {
        System.out.println("Deposits: ");
        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }

    // Maaike help Method to display negative amount payments
    private static void paymentEntries() {
        System.out.println("Payments: ");
        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }

    // Method to display reports
    private static void report() {
        displayOptions("Report:", "M) Month to Date", "PM) Previous Month", "Y) Year to Date", "PY) Previous Year", "S) Search by Vendor", "X) Exit");
        String choose = SCANNER.nextLine().toUpperCase();

        switch (choose) {
            case "M" -> monthToDate();
            case "PM" -> previousMonth();
            case "Y" -> yearToDate();
            case "PY" -> previousYear();
            case "S" -> searchVendor();
            case "X" -> System.out.println("Return to main menu");
            default -> System.out.println("Invalid option.");
        }
    }

    // Filter Transaction Month to Date
    private static void monthToDate() {
        System.out.println("Month to Date: ");
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();
        int currentYear = today.getYear();

        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getDate().getMonthValue() == currentMonth && t.getDate().getYear() == currentYear) {
                System.out.println(t);

            }
        }
    }

    // Filter Transaction Previous Month
    private static void previousMonth() {
        System.out.println("Previous Month: ");
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();
        int currentYear = today.getYear();

        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getDate().getMonthValue() == currentMonth && t.getDate().getYear() == currentYear) {
                System.out.println(t);

            }
        }
    }

    //Filter Transaction Year to Date
    private static void yearToDate() {
        System.out.println("Year to Date: ");
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();

        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getDate().getYear() == currentYear) {
                System.out.println(t);
            }
        }
    }

    //Filter Transaction Previous Year
    private static void previousYear() {
        System.out.println("Previous Year: ");
        LocalDate today = LocalDate.now();
        int previousYear = today.getYear() - 1;

        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getDate().getYear() == previousYear) {
                System.out.println(t);
            }
        }
    }

    //Filter Transaction Vendor Name
    private static void searchVendor() {
        System.out.println("Vendor Name: ");
        String vendorName = SCANNER.nextLine().toLowerCase();

        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getVendor().toLowerCase().contains(vendorName)) {
                System.out.println(t);
            }
        }
    }
}
