package com.tw.intergalactic.questions;

public class UnknownQuestion implements Question<String> {

  private static final String I_HAVE_NO_IDEA_WHAT_YOU_ARE_TALKING_ABOUT = "I have no idea what you are talking about";

  @Override
  public String answer() {
    return I_HAVE_NO_IDEA_WHAT_YOU_ARE_TALKING_ABOUT;
  }

  @Override
  public String getDefinition() {
    return I_HAVE_NO_IDEA_WHAT_YOU_ARE_TALKING_ABOUT;
  }

  @Override
  public String getFormattedAnswer() {
    return I_HAVE_NO_IDEA_WHAT_YOU_ARE_TALKING_ABOUT;
  }

  @Override
  public String toString() {
    return I_HAVE_NO_IDEA_WHAT_YOU_ARE_TALKING_ABOUT;
  }
}
