package com.tw.intergalactic.parser;

import com.tw.intergalactic.facts.FactFactory;
import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.questions.QuestionFactory;

public interface ParserContext {
  FactFactory getFactFactory();

  QuestionFactory getQuestionFactory();

  FactStore getFactStore();
}
