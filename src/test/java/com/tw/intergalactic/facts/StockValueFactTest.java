package com.tw.intergalactic.facts;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class StockValueFactTest {

  public static final String PISH_PISH_IRON_IS_3910_CREDITS = "pish pish Iron is 3910 Credits";

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnNull() {
    StockValueFact.parse(factStore(), null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnWhenAmountIsIncomplete() {
    StockValueFact.parse(factStore(), "Iron is 3910 Credits");
  }

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnWhenCreditsAreMissing() {
    StockValueFact.parse(factStore(), "pish pish Iron is 3910");
  }

  @Test
  public void parseShouldParseCorrectLine() {
    StockValueFact actual = StockValueFact.parse(factStore(), PISH_PISH_IRON_IS_3910_CREDITS);

    assertThat(actual.getDefinition(), is("Iron"));
    assertThat(actual.getValue(), is(new StockValue(Arrays.asList("pish", "pish"), 3910)));
  }

  @Test
  public void resolveShouldResolveUnitValueCorrectly() {
    StockValueFact actual = StockValueFact.parse(factStore(), PISH_PISH_IRON_IS_3910_CREDITS);

    assertEquals(195.5, actual.resolve(), 0.05);
  }

  @Test(expected = IllegalStateException.class)
  public void resolveShouldThrowWhenFactIsUnknown() {
    StockValueFact actual = StockValueFact.parse(factStore(), "trash garbage Iron is 3910 Credits");

    actual.resolve();
  }

  private FactStore factStore() {
    FactStore factStore = new FactStoreImpl();
    IntergalacticUnitFact fact = IntergalacticUnitFact.parse(factStore, "pish is X");
    factStore.store(fact);
    return factStore;
  }
}