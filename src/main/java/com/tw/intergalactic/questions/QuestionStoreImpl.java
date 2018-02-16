package com.tw.intergalactic.questions;

import java.util.*;

public class QuestionStoreImpl implements QuestionStore {

  private List<Question<?>> questions = new LinkedList<>();

  @Override
  @SuppressWarnings("unchecked")
  public <T> List<Question<?>> listQuestions() {
    return questions;
  }

  @Override
  public void store(Question<?> question) {
    questions.add(question);
  }
}
