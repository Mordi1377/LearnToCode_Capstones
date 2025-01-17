package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the storage and retrieval of transactions from a CSV file.
 * <p>
 * The {@code TransactionFileManager} class is responsible for handling the
 * reading and writing of transaction data to and from a CSV file. It provides
 * a static list of transactions that can be accessed and manipulated by other
 * parts of the application.
 */
public class TransactionFileManager {
    // The transaction list
    private static final List<Transaction> TRANSACTIONS = new ArrayList<>();
    //The CSV file where the transactions are saved
    private static final String FILE_NAME = "src/transactions.csv";

    //-----------------------------------------------------------------------
/**
 * Loads transactions from a CSV file into the {@code transactions} list.
 * <p>
 * This method reads the CSV file specified by {@code FILE_NAME} and parses
 * each line into a {@link Transaction} object. The resulting {@code Transaction}
 * objects are added to the {@code transactions} list. The list is cleared before
 * loading to ensure no duplicate entries.
 */
    public static void loadTransactionList() {
        TRANSACTIONS.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] arrTrans = line.split("\\|");
                // add transaction to in-memory list
                Transaction transaction = new Transaction(LocalDate.parse(arrTrans[0]), LocalTime.parse(arrTrans[1]), arrTrans[2], arrTrans[3], Double.parseDouble(arrTrans[4]));
                TRANSACTIONS.add(transaction);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //-----------------------------------------------------------------------
/**
 * Appends a new transaction to the CSV file.
 * <p>
 * This method takes a transaction string, formats it as a new line, and appends
 * it to the file specified by {@code FILE_NAME}. The method uses a
 * {@link BufferedWriter} in append mode to ensure the new transaction is added
 * without overwriting existing data
 */
    public static void addTransaction(Transaction transaction) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
            bw.write("\n" + transaction.toString());
            bw.close();
            TRANSACTIONS.add(transaction);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Transaction> getTransactions() {
        return TRANSACTIONS;
    }
}
