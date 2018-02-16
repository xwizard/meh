package com.tw.intergalactic;

import com.tw.intergalactic.facts.Fact;
import com.tw.intergalactic.facts.FactStore;

public class StockStubFact implements Fact<Double> {
  private final String definition;
  private final Double value;

  public StockStubFact(String definition, Double value) {
    this.definition = definition;
    this.value = value;
  }

  @Override
  public String getDefinition() {
    return definition;
  }

  @Override
  public FactStore getFactStore() {
    return null;
  }

  @Override
  public Double resolve() {
    return value;
  }
}
