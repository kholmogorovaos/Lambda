import functions.*;
import functions.Double;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FunctionsTest {
    @Test
    @DisplayName("Test from lesson 4.4_1 - testApplyFunctions - positive tests")
    public void testApplyFunction() {
        Function half = new Half();
        int[] input = {1, 2, 3, 4, 5};
        int[] expectedOutput = {0, 1, 1, 2, 2};
        assertArrayEquals(expectedOutput, Apply.applyFunction(input, half));

        Function sqr = new Square();
        input = new int[]{1, -2, 3, -4, 5};
        expectedOutput = new int[]{1, 4, 9, 16, 25};
        assertArrayEquals(expectedOutput, Apply.applyFunction(input, sqr));

        Function dbl = new Double();
        input = new int[]{1, -2, 3, -4, 5};
        expectedOutput = new int[]{2, -4, 6, -8, 10};
        assertArrayEquals(expectedOutput, Apply.applyFunction(input, dbl));

        Function exact = new Exact();
        input = new int[]{1, -2, 3, -4, 5};
        expectedOutput = new int[]{1, -2, 3, -4, 5};
        assertArrayEquals(expectedOutput, Apply.applyFunction(input, exact));
    }

    @Test
    @DisplayName("Test from lesson 4.4_1 - testInvalidOperation - negative tests")
    public void testInvalidOperation() {
        String[] args = {"Invalid", "1", "2", "3"};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Apply.main(args);
        assertEquals("Операция Invalid не поддерживается", outContent.toString());
    }

    @Test
    @DisplayName("Test from lesson 4.4_1 - testNoNumbers - negative tests")
    public void testNoNumbers() {
        String[] args = {"Square"};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Apply.main(args);
        assertEquals("Не переданы числа для операции", outContent.toString());
    }

    @Test
    @DisplayName("Test from lesson 4.4_1 - testNonNumeric - negative tests")
    public void testNonNumeric() {
        String[] args = {"Half", "1", "2", "abc"};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Apply.main(args);
        assertEquals("Неверное значение аргумента", outContent.toString());
    }
}
