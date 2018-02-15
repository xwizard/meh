package com.tw.intergalactic.facts;

public interface Fact<Definition, Value> {
  Definition getDefinition();
  Value getValue();
}
