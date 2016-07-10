package com.company.module1.part2.arithmeticFunctions;

/**
 * Class for calculating of division.
 *
 * Created by alt-hanny on 10.07.2016.
 */
public class Division implements ArithmeticOperationsI {
    /**
     *
     * @param leftValue First value of user input.
     * @param rightValue Second value of user input.
     * @return Value of division.
     */
    @Override
    public double resultOfOperation(double leftValue, double rightValue) {
        return leftValue / rightValue;
    }
}
