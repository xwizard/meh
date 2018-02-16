package com.tw.intergalactic.facts;

public class FactFactory {

  private final FactStore factStore;

  public FactFactory(FactStore factStore) {
    this.factStore = factStore;
  }

  public Fact<?> createFromUnparsed(String line) {
    if (IntergalacticUnitFact.canHandle(line)) {
      return IntergalacticUnitFact.parse(factStore, line);
    }

    if (StockValueFact.canHandle(line)) {
      return StockValueFact.parse(factStore, line);
    }

    throw new IllegalArgumentException(line + " is an unknown fact definition");
  }
}
