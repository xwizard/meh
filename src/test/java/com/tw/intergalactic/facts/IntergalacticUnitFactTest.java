package com.tw.intergalactic.facts;

import com.tw.intergalactic.roman.RomanNumber;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IntergalacticUnitFactTest {

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnNull() {
    IntergalacticUnitFact.parse(factStore(), null);
  }

  @Test
  public void parseShouldParseProperValues() {
    IntergalacticUnitFact actual = IntergalacticUnitFact.parse(factStore(), "prok is\tV ");

    assertThat(actual.getDefinition(), is("prok"));
    assertThat(actual.resolve(), is(RomanNumber.V));
  }

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnInvalidLine() {
    IntergalacticUnitFact.parse(factStore(), "trash");
  }

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnInvalidRomanNumber() {
    IntergalacticUnitFact.parse(factStore(), " trash is  P");
  }

  private FactStore factStore() {
    return new FactStore();
  }
}