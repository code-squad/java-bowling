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

  public boolean isStrike() {
    return pins == 10;
  }

  public boolean isGutter() {
    return pins == 0;
  }

  public boolean isSpare(BowlPin firstBowlPin) {
    return sum(firstBowlPin) == 10;
  }

  public int getPins() {
    return pins;
  }

  public int sum(BowlPin firstBowlPin) {
    return pins + firstBowlPin.getPins();
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
