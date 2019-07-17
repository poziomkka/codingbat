public class Warmup1 {
    // Return true if the given non-negative number is a multiple of 3 or a multiple of 5.
// Use the % "mod" operator
    public boolean or35(int n) {
        if (n % 5 == 0 || n % 3 == 0) return true;
        return false;
    }

    // Given a string, take the first 2 chars and return the string with the 2 chars added
// at both the front and back, so "kitten" yields"kikittenki".
// If the string length is less than 2, use whatever chars are there.
    public String front22(String str) {
        if (str == "") return "";
        if (str.length() == 1) return str + str + str;
        return str.substring(0, 2) + str + str.substring(0, 2);
    }

    // Given a string, return true if the string starts with "hi" and false otherwise.
    public boolean startHi(String str) {
        if (str.length() < 2) return false;
        if (str.substring(0, 2).equals("hi")) return true;
        return false;
    }
}

