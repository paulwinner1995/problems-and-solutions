package com.leetcode.problems.p141;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("141. Linked List Cycle")
public class SolutionTest {

  @ParameterizedTest
  @MethodSource("data")
  void testHashingSolution(ListNode head, boolean expected) {
    test(new HashingApproach(), head, expected);
  }

  @ParameterizedTest
  @MethodSource("data")
  void testFloydSolution(ListNode head, boolean expected) {
    test(new FloydCycleFindingAlgorithm(), head, expected);
  }

  private void test(Solution solution, ListNode head, boolean expected) {
    assertThat(solution.hasCycle(head), is(expected));
  }

  static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of(listOf(new int[] {
            1
        }, -1), false),
        Arguments.of(listOf(new int[] {
            1, 2
        }, 0), true),
        Arguments.of(listOf(new int[] {
            3, 2, 0, -4
        }, 1), true),
        Arguments.of(listOf(new int[] {
            3, 3, 1
        }, -1), false)
    );
  }

  static ListNode listOf(int[] arr, int pos) {
    final var list = new ListNode[arr.length];

    ListNode head, tail;

    head = tail = list[0] = new ListNode(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      var node = new ListNode(arr[i]);

      list[i - 1].next = node;
      list[i] = tail = node;
    }

    if (pos != -1) {
      tail.next = list[pos];
    }

    return head;
  }
}
