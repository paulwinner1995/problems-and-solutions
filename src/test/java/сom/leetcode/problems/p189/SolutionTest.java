package сom.leetcode.problems.p189;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("189. Rotate Array")
public class SolutionTest {

  private final Solution solution = new SolutionImpl();

  @ParameterizedTest
  @MethodSource("data")
  void test(int[] nums, int k, int[] expected) {
    // when
    solution.rotate(nums, k);
    // then
    assertThat(nums, is(expected));
  }

  private static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7}, 3, new int[] {5, 6, 7, 1, 2, 3, 4}),
        Arguments.of(new int[] {-1, -100, 3, 99}, 2, new int[] {3, 99, -1, -100})
    );
  }
}
