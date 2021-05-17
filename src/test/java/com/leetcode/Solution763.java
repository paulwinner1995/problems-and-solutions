package com.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * <a href="https://leetcode.com/problems/partition-labels/">763. Partition Labels</a>
 */
public class Solution763 {

  private static final Solution763 SOLUTION = new Solution763();

  public List<Integer> partitionLabels(String s) {
    final var met = new HashSet<Character>();
    final var ans = new LinkedList<Integer>();

    for (int i = 0, end; i < s.length(); i = end + 1) {
      char start = s.charAt(i);

      met.add(start);
      end = s.lastIndexOf(start);

      for (int j = i + 1; j < end; j++) {
        char c = s.charAt(j);

        if (met.contains(c)) {
          continue;
        }

        met.add(c);
        end = Math.max(end, s.lastIndexOf(c));
      }

      ans.add((end - i) + 1);
    }

    return ans;
  }

  @ParameterizedTest
  @MethodSource("data")
  void test(String input, Integer[] output) {
    assertThat(SOLUTION.partitionLabels(input), contains(output));
  }

  private static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of("ababcbacadefegdehijhklij", new Integer[]{9, 7, 8})
    );
  }
}
