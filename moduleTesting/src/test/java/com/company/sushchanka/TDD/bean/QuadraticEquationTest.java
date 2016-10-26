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
        double D = 4;
        QuadraticEquation quadraticEquation = new QuadraticEquation();
        quadraticEquation.setD(D);
        List<Double> result = quadraticEquation.getResult();
        assertEquals(2, result.size());
        result.clear();
        D = -1;
        quadraticEquation.setD(D);
        result = quadraticEquation.getResult();
        assertEquals(0, result.size());
        result.clear();
        D = 0;
        quadraticEquation.setD(D);
        result = quadraticEquation.getResult();
        assertEquals(1, result.size());
        result.clear();
    }
}