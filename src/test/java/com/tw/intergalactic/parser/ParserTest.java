package com.tw.intergalactic.parser;

import com.tw.intergalactic.facts.Fact;
import com.tw.intergalactic.questions.Question;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ParserTest {
  @Test
  public void parserShouldDistinguishFact() {
    Parser parser = parser();
    parser.parse("glob glob Silver is 34 Credits");
    Optional<Fact<Double>> fact = parser.getContext().getFactStore().findFact("Silver");
    assertTrue(fact.isPresent());
  }

  @Test
  public void parserShouldDistinguishQuestion() {
    Parser parser = parser();
    parser.parse("how much is pish tegj glob glob ?");
    List<Question<?>> questions = parser.getContext().getQuestionStore().listQuestions();
    assertThat(questions.size(), is(1));
  }

  private Parser parser() {
    return new Parser(new ParserContextImpl());
  }
}