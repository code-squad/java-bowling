package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class NoneState implements State {

  private BowlPin firstBowlPins;

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {
    if (firstBowlPins != null) {
      if (fallenPins.isSpare(firstBowlPins)) {
        frame.changeState(new Spare(firstBowlPins, fallenPins));
        return;
      }

      if (fallenPins.isGutter()) {
        frame.changeState(new Gutter(firstBowlPins, fallenPins));
        return;
      }

      frame.changeState(new Miss(firstBowlPins, fallenPins));
      return;
    }

    if (fallenPins.isStrike()) {
      frame.changeState(new Strike(fallenPins));
      return;
    }

    if (fallenPins.isGutter()) {
      frame.changeState(new Gutter(fallenPins));
      return;
    }

    firstBowlPins = fallenPins;
    frame.changeState(this);
  }

  @Override
  public boolean isFrameEnd() {
    return false;
  }

  @Override
  public int getScore() {
    return firstBowlPins.getPins();
  }

  @Override
  public String toString() {
    return firstBowlPins + "";
  }
}
