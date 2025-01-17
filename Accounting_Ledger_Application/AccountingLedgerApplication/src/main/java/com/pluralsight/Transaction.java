package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {

    /**
     * Date of when transaction took place
     */
    private LocalDate date;
    /**
     * Time of when transaction took place
     */
    private LocalTime time;
    /**
     * Type of transaction being made
     */
    private String description;
    /**
     * Type of vendor
     */
    private String vendor;
    /**
     * Amount of transaction being made
     */
    private double amount;

    //-----------------------------------------------------------------------
    /**
     * Constructor of Transaction
     * @param date - Date of transaction
     * @param time - Time of transaction
     * @param description - Description of transaction
     * @param vendor - Vendor name
     * @param amount - Amount of transaction
     */
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the value of the specified field from this date as an {@code LocalDate}
     * @return Date of transaction
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * Gets the value of the specified field from this date as an {@code LocalDate}
     * @return Time of transaction
     */
    public LocalTime getTime()
    {
        return time;
    }

    /**
     * Gets the value of the specified field from this date as a {@code String}
     * @return Description of transaction
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Gets the value of the specified field from this date as a {@code String}
     * @return Vendor name
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * Gets the value of the specified field from this date as a {@code double}
     * @return Amount of transaction
     */
    public double getAmount()
    {
        return amount;
    }

    //-----------------------------------------------------------------------
    /**
     * Returns a {@code string} representation of the object.
     */
    public String toString() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }

}