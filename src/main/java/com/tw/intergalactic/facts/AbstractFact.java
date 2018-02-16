package com.tw.intergalactic.facts;

abstract class AbstractFact<T> implements Fact<T> {

  protected final static String IS_PATTERN = "\\s+is\\s+";
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
