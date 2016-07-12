package com.company.calculatorviolations;

import com.company.calculatorviolations.interfaces.OperationsI;

/**
 * Created by alt-hanny on 10.07.2016.
 */
public class BaseOperations implements OperationsI {

    //DRY
    public static double summation (double x, double y) {
        double result = x + y;
        return result;
    }

    public static double subtraction (double x, double y) {
        double result = x - y;
        return result;
    }

    public static double multiplication (double x, double y) {
        double result = x * y;
        return result;
    }

    public static double division (double x, double y) {
        double result = x / y;
        return result;
    }

    //KISS
    public static void showMessage(double result) {
        System.out.println("Result: " + result);
    }
}
