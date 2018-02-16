package com.tw.intergalactic.questions;

import com.tw.intergalactic.facts.FactStore;

public class QuestionFactory {

  public static final String I_HAVE_NO_IDEA_WHAT_YOU_ARE_TALKING_ABOUT = "I have no idea what you are talking about";
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

    return unknownQuestion();
  }

  private Question<String> unknownQuestion() {
    return new Question<String>() {
      @Override
      public String answer() {
        return I_HAVE_NO_IDEA_WHAT_YOU_ARE_TALKING_ABOUT;
      }

      @Override
      public String getDefinition() {
        return I_HAVE_NO_IDEA_WHAT_YOU_ARE_TALKING_ABOUT;
      }

      @Override
      public String toString() {
        return I_HAVE_NO_IDEA_WHAT_YOU_ARE_TALKING_ABOUT;
      }
    };
  }
}
