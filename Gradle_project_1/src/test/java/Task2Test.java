import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

public class Task2Test {

    @Test
    @DisplayName("Test from lesson 2.54_2 - ValidFilePathWithSlash")
    public void testValidFilePathWithSlash() {
        String filePath = "/Users/user/Documents/test.txt";
        String expectedResult = "Path: /Users/user/Documents/\nFile Name: test.txt";
        assertEquals(expectedResult, Task2.getFilePathAndName(filePath));
    }
@Test
public void testInvalidFilePath() {
    String filePath = "/Users/user/Documents/";
    String expectedResult = "Invalid path to file entered.";
    assertEquals(expectedResult, Task2.getFilePathAndName(filePath));
}
    @Test
    @DisplayName("Test from lesson 2.54_2 - ValidFilePathWithBackslash")
    public void testValidFilePathWithBackslash() {
        String filePath = "C:\\Users\\user\\Documents\\test.txt";
        String expectedResult = "Path: C:\\Users\\user\\Documents\\\nFile Name: test.txt";
        assertEquals(expectedResult, Task2.getFilePathAndName(filePath));
    }

    @Test
    @DisplayName("Test from lesson 2.54_2 - InvalidFilePathWithoutFileName")
    public void testInvalidFilePathWithoutFileName() {
        String filePath = "/Users/user/Documents/";
        String expectedResult = "Invalid path to file entered.";
        assertEquals(expectedResult, Task2.getFilePathAndName(filePath));
    }

    @Test
    @DisplayName("Test from lesson 2.54_2 - InvalidFilePathWithoutFileNameBackslash")
    public void testInvalidFilePathWithoutFileNameBackslash() {
        String filePath = "C:\\Users\\user\\Documents\\";
        String expectedResult = "Invalid path to file entered.";
        assertEquals(expectedResult, Task2.getFilePathAndName(filePath));
    }
    @Test
    @DisplayName("Test from lesson 2.54_2 - ShortFilePathWithSlash")
    public void testShortFilePathWithSlash() {
        String filePath = "test.txt";
        String expectedResult = "Path: \nFile Name: test.txt";
        assertEquals(expectedResult, Task2.getFilePathAndName(filePath));
    }

    @Test
    @DisplayName("Test from lesson 2.54_2 - ShortFilePathWithBackslash")
    public void testShortFilePathWithBackslash() {
        String filePath = "test.txt";
        String expectedResult = "Path: \nFile Name: test.txt";
        assertEquals(expectedResult, Task2.getFilePathAndName(filePath));
    }
}
