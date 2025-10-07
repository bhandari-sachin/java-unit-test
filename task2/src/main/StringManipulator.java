public class StringManipulator {

    // Concatenates two strings
    public String concatenate(String str1, String str2) {
        return str1 + str2;
    }

    // Returns length of the string
    public int getLength(String str) {
        return str.length();
    }

    // Converts string to uppercase
    public String convertToUpperCase(String str) {
        return str.toUpperCase();
    }

    // Converts string to lowercase
    public String convertToLowerCase(String str) {
        return str.toLowerCase();
    }

    // checks if the string contains a specific substring
    public boolean containsSubstring(String str, String substring) {
        return str.contains(substring);
    }
}
