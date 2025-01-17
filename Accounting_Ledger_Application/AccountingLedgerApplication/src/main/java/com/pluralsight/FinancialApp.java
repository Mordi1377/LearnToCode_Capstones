package com.pluralsight;

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

    /**
     * Displays the main menu and handles user navigation through application features.
     * <p>
     * This method provides a looping menu interface for the user to interact with
     * different functionalities of the application. It remains active until the user
     * chooses to exit by entering the {@code X} option. Each menu option triggers
     * a corresponding method for performing specific tasks.
     */
<<<<<<< HEAD
    private static void displayMenu() {
=======
     private static void displayMenu() {
        String choose;
>>>>>>> 89facdc (refactor completed comments)
        while (true) {
            displayOptions("Home Screen:", "D) Add Deposit", "P) Add Payment", "L) Display Ledger", "X) Exit", "Choose other option");
            String choose = validateString().toUpperCase();

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

    //-----------------------------------------------------------------------
    /**
     * Adds a new deposit transaction and saves it to the CSV file.
     * <p>
     * This method prompts the user to input the deposit amount, description, and vendor.
     * It creates a new {@link Transaction} object with the current date and time.
     * The transaction is then converted to a string format and appended to the CSV file
     * using {@link TransactionFileManager#addTransactionToFile(String)}.
     */
     private static void addDeposit() {
        System.out.print("Enter deposit amount: ");
        double amount = validateDouble();
        System.out.print("Enter deposit description: ");
        String description = validateString();
        System.out.print("Enter vendor: ");
        String vendor = validateString();
        TransactionFileManager.addTransaction(new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount));
        System.out.println("Deposit Successfully: ");
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a new payment transaction and saves it to the CSV file.
     * <p>
     * This method prompts the user to input the payment amount, description, and vendor.
     * It creates a new {@link Transaction} object with the current date and time,
     * and a negative amount (to represent a payment). The transaction is then converted
     * to a string format and appended to the CSV file using
     * {@link TransactionFileManager#addTransactionToFile(String)}.
     */
     private static void addPayment() {
        System.out.print("Enter payment amount: ");
        double amount = validateDouble() * -1;
        System.out.print("Enter payment description: ");
        String description = validateString();
        System.out.print("Enter vendor: ");
        String vendor = validateString();
        TransactionFileManager.addTransaction(new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount));
        System.out.println("Payment Received");
    }

    //-----------------------------------------------------------------------
    /**
     * Displays the ledger menu and executes the selected action based on user input.
     * <p>
     * This method presents a menu with options to display all transactions, deposits,
     * payments, or reports. The user selects an option by entering a corresponding
     * letter, and the method calls the appropriate function to handle the request.
     * If an invalid option is entered, a message is displayed.
     */
    private static void displayLedger() {
        displayOptions("Ledger:", "A) Display ALL Transactions", "D) Display Deposits", "P) Display Payments", "R) Reports", "X) Exit");
        String choose = validateString().toUpperCase();

        switch (choose) {
            case "A" -> allEntries();
            case "D" -> deposit();
            case "P" -> paymentEntries();
            case "R" -> report();
            case "X" -> System.out.println("Return to main menu");
            default -> System.out.println("Invalid option.");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Displays all transactions from the CSV file.
     * <p>
     * This method loads the list of transactions from the {@link TransactionFileManager}
     * and iterates through each transaction in the list, printing its details to the console.
     * The transactions are displayed in the order they appear in the CSV file.
     */
<<<<<<< HEAD
    private static void allEntries() {

=======
     private static void allEnteries() {
>>>>>>> 89facdc (refactor completed comments)
        System.out.println("ALL transactions: ");
        for (Transaction t : TransactionFileManager.getTransactions()) {
            System.out.println(t);
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Displays all deposit transactions from the loaded transaction list.
     * <p>
     * This method iterates through the list of transactions loaded by
     * {@link TransactionFileManager} and prints only those transactions where
     * the amount is greater than zero (representing deposits).
     */
     private static void deposit() {
        System.out.println("Deposits: ");
        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Displays all payment transactions from the loaded transaction list.
     * <p>
     * This method iterates through the list of transactions loaded by
     * {@link TransactionFileManager} and prints only those transactions where
     * the amount is less than zero (representing payments).
     */
<<<<<<< HEAD
    private static void paymentEntries() {
=======
     private static void paymentEnteries() {
>>>>>>> 89facdc (refactor completed comments)
        System.out.println("Payments: ");
        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Displays the report menu and executes the selected action based on user input.
     * <p>
     * This method provides a menu for generating various types of reports and
     * performs the corresponding action based on the user's choice. Users can generate
     * reports for the current month, previous month, current year, previous year,
     * or search transactions by vendor. The user can also exit the menu.
     */
<<<<<<< HEAD
    private static void report() {
        displayOptions("Report:", "M) Month to Date", "PM) Previous Month", "Y) Year to Date", "PY) Previous Year", "S) Search by Vendor", "X) Exit");
        String choose = validateString().toUpperCase();
=======
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
>>>>>>> 89facdc (refactor completed comments)

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

<<<<<<< HEAD
    // Filter Transaction Month to Date

    /**
     * Filters Transactions from Month to Date
=======
    //-----------------------------------------------------------------------
    /**
     * Prints a list of transactions that occurred in the current month to date.
     *  <p>
     *  This method retrieves the current date to determine the month and year. It then
     *  loads the transaction list from the {@link TransactionFileManager} and filters
     *  transactions to include only those matching the current month and year.
     *  <p>
     *  Transactions are displayed using their overridden {@code toString()} method.
>>>>>>> 89facdc (refactor completed comments)
     */
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

<<<<<<< HEAD
    // Filter Transaction Previous Month
    private static void previousMonth() {
=======
    //-----------------------------------------------------------------------
    /**
     * Prints a list of transactions that occurred in the previous month.
     * <p>
     * This method retrieves the current date subtracting 1 to the month to determine the previous month and current year.
     * It then loads the transaction list from the {@link TransactionFileManager} and filters
     * transactions to include only those matching the previous month and current year.
     * <p>
     * Transactions are displayed using their overridden {@code toString()} method.
     */
        private static void previousMonth() {
>>>>>>> 89facdc (refactor completed comments)
        System.out.println("Previous Month: ");
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue() - 1;
        int currentYear = today.getYear();

        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getDate().getMonthValue() == currentMonth && t.getDate().getYear() == currentYear) {
                System.out.println(t);

            }
        }
    }

<<<<<<< HEAD
    //Filter Transaction Year to Date
=======
    //-----------------------------------------------------------------------
    /**
     * Prints a list of transactions that occurred in the current year to date.
     * <p>
     * This method retrieves the current date to determine the year.
     * It then loads the transaction list from the {@link TransactionFileManager} and filters
     * transactions to include only those matching the current year.
     * <p>
     * Transactions are displayed using their overridden {@code toString()} method.
     */
>>>>>>> 89facdc (refactor completed comments)
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

<<<<<<< HEAD
    //Filter Transaction Previous Year
=======
    //-----------------------------------------------------------------------
    /**
     * Prints a list of transactions that occurred in the previous year.
     * <p>
     * This method retrieves the current date subtracting 1 to the current year to determine the previous year.
     * It then loads the transaction list from the {@link TransactionFileManager} and filters
     * transactions to include only those matching the previous year.
     * <p>
     * Transactions are displayed using their overridden {@code toString()} method.
     */
>>>>>>> 89facdc (refactor completed comments)
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

<<<<<<< HEAD
    //Filter Transaction Vendor Name
=======
    //-----------------------------------------------------------------------
    /**
     Prints a list of transactions that match the specified vendor name.
     * <p>
     * This method prompts the user to enter a vendor name. It
     * then loads the transaction list from the {@link TransactionFileManager} and
     * filters transactions to include only those where the vendor's name contains
     * the input string. Matching transactions are displayed using their
     * overridden {@code toString()} method.
     */
>>>>>>> 89facdc (refactor completed comments)
    private static void searchVendor() {
        System.out.println("Vendor Name: ");
        String vendorName = validateString();

        for (Transaction t : TransactionFileManager.getTransactions()) {
            if (t.getVendor().toLowerCase().contains(vendorName)) {
                System.out.println(t);
            }
        }
    }


    private static String validateString() {

        String input = SCANNER.nextLine();

        while (input.trim().isBlank()) {
            System.out.println("Empty string not allowed");
            input = SCANNER.nextLine();

        }

        return input;
    }

    private static double validateDouble() {
        while (true) {
            try {
                return SCANNER.nextFloat();

            } catch (Exception e) {
                System.out.println("Please enter a number");
            } finally {
                SCANNER.nextLine();
            }
        }
    }
}
