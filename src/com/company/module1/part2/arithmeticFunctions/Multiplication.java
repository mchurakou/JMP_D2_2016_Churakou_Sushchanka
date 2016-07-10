package com.company.module1.part2.arithmeticFunctions;

/**
 * Created by alt-hanny on 10.07.2016.
 */
public class Multiplication implements ArithmeticOperationsI {
    @Override
    public double resultOfOperation(double leftValue, double rightValue) {
        return leftValue * rightValue;
    }
}
