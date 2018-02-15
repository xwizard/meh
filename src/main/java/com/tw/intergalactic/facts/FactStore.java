package com.tw.intergalactic.facts;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FactStore {

  private Map<String, Fact> facts = new HashMap<>();

  @SuppressWarnings("unchecked")
  public <T> Optional<Fact<T>> findFact(String definition) {
    return Optional.ofNullable((Fact<T>) facts.get(definition));
  }

  public void store(Fact<?> fact) {
    facts.put(fact.getDefinition(), fact);
  }
}
