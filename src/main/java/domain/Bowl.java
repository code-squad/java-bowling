package domain;

import domain.state.BowlState;

public class Bowl {

  protected BowlPin fallenBowlPin;
  protected BowlState bowlState;

  public Bowl(int fallenPins) {
    this.fallenBowlPin = new BowlPin(fallenPins);
    if (fallenBowlPin.isStrike()) {
      bowlState = BowlState.STRIKE;
    }

    if (fallenBowlPin.isGutter()) {
      bowlState = BowlState.GUTTER;
    }
  }

  protected BowlPin getFallenBowlPin() {
    return fallenBowlPin;
  }

  public BowlState getBowlState() {
    return bowlState;
  }

  public String getResult() {
    String result = bowlState.getSymbol();
    return result.isEmpty() ? getFallenBowlPin() + "" : result;
  }
}
