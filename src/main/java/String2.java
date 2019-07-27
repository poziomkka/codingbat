import java.util.ArrayList;
import java.util.List;

public class String2 {

    // Given a string and an int n, return a string made of n repetitions of the last n characters of the string. You
    // may assume that n is between 0 and the length of the string, inclusive.
    public String repeatEnd(String str, int n) {
        String a = "";
        for (int i = 0; i < n; i++) {
            a += str.substring(str.length() - n, str.length());
        }
        return a;
    }

    // Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second
    // char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
    public String mixString(String a, String b) {
        String longer = "";
        String shorter = "";
        String mix = "";
        if (a.length() > b.length()) {
            longer = a;
            shorter = b;
        } else {
            longer = b;
            shorter = a;
        }
        for (int i = 0; i < shorter.length(); i++) {
            mix += a.substring(i, i + 1) + b.substring(i, i + 1);
        }
        mix += longer.substring(shorter.length(), longer.length());
        return mix;
    }

    // We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere
    // later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if
    // the given string is xy-balanced.
    public boolean xyBalance(String str) {
        boolean mark = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') mark = false;
            if (str.charAt(i) == 'y') mark = true;
        }
        return mark;
    }

    // Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
    public boolean bobThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            String bob = str.substring(i, i+3);
            if (bob.substring(0, 1).equals("b") && bob.substring(2, 3).equals("b")) return true;
        }
        return false;
    }

    // Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by
    // a period (.). So "xxyz" counts but "x.xyz" does not.
    public boolean xyzThere(String str) {
        if (str.length() < 3) return false;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("xyz")) {
                if (i == 0) return true;
                else if (str.charAt(i - 1) != '.') return true;
            }
        }
        return false;
    }

    //Given two strings, return true if either of the strings appears at the very end of the other string, ignoring
    // upper/lower case differences (in other words, the computation should not be "case sensitive").
    // Note: str.toLowerCase() returns the lowercase version of a string.
    public boolean endOther(String a, String b) {
        String longer = "";
        String shorter = "";
        if (a.length() == b.length()) {
            if (a.equals(b)) return true;
            else return false;
        } else {
            if (a.length() > b.length()) {
                longer = a.toLowerCase();
                shorter = b.toLowerCase();
            } else {
                longer = b.toLowerCase();
                shorter = a.toLowerCase();
            }
        }
        String longerEnd = longer.substring(longer.length() - shorter.length(), longer.length());
        if (longerEnd.equals(shorter)) return true;

        return false;
    }


    // Given a string and an int n, return a string made of the first n characters of the string, followed by the first
    // n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string,
    // inclusive (i.e. n >= 0 and n <= str.length()).
    public static String repeatFront(String str, int n) {
        String result = "";
        for (int i = n; i >=0; i--) {
            result += str.substring(0, i);
        }
        return result;
    }

    // Given two strings, word and a separator sep, return a big string made of count occurrences of the word,
    // separated by the separator string.
    public static String repeatSeparator(String word, String sep, int count) {
        //String result = "";
        StringBuilder sb = new StringBuilder();
        if (count > 0) sb.append(word);
        for (int i = 1; i < count; i++) {
            sb.append(sep + word);
        }
        return sb.toString();
    }

    // Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string
    // appear somewhere else in the string? Assume that the string is not empty and that N is in the range
    // 1..str.length().
    public static boolean prefixAgain(String str, int n) {
        String prefix = str.substring(0, n);
        for (int i = n; i < str.length() - n + 1; i++) {
            if (str.substring(i, i + n).equals(prefix)) return true;
        }
        return false;
    }


    // Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number
    // of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
    public static boolean xyzMiddle(String str) {
        if (str.length() < 3) return false;
        int n = str.length();
        if (n%2 == 1) {
            if (str.substring(n/2 - 1, n/2 + 2).equals("xyz")) return true;
        } else if (str.substring(n/2 - 1, n/2 + 2).equals("xyz")
                || str.substring(n/2 - 2, n/2 + 1).equals("xyz")) return true;
        return false;
    }

    // A sandwich is two pieces of bread with something in between. Return the string that is between the first and last
    // appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.
    public static String getSandwich(String str) {
        if (str.length() < 10) return "";
        int breadNr = 0;
        int b1 = -1;
        int b2 = -1;
        for (int i = 0; i < str.length() - 4; i ++) {
            if (str.substring(i, i + 5).equals("bread")) {
                breadNr++;
                if (b1 == -1) b1 = i;
                else b2 = i;
            }
        }
        if (b2 == -1) return "";
        return str.substring(b1 + 5, b2);
    }

    // Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the
    // star, they are the same.
    public static boolean sameStarChar(String str) {
        if (str.length() < 3) return true;
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*' && str.charAt(i - 1) != str.charAt(i + 1)) return false;
        }
        return true;
    }

    // Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields
    // "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group
    // of fewer than 3 chars at the end.
    public static String oneTwo(String str) {
        int length = str.length() - str.length()%3;
        if (length < 3) return "";
        for (int i = 0; i < length; i = i + 3) {
            if (str.substring(i, i + 3).length() == 3) {
                str = str.substring(0, i) + str.substring(i + 1, i + 3) + str.substring(i, i + 1)
                        + str.substring(i + 3, length);
            }
        }
        return str;
    }

    // Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return
    // a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
    public static String zipZap(String str) {
        if (str.length() < 3) return str;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
                str = str.substring(0, i) + str.charAt(i) + str.charAt(i + 2) + str.substring(i + 3, str.length());
                i = i + 1;
            }
        }
        return str;
    }

    // Return a version of the given string, where for every star (*) in the string the star and the chars immediately
    // to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
    public static String starOut(String str) {
        List<Integer> map = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '*') {
                map.add(i);
                if (i - 1 >= 0) map.add(i - 1);
                if (i + 1 <= str.length()) map.add(i + 1);
            }
        }
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (!map.contains(i)) newStr += str.charAt(i);
        }
        return newStr;
    }

    // Given a string and a non-empty word string, return a version of the original String where all chars have been
    // replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
    public static String plusOut(String str, String word) {
        StringBuilder newStr = new StringBuilder();
        int help = 0;

        for (int i = 0; i < str.length() - word.length() + 1; i++) {
            if (str.substring(i, i + word.length()).equals(word)) {
                newStr.append(word);
                i += word.length() - 1;
                help = i;
            } else {
                newStr.append("+");
                help = i;
            }
        }

        for (int i = help; i < str.length() - 1; i++) {
            newStr.append("+");
        }
        return newStr.toString();
    }

    // Given a string and a non-empty word string, return a string made of each char just before and just after every
    // appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char
    // may be included twice if it is between two words.
    public static String wordEnds(String str, String word) {
        StringBuilder neW = new StringBuilder();
        for (int i = 0; i < str.length() - word.length() + 1; i++) {
            if (str.substring(i, i + word.length()).equals(word)) {
                if (i > 0) neW.append(str.charAt(i - 1));
                if (i < str.length() - word.length()) neW.append(str.charAt(i + word.length()));
            }
        }
        return neW.toString();
    }
}
