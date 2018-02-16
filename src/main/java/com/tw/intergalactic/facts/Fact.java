package com.tw.intergalactic.facts;

public interface Fact<T> {
  String getDefinition();

  FactStore getFactStore();

  T resolve();
}
