package com.tw.intergalactic.parser;

import com.tw.intergalactic.facts.FactStore;

public class ParserContext {
  private final FactFactory factFactory;
  private final QuestionFactory questionFactory;
  private final FactStore factStore;

  public ParserContext() {
    factStore = new FactStore();
    factFactory = new FactFactory(factStore);
    questionFactory = null;
  }

  public FactFactory getFactFactory() {
    return factFactory;
  }

  public QuestionFactory getQuestionFactory() {
    return questionFactory;
  }

  public FactStore getFactStore() {
    return factStore;
  }
}
