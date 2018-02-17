package com.tw.intergalactic.questions;

public interface Question<T> {
  T answer();

  String getDefinition();

  String getFormattedAnswer();
}
