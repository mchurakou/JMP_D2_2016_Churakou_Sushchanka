package com.company.sushchanka.TDD;

import com.company.sushchanka.TDD.bean.QuadraticEquation;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by alt-hanny on 24.10.2016.
 */
public class AppTest extends TestCase {
    double a, b, c;
    QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
    @Test
    public void testQuadraticEquationExists() {
        assertNotNull(quadraticEquation);
    }

    @Test (expected= InputMismatchException.class)
    public void testMain() {
        String str = "qwe";
        System.setIn(new ByteArrayInputStream(str.getBytes()));
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input");
        }
    }



}