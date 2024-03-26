package bevans.ctci.CH01_arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class Q1_1_IsUniqueCharsTest {
    private Q1_1_IsUniqueChars sut;

    @BeforeEach
    public void setup() {
        sut = new Q1_1_IsUniqueChars();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindUniqueCharsCharCount(String testString, boolean isUnique) {
        // given
        // when
        var isUniqueChars = sut.isUniqueCharsCharCount(testString);

        // then
        assertThat(isUniqueChars).isEqualTo(isUnique);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindUniqueCharsBitShifting(String testString, boolean isUnique) {
        // given
        // when
        var isUniqueChars = sut.isUniqueCharsBitShifting(testString);

        // then
        assertThat(isUniqueChars).isEqualTo(isUnique);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                of("abcde", true),
                of("hello", false),
                of("apple", false),
                of("kite", true),
                of("padle", true),
                of("abcdefghijklmnopqrstuvwxyz_" +
                        "abcdefghijklmnopqrstuvwxyz_" +
                        "abcdefghijklmnopqrstuvwxyz_" +
                        "abcdefghijklmnopqrstuvwxyz_" +
                        "abcdefghijklmnopqrstuvwxyz_", false)
        );
    }
}
