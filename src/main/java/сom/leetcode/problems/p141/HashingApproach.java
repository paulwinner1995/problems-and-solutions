package сom.leetcode.problems.p141;

import java.util.HashSet;

import сom.leetcode.annotations.MySolution;

@MySolution
public class HashingApproach implements Solution {
  
  @Override
  public boolean hasCycle(ListNode head) {
    var hash = new HashSet<ListNode>();
    var node = head;

    for (; node != null; node = node.next) {
      if (hash.contains(node)) {
        return true;
      } else {
        hash.add(node);
      }
    }

    return false;
  }
}
