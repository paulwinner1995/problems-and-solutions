package com.leetcode.problems.p763;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.annotations.MySolution;

@MySolution
class SolutionImpl implements Solution {
  @Override
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
}
