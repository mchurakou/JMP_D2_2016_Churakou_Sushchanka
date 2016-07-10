package com.company.module1.part1;

/**
 * Created by alt-hanny on 10.07.2016.
 */
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double inputX, inputY;
        double answer = 0;
        char operation;
        InputStream input =  System.in;
        Scanner sc = new Scanner(input);
        try {
            System.out.println("Enter the first number: ");
            inputX = sc.nextDouble();
            System.out.println("Enter the operation: ");
            operation = sc.next().charAt(0);
            System.out.println("Enter the second number: ");
            inputY = sc.nextDouble();
            Operations ops = new Operations();
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
            System.out.println("Result: " + answer);
        } catch (InputMismatchException e){
            System.out.println("Error: Unknown symbol");
            sc.nextLine();
        } finally {
            sc.close();
        }

    }
}
