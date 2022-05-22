package сom.leetcode.problems.p12;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("12. Integer to Roman")
class SolutionTest {

  private final Solution solution = new SolutionImpl();

  @ParameterizedTest
  @MethodSource("data")
  void test(int input, String output) {
    // when
    final var actual = solution.intToRoman(input);
    // then
    assertThat(actual, is(output));
  }

  private static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of(1, "I"),
        Arguments.of(2, "II"),
        Arguments.of(3, "III"),
        Arguments.of(4, "IV"),
        Arguments.of(5, "V"),
        Arguments.of(6, "VI"),
        Arguments.of(7, "VII"),
        Arguments.of(8, "VIII"),
        Arguments.of(9, "IX"),
        Arguments.of(10, "X"),
        Arguments.of(20, "XX"),
        Arguments.of(30, "XXX"),
        Arguments.of(40, "XL"),
        Arguments.of(50, "L"),
        Arguments.of(60, "LX"),
        Arguments.of(70, "LXX"),
        Arguments.of(80, "LXXX"),
        Arguments.of(90, "XC"),
        Arguments.of(100, "C"),
        Arguments.of(200, "CC"),
        Arguments.of(300, "CCC"),
        Arguments.of(400, "CD"),
        Arguments.of(500, "D"),
        Arguments.of(600, "DC"),
        Arguments.of(700, "DCC"),
        Arguments.of(800, "DCCC"),
        Arguments.of(900, "CM"),
        Arguments.of(1000, "M"),
        Arguments.of(2000, "MM"),
        Arguments.of(3000, "MMM")
    );
  }
}
