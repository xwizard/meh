package com.tw.intergalactic.questions;

public class QuestionFactory {

  private final QuestionStore questionStore;

  public QuestionFactory(QuestionStore questionStore) {
    this.questionStore = questionStore;
  }

  public Question createFromUnparsed(String line) {
    return null;
  }
}
