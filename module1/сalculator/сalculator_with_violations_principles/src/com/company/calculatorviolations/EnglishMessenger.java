package com.company.calculatorviolations;

import com.company.calculatorviolations.interfaces.MessengerI;

/**
 * Created by alt-hanny on 10.07.2016.
 */
public class EnglishMessenger implements MessengerI {

    @Override
    public void inputFirstNumMessage() {
        System.out.println("Enter the first number: ");
    }

    @Override
    public void inputSecondNumMessage() {
        System.out.println("Enter the second number: ");;
    }

    @Override
    public void inputOperationMessage() {
        System.out.println("Enter the operation: ");
    }
}
