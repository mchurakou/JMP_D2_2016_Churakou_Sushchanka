package com.company.calculator.messengers;

import com.company.calculator.constants.Constants;

import java.util.ResourceBundle;

/**
 * Simple Calculator messenger.
 *
 * Created by alt-hanny on 10.07.2016.
 */
public class SimpleCalculatorMessenger {

    private static ResourceBundle messagesResourceBundle = ResourceBundle.getBundle(Constants.MESSAGES_BUNDLE);
    /**
     * Prints message for the input next number.
     */
    public static void inputNumberMessage() {
        System.out.println(messagesResourceBundle.getString("INPUT_NUMBER_MESSAGE"));
    }

    /**
     * Prints message for the input next operation.
     */
    public static void inputOperationMessage() {
        System.out.println(messagesResourceBundle.getString("INPUT_OPERATOR_MESSAGE"));
    }

    /**
     * Prints the calculation result.
     *
     * @param result Result of calculation.
     */
    public static void outputResultMessage(double result) {
        System.out.println(messagesResourceBundle.getString("RESULT_MESSAGE") + result);
    }

}
