package bevans.ctci.CH01_arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class Q1_2_CheckPermutationsTest {

    private Q1_2_CheckPermutations sut;

    @BeforeEach
    public void setup() {
        sut = new Q1_2_CheckPermutations();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldTestForPermutationArrays(String[] strings, boolean expected) {
        // given
        // when
        var val = sut.isPermutationSortedArrays(strings[0], strings[1]);

        // then
        assertThat(val).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldTestForPermutationCharCounts(String[] strings, boolean expected) {
        // given
        // when
        var val = sut.isPermutationCharCounts(strings[0], strings[1]);

        // then
        assertThat(val).isEqualTo(expected);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                of(new String[]{"apple", "papel"}, true),
                of(new String[]{"carrot", "tarroc"}, true),
                of(new String[]{"hello", "llloh"}, false),
                of(new String[]{"hello", "lloh"}, false)
        );
    }
}
