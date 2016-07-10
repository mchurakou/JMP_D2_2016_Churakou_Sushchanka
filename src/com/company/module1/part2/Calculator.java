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
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the first number: ");
            leftValue = sc.nextDouble();
            System.out.println("Enter the operation: ");
            operator = sc.next().charAt(0);
            System.out.println("Enter the second number: ");
            rightValue = sc.nextDouble();
            SimpleCalcFunctions calcFunctions = new SimpleCalcFunctions(operator);
            ArithmeticOperationsI opc = calcFunctions.getFunctions().get(operator);
            if (opc != null) {
                result = opc.resultOfOperation(leftValue, rightValue);
                System.out.println("Result: " + result);
            } else {
                System.out.println("Error: Unknown operator");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Unknown symbol");
            sc.nextLine();
        }
        sc.close();
    }
}
