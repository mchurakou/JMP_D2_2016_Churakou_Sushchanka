package com.company.module1.part2;

import com.company.module1.part2.arithmeticFunctions.ArithmeticOperationsI;
import com.company.module1.part2.constants.Constants;

import java.util.InputMismatchException;
import java.util.Map;

/**
 * Implementation of calculation.
 *
 * Created by alt-hanny on 10.07.2016.
 */
public class SimpleCalculatorImpl implements CalculatorI {
    /** Input user. Operator. */
    private Character operator;
    /** Values for the calculation. User input. Temporary result.*/
    private double leftValue, rightValue, result, tempResult;
    /** Boolean flag for the calculation stop. */
    private boolean quitFlag;
    /** Map of user input values. */
    private Map<String, Object> userInput;

    /** Default constructor. */
    public SimpleCalculatorImpl() {
    }

    /**
     * Constructot with map of user inputs.
     * @param userInput Map of user input values.
     */
    public SimpleCalculatorImpl(Map<String, Object> userInput) {
        this.userInput = userInput;
        initialization();
    }

    /**
     * Calculates the result.
     *
     * @param operator User input operator.
     * @return Result of calculation.
     */
    @Override
    public double calculation(Character operator) {
        SimpleCalcFunctions calcFunctions = new SimpleCalcFunctions(operator);
        ArithmeticOperationsI opc = calcFunctions.getBaseFunction(operator);
        if (opc != null) {
            result =  opc.resultOfOperation(leftValue, rightValue);
            saveCalcResults(userInput);

        } else {
            stopCalculation(quitFlag);
            throw new InputMismatchException();
        }
        return result;
    }

    /**
     * Sets init values for calculation.
     */
    private void initialization() {
        setLeftValue(leftValue);
        setRightValue(rightValue);
        setOperator(operator);
        setQuitFlag(quitFlag);
        setResult(result);
        setTempResult(tempResult);
        saveCalcResults(userInput);
    }

    /** Sets flag for the stopping of calculation. */
    private boolean stopCalculation (boolean quitFlag) {
        quitFlag = Boolean.TRUE;
        return quitFlag;
    }

    /** Saves of the temporary results for continuing calculations. */
    private void saveCalcResults (Map<String, Object> userInput) {
        userInput.put(Constants.RESULT_VALUE_KEY, tempResult);
        userInput.put(Constants.USER_INPUT_LEFT_VALUE_KEY, tempResult);
    }

    /**
     * Sets operator.
     * @param operator
     */
    public void setOperator(Character operator) {
        this.operator = (Character) userInput.get(Constants.USER_INPUT_OPERATOR_KEY);
    }

    /**
     * Sets of the first value.
     * @param leftValue
     */
    public void setLeftValue(double leftValue) {
        this.leftValue = (Double) userInput.get(Constants.USER_INPUT_LEFT_VALUE_KEY);
    }

    /**
     * Sets of the next value.
     * @param rightValue
     */
    public void setRightValue(double rightValue) {
        this.rightValue = (Double) userInput.get(Constants.USER_INPUT_RIGHT_VALUE_KEY);
    }

    /**
     * Sets the result value in user input map for the continue calculation.
     * @param result
     */
    public void setResult(double result) {
        this.result = (Double) userInput.get(Constants.RESULT_VALUE_KEY);
    }

    /**
     * Sets tempresult instead the first value of user input for the continue calculation.
     * @param tempResult
     */
    public void setTempResult(double tempResult) {
        this.tempResult = calculation(operator);
    }

    /**
     * Sets value for the quit flag.
     * @param quitFlag
     */
    public void setQuitFlag(boolean quitFlag) {
        this.quitFlag = (Boolean) userInput.get(Constants.QUIT_FLAG_KEY);
    }
}
