package com.company.module1.part1;

import com.company.module1.part1.interfaces.OperationsI;

/**
 * Created by alt-hanny on 10.07.2016.
 */
public class BaseOperations implements OperationsI {
    //DRY
    public double summation (double x, double y) {
        double result = x + y;
        return result;
    }

    public double subtraction (double x, double y) {
        double result = x - y;
        return result;
    }

    public double multiplication (double x, double y) {
        double result = x * y;
        return result;
    }

    public double division (double x, double y) {
        double result = x / y;
        return result;
    }

    //KISS
    @Override
    public void showMessage(double result) {
        System.out.println("Result: " + result);
    }
}
