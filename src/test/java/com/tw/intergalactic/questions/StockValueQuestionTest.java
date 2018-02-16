package com.tw.intergalactic.questions;

import com.tw.intergalactic.RomanStubFact;
import com.tw.intergalactic.StockStubFact;
import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.facts.FactStoreImpl;
import com.tw.intergalactic.roman.RomanNumber;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StockValueQuestionTest {

  public static final String HOW_MANY_CREDITS_IS_GLOB_PROK_SILVER = "how many Credits is glob prok Silver ?";

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnNull() {
    StockValueQuestion.parse(factStore(), null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnInvalidQuestion() {
    StockValueQuestion.parse(factStore(), "some trash and gibberish");
  }

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowWhenStockIsNotGiven() {
    StockValueQuestion.parse(factStore(), "how many Credits is glob ?");
  }

  @Test
  public void parseShouldParseLine() {
    StockValueQuestion actual = StockValueQuestion.parse(factStore(), HOW_MANY_CREDITS_IS_GLOB_PROK_SILVER);

    assertThat(actual.getIntergalacticNumber(), is(Arrays.asList("glob", "prok")));
    assertThat(actual.getStockName(), is("Silver"));
  }

  @Test
  public void answerShouldGiveCorrectAnswer() {
    StockValueQuestion actual = StockValueQuestion.parse(factStore(), HOW_MANY_CREDITS_IS_GLOB_PROK_SILVER);

    assertThat(actual.answer(), is(68L));
  }

  private FactStore factStore() {
    FactStoreImpl factStore = new FactStoreImpl();
    factStore.store(new RomanStubFact("glob", RomanNumber.I));
    factStore.store(new RomanStubFact("prok", RomanNumber.V));
    factStore.store(new StockStubFact("Silver", 17.0));
    return factStore;
  }
}