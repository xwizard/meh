package com.tw.intergalactic.facts.util;

import com.tw.intergalactic.facts.Fact;
import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.roman.RomanNumber;
import com.tw.intergalactic.roman.RomanNumberCalculator;
import com.tw.intergalactic.roman.RomanNumberCalculatorImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class IntergalacticUnitUtil {

  public static double convert(List<String> intergalactic, FactStore factStore) {
    List<RomanNumber> romanNumbers = new LinkedList<>();
    for (String numeral : intergalactic) {
      Optional<Fact<RomanNumber>> fact = factStore.findFact(numeral);

      if (!fact.isPresent()) {
        throw new IllegalStateException(numeral + " is not a known fact");
      }

      romanNumbers.add(fact.get().resolve());
    }

    RomanNumberCalculator calculator = new RomanNumberCalculatorImpl();

    return (double) calculator.calculate(romanNumbers);
  }
}
