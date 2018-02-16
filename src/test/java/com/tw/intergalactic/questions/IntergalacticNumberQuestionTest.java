package com.tw.intergalactic.questions;

import org.junit.Test;

public class IntergalacticNumberQuestionTest {
  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnNull() {
    IntergalacticNumberQuestion.parse(null);
  }

  @Test
  public void parseShouldParseLine() {
    IntergalacticNumberQuestion actual = IntergalacticNumberQuestion.parse("how much is pish tegj glob glob");

  }
}