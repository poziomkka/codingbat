public class Warmup1 {
    // Return true if the given non-negative number is a multiple of 3 or a multiple of 5.
// Use the % "mod" operator
    public static boolean or35(int n) {
        return (n % 5 == 0 || n % 3 == 0);
    }

    // Given a string, take the first 2 chars and return the string with the 2 chars added
// at both the front and back, so "kitten" yields"kikittenki".
// If the string length is less than 2, use whatever chars are there.
    public static String front22(String str) {
        if (str.equals("")) return "";
        if (str.length() == 1) return str + str + str;
        return str.substring(0, 2) + str + str.substring(0, 2);
    }

    // Given a string, return true if the string starts with "hi" and false otherwise.
    public static boolean startHi(String str) {
        if (str.length() < 2) return false;
        return (str.substring(0, 2).equals("hi"));
    }
}

