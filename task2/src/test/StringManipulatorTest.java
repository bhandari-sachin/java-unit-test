import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {
    StringManipulator manipulator = new StringManipulator();

    @Test
    void concatenate() {
        assertEquals("HelloWorld", manipulator.concatenate("Hello", "World"));
        assertEquals("JavaJUnit", manipulator.concatenate("Java", "JUnit"));
        assertEquals("12345", manipulator.concatenate("123", "45"));
    }

    @Test
    void getLength() {
        assertEquals(5, manipulator.getLength("Hello"));
        assertEquals(0, manipulator.getLength(""));
        assertEquals(10, manipulator.getLength("1234567890"));
    }

    @Test
    void convertToUpperCase() {
        assertEquals("HELLO", manipulator.convertToUpperCase("hello"));
        assertEquals("JAVA", manipulator.convertToUpperCase("Java"));
        assertEquals("123ABC", manipulator.convertToUpperCase("123abc"));
    }

    @Test
    void convertToLowerCase() {
        assertEquals("hello", manipulator.convertToLowerCase("HELLO"));
        assertEquals("java", manipulator.convertToLowerCase("Java"));
        assertEquals("123abc", manipulator.convertToLowerCase("123ABC"));
    }

    @Test
    void containsSubstring() {
        assertTrue(manipulator.containsSubstring("HelloWorld", "World"));
        assertFalse(manipulator.containsSubstring("HelloWorld", "world"));
    }
}