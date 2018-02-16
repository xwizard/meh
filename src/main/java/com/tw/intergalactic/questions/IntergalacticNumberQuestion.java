package com.tw.intergalactic.questions;

import com.tw.intergalactic.facts.FactStore;

public class IntergalacticNumberQuestion extends AbstractQuestion<Integer> {
  protected IntergalacticNumberQuestion(FactStore factStore, String definition) {
    super(factStore, definition);
  }

  @Override
  public Integer answer() {
    return null;
  }

  public static IntergalacticNumberQuestion parse(String line) {
    if (line == null) throw new IllegalArgumentException("line cannot be null");

    return null;
  }
}
