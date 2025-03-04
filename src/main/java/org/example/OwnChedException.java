package org.example;

public class OwnChedException extends Exception {
    // Constructor to initialize the exception message
    public OwnChedException(String message) {
        super(message);
    }
}

class User {
    // Method that throws a custom exception if age is invalid
    static void validateAge(int age) throws OwnChedException {
        if (age < 18) {
            throw new OwnChedException("Age must be 18 or above.");
        } else {
            System.out.println("Age is valid.");
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(16); // This will throw the custom exception
        } catch (OwnChedException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
