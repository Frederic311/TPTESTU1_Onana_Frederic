import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.stjean.operation.OperationMathematique; // Replace with your package name

public class TestOperationMathematique {

    @Test
    public void testEstPositif_PositiveNumber() {
        int number = 5;
        boolean result = OperationMathematique.estPositif(number);
        Assertions.assertTrue(result, "estPositif should return true for positive numbers");
    }

    @Test
    public void testEstPositif_Zero() {
        int number = 0;
        boolean result = OperationMathematique.estPositif(number);
        Assertions.assertFalse(result, "estPositif should return false for zero");
    }

    @Test
    public void testEstPositif_NegativeNumber() {
        int number = -3;
        boolean result = OperationMathematique.estPositif(number);
        Assertions.assertFalse(result, "estPositif should return false for negative numbers");
    }

    @Test
    public void testFactorial_Zero() {
        int number = 0;
        int expected = 1;
        int result = OperationMathematique.factorial(number);
        Assertions.assertEquals(expected, result, "Factorial of zero should be 1");
    }

    @Test
    public void testFactorial_One() {
        int number = 1;
        int expected = 1;
        int result = OperationMathematique.factorial(number);
        Assertions.assertEquals(expected, result, "Factorial of one should be 1");
    }

    @Test
    public void testFactorial_PositiveNumber() {
        int number = 5;
        int expected = 120;
        int result = OperationMathematique.factorial(number);
        Assertions.assertEquals(expected, result, "Factorial of a positive number should be calculated correctly");
    }
}