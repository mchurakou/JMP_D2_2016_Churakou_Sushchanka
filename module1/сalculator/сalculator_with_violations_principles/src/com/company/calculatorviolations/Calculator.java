package com.company.calculatorviolations;

/**
 * Simple Calculator. Arithmetic functions: summation, substraction, multiplication, division.
 *
 * Created by alt-hanny on 10.07.2016.
 */
import com.company.calculatorviolations.constants.Constants;
import com.company.calculatorviolations.interfaces.MessengerI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        //SOLID (Simple responsibility principle)
        double inputX, inputY;
        double answer = 0;
        char operation;
        MessengerI messenger = new FrenchMessenger();
        try (Scanner sc = new Scanner(System.in)){ //try with resource
            messenger.inputFirstNumMessage();
            inputX = sc.nextDouble();
            messenger.inputOperationMessage();
            operation = sc.next().charAt(0);
            messenger.inputSecondNumMessage();
            inputY = sc.nextDouble();
            //DRY
            switch (operation) {
                case '+':
                    answer = BaseOperations.summation(inputX, inputY);
                    break;
                case '-':
                    answer = BaseOperations.subtraction(inputX, inputY);
                    break;
                case '*':
                    answer = BaseOperations.multiplication(inputX, inputY);
                    break;
                case '/':
                    answer = BaseOperations.division(inputX, inputY);
                    break;
                default:
                    System.out.println(Constants.UNKNOWN_OPERATION_ERROR);
            }
            BaseOperations.showMessage(answer);
        } catch (InputMismatchException e){
            System.out.println(Constants.UNKNOWN_SYMBOL_ERROR);
        }
    }
}