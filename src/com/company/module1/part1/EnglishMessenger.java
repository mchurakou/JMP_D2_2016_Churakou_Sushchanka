package com.company.module1.part1;

import com.company.module1.part1.interfaces.MessengerI;

import java.util.Locale;

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
