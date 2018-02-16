package com.tw.intergalactic.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class QuestionStoreImpl implements QuestionStore {

  private Map<String, Question> questions = new HashMap<>();

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<Question<T>> findFact(String definition) {
    return Optional.ofNullable((Question<T>) questions.get(definition));
  }

  @Override
  public void store(Question<?> question) {
    questions.put(question.getDefinition(), question);
  }
}
