package com.tw.intergalactic.questions;

import java.util.Optional;

public interface QuestionStore {
  @SuppressWarnings("unchecked")
  <T> Optional<Question<T>> findFact(String definition);

  void store(Question<?> question);
}
