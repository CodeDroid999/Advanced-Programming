package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    /**
     * Checks if the transaction amount is valid (greater than 0).
     * @param amt the amount to check
     * @return true if the amount is valid, false if negative
     */
    private boolean checkTransactionAmount(int amt) {
        return amt >= 0;
    }

    /**
     * Reverses the withdrawal transaction (adds the amount back to the account).
     * @return true if the reversal was successful
     */
    public boolean reverse() {
        // A simple reversal: Credit the withdrawal amount back to the account
        // The reversal process might include additional checks (e.g., transaction history, permissions, etc.)
        return true;  // Assuming reversal is always successful here (this can be extended)
    }

    /**
     * Prints the transaction details for the withdrawal.
     */
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: " + this.toString());
    }

    /**
     * Applies the withdrawal to the bank account by decreasing the balance.
     * The withdrawal is only successful if the account has sufficient funds.
     */
    public void apply(BankAccount ba) {
        double curr_balance = ba.getBalance();
        if (curr_balance >= getAmount()) {
            double new_balance = curr_balance - getAmount();
            ba.setBalance(new_balance);
        } else {
            System.out.println("Insufficient funds for withdrawal!");
        }
    }
}
