package сom.leetcode.problems.p189;

import сom.leetcode.annotations.ThirdPartySolution;

@ThirdPartySolution
class SolutionImpl implements Solution {

  @Override
  public void rotate(int[] nums, int k) {
    // nums = [1, 2, 3, 4, 5, 6, 7]; k = 3
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
        // 1) current = 0; next = 3; temp = 4; count = 0; nums = [1, 2, 3, (1), 5, 6, 7]
        // 2) current = 3; next = 6; temp = 7; count = 1; nums = [1, 2, 3, 1, 5, 6, (4)]
        // 3) current = 6; next = 2; temp = 3; count = 2; nums = [1, 2, (7), 1, 5, 6, 4]
        // 4) current = 2; next = 5; temp = 6; count = 3; nums = [1, 2, 7, 1, 5, (3), 4]
        // 5) current = 5; next = 1; temp = 2; count = 4; nums = [1, (6), 7, 1, 5, 3, 4]
        // 6) current = 1; next = 4; temp = 5; count = 5; nums = [1, 6, 7, 1, (2), 3, 4]
        // 2) current = 4; next = 0; temp = 1; count = 6; nums = [(5), 6, 7, 1, 2, 3, 4]
      } while (start != current);
    }
  }
}
