package сom.leetcode.problems.p12;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import сom.leetcode.annotations.MySolution;

@MySolution
class SolutionImpl implements Solution {
  private static final String EMPTY = "";
  private static final Map<Integer, String> DICTIONARY = Map.ofEntries(
      Map.entry(1, "I"),
      Map.entry(5, "V"),
      Map.entry(10, "X"),
      Map.entry(50, "L"),
      Map.entry(100, "C"),
      Map.entry(500, "D"),
      Map.entry(1000, "M")
  );

  @Override
  public String intToRoman(int input) {
    final Deque<String> roman = new LinkedList<>();

    for (int rank = 1, value, digit; input > 0; rank *= 10) {
      value = input % (10 * rank);
      digit = value / rank;
      input -= value;

      final var i = DICTIONARY.get(rank);
      final var v = DICTIONARY.get(5 * rank);
      final var x = DICTIONARY.get(10 * rank);

      switch (digit) {
        case 4:
          roman.push(i + v);
          break;
        case 5:
          roman.push(v);
          break;
        case 9:
          roman.push(i + x);
          break;
        default:
          roman.push((digit < 5)
              ? i.repeat(digit)
              : v + i.repeat(digit - 5));
      }
    }

    return String.join(EMPTY, roman);
  }
}
