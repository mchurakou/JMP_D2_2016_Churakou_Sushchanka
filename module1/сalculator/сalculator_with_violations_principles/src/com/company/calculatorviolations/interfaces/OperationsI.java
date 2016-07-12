package com.company.calculatorviolations.interfaces;

/**
 * Arithmetic operations interface.
 *
 * Created by alt-hanny on 10.07.2016.
 */
//KISS
public interface OperationsI {
    /**
     * Calculates the sum of the two numbers.
     *
     * @param x First value of user input.
     * @param y Second value of user input.
     * @return Sum of the two numbers.
     */
    static double summation(double x, double y) {
        return x+y;
    }

    /**
     *
     * @param x First value of user input.
     * @param y Second value of user input.
     * @return Subtraction of two numbers.
     */
    static double subtraction(double x, double y) {
        return x-y;
    }

    /**
     *
     * @param x First value of user input.
     * @param y Second value of user input.
     * @return Multiplication of two numbers.
     */
    static double multiplication(double x, double y) {
        return x*y;
    }

    /**
     *
     * @param x First value of user input.
     * @param y Second value of user input.
     * @return Division of two numbers.
     */
    static double division(double x, double y) {
        return x/y;
    }

    /**
     * Shows the result of calculation.
     * @param result Result of the calculation.
     */
    static void showMessage (double result) {
        System.out.println("Result: " + result);
    }; // KISS
}
