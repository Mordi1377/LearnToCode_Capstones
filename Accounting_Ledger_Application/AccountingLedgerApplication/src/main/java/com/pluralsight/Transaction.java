package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @param date        Date of when transaction took place
 * @param time        Time of when transaction took place
 * @param description Type of transaction being made
 * @param vendor      Type of vendor
 * @param amount      Amount of transaction being made
 */
public record Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {

    //-----------------------------------------------------------------------
    /**
     * Constructor of Transaction
     *
     * @param date        - Date of transaction
     * @param time        - Time of transaction
     * @param description - Description of transaction
     * @param vendor      - Vendor name
     * @param amount      - Amount of transaction
     */
    public Transaction {
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the value of the specified field from this date as an {@code LocalDate}
     *
     * @return Date of transaction
     */
    @Override
    public LocalDate date() {
        return date;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the value of the specified field from this date as an {@code LocalDate}
     *
     * @return Time of transaction
     */
    @Override
    public LocalTime time() {
        return time;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the value of the specified field from this date as a {@code String}
     *
     * @return Description of transaction
     */
    @Override
    public String description() {
        return description;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the value of the specified field from this date as a {@code String}
     *
     * @return Vendor name
     */
    @Override
    public String vendor() {
        return vendor;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the value of the specified field from this date as a {@code double}
     *
     * @return Amount of transaction
     */
    @Override
    public double amount() {
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