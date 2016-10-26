package com.company.sushchanka.TDD.bean;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alt-hanny on 24.10.2016.
 */
public class QuadraticEquationTest {
    double a, b, c;

    @Test
    public void testDiscriminant() {
        a = 5; b = 6; c = 4;
        double d = b*b - 4 * a * c;
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        double discriminant = quadraticEquation.getD();
        assertNotNull(discriminant);
        assertEquals(discriminant, d, 0);
    }

    @Test
    public void testResult() {

        QuadraticEquation quadraticEquation = new QuadraticEquation(1, 4 , 3);

        List<Double> result = quadraticEquation.getResult();
        assertEquals(2, result.size());
        result.clear();
        QuadraticEquation quadraticEquation1 = new QuadraticEquation(1, 0 , 3);
        result = quadraticEquation1.getResult();
        assertEquals(0, result.size());
        result.clear();
        QuadraticEquation quadraticEquation2 = new QuadraticEquation(1, 2, 1);
        result = quadraticEquation2.getResult();
        assertEquals(1, result.size());
        result.clear();
        QuadraticEquation lineEquation = new QuadraticEquation(0, 4, 2);
        result = lineEquation.getResult();
        assertEquals(1, result.size());
        assertEquals(-0.5, result.get(0), 0);
        result.clear();
    }
}