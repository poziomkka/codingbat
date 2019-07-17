public class String3 {

    // Given a string, return the length of the largest "block" in the string.
// A block is a run of adjacent chars that are the same.
    public int maxBlock(String str) {
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
    public int sumNumbers(String str) {
        return -1;
    }


    // Given a string, return a string where every appearance of the lowercase word "is" has
// been replaced with "is not". The word "is" should not be immediately preceeded or
// followed by a letter -- so for example the "is" in "this" does not count.
// (Note: Character.isLetter(char) tests if a char is a letter.)
    public String notReplace(String str) {

        String strN = "";
        boolean front;
        boolean back;
        int lastOne = 0;

        if (str.length() < 2) return str;
        for (int i = 0; i < str.length() - 1; i++) {
            lastOne = i;

            if (str.substring(i, i + 2).equals("is")) {
                lastOne = 0;
                if (i == 0) front = true;
                else if (!Character.isLetter(str.charAt(i - 1))) front = true;
                else front = false;

                if (i == str.length() - 2) back = true;
                else if (!Character.isLetter(str.charAt(i + 2))) back = true;
                else back = false;

                if (front && back) strN += "is not";
                else strN += "is";
                i++;
            } else strN += str.charAt(i);

            if (i == str.length() - 2) strN += str.charAt(i + 1);
        }
        return strN;
    }


}