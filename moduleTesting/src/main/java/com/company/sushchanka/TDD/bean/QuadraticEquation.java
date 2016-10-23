package com.company.sushchanka.TDD.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alt-hanny on 24.10.2016.
 */
public class QuadraticEquation {
    double a, b, c;
    double D;
    private List<Double> roots = new ArrayList<>();

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setD(double d) {
        D = d;
    }

    public double getD() {
        D = b*b - 4 * a * c;
        return D;
    }


    public List<Double> getResult() {
        if (D > 0) {
            hasTwoRoots();
        }
        else if (D == 0) {
            hasOneRoot();
        }
        else {
            System.out.println("The equation has no real roots!");
        }
        return roots;
    }

    private List<Double> hasOneRoot() {
        double x;
        x = -b / (2 * a);
        roots.add(x);
        System.out.println("The equation has a single root: x = " + x);
        return roots;
    }

    private List<Double> hasTwoRoots() {
        double x1, x2;
        x1 = (-b - Math.sqrt(D)) / (2 * a);
        roots.add(0, x1);
        x2 = (-b + Math.sqrt(D)) / (2 * a);
        roots.add(1, x2);
        System.out.println("The roots of the equation: x1 = " + x1 + ", x2 = " + x2);
        return roots;
    }
}