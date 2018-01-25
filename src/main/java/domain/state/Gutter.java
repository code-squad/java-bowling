package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Gutter implements State {

  private Frame frame;
  private BowlPin firstBowlPins;
  private BowlPin secondBowlPins;

  public Gutter(Frame frame, BowlPin firstBowlPins) {
    this.frame = frame;
    this.firstBowlPins = firstBowlPins;
  }

  public Gutter(Frame frame, BowlPin firstBowlPins, BowlPin secondBowlPins) {
    this.frame = frame;
    this.firstBowlPins = firstBowlPins;
    this.secondBowlPins = secondBowlPins;
  }

  @Override
  public void roll(BowlPin fallenPins) {
    if (fallenPins.isSpare(firstBowlPins)) {
      frame.changeState(new Spare(frame, firstBowlPins, fallenPins));
      return;
    }

    if (fallenPins.isGutter()) {
      frame.changeState(new Gutter(frame, firstBowlPins, fallenPins));
      return;
    }

    frame.changeState(new Miss(frame, firstBowlPins, fallenPins));
  }

  @Override
  public boolean isEnd() {
    return hasSecondBowlPins();
  }

  @Override
  public int getScore() {
    return hasSecondBowlPins() ? firstBowlPins.sum(secondBowlPins) : firstBowlPins.getPins();
  }

  @Override
  public String toString() {
    return hasSecondBowlPins() ? firstBowlPins + "|" + secondBowlPins : firstBowlPins + "";
  }

  private boolean hasSecondBowlPins() {
    return secondBowlPins != null;
  }
}
