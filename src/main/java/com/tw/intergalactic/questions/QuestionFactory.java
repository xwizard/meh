package com.tw.intergalactic.questions;

import com.tw.intergalactic.facts.FactStore;

public class QuestionFactory {

  private final FactStore factStore;

  public QuestionFactory(FactStore factStore) {
    this.factStore = factStore;
  }

  public Question createFromUnparsed(String line) {
    if (IntergalacticNumberQuestion.canHandle(line)) {
      return IntergalacticNumberQuestion.parse(factStore, line);
    }

    if (StockValueQuestion.canHandle(line)) {
      return StockValueQuestion.parse(factStore, line);
    }

    return new UnknownQuestion();
  }
}
