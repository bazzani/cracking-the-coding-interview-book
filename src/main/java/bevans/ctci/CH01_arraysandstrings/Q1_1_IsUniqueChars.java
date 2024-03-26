package bevans.ctci.CH01_arraysandstrings;

public class Q1_1_IsUniqueChars {
    public boolean isUniqueCharsCharCount(String test) {
        if (test.length() > 128) {
            return false;
        }

        boolean[] charFlags = new boolean[128];

        for (int i = 0; i < test.length(); i++) {
            int val = test.charAt(i);
            if (charFlags[val]) {
                return false;
            }
            charFlags[val] = true;
        }

        return true;
    }

    public boolean isUniqueCharsBitShifting(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
}
