package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Bonus implements State {

  private Frame frame;
  private BowlPin firstBowlPins;
  private BowlPin secondBowlPins;

  public Bonus(Frame frame, BowlPin firstBowlPins) {
    this.frame = frame;
    this.firstBowlPins = firstBowlPins;
  }

  public Bonus(Frame frame, BowlPin firstBowlPins, BowlPin secondBowlPins) {
    this.frame = frame;
    this.firstBowlPins = firstBowlPins;
    this.secondBowlPins = secondBowlPins;
  }

  @Override
  public void roll(BowlPin fallenPins) {
    if (fallenPins.isStrike()) {
      this.secondBowlPins = fallenPins;
      return;
    }
  }

  @Override
  public boolean isEnd() {
    return secondBowlPins != null;
  }

  @Override
  public int getScore() {
    if (hasSecondBowlPins()) {
      return firstBowlPins.getPins() + secondBowlPins.getPins();
    }
    return firstBowlPins.getPins();
  }

  @Override
  public String toString() {
    return hasSecondBowlPins() ? firstBowlPins + "|" + secondBowlPins : firstBowlPins + "";
  }

  private boolean hasSecondBowlPins() {
    return secondBowlPins != null;
  }
}
