package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class NoneState implements State {

  private BowlPin firstBowlPins;

  public NoneState() {}

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {
    if (hasFirstBowlPins()) {
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
  }

  private boolean hasFirstBowlPins() {
    return firstBowlPins != null;
  }

  @Override
  public boolean isEnd(Frame frame) {
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
