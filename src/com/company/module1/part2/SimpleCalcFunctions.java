package com.company.module1.part2;

import com.company.module1.part2.arithmeticFunctions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alt-hanny on 10.07.2016.
 */
public class SimpleCalcFunctions {
    public Map<Character, ArithmeticOperationsI> getFunctions() {
        return functions;
    }

    private Map<Character, ArithmeticOperationsI> functions = new HashMap<Character, ArithmeticOperationsI>();

    public SimpleCalcFunctions(Character operator) {
        functions.put('+', new Summation());
        functions.put('-', new Substraction());
        functions.put('*', new Multiplication());
        functions.put('/', new Division());
    }
}
