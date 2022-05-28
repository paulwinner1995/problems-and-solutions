package сom.leetcode.problems.p206;

import сom.leetcode.annotations.MySolution;

@MySolution
public class Iterative implements Solution {

  @Override
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode temp, next = head.next;

    head.next = null;

    while (next != null) {
      temp = next.next;
      next.next = head;
      head = next;
      next = temp;
    }

    return head;
  }
}
