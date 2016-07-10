package com.company.module1.part2.messangers;

/**
 * Simple Calculator messenger.
 *
 * Created by alt-hanny on 10.07.2016.
 */
public class SimpleCalculatorMessenger implements MessengerI {
    /**
     * Prints the welcome message for user.
     */
    @Override
    public void welcomeMessage() {
        System.out.println("Welcome! Enter the first number: ");
    }

    /**
     * Prints message for the input next number.
     */
    @Override
    public void inputNumberMessage() {
        System.out.println("Enter the next number: ");
    }

    /**
     * Prints message for the input next operation.
     */
    @Override
    public void inputOperationMessage() {
        System.out.println("Enter the operation: ");
    }

    /**
     * Prints the calculation result.
     *
     * @param result Result of calculation.
     */
    @Override
    public void outputResultMessage(double result) {
        System.out.println("Result: " + result);
    }
}
