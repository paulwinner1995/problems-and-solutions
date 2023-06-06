package com.leetcode.problems.p141;

import com.leetcode.annotations.ThirdPartySolution;

@ThirdPartySolution("tortoise and the hare algorithm")
public class FloydCycleFindingAlgorithm implements Solution {

  @Override
  public boolean hasCycle(ListNode head) {
    ListNode slowPtr = head;
    ListNode fastPtr = head;

    while ((fastPtr != null) && (fastPtr.next != null)) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;

      if (slowPtr == fastPtr) {
        return true;
      }
    }

    return false;
  }
}
