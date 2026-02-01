package com.example;

public class Calculator {

    public int calculate(int a, int b, String op) { 
        if (op == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        switch(op) {
            case "add":
                return a + b;
            case "sub":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            case "mod":
                if (b == 0) {
                    throw new ArithmeticException("Cannot calculate modulo with zero");
                }
                return a % b;
            case "pow":
                int result = 1;
                for (int i = 0; i < b; i++) {
                    result = result * a;
                }
                return result;
            default:
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }

}
