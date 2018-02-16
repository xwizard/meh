package com.tw.intergalactic.parser;

import com.tw.intergalactic.facts.FactFactory;
import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.questions.QuestionFactory;
import com.tw.intergalactic.questions.QuestionStore;

public interface ParserContext {
  FactFactory getFactFactory();

  QuestionFactory getQuestionFactory();

  FactStore getFactStore();

  QuestionStore getQuestionStore();
}
