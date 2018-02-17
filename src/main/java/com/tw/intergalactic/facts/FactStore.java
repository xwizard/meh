package com.tw.intergalactic.facts;

import java.util.Optional;

public interface FactStore {
  <T> Optional<Fact<T>> findFact(String definition);

  void store(Fact<?> fact);
}
