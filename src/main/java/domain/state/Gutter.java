package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Gutter implements State {

  private BowlPin firstBowlPins;
  private BowlPin secondBowlPins;

  public Gutter(BowlPin firstBowlPins) {
    this.firstBowlPins = firstBowlPins;
  }

  public Gutter(BowlPin firstBowlPins, BowlPin secondBowlPins) {
    this.firstBowlPins = firstBowlPins;
    this.secondBowlPins = secondBowlPins;
  }

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {
    if (fallenPins.isSpare(firstBowlPins)) {
      frame.changeState(new Spare(firstBowlPins, fallenPins));
      return;
    }

    if (fallenPins.isGutter()) {
      frame.changeState(new Gutter(firstBowlPins, fallenPins));
      return;
    }

    frame.changeState(new Miss(firstBowlPins, fallenPins));
  }

  @Override
  public boolean isEnd(Frame frame) {
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
