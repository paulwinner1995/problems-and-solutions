package com.leetcode.problems.p206;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("206. Reverse Linked List")
public class SolutionTest {

  @ParameterizedTest
  @MethodSource("data")
  void testIterative(ListNode input, ListNode output) {
    test(new Iterative(), input, output);
  }

  @ParameterizedTest
  @MethodSource("data")
  void testRecursive(ListNode input, ListNode output) {
    test(new Recursive(), input, output);
  }

  void test(Solution solution, ListNode input, ListNode output) {
    // when
    var result = solution.reverseList(input);
    // then
    for (; output != null; output = output.next, result = result.next) {
      assertThat(result, notNullValue());
      assertThat(result.val, is(output.val));
    }
  }

  static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of(
            null,
            null
        ),
        Arguments.of(
            listOf(new int[] {1}),
            listOf(new int[] {1})
        ),
        Arguments.of(
            listOf(new int[] {1, 2, 3, 4, 5}),
            listOf(new int[] {5, 4, 3, 2, 1})
        )
    );
  }

  static ListNode listOf(int[] arr) {
    ListNode prev, head;

    head = prev = new ListNode(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      prev.next = new ListNode(arr[i]);
      prev = prev.next;
    }

    return head;
  }
}
