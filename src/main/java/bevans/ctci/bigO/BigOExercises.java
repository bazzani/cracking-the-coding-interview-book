package bevans.ctci.bigO;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;

class BigOExercises {
    int product(int a, int b) {
        int sum = 0;

        for (int i = 0; i < b; i++) {
            sum += a;
        }

        return sum;
    }

    int power(int a, int b) {
        if (b < 0) {
            return 0; // error
        } else if (b == 0) {
            return 1;
        } else {
            return a * power(a, b - 1);
        }
    }

    int mod(int a, int b) {
        if (b <= 0) {
            return -1;
        }

        int div = a / b;

        return a - div * b;
    }

    int div(int a, int b) {
        int count = 0;
        int sum = b;

        while (sum <= a) {
            sum += b;
            count++;
        }

        return count;
    }

    int sqrt_guess(int n) {
        return sqrt_helper(n, 1, n);
    }

    private int sqrt_helper(int n, int min, int max) {
        if (max < min) {
            return -1;
        }

        int guess = (min + max) / 2;
        if (guess * guess == n) {
            return guess; // found it!
        } else if (guess * guess < n) {
            // too low
            return sqrt_helper(n, guess + 1, max);
        } else {
            // too high
            return sqrt_helper(n, min, guess - 1);
        }
    }

    int sqrt_powers(int n) {
        for (int guess = 1; guess * guess <= n; guess++) {
            if (guess * guess == n) {
                return guess;
            }
        }

        return -1;
    }

    int[] copyArray(int[] array) {
        int[] copy = new int[0];
        for (int value : array) {
            copy = appendToNew(copy, value);
        }

        return copy;
    }

    private int[] appendToNew(int[] array, int value) {
        // copy all elements over to new array
        int[] bigger = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            bigger[i] = array[i];
        }

        // add new element
        bigger[bigger.length - 1] = value;
        // System.out.println("bigger = " + Arrays.toString(bigger));

        return bigger;
    }

    int sumDigits(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    static int STRING_CK_COUNT;
    static int STRING_K_COUNT;
    static final int NUM_CHARS = 26;

    private void printSortedStrings(int remaining, String prefix) {


        if (remaining == 0) {
            if (isInOrder(prefix)) {
//                System.out.println("p:" + prefix);
                STRING_CK_COUNT++;
            } else {
                STRING_CK_COUNT++;
            }
        } else {
            for (int i = 0; i < NUM_CHARS; i++) {
                char c = ithLetter(i);
                printSortedStrings(remaining - 1, prefix + c);
            }
        }
    }

    private boolean isInOrder(String s) {
        for (int i = 1; i < s.length(); i++) {
            STRING_K_COUNT++;
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }

        return true;
    }

    private char ithLetter(int i) {
        return (char) ('a' + i);
    }

    int intersection(int[] a, int[] b) {
        Arrays.sort(b);

        int intersect = 0;

        for (int x : a) {
            int i = binarySearch(b, x);
            if (i >= 0) {
                intersect++;
            }
        }

        return intersect;
    }
}
