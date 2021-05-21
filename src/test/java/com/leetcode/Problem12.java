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

  @ParameterizedTest
  @MethodSource("data")
  void test(int input, String output) {
    assertThat(SOLUTION.intToRoman(input), is(output));
  }

  private static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of(1, "I"),
        Arguments.of(2, "II"),
        Arguments.of(3, "III"),
        Arguments.of(4, "IV"),
        Arguments.of(5, "V"),
        Arguments.of(6, "VI"),
        Arguments.of(7, "VII"),
        Arguments.of(8, "VIII"),
        Arguments.of(9, "IX"),
        Arguments.of(10, "X"),
        Arguments.of(20, "XX"),
        Arguments.of(30, "XXX"),
        Arguments.of(40, "XL"),
        Arguments.of(50, "L"),
        Arguments.of(60, "LX"),
        Arguments.of(70, "LXX"),
        Arguments.of(80, "LXXX"),
        Arguments.of(90, "XC"),
        Arguments.of(100, "C"),
        Arguments.of(200, "CC"),
        Arguments.of(300, "CCC"),
        Arguments.of(400, "CD"),
        Arguments.of(500, "D"),
        Arguments.of(600, "DC"),
        Arguments.of(700, "DCC"),
        Arguments.of(800, "DCCC"),
        Arguments.of(900, "CM"),
        Arguments.of(1000, "M"),
        Arguments.of(2000, "MM"),
        Arguments.of(3000, "MMM")
    );
  }
}
