package com.company.calculator;

import com.company.calculator.constants.Constants;

/**
 * Created by Hanna_Sushchanka on 7/11/2016.
 */
public enum Operation {
    /**
     * Return the summation result.
     */
    PLUS(Constants.SUMMATION_KEY) {
        double calculation(double firstValue, double secondValue) {
            return firstValue + secondValue;
        }
    },
    /**
     * Return the substraction result.
     */
    MINUS(Constants.SUBSTRACTION_KEY) {
        double calculation(double firstValue, double secondValue) {
            return firstValue - secondValue;
        }
    },
    /**
     * Return the multiplication result.
     */
    MULTIPLICATION(Constants.MULTIPLICATION_KEY) {
        double calculation(double firstValue, double secondValue) {
            return firstValue * secondValue;
        }
    },
    /**
     * Return the divide result.
     */
    DIVIDE(Constants.DIVISION_KEY) {
        double calculation(double firstValue, double secondValue) {
            return firstValue / secondValue;
        }
    };
    /**
     * Input operator.
     */
    private final Character operator;

    /**
     * Return operator.
     * @return Operator of the calculation.
     */
    public Character operator() {
        return operator;
    }

    /**
     * Constructor with parameter.
     * @param operator Operator.
     */
    Operation(Character operator) {
        this.operator = operator;
    }

    /**
     * @param firstValue The first input number.
     * @param secondValue The second input number.
     */
    abstract double calculation(double firstValue, double secondValue);
}
