public class PalindromeChecker {
    /**
     * Checks if the given string is a palindrome.
     * A palindrome reads the same forwards and backwards, ignoring case, spaces, and punctuation.
     *
     * @param s the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        String cleanedStr = cleaned.toString();
        String reversedStr = cleaned.reverse().toString();
        return cleanedStr.equals(reversedStr);
    }
}
