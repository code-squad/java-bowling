package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class NoneState implements State {

  private BowlPin firstBowlPin;

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {
    if (fallenPins.isStrike()) {
      frame.changeState(new Strike(fallenPins));
      return;
    }

    if (fallenPins.isGutter()) {
      frame.changeState(new Gutter());
      return;
    }

    if (firstBowlPin != null) {
      frame.changeState(new Miss(firstBowlPin, fallenPins));
      return;
    }

    firstBowlPin = fallenPins;
  }

  @Override
  public boolean isCurrentFrameEnd() {
    return false;
  }

  @Override
  public int getScore() {
    return firstBowlPin.getPins();
  }

  @Override
  public String getSymbol() {
    return null;
  }
}
