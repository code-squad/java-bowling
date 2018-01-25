package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class NoneState implements State {

  private Frame frame;
  private BowlPin firstBowlPins;

  public NoneState(Frame frame) {
    this.frame = frame;
  }

  public NoneState(BowlPin firstBowlPins) {
    this.firstBowlPins = firstBowlPins;
  }

  @Override
  public void roll(BowlPin fallenPins) {
    if (hasFirstBowlPins()) {
      if (fallenPins.isSpare(firstBowlPins)) {
        frame.changeState(new Spare(frame, firstBowlPins, fallenPins));
        return;
      }

      if (fallenPins.isGutter()) {
        frame.changeState(new Gutter(frame, firstBowlPins, fallenPins));
        return;
      }

      frame.changeState(new Miss(frame, firstBowlPins, fallenPins));
      return;
    }

    if (fallenPins.isStrike()) {
      frame.changeState(new Strike(frame, fallenPins));
      return;
    }

    if (fallenPins.isGutter()) {
      frame.changeState(new Gutter(frame, fallenPins));
      return;
    }

    firstBowlPins = fallenPins;
  }

  private boolean hasFirstBowlPins() {
    return firstBowlPins != null;
  }

  @Override
  public boolean isEnd() {
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
