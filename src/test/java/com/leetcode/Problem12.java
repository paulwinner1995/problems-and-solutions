package com.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.leetcode.annotations.MySolution;

/**
 * <a href="https://leetcode.com/problems/integer-to-roman/">12. Integer to Roman</a>
 */
@MySolution
public class Problem12 {

  private static final Problem12 SOLUTION = new Problem12();

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
        case 1:
          roman.push(i);
          break;
        case 5:
          roman.push(v);
          break;
        case 4:
          roman.push(i + v);
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

  @ParameterizedTest
  @MethodSource("data")
  void test(int input, String output) {
    assertThat(SOLUTION.intToRoman(input), is(output));
  }

  private static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of(3, "III"),
        Arguments.of(4, "IV"),
        Arguments.of(58, "LVIII"),
        Arguments.of(1994, "MCMXCIV")
    );
  }
}
