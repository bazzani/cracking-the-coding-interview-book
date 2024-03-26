package bevans.ctci.CH01_arraysandstrings;

public class Q1_3_URLify {
    void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;

        for (var i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int index = trueLength + spaceCount * 2;

        if (trueLength < str.length) {
            str[trueLength] = '\0';
        }

        for (var i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
