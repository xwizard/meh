package com.tw.intergalactic.parser;

import com.tw.intergalactic.facts.FactFactory;
import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.facts.FactStoreImpl;
import com.tw.intergalactic.questions.QuestionFactory;

public class ParserContext {
  private final FactFactory factFactory;
  private final QuestionFactory questionFactory;
  private final FactStore factStore;

  public ParserContext() {
    factStore = new FactStoreImpl();
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
