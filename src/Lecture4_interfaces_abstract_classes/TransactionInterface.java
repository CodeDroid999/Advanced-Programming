package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

/**
 * Interface for Transactions
 * Any class that defines a transaction must implement this Interface.
 * The interface enforces methods to retrieve transaction details such as amount, date, and a unique ID.
 */
public interface TransactionInterface {

    /**
     * Gets the amount of the transaction.
     * @return the transaction amount as a double
     */
    double getAmount();

    /**
     * Gets the date of the transaction.
     * @return the date of the transaction as a Calendar object
     */
    Calendar getDate();

    /**
     * Gets the unique transaction ID.
     * @return the unique transaction ID as a String
     */
    String getTransactionID();
}
