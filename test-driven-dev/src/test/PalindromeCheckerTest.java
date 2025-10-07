/**
 * PalindromeCheckerTest
 * Tests the PalindromeChecker class.
 * Cases tested:
 * - Simple palindromes ("radar", "level")
 * - Palindromes with spaces and punctuation ("A man, a plan, a canal: Panama")
 * - Non-palindromes ("hello", "world")
 * - Edge cases (empty string, single character)
 *
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {
    private final PalindromeChecker checker = new PalindromeChecker();

    @Test
    @DisplayName("Test simple palindromes")
    void shouldReturnTrueForSimplePalindromes() {
        assertTrue(checker.isPalindrome("radar"));
        assertTrue(checker.isPalindrome("level"));
        assertTrue(checker.isPalindrome("deified"));
    }

    @Test
    @DisplayName("Test palindromes ignoring spaces and punctuation")
    void shouldReturnTrueForPalindromesWithSpacesAndPunctuation() {
        assertTrue(checker.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(checker.isPalindrome("No 'x' in Nixon"));
    }

    @Test
    @DisplayName("Test non-palindromes")
    void shouldReturnFalseForNonPalindromes() {
        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("world"));
        assertFalse(checker.isPalindrome("Java"));
    }

    @Test
    @DisplayName("Test edge cases")
    void shouldHandleEdgeCases() {
        assertTrue(checker.isPalindrome("")); // Empty string
        assertTrue(checker.isPalindrome("a")); // Single character
        assertTrue(checker.isPalindrome(" ")); // Single space
        assertTrue(checker.isPalindrome("!!!")); // Only punctuation
    }
}
