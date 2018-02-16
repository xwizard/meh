package com.tw.intergalactic.questions;

import java.util.List;

public interface QuestionStore {
  @SuppressWarnings("unchecked")
  <T> List<Question<?>> listQuestions();

  void store(Question<?> question);
}
