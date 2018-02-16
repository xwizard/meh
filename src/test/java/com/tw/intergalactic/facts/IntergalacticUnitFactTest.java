package com.tw.intergalactic.facts;

import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.facts.FactStoreImpl;
import com.tw.intergalactic.facts.IntergalacticUnitFact;
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
    IntergalacticUnitFact actual = IntergalacticUnitFact.parse(factStore(), "prok is V ");

    assertThat(actual.getDefinition(), is("prok"));
    assertThat(actual.resolve(), is(RomanNumber.V));
  }

  @Test
  public void parseShouldParseLineWithExtraWhitespacesValues() {
    IntergalacticUnitFact actual = IntergalacticUnitFact.parse(factStore(), "\t \t\t prok\tis   V\t ");

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
    return new FactStoreImpl();
  }
}