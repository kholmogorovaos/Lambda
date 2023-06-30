import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

public class Task6Test {
    @Test
    @DisplayName("Test from lesson 2.54_6 - The string represents a positive integer ")
    public void testToIntPositive() {
        String str = "123";
        int expected = 246;
        assertEquals(expected, Task6.toInt(str) * 2);
    }

    @Test
    @DisplayName("Test from lesson 2.54_6 - The string represents a negative integer")
    public void testToIntNegative() {
        String str = "-456";
        int expected = -912;
        assertEquals(expected, Task6.toInt(str) * 2);
    }

    @Test
    @DisplayName("Test from lesson 2.54_6 - The string represents a very large number exceeding the int range")
    public void testToIntNumberFormatException2() {
        String str = "2147483648";
        Task6.toInt(str);
    }

    @Test
    @DisplayName("Test from lesson 2.54_6 - The string cannot be converted to an integer")
    public void testToIntNumberFormatException() {
        String str = "abc";
        Assertions.assertThrows(NumberFormatException.class, () -> Task6.toInt(str));
    }
}
