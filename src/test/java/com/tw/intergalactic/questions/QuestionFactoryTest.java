package com.tw.intergalactic.questions;

import com.tw.intergalactic.facts.FactStoreImpl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class QuestionFactoryTest {
  @Test
  public void shouldCreateIntergalacticNumberQuestion() {
    Question<?> actual = questionFactory().createFromUnparsed("how much is pish tegj glob glob");

    assertTrue(actual instanceof IntergalacticNumberQuestion);
  }

  @Test
  public void shouldCreateStockValueQuestion() {
    Question<?> actual = questionFactory().createFromUnparsed("how many Credits is glob prok Gold ?");

    assertTrue(actual instanceof StockValueQuestion);
  }

  @Test
  public void shouldCreateStockValueUnknownQuestion() {
    Question<?> actual = questionFactory().createFromUnparsed("what if trash garbage ?");

    assertTrue(actual instanceof UnknownQuestion);
  }

  private QuestionFactory questionFactory() {
    return new QuestionFactory(new FactStoreImpl());
  }
}