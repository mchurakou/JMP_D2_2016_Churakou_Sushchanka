package com.company.module1.part2;

import com.company.module1.part2.arithmeticFunctions.ArithmeticOperationsI;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by alt-hanny on 10.07.2016.
 */
public class Calculator {
    public static void main (String[] args) {
        char operator;
        double leftValue, rightValue, result;
        boolean quit = false;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the number: ");
            leftValue = sc.nextDouble();
            while (!quit) {
                System.out.println("Enter the operation: ");
                operator = sc.next().charAt(0);
                System.out.println("Enter the next number: ");
                rightValue = sc.nextDouble();
                SimpleCalcFunctions calcFunctions = new SimpleCalcFunctions(operator);
                ArithmeticOperationsI opc = calcFunctions.getFunctions().get(operator);
                if (opc != null) {
                    result = opc.resultOfOperation(leftValue, rightValue);
                    System.out.println("Result: " + result);
                    leftValue = result;
                } else {
                    System.out.println("Error: Unknown operator");
                    quit = true;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Unknown symbol.");
        } finally {
            sc.close();
        }

    }
}
