package domain;

import domain.state.BowlState;

public class SecondBowl {

  private BowlPin fallenBowlPin;
  private FirstBowl firstBowl;
  private BowlState bowlState = BowlState.MISS;

  public SecondBowl(int fallenPins, FirstBowl firstBowl) {
    if (firstBowl.getFallenBowlPin() == 10) {
      throw new IllegalArgumentException("해당 프레임은 이미 종료되었습니다.");
    }

    this.fallenBowlPin = new BowlPin(fallenPins);
    this.firstBowl = firstBowl;

    if (isSpare()) {
      bowlState = BowlState.SPARE;
    }

    if (isGutter()) {
      bowlState = BowlState.GUTTER;
    }
  }

  private boolean isGutter() {
    return getSumFallenBowlPin() == 0;
  }

  private boolean isSpare() {
    return getSumFallenBowlPin() == 10;
  }

  private int getSumFallenBowlPin() {
    return getFallenBowlPin() + firstBowl.getFallenBowlPin();
  }

  public int getFallenBowlPin() {
    return fallenBowlPin.getPins();
  }

  public BowlState getBowlState() {
    return bowlState;
  }
}
