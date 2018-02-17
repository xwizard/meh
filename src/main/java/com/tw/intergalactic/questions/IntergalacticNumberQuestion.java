package com.tw.intergalactic.questions;

import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.facts.util.IntergalacticUnitUtil;

import java.util.Arrays;
import java.util.List;

public class IntergalacticNumberQuestion implements Question<Long> {

  private final static String INTERGALACTIC_NUMBER_QUESTION = "\\s*how\\s+much\\s+is\\s+?";
  private final static String INTERGALACTIC_NUMBER_QUESTION_PATTERN = "^" + INTERGALACTIC_NUMBER_QUESTION + ".+\\s*\\??$";

  private final List<String> intergalacticNumber;
  private final FactStore factStore;

  protected IntergalacticNumberQuestion(FactStore factStore, List<String> intergalacticNumber) {
    this.intergalacticNumber = intergalacticNumber;
    this.factStore = factStore;
  }

  @Override
  public Long answer() {

    return Math.round(IntergalacticUnitUtil.convert(intergalacticNumber, factStore));
  }

  @Override
  public String getDefinition() {
    return String.join(" ", intergalacticNumber);
  }

  public static IntergalacticNumberQuestion parse(FactStore factStore, String line) {
    assertArgument(line);

    List<String> intergalacticNumber = Arrays.asList(line
        .trim()
        .replaceAll(INTERGALACTIC_NUMBER_QUESTION, "")
        .replaceAll("\\s+\\?", "")
        .split("\\s+"));

    return new IntergalacticNumberQuestion(factStore, intergalacticNumber);
  }

  private static void assertArgument(String line) {
    if (line == null) { throw new IllegalArgumentException("line cannot be null"); }
    if (!canHandle(line)){ throw new IllegalArgumentException(line + " is not a valid question");}
  }

  public static boolean canHandle(String line) {
    return line.matches(INTERGALACTIC_NUMBER_QUESTION_PATTERN);
  }

  List<String> getIntergalacticNumber() {
    return intergalacticNumber;
  }

  @Override
  public String getFormattedAnswer() {
    return String.format("%s is %d", getDefinition(), answer());
  }

  @Override
  public String toString() {
    return "IntergalacticNumberQuestion{" +
        "intergalacticNumber=" + intergalacticNumber +
        ", factStore=" + factStore +
        '}';
  }
}
