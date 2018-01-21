package domain;

import domain.state.BowlState;

public class FirstBowl {

  private BowlPin fallenBowlPin;
  private BowlState bowlState;

  public FirstBowl(int fallenPins) {
    this.fallenBowlPin = new BowlPin(fallenPins);
    if (isStrike(fallenPins)) {
      bowlState = BowlState.STRIKE;
    }
  }

  private boolean isStrike(int fallenPins) {
    return fallenPins == 10;
  }

  public int getFallenBowlPin() {
    return fallenBowlPin.getPins();
  }

  public BowlState getBowlState() {
    return bowlState;
  }
}
