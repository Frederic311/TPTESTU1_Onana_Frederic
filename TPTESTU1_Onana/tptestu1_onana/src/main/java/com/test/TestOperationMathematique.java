package com.test;

import org.junit.Test;
import static org.junit.Assert.*;

import com.stjean.operation.OperationMathematique;

public class TestOperationMathematique {

    @Test
    public void testEstPositif_PositiveNumber() {
        int number = 5;
        boolean result = OperationMathematique.estPositif(number);
        assertTrue("estPositif should return true for positive numbers", result);
    }

    @Test
    public void testEstPositif_Zero() {
        int number = 0;
        boolean result = OperationMathematique.estPositif(number);
        assertFalse("estPositif should return false for zero", result);
    }

    @Test
    public void testEstPositif_NegativeNumber() {
        int number = -3;
        boolean result = OperationMathematique.estPositif(number);
        assertFalse("estPositif should return false for negative numbers", result);
    }

    @Test
    public void testFactorial_Zero() {
        int number = 0;
        int expected = 1;
        int result = OperationMathematique.factorial(number);
        assertEquals("Factorial of zero should be 1", expected, result);
    }

    @Test
    public void testFactorial_One() {
        int number = 1;
        int expected = 1;
        int result = OperationMathematique.factorial(number);
        assertEquals("Factorial of one should be 1", expected, result);
    }

    @Test
    public void testFactorial_PositiveNumber() {
        int number = 5;
        int expected = 120;
        int result = OperationMathematique.factorial(number);
        assertEquals("Factorial of a positive number should be calculated correctly", expected, result);
    }
}