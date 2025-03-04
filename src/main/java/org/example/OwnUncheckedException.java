package org.example;

// Define a custom unchecked exception by extending RuntimeException
class OwnUncheckedException extends RuntimeException {
    public OwnUncheckedException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance = 5000;

    // Method to withdraw money
    void withdraw(double amount) {
        if (amount > balance) {
            throw new OwnUncheckedException("Insufficient balance! Available: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // No need to catch the exception explicitly
        account.withdraw(6000); // This will throw the custom exception
    }
}
