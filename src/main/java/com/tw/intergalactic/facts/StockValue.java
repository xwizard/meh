package com.tw.intergalactic.facts;

import java.util.Objects;

class StockValue {
  private final String amount;
  private final int value;

  public StockValue(String amount, int value) {
    this.amount = amount;
    this.value = value;
  }

  public String getAmount() {
    return amount;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StockValue that = (StockValue) o;
    return value == that.value &&
        Objects.equals(amount, that.amount);
  }

  @Override
  public int hashCode() {

    return Objects.hash(amount, value);
  }

  @Override
  public String toString() {
    return "StockValue{" +
        "amount='" + amount + '\'' +
        ", value=" + value +
        '}';
  }
}
