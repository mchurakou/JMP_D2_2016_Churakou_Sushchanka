package com.company.module1.part2.arithmeticFunctions;

/**
 * Class for calculating of summation.
 *
 * Created by alt-hanny on 10.07.2016.
 */
public class Summation implements ArithmeticOperationsI {
    /**
     *
     * @param leftValue First value of user input.
     * @param rightValue Second value of user input.
     * @return Result of the summation.
     */
    @Override
    public double resultOfOperation(double leftValue, double rightValue) {
        return leftValue + rightValue;
    }
}
