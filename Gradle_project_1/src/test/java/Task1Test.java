import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

public class Task1Test {
    private Task1 task1;
    private String s;
    @BeforeEach
    public void setUp() {
        task1 = new Task1();
        s = "Циклом называется многократное выполнение одних и тех же действий.";
    }
    @Test
    @DisplayName("Test for method calculate from lesson 2.54_1 - letter present")
    public void testCalculateLetterPresent() {
        int result = task1.calculate(s,"м");
        assertEquals(5, result);
    }
    @Test
    @DisplayName("Test for method calculate from lesson 2.54_1 - letter absent")
    public void testCalculateLetterNotPresent() {
        int result = task1.calculate(s,"z");
        assertEquals(-1, result);
    }
    @Test
    @DisplayName("Test for method calculate from lesson 2.54_1 - empty line")
    public void testCalculateEmptyString() {
        String s = "";
        int result = task1.calculate(s,"a");
        assertEquals(-1, result);
    }
}
