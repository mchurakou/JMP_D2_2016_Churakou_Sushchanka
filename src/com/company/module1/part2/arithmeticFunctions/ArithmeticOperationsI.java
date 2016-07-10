package com.company.module1.part2.arithmeticFunctions;

/**
 * Arithmetic operations interface.
 *
 * Created by alt-hanny on 10.07.2016.
 */
//DRY, KISS resolved
public interface ArithmeticOperationsI {
    /**
     * @param leftValue First value of user input.
     * @param rightValue Second value of user input
     */
    public double resultOfOperation(double leftValue, double rightValue);
}
