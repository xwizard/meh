package com.tw.intergalactic.facts;

import com.tw.intergalactic.facts.util.IntergalacticUnitUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StockValueFact extends AbstractFact<Double> {

  private static final String WHITESPACE_PATTERN = "\\s";
  private static final String STOCK_VALUE_PATTERN = "^\\s*.*?" + IS_PATTERN + "[0-9]+\\sCredits\\s*";
  private static final String NOT_VALID_FACT = " is not a valid stock value fact";

  private final StockValue value;

  private StockValueFact(FactStore factStore, String definition, StockValue value) {
    super(factStore, definition);
    this.value = value;
  }

  public static StockValueFact parse(FactStore factStore, String line) {
    assertArgument(line);

    String[] parts = line.trim().split(IS_PATTERN);

    List<String> amountAndDefinition = new ArrayList<>(Arrays.asList(parts[0].split("\\s")));
    if (amountAndDefinition.size() < 2) {
      throw new IllegalArgumentException(line + NOT_VALID_FACT);
    }

    String definition = amountAndDefinition.remove(amountAndDefinition.size() - 1);

    String[] credits = parts[1].split(WHITESPACE_PATTERN);
    int value = Integer.parseInt(credits[0]);

    StockValue stockValue = new StockValue(amountAndDefinition, value);

    return new StockValueFact(factStore, definition, stockValue);
  }

  private static void assertArgument(String line) {
    if (line == null) {
      throw new IllegalArgumentException("line cannot be null");
    }
    if (!line.matches(STOCK_VALUE_PATTERN)) {
      throw new IllegalArgumentException(line + NOT_VALID_FACT);
    }
  }

  public static boolean canHandle(String line) {
    return line.matches(STOCK_VALUE_PATTERN);
  }

  @Override
  public Double resolve() {
    return (double) value.getValue() / IntergalacticUnitUtil.convert(value.getAmount(), factStore);
  }

  public StockValue getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "StockValueFact{" +
        "value=" + value +
        ", definition='" + definition + '\'' +
        '}';
  }
}
