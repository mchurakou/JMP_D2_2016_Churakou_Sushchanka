package com.company.module1.part2;

import com.company.module1.part2.constants.Constants;
import com.company.module1.part2.messangers.MessengerI;
import com.company.module1.part2.messangers.SimpleCalculatorMessenger;

import java.util.*;

/**
 * Simple Calculator. Arithmetic functions: summation, substraction, multiplication, division.
 *
 * Created by alt-hanny on 10.07.2016.
 */
public class SimpleCalculator {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        MessengerI messenger = new SimpleCalculatorMessenger();
        Map<String, Object> userInput = new HashMap<String, Object>();
        try {
            messenger.welcomeMessage();
            init(userInput);
            userInput.put(Constants.USER_INPUT_LEFT_VALUE_KEY, sc.nextDouble());
            while (!(Boolean)(userInput.get(Constants.QUIT_FLAG_KEY))) {
                messenger.inputOperationMessage();
                userInput.put(Constants.USER_INPUT_OPERATOR_KEY, sc.next().charAt(0));
                messenger.inputNumberMessage();
                userInput.put(Constants.USER_INPUT_RIGHT_VALUE_KEY, sc.nextDouble());
                CalculatorI calculator = new SimpleCalculatorImpl(userInput);
                messenger.outputResultMessage((double)(userInput.get(Constants.RESULT_VALUE_KEY)));
            }
        } catch (InputMismatchException e) {
            System.out.println(Constants.UNKNOWN_SYMBOL_ERROR);
        } finally {
            sc.close();
        }
    }

    /**
     * Initialization before the calculation.
     * @param input Maps for the values of user input.
     * @return Return map for saving user input.
     */
    private static Map<String, Object> init(Map<String, Object> input) {
        input.put(Constants.USER_INPUT_OPERATOR_KEY, null);
        input.put(Constants.USER_INPUT_LEFT_VALUE_KEY, 0.0);
        input.put(Constants.USER_INPUT_RIGHT_VALUE_KEY, 0.0);
        input.put(Constants.QUIT_FLAG_KEY, Boolean.FALSE);
        input.put(Constants.RESULT_VALUE_KEY, 0.0);
        return input;
    }
}
