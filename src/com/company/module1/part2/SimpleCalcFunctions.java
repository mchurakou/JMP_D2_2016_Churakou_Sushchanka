package com.company.module1.part2;

import com.company.module1.part2.arithmeticFunctions.*;
import com.company.module1.part2.constants.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * The base calculation functions of the simple calculator.
 *
 * Created by alt-hanny on 10.07.2016.
 */
public class SimpleCalcFunctions {
    /** User input. Operator. */
    private Character operator;
    /** Map of base functions.*/
    private Map<Character, ArithmeticOperationsI> functions = new HashMap<Character, ArithmeticOperationsI>();
    /** Default constructor. */
    public SimpleCalcFunctions() {
    }

    /**
     * Constructor.
     * @param operator User input operator.
     */
    public SimpleCalcFunctions(Character operator) {
        initBaseFunctions();
        this.operator = operator;
    }

    /**
     * Initialization of base functions.
     */
    private void initBaseFunctions () {
        functions.put(Constants.SUMMATION_CHAR_KEY, new Summation());
        functions.put(Constants.SUBSTRACTION_CHAR_KEY, new Substraction());
        functions.put(Constants.MULTIPLICATION_CHAR_KEY, new Multiplication());
        functions.put(Constants.DIVISION_CHAR_KEY, new Division());
    }

    /**
     * Returns the arithmetic operations.
     * @param operator User input operator.
     * @return Object of the arithmetic operation.
     */
    public ArithmeticOperationsI getBaseFunction(Character operator) {
        return functions.get(operator);
    }

}
