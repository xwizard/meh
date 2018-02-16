package com.tw.intergalactic.parser;

import com.tw.intergalactic.facts.FactFactory;
import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.facts.FactStoreImpl;
import com.tw.intergalactic.questions.QuestionFactory;
import com.tw.intergalactic.questions.QuestionStore;
import com.tw.intergalactic.questions.QuestionStoreImpl;

public class ParserContextImpl implements ParserContext {
  private final FactFactory factFactory;
  private final FactStore factStore;

  private final QuestionFactory questionFactory;

  public QuestionStore getQuestionStore() {
    return questionStore;
  }

  private final QuestionStore questionStore;

  public ParserContextImpl() {
    factStore = new FactStoreImpl();
    factFactory = new FactFactory(factStore);
    questionStore = new QuestionStoreImpl();
    questionFactory = new QuestionFactory(questionStore);
  }

  @Override
  public FactFactory getFactFactory() {
    return factFactory;
  }

  @Override
  public QuestionFactory getQuestionFactory() {
    return questionFactory;
  }

  @Override
  public FactStore getFactStore() {
    return factStore;
  }
}
