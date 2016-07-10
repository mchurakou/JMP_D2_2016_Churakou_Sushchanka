package com.company.module1.part2.arithmeticFunctions;

/**
 * Class for calculating of substraction.
 *
 * Created by alt-hanny on 10.07.2016.
 */
public class Substraction implements ArithmeticOperationsI {
    /**
     *
     * @param leftValue First value of user input.
     * @param rightValue Second value of user input.
     * @return Result of substraction.
     */
    @Override
    public double resultOfOperation(double leftValue, double rightValue) {
        return leftValue - rightValue;
    }
}
