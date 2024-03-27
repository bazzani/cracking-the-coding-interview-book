package bevans.ctci.CH01_arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class Q1_5_OneAwayTest {

    private Q1_5_OneAway sut;

    @BeforeEach
    public void setup() {
        sut = new Q1_5_OneAway();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindOneEditAway(String first, String second, boolean expected) {
        // given

        // when
        var val = sut.oneEditAway(first, second);

        // then
        assertThat(val).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindOneEditAwayDRY(String first, String second, boolean expected) {
        // given

        // when
        var val = sut.oneEditAwayDRY(first, second);

        // then
        assertThat(val).isEqualTo(expected);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                of("foo", "foooo", false),
                of("foo", "foo", false),
                of("ff", "foo", false), // replacement and insertion
                of("a", "b", true),
                of("", "d", true),
                of("d", "de", true),
                of("pale", "pse", false),
                of("acdsfdsfadsf", "acdsgdsfadsf", true),
                of("acdsfdsfadsf", "acdsfdfadsf", true),
                of("acdsfdsfadsf", "acdsfdsfads", true),
                of("acdsfdsfadsf", "cdsfdsfadsf", true),
                of("adfdsfadsf", "acdfdsfdsf", false),
                of("adfdsfadsf", "bdfdsfadsg", false),
                of("adfdsfadsf", "affdsfads", false),
                of("pale", "pkle", true),
                of("pkle", "pable", false)
        );
    }
}
