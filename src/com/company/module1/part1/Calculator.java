package com.company.module1.part1;

/**
 * Created by alt-hanny on 10.07.2016.
 */
import com.company.module1.part1.interfaces.MessengerI;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        //SOLID (Simple responsibility principle)
        double inputX, inputY;
        double answer = 0;
        char operation;
        InputStream input =  System.in;
        Scanner sc = new Scanner(input);
        MessengerI messenger = new FrenchMessenger();
        try {
            messenger.inputFirstNumMessage();
            inputX = sc.nextDouble();
            messenger.inputOperationMessage();
            operation = sc.next().charAt(0);
            messenger.inputSecondNumMessage();
            inputY = sc.nextDouble();
            BaseOperations ops = new BaseOperations() {
            };
            //DRY
            switch (operation) {
                case '+':
                    answer = ops.summation(inputX, inputY);
                    break;
                case '-':
                    answer = ops.subtraction(inputX, inputY);
                    break;
                case '*':
                    answer = ops.multiplication(inputX, inputY);
                    break;
                case '/':
                    answer = ops.division(inputX, inputY);
                    break;
                default:
                    System.out.println("Error: Unknown operation");
            }
            ops.showMessage(answer);
        } catch (InputMismatchException e){
            System.out.println("Error: Unknown symbol");
            sc.nextLine();
        } finally {
            sc.close();
        }

    }
}
