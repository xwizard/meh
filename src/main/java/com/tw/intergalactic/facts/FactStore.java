package com.tw.intergalactic.facts;

import java.util.Optional;

public interface FactStore<Definition, Value> {
  Optional<Fact<Definition, Value>> findFact(Definition definition);
  void store(Fact<Definition, Value> fact);
}
