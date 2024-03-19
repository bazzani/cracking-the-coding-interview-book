package bevans.ctci.bigO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Timeout(value = 2, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class BigOExercisesTest {
    private BigOExercises sut;

    @BeforeEach
    public void setup() {
        sut = new BigOExercises();
    }

    @Test
    void shouldGetProduct() {
        // given
        // when
        int product = sut.product(10, 20);

        // then
        assertThat(product).isEqualTo(200);

        // O(b)
    }

    @Test
    void shouldGetPower() {
        // given
        // when
        int power = sut.power(2, 4);

        // then
        assertThat(power).isEqualTo(16);

        // O(b)
    }

    @Test
    void shouldGetMod() {
        // given
        // when
        int mod = sut.mod(10, 3);

        // then
        assertThat(mod).isEqualTo(1);

        // O(1)
    }

    @Test
    void shouldGetDiv() {
        // given

        // when
        int div = sut.div(10, 3);

        // then
        assertThat(div).isEqualTo(3);

        // O(a/b)
    }

    @Test
    void shouldGetSqrt_Guess() {
        // given

        // when
        int sqrt = sut.sqrt_guess(100);

        // then
        assertThat(sqrt).isEqualTo(10);

        // O(log n)
    }

    @Test
    void shouldGetSqrt_Powers() {
        // given

        // when
        int sqrt = sut.sqrt_powers(16);

        // then
        assertThat(sqrt).isEqualTo(4);

        // O(sqrt(n))
    }

    @Test
    void shouldCopyArray() {
        // given
        int[] array = IntStream.range(1, 1_000).toArray();

        // when
        int[] copiedArray = sut.copyArray(array);

        // then
        assertArrayEquals(copiedArray, array);

        // O(n^2)
    }

    @Test
    void shouldGetSummedDigits() {
        // given

        // when
        int summedDigits = sut.sumDigits(123);

        // then
        assertThat(summedDigits).isEqualTo(6);

        // O(log n)
    }

    @ParameterizedTest(name = "k = {0} should have O(k c^k) == {1}")
    @CsvSource({"2,1_352", "3,52_728", "4,1_827_904"})
    void shouldPrintSortedStrings(int k, int expected) {
        // given

        // when
        sut.printSortedStrings(k);

        // then
        var bigOCount = BigOExercises.STRING_CK_COUNT + BigOExercises.STRING_K_COUNT;
        assertThat(bigOCount).isEqualTo(expected);

        // O(k c^k)
    }

    @Test
    void shouldFindIntersectionsInArrays() {
        // given
        int[] a = IntStream.rangeClosed(1, 100)
                .toArray();
        int[] b = IntStream.rangeClosed(51, 150)
                .toArray();

        // when
        int intersections = sut.intersection(a, b);

        // then
        assertThat(intersections).isEqualTo(50);

        // O(b   log b   + a   log b)
        // ____________________________
        // O(100 log 100 + 100 log 100)
        // O(100 2       + 100 2)
        // O(200         + 200)
    }
}
