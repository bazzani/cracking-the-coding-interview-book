package bevans.ctci.CH01_arraysandstrings;

public class Q1_4_PermutationOfPalindrome {
    private static final int Z_NUM = Character.getNumericValue('z');

    private static final int A_NUM = Character.getNumericValue('a');

    boolean isPermutationOfPalindrome(String input) {
        int[] table = buildCharFrequencyTable(input);
        return checkMaxOneOddChar(table);
    }

    boolean isPermutationOfPalindromeSinglePass(String input) {
        int oddCount = 0;
        var charTable = new int[Z_NUM - A_NUM + 1];

        for (char c : input.toCharArray()) {
            var charNumber = getCharNumber(c);

            if (charNumber != -1) {
                charTable[charNumber]++;
                if (charTable[charNumber] % 2 == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }
            }
        }

        return oddCount <= 1;
    }

    private int[] buildCharFrequencyTable(String input) {
        var charTable = new int[Z_NUM - A_NUM + 1];

        for (char c : input.toCharArray()) {
            var charNumber = getCharNumber(c);
            if (charNumber != -1) {
                charTable[charNumber]++;
            }
        }

        return charTable;
    }

    private int getCharNumber(char c) {
        int charNumber = Character.getNumericValue(c);

        if (A_NUM <= charNumber && charNumber <= Z_NUM) {
            return charNumber - A_NUM;
        }

        return -1;
    }

    private boolean checkMaxOneOddChar(int[] table) {
        boolean foundOdd = false;

        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }
}
