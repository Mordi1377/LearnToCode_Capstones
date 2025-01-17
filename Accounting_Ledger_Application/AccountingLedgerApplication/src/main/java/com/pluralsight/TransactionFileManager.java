package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileManager {
    // The transaction list
    private static final List<Transaction> TRANSACTIONS = new ArrayList<>();
    //The CSV file where the transactions are saved
    private static final String FILE_NAME = "src/transactions.csv";

    // maaike helper methods
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

    // maaike helper methods
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
