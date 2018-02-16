package com.tw.intergalactic.facts;

import java.util.Optional;

public interface FactStore {
  @SuppressWarnings("unchecked")
  <T> Optional<Fact<T>> findFact(String definition);

  void store(Fact<?> fact);
}
