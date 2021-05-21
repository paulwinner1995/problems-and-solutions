package com.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * <a href="https://leetcode.com/problems/rotate-array/">189. Rotate Array</a>
 */
public class Problem189 {

  private static final Problem189 SOLUTION = new Problem189();

  public void rotate(int[] nums, int k) {
    k %= nums.length;

    for (int start = 0, count = 0; count < nums.length; start++) {
      int current = start;
      int prev = nums[current];

      do {
        int next = (current + k) % nums.length;
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
        count++;
      } while (start != current);
    }
  }

  @ParameterizedTest
  @MethodSource("data")
  void test(int[] nums, int k, int[] expected) {
    SOLUTION.rotate(nums, k);
    assertThat(nums, is(expected));
  }

  private static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
        Arguments.of(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100})
    );
  }
}
