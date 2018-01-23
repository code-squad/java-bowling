package domain;

import domain.state.BowlState;

public class SecondBowl extends Bowl {

  private BowlPin firstBowlPin;

  public SecondBowl(int fallenPins, BowlPin firstBowlPin) {
    super(fallenPins);
    if (firstBowlPin.getPins() == 10) {
      throw new IllegalArgumentException("해당 프레임은 이미 종료되었습니다.");
    }

    this.firstBowlPin = firstBowlPin;

    if (fallenBowlPin.isSpare(firstBowlPin)) {
      bowlState = BowlState.SPARE;
    }

    if (fallenBowlPin.isGutter()) {
      bowlState = BowlState.GUTTER;
    }
  }
}
