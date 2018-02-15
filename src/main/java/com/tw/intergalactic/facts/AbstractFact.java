package com.tw.intergalactic.facts;

public abstract class AbstractFact<T> implements Fact<T> {

  protected final FactStore factStore;
  protected final String definition;

  protected AbstractFact(FactStore factStore, String definition) {
    this.factStore = factStore;
    this.definition = definition;
  }

  @Override
  public String getDefinition() {
    return definition;
  }

  @Override
  public FactStore getFactStore() {
    return factStore;
  }

  @Override
  public abstract T resolve();
}
