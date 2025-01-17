package com.pluralsight;
// hello world
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class FinancialApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();

    }

    // Method to display the main menu
    private static void displayMenu() {
        String choose;
        while (true) {
            System.out.println("\nHome Screen:");
            System.out.println("D) Add Deposit:");
            System.out.println("P) Add Payment:");
            System.out.println("L) Display Ledger:");
            System.out.println("X) Exit");
            System.out.println("Choose other option: ");

            choose = scanner.nextLine().toUpperCase();

            switch (choose) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    addPayment();
                    break;
                case "L":
                    displayLedger();
                    break;
                case "X":
                    System.out.println("Exiting the application");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }

    }

    //Method for adding deposit
    private static void addDeposit() {
        System.out.print("Enter deposit amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter deposit description: ");
        String description = scanner.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();
        TransactionFileManager.addTransactionToFile(new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount).toString());
        System.out.println("Deposit Successfully: ");
    }

    //Method for adding payment
    private static void addPayment() {
        System.out.print("Enter payment amount: ");
        double amount = Double.parseDouble(scanner.nextLine()) * -1;
        System.out.print("Enter payment description: ");
        String description = scanner.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();
        TransactionFileManager.addTransactionToFile(new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount).toString());
        System.out.println("Payment Received");
    }

    //Method to display ledger
    private static void displayLedger() {
        String choose;
        System.out.println("\nLedger:");
        System.out.println("A) Display ALL Transaction:");
        System.out.println("P) Display Deposits:");
        System.out.println("I) Display Payments:");
        System.out.println("R) Reports");
        System.out.println("X) Exit");

        choose = scanner.nextLine().toUpperCase();

        switch (choose) {
            case "A":
                allEnteries();
                break;
            case "P":
                deposit();
                break;
            case "I":
                paymentEnteries();
                break;
            case "R":
                report();
                break;
            case "X":
                System.out.println("Return to main menu");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Method to display all transactions
    private static void allEnteries() {
        System.out.println("ALL transactions: ");
        TransactionFileManager.loadTransactionList();
        for (Transaction t : TransactionFileManager.transactions) {
            System.out.println(t);
        }
    }

    // Maaike help Method to display deposits
    private static void deposit() {
        System.out.println("Deposits: ");
        for (Transaction t : TransactionFileManager.transactions) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }

        }
    }

    // Maaike help Method to display negative amount payments
    private static void paymentEnteries() {
        System.out.println("Payments: ");
        for (Transaction t : TransactionFileManager.transactions) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }

    // Method to display reports
    private static void report() {
        String choose;
        System.out.println("\nReport:");
        System.out.println("M) Month to Date:");
        System.out.println("P) Previous Month:");
        System.out.println("Y) Year to Date:");
        System.out.println("PY) Previous Year");
        System.out.println("S) Search by Vendor");
        System.out.println("X) Exit");

        choose = scanner.nextLine().toUpperCase();

        switch (choose) {
            case "M":
                monthToDate();
                break;
            case "P":
                previousMonth();
                break;
            case "Y":
                yearToDate();
                break;
            case "PY":
                previousYear();
                break;
            case "S":
                searchVendor();
                break;
            case "X":
                System.out.println("Return to main menu");
                return;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Filter Transaction Month to Date
    private static void monthToDate() {
        System.out.println("Month to Date: ");
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();
        int currentYear = today.getYear();

        TransactionFileManager.loadTransactionList();

        for (Transaction t : TransactionFileManager.transactions) {
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

        TransactionFileManager.loadTransactionList();

        for (Transaction t : TransactionFileManager.transactions) {
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

        TransactionFileManager.loadTransactionList();

        for (Transaction t : TransactionFileManager.transactions) {
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

        TransactionFileManager.loadTransactionList();

        for (Transaction t : TransactionFileManager.transactions) {
            if (t.getDate().getYear() == previousYear) {
                System.out.println(t);
            }
        }
    }
    //Filter Transaction Vendor Name
    private static void searchVendor() {
        System.out.println("Vendor Name: ");
        String vendorName = scanner.nextLine().toLowerCase();

        TransactionFileManager.loadTransactionList();

        for (Transaction t : TransactionFileManager.transactions) {
            if (t.getVendor().toLowerCase().contains(vendorName)) {
                System.out.println(t);
            }
        }
    }
}
