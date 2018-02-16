package com.tw.intergalactic.facts;

import com.tw.intergalactic.roman.RomanNumber;

public class IntergalacticUnitFact extends AbstractFact<RomanNumber> {

  private final static String INTERGALACTIC_UNIT_PATTERN = "^\\s*.+" + IS_PATTERN + ".\\s*$";

  private final RomanNumber romanNumber;

  private IntergalacticUnitFact(FactStore factStore, String definition, RomanNumber romanNumber) {
    super(factStore, definition);
    this.romanNumber = romanNumber;
  }

  @Override
  public RomanNumber resolve() {
    return romanNumber;
  }

  public static IntergalacticUnitFact parse(FactStore factStore, String line) {
    if (line == null) throw new IllegalArgumentException("line cannot be null");

    String trimmedLine = line.trim();

    if (!trimmedLine.matches(INTERGALACTIC_UNIT_PATTERN))
      throw new IllegalArgumentException(line + " is not intergalactic unit fact");

    String[] parts = trimmedLine.split(IS_PATTERN);
    return new IntergalacticUnitFact(factStore, parts[0].trim(), RomanNumber.valueOf(parts[1].trim()));
  }

  public static boolean canHandle(String line) {
    return line.matches(INTERGALACTIC_UNIT_PATTERN);
  }

  @Override
  public String toString() {
    return "IntergalacticUnitFact{" +
        "romanNumber=" + romanNumber +
        ", definition='" + definition + '\'' +
        '}';
  }
}
