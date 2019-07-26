public class String3 {

    // Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez"
    // count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there
    // is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an
    // alphabetic letter.)
    public int countYZ(String str) {
        int count = 0;

        for (int i = str.length() - 1; i > 0; i--) {
            if (i == str.length() - 1 && (str.toLowerCase().charAt(str.length() - 1) == 'y' ||
                    str.toLowerCase().charAt(str.length() - 1) == 'z')) count++;
            if (!Character.isLetter(str.charAt(i)) && (str.toLowerCase().charAt(i - 1) == 'y' ||
                    str.toLowerCase().charAt(i - 1) == 'z')) count ++;
        }
        return count;
    }

    // Given two strings, "base" and "remove", return a version of the base string where all instances of the remove
    // string have been removed (not case sensitive). You may assume that the remove string is length 1 or more.
    // Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
    public static String withoutString(String str, String remove) {
        StringBuilder sb = new StringBuilder();
        int help = 0;
        if (str.length() < remove.length()) return str;
        for (int i = 0; i < str.length() - remove.length()+1; i++) {
            if (!str.substring(i, i + remove.length()).equalsIgnoreCase(remove)) sb.append(str.charAt(i));
            else i+= remove.length() - 1;
            help = str.length() - remove.length() - i;
        }
        return sb.append(str.substring(str.length() - remove.length() + 1 - help)).toString();
    }

    // Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number
    // of appearances of "not" anywhere in the string (case sensitive).
    public static boolean equalIsNot(String str) {
        int is = 0;
        int not = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("not")) not++;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("is")) is++;
        }
        return is==not;
    }

    // We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
    // Return true if all the g's in the given string are happy.
    public static boolean gHappy(String str) {
        if (str.length() == 0) return true;
        if (str.length() == 1) return false;
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.substring(i, i + 1).equals("g") &&
                    (str.charAt(i - 1) != 'g' && str.charAt(i + 1) != 'g')) return false;
        }
        return !((str.charAt(0) == 'g' && str.charAt(1) != 'g') || (str.charAt(str.length() - 1) == 'g' &&
                str.charAt(str.length() - 2) != 'g'));
    }

    // We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in
    // the given string. The triples may overlap.
    public static int countTriple(String str) {
        if (str.length() < 3) return 0;
        int n = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2)) n++;
        }
        return n;
    }

    // Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters.
    // Return 0 if there are no digits in the string. (Note: Character.isDigit(char) tests if a char is one of the
    // chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
    public static int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) sum += Integer.parseInt(str.substring(i, i + 1));
        }
        return sum;
    }

    // Given a string, return the longest substring that appears at both the beginning and end of the string without
    // overlapping. For example, sameEnds("abXab") is "ab".
    public static String sameEnds(String str) {
        String p = "";
        int a = str.length();
        for (int i = a / 2; i > 0; i--) {
            if (str.substring(0, i).equals(str.substring(str.length() - i, a))) return str.substring(0, i);
        }
        return p;
    }

    // Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string.
    // In other words, zero or more characters at the very begining of the given string, and at the very end
    // of the string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
    public static String mirrorEnds(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.length() < 2) return str;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(str.length() - i - 1)) sb.append(str.charAt(i));
            else break;
        }
        return sb.toString();
    }

    // Given a string, return the length of the largest "block" in the string.
// A block is a run of adjacent chars that are the same.
    public static int maxBlock(String str) {
        if (str.length() < 2) return str.length();
        int max = 1;
        int help = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                help++;
                if (max < help) max = help;
            } else help = 1;

        }
        return max;
    }

    //Given a string, return the sum of the numbers appearing in the string, ignoring all other
//characters. A number is a series of 1 or more digit chars in a row.
//(Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
//Integer.parseInt(string) converts a string to an int.)
    //TODO
    public static int sumNumbers(String str) {
        return -1;
    }


    // Given a string, return a string where every appearance of the lowercase word "is" has
// been replaced with "is not". The word "is" should not be immediately preceeded or
// followed by a letter -- so for example the "is" in "this" does not count.
// (Note: Character.isLetter(char) tests if a char is a letter.)
    public static String notReplace(String str) {
        StringBuilder sb = new StringBuilder();
        boolean front;
        boolean back;
        if (str.length() < 2) return str;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("is")) {
                if (i == 0) front = true;
                else front = !Character.isLetter(str.charAt(i - 1));

                if (i == str.length() - 2) back = true;
                else back = !Character.isLetter(str.charAt(i + 2));

                if (front && back) sb.append("is not");
                else sb.append("is");

                i++;
            } else sb.append(str.charAt(i));
            if (i == str.length() - 2) sb.append(str.charAt(i + 1));
        }
        return sb.toString();
    }

}