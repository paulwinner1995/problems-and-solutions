package сom.leetcode.problems.p206;

import сom.leetcode.annotations.MySolution;

@MySolution
public class Recursive implements Solution {

  @Override
  public ListNode reverseList(ListNode head) {
    if ((head == null) || (head.next == null)) {
      return head;
    }

    return reverse(null, head, head.next);
  }

  private ListNode reverse(ListNode prev, ListNode curr, ListNode next) {
    curr.next = prev;

    return (next == null)
        ? curr
        : reverse(curr, next, next.next);
  }
}
