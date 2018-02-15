package com.tw.intergalactic.parser;

import com.tw.intergalactic.facts.Fact;
import com.tw.intergalactic.facts.FactStore;

import java.util.List;

public class Parser {

  private FactFactory factFactory;
  private QuestionFactory questionFactory;
  private FactStore factStore;

  public void parse(String line) {
    if (isFact(line)) {
      Fact fact = factFactory.createFromUnparsed(line);
      factStore.store(fact);
    } else {
      Question question = questionFactory.createFromUnparsed(line);
    }
  }

  private boolean isFact(String line) {
    return !line.contains("how");
  }

  public void parse(List<String> lines) {
    lines.forEach(this::parse);
  }
}
