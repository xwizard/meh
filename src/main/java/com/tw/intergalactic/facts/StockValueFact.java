package com.tw.intergalactic.facts;

import com.tw.intergalactic.roman.RomanNumber;
import com.tw.intergalactic.roman.RomanNumberCalculator;
import com.tw.intergalactic.roman.RomanNumberCalculatorImpl;

import java.util.*;

public class StockValueFact extends AbstractFact<Double> {

  private static final String WHITESPACE_PATTERN = "\\s";
  private static final String STOCK_VALUE_PATTERN = "^\\s*.*?" + IS_PATTERN + "[0-9]+\\sCredits\\s*";
  public static final String NOT_VALID_FACT = " is not a valid stock value fact";

  private final StockValue value;

  protected StockValueFact(FactStore factStore, String definition, StockValue value) {
    super(factStore, definition);
    this.value = value;
  }

  public static StockValueFact parse(FactStore factStore, String line) {
    if (line == null) throw new IllegalArgumentException("line cannot be null");
    if (!line.matches(STOCK_VALUE_PATTERN)) throw new IllegalArgumentException(line + NOT_VALID_FACT);

    String[] parts = line.trim().split(IS_PATTERN);

    List<String> amountAndDefinition = new ArrayList<>(Arrays.asList(parts[0].split("\\s")));
    if (amountAndDefinition.size() < 2) {
      throw new IllegalArgumentException(line + NOT_VALID_FACT);
    }

    String definition = amountAndDefinition.remove(amountAndDefinition.size() - 1);
    String amount = String.join(" ", amountAndDefinition);

    String[] credits = parts[1].split(WHITESPACE_PATTERN);
    int value = Integer.parseInt(credits[0]);

    StockValue stockValue = new StockValue(amount, value);

    return new StockValueFact(factStore, definition, stockValue);
  }

  @Override
  public Double resolve() {
    String[] intergalacticNumerals = value.getAmount().split(" ");

    List<RomanNumber> romanNumbers = new LinkedList<>();
    for (String numeral : intergalacticNumerals) {
      Optional<Fact<RomanNumber>> fact = factStore.findFact(numeral);

      if (!fact.isPresent()) {
        throw new IllegalStateException(numeral + " is not a known fact");
      }

      romanNumbers.add(fact.get().resolve());
    }

    RomanNumberCalculator calculator = new RomanNumberCalculatorImpl();
    double amount = calculator.calculate(romanNumbers);

    return (double) value.getValue() / amount;
  }

  public StockValue getValue() {
    return value;
  }

  public static boolean canHandle(String line) {
    return line.matches(STOCK_VALUE_PATTERN);
  }

  @Override
  public String toString() {
    return "StockValueFact{" +
        "value=" + value +
        ", definition='" + definition + '\'' +
        '}';
  }
}
