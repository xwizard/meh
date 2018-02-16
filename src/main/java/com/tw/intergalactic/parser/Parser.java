package com.tw.intergalactic.parser;

import com.tw.intergalactic.facts.Fact;

import java.util.List;

public class Parser {

  private final ParserContext context;

  public Parser(ParserContext parserContext) {
    this.context = parserContext;
  }

  public void parse(String line) {
    if (isFact(line)) {
      Fact fact = context.getFactFactory().createFromUnparsed(line);
      context.getFactStore().store(fact);
    } else {
      //Question question = context.getQuestionFactory().createFromUnparsed(line);
    }
  }

  private boolean isFact(String line) {
    return !line.contains("how");
  }

  public void parse(List<String> lines) {
    lines.forEach(this::parse);
  }
}
