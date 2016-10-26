package com.company.sushchanka.TDD;

import com.company.sushchanka.TDD.bean.QuadraticEquation;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        double a, b, c;
        System.out.println("Input numbers for a, b and c: ");
        try (Scanner scanner = new Scanner(System.in)) {
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            new QuadraticEquation(a,b,c).getResult();
        } catch (InputMismatchException | ArithmeticException e) {
            System.out.println("Incorrect input. Please, try again.");
        }
    }
}
