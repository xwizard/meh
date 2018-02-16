package com.tw.intergalactic.questions;

import com.tw.intergalactic.facts.Fact;
import com.tw.intergalactic.facts.FactStore;
import com.tw.intergalactic.facts.FactStoreImpl;
import com.tw.intergalactic.roman.RomanNumber;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IntergalacticNumberQuestionTest {

  public static final String HOW_MUCH_IS_PISH_TEGJ_GLOB_GLOB = "how much is pish tegj glob glob ?";

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnNull() {
    IntergalacticNumberQuestion.parse(factStore(), null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void parseShouldThrowOnInvalidQuestion() {
    IntergalacticNumberQuestion.parse(factStore(), "some trash and gibberish");
  }

  @Test
  public void parseShouldParseLine() {
    IntergalacticNumberQuestion actual = IntergalacticNumberQuestion.parse(factStore(), HOW_MUCH_IS_PISH_TEGJ_GLOB_GLOB);

    assertThat(actual.getIntergalacticNumber(), is(Arrays.asList("pish", "tegj", "glob", "glob")));
  }

  @Test
  public void answerShouldGiveCorrectAnswer() {
    IntergalacticNumberQuestion actual = IntergalacticNumberQuestion.parse(factStore(), HOW_MUCH_IS_PISH_TEGJ_GLOB_GLOB);

    assertThat(actual.answer(), is(42L));
  }

  private FactStore factStore() {
    FactStoreImpl factStore = new FactStoreImpl();
    factStore.store(fact("pish", RomanNumber.X));
    factStore.store(fact("tegj", RomanNumber.L));
    factStore.store(fact("glob", RomanNumber.I));
    return factStore;
  }

  private Fact<RomanNumber> fact(String intergalactic, RomanNumber roman) {
    return new Fact<RomanNumber>() {
      @Override
      public String getDefinition() {
        return intergalactic;
      }

      @Override
      public FactStore getFactStore() {
        return null;
      }

      @Override
      public RomanNumber resolve() {
        return roman;
      }
    };
  }
}