package com.tw.intergalactic.roman;

import java.util.List;

public class RomanNumberCalculatorImpl implements RomanNumberCalculator {

  public int calculate(List<RomanNumber> romanNumbers) {
    int sum = 0;
    int repeatedNumberCounter = 1;
    RomanNumber previousNumber = null;
    for (RomanNumber currentNumber : romanNumbers) {
      Integer currentValue = currentNumber.getValue();
      if (currentNumber.isRepeated(previousNumber)) {
        assertValidSum(repeatedNumberCounter, currentNumber);
        repeatedNumberCounter++;
      } else if (previousNumber != null && currentValue > previousNumber.getValue()) {
        assertValidSubtrators(romanNumbers, repeatedNumberCounter, previousNumber, currentNumber);
        sum -= 2 * previousNumber.getValue();
      } else {
        repeatedNumberCounter = 1;
      }
      sum += currentValue;
      previousNumber = currentNumber;
    }
    return sum;
  }

  private void assertValidSubtrators(List<RomanNumber> romanNumbers, int repeatedNumberCounter, RomanNumber previousNumber, RomanNumber currentNumber) {
    if (repeatedNumberCounter > 1 || !currentNumber.canSubtract(previousNumber)) {
      throw new IllegalArgumentException("Invalid Roman Number definition: " + RomanNumber.getRomanNumbersAsString(romanNumbers));
    }
  }

  private void assertValidSum(int repeatedNumberCounter, RomanNumber currentNumber) {
    if (!currentNumber.canBeRepeated(repeatedNumberCounter)) {
      throw new IllegalArgumentException(String.format("Current number %1$s cannot be repeated %2$s.", currentNumber, repeatedNumberCounter));
    }
  }
}
