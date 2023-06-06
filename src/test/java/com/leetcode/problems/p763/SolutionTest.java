package com.leetcode.problems.p763;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("763. Partition Labels")
class SolutionTest {

  private final Solution solution = new SolutionImpl();

  @ParameterizedTest
  @MethodSource("data")
  void test(String input, Integer[] output) {
    // when
    final var actual = solution.partitionLabels(input);
    // then
    assertThat(actual, contains(output));
  }

  private static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of("ababcbacadefegdehijhklij", new Integer[] {9, 7, 8})
    );
  }
}
