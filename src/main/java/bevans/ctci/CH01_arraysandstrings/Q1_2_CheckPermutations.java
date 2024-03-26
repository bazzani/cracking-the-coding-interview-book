package bevans.ctci.CH01_arraysandstrings;

import java.util.Arrays;

public class Q1_2_CheckPermutations {
    boolean isPermutationSortedArrays(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        var s1Chars = s1.toCharArray();
        var s2Chars = s2.toCharArray();

        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        return Arrays.equals(s1Chars, s2Chars);
    }

    boolean isPermutationCharCounts(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        var charCounts = new int[128]; // assuming ASCII

        for (char s1Char : s1.toCharArray()) {
            charCounts[s1Char]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int s2Char = s2.charAt(i);
            charCounts[s2Char]--;
            if (charCounts[s2Char] < 0) {
                return false;
            }
        }

        return true;
    }
}
