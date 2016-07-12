package com.company.calculator;

import com.company.calculator.constants.Constants;
import com.company.calculator.messengers.SimpleCalculatorMessenger;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Simple Calculator. Arithmetic functions: summation, substraction, multiplication, division.
 *
 * Created by alt-hanny on 10.07.2016.
 */
public class SimpleCalculator {
    public static void main (String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            double result = 0.0;
            SimpleCalculatorMessenger.inputNumberMessage();
            double firstValue = sc.nextDouble();
            SimpleCalculatorMessenger.inputOperationMessage();
            char operator = sc.next().charAt(0);
            SimpleCalculatorMessenger.inputNumberMessage();
            double secondValue = sc.nextDouble();
            for (Operation operation : Operation.values()) {
                if (operation.operator() == operator) {
                    result = operation.calculation(firstValue, secondValue);
                }
            }
            SimpleCalculatorMessenger.outputResultMessage(result);
        } catch (InputMismatchException e) {
            System.out.println(ResourceBundle.getBundle(Constants.MESSAGES_BUNDLE).getString("UNKNOWN_SYMBOL_ERROR"));
        }
    }

}
