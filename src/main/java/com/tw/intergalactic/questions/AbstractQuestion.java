package com.tw.intergalactic.questions;

import com.tw.intergalactic.facts.FactStore;

public abstract class AbstractQuestion<T> implements Question<T> {
  protected final FactStore factStore;

  protected AbstractQuestion(FactStore factStore) {
    this.factStore = factStore;
  }
}
