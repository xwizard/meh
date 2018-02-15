package com.tw.intergalactic.facts;

import com.tw.intergalactic.roman.RomanNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class IntergalacticUnitFactStore implements FactStore<String, RomanNumber> {

  private Map<String, Fact<String, RomanNumber>> facts = new HashMap<>();

  @Override
  public Optional<Fact<String, RomanNumber>> findFact(String definition) {
    return Optional.ofNullable(facts.get(definition));
  }

  @Override
  public void store(Fact<String, RomanNumber> fact) {
    facts.put(fact.getDefinition(), fact);
  }
}
