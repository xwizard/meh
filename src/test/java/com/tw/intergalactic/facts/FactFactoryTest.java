package com.tw.intergalactic.facts;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class FactFactoryTest {
  @Test
  public void shouldCreateIntergalacticUnitFact() {
    FactFactory factory = factFactory();

    Fact<?> fact = factory.createFromUnparsed("prok is V");

    assertTrue(fact instanceof IntergalacticUnitFact);
  }

  @Test
  public void shouldCreateStockValueFact() {
    FactFactory factory = factFactory();

    Fact<?> fact = factory.createFromUnparsed("glob glob Silver is 34 Credits");

    assertTrue(fact instanceof StockValueFact);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowOnUnknownFact() {
    factFactory().createFromUnparsed("trash garbage");
  }

  private FactFactory factFactory() {
    FactStore factStore = new FactStoreImpl();
    return new FactFactory(factStore);
  }
}