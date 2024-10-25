package com.stjean.operation;

public class OperationMathematique {

    public static boolean estPositif(int nombre) {
        return nombre > 0;
    }

    public static int factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative.");
        }

        if (number == 0 || number == 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }
}
