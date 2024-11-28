package Lecture4_interfaces_abstract_classes;

public class BankAccount {
    private double balance;

    // Constructor initializes the bank account with a starting balance
    public BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    // Getter for the balance
    public double getBalance() {
        return balance;
    }

    // Setter for the balance, includes validation to prevent negative balances
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        this.balance += amount;
    }

    // Method to withdraw an amount from the account, ensuring sufficient funds
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal.");
        }
        this.balance -= amount;
    }

    // Method to print account details
    public void printAccountDetails() {
        System.out.println("Bank Account Balance: $" + balance);
    }
}
