package com.tw.intergalactic;

import com.tw.intergalactic.facts.Fact;
import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.roman.RomanNumber;

public class RomanStubFact implements Fact<RomanNumber> {
  private final String intergalactic;
  private final RomanNumber roman;

  public RomanStubFact(String intergalactic, RomanNumber roman) {
    this.intergalactic = intergalactic;
    this.roman = roman;
  }

  @Override
  public String getDefinition() {
    return intergalactic;
  }

  @Override
  public FactStore getFactStore() {
    return null;
  }

  @Override
  public RomanNumber resolve() {
    return roman;
  }
}
