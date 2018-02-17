package com.tw.intergalactic.questions;

import com.tw.intergalactic.facts.Fact;
import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.facts.util.IntergalacticUnitUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class StockValueQuestion implements Question<Long> {
  private final static String STOCK_QUESTION = "\\s*how\\s+many\\s+Credits\\s+is\\s+?";
  private final static String STOCK_QUESTION_PATTERN = "^" + STOCK_QUESTION + ".+\\s*\\??$";

  private final List<String> intergalacticNumber;
  private final FactStore factStore;
  private final String stockName;

  public StockValueQuestion(List<String> intergalacticNumber, FactStore factStore, String stockName) {
    this.intergalacticNumber = intergalacticNumber;
    this.factStore = factStore;
    this.stockName = stockName;
  }

  @Override
  public Long answer() {
    Optional<Fact<Double>> stockValueFact = factStore.findFact(stockName);
    if (!stockValueFact.isPresent()) {
      throw new IllegalStateException(stockName + " is not a known fact");
    }

    double unitValue = stockValueFact.get().resolve();
    double amount = IntergalacticUnitUtil.convert(intergalacticNumber, factStore);

    return Math.round(unitValue * amount);
  }

  @Override
  public String getDefinition() {
    return String.join(" ", intergalacticNumber);
  }

  @Override
  public String getFormattedAnswer() {
    return String.format("%s %s is %d Credits", getDefinition(), stockName, answer());
  }

  public static StockValueQuestion parse(FactStore factStore, String line) {
    assertArgument(line);

    List<String> parts = new LinkedList<>(Arrays.asList(line
        .trim()
        .replaceAll(STOCK_QUESTION, "")
        .replaceAll("\\s+\\?", "").split("\\s+")));

    if (parts.size() < 2) throw new IllegalArgumentException(line + " does not define stock name correctly");

    String stockName = parts.remove(parts.size() - 1);

    return new StockValueQuestion(parts, factStore, stockName);
  }

  private static void assertArgument(String line) {
    if (line == null) {throw new IllegalArgumentException("line cannot be null"); }
    if (!canHandle(line)) {throw new IllegalArgumentException(line + " is not a valid question");}
  }

  public List<String> getIntergalacticNumber() {
    return intergalacticNumber;
  }

  public String getStockName() {
    return stockName;
  }

  public static boolean canHandle(String line) {
    return line.matches(STOCK_QUESTION_PATTERN);
  }

  @Override
  public String toString() {
    return "StockValueQuestion{" +
        "intergalacticNumber=" + intergalacticNumber +
        ", factStore=" + factStore +
        ", stockName='" + stockName + '\'' +
        '}';
  }
}
