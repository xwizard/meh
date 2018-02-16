package com.tw.intergalactic.questions;

import com.tw.intergalactic.facts.FactStore;

public abstract class AbstractQuestion<T> implements Question<T> {
  protected final FactStore factStore;
  protected final String definition;

  protected AbstractQuestion(FactStore factStore, String definition) {
    this.factStore = factStore;
    this.definition = definition;
  }
  @Override
  public String getDefinition() {
    return null;
  }
}
