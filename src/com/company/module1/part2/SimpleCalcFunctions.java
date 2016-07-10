package com.company.module1.part2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alt-hanny on 10.07.2016.
 */
public class SimpleCalcFunctions {
    public Map<Character, ArithmeticOperations> getFunctions() {
        return functions;
    }

    private Map<Character, ArithmeticOperations> functions = new HashMap<Character, ArithmeticOperations>();

    public SimpleCalcFunctions(Character operator) {
        functions.put('+', new Summation());
        functions.put('-', new Substraction());
        functions.put('*', new Multiplication());
        functions.put('/', new Division());
    }
}
