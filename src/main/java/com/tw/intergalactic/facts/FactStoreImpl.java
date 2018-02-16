package com.tw.intergalactic.facts;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FactStoreImpl implements FactStore {

  private Map<String, Fact> facts = new HashMap<>();

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<Fact<T>> findFact(String definition) {
    return Optional.ofNullable((Fact<T>) facts.get(definition));
  }

  @Override
  public void store(Fact<?> fact) {
    facts.put(fact.getDefinition(), fact);
  }
}
