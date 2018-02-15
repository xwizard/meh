package com.tw.intergalactic.roman;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumber {
  I(1, 3, Collections.emptyList()),
  V(5, 1, Collections.singletonList(RomanNumber.I)),
  X(10, 3, Collections.singletonList(RomanNumber.I)),
  L(50, 1, Collections.singletonList(RomanNumber.X)),
  C(100, 3, Collections.singletonList(RomanNumber.X)),
  D(500, 1, Collections.singletonList(RomanNumber.C)),
  M(1000, 3, Collections.singletonList(RomanNumber.C));

  private final Integer value;
  private final int repeatLimit;
  private final List<RomanNumber> properSubtractionNumbers;


  RomanNumber(int value, int repeatLimit, List<RomanNumber> properSubtractionNumbers) {
    this.value = value;
    this.repeatLimit = repeatLimit;
    this.properSubtractionNumbers = properSubtractionNumbers;
  }

  public static String getRomanNumbersAsString(List<RomanNumber> romanNumbers) {
    return romanNumbers.stream().map(RomanNumber::toString).collect(Collectors.joining(""));
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.name();
  }

  public boolean canBeRepeated(int currentRepeatCounter) {
    return this.repeatLimit > currentRepeatCounter;
  }

  public boolean isRepeated(RomanNumber romanNumber) {
    return this.equals(romanNumber);
  }

  public boolean canSubtract(RomanNumber romanNumber) {
    return this.properSubtractionNumbers.contains(romanNumber);
  }
}
