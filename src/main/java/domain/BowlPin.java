package domain;

import java.util.Objects;

public class BowlPin {

  private int pins;

  public BowlPin(int pins) {
    if (pins < 0 || pins > 10) {
      throw new IllegalArgumentException("유효하지 않은 값입니다.");
    }
    this.pins = pins;
  }

  public int getPins() {
    return pins;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BowlPin)) {
      return false;
    }
    BowlPin bowlPin = (BowlPin) o;
    return this.pins == bowlPin.pins;
  }

  @Override
  public int hashCode() {
    return Objects.hash(pins);
  }
}
