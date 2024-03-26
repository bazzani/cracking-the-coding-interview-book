package bevans.ctci.CH01_arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class Q1_3_URLifyTest {
    private Q1_3_URLify sut;

    @BeforeEach
    public void setup() {
        sut = new Q1_3_URLify();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldURLifyString(char[] str, char[] expected) {
        // given
        var trueLength = findLastCharacter(str);

        // when
        sut.replaceSpaces(str, trueLength);

        // then
        assertArrayEquals(expected, str);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                of("Mr John Smith    ".toCharArray(), "Mr%20John%20Smith".toCharArray()),
                of(" Mr Smith    ".toCharArray(), "%20Mr%20Smith".toCharArray())
        );
    }

    private static int findLastCharacter(char[] str) {
        for (var i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i + 1;
            }
        }

        return -1;
    }
}
