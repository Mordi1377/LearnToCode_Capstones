package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileManager {
    public static List<Transaction> transactions = new ArrayList<>();
    //The CSV file where the transactions are saved
    private static final String FILE_NAME = "src/transactions.csv";

    public TransactionFileManager() {

    }
    // maaike helper methods
    public static void loadTransactionList() {
        transactions.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] arrTrans = line.split("\\|");
                Transaction transaction = new Transaction(LocalDate.parse(arrTrans[0]), LocalTime.parse(arrTrans[1]), arrTrans[2], arrTrans[3], Double.parseDouble(arrTrans[4]));
                transactions.add(transaction);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // maaike helper methods
    public static void addTransactionToFile(String transactionStr) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
            bw.write("\n" + transactionStr);
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
