package bevans.ctci.CH01_arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class Q1_4_PermutationOfPalindromeTest {
    private Q1_4_PermutationOfPalindrome sut;

    @BeforeEach
    public void setup() {
        sut = new Q1_4_PermutationOfPalindrome();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindPermutationOfPalindrome(String input, boolean expected) {
        // given
        // when
        var val = sut.isPermutationOfPalindrome(input);

        // then
        assertThat(val).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindPermutationOfPalindromeSinglePass(String input, boolean expected) {
        // given
        // when
        var val = sut.isPermutationOfPalindromeSinglePass(input);

        // then
        assertThat(val).isEqualTo(expected);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                of("apple", false),
                of("Rats live on no evil star", true),
                of("A man, a plan, a canal, panama", true),
                of("Lleve", true),
                of("Tacotac", true),
                of("asda", false),
                of("barryisibarry", true)
        );
    }
}
