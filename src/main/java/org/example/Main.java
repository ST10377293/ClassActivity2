package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final double SMALL_COST_PER_MONTH = 2050.00;
    public static final double MEDIUM_COST_PER_MONTH = 2950.00;
    public static final double LARGE_COST_PER_MONTH = 4250.00;

    public static final double ADMIN_FEE = 55.99;
    public static final double VAT_RATE = 0.15;
    public static final double DELIVERY_FEE = 499.00;

    public static void main(String[] args) {
        Random random = new Random();

        int randomNumber = random.nextInt(50);

        if (randomNumber % 5 == 0) {
            int cube = (int) Math.pow(randomNumber, 3);

            double squareRoot = Math.sqrt(cube);

            System.out.println("Square root: " + squareRoot);
            System.out.println("Cube: " + cube);
        } else {
            System.out.println("Error: The generated number " + randomNumber + " is not a multiple of 5.");
        }

        // Declare variables
        int accountNumber, termOfHire;
        char generatorCode;
        String delivery;

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter account number: ");
        accountNumber = scanner.nextInt();
        System.out.print("Enter generator code type (S/M/L): ");
        generatorCode = scanner.next().toUpperCase().charAt(0);
        System.out.print("Enter term of hire (1-24 months): ");
        termOfHire = scanner.nextInt();
        System.out.print("Delivery required? (Y/N): ");
        delivery = scanner.next().toUpperCase();

        // Validate term of hire
        if (termOfHire < 1 || termOfHire > 24) {
            System.out.println("Error: Term of hire must be between 1 and 24 months.");
        } else {
            // Calculate cost based on generator code and term of hire
            double costPerMonth = 0;
            switch (generatorCode) {
                case 'S':
                    costPerMonth = SMALL_COST_PER_MONTH;
                    break;
                case 'M':
                    costPerMonth = MEDIUM_COST_PER_MONTH;
                    break;
                case 'L':
                    costPerMonth = LARGE_COST_PER_MONTH;
                    break;
                default:
                    System.out.println("Error: Invalid generator code.");
                    return;
            }
            double totalCost = costPerMonth * termOfHire;

            // Calculate VAT amount
            double vatAmount = totalCost * VAT_RATE;

            // Calculate booking fee (including admin fee)
            double bookingFee = totalCost + ADMIN_FEE + vatAmount;

            // Calculate total amount (including delivery fee if requested)
            if (delivery.equals("Y")) {
                bookingFee += DELIVERY_FEE;
            }

            // Display invoice
            System.out.println();
            System.out.println("Invoice:");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Generator Code: " + generatorCode);
            System.out.println("Term of Hire: " + termOfHire + " months");
            System.out.printf("Total Cost: R%.2f%n", totalCost);
            System.out.printf("VAT Amount: R%.2f%n", vatAmount);
            System.out.printf("Booking Fee: R%.2f%n", bookingFee);
        }

//        // Handle invalid term of hire
//        else{
//            System.out.println("Error: Term of hire is invalid.");
//        }
    }
}