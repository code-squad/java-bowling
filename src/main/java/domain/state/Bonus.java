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

  @Override
  public void roll(BowlPin fallenPins) {
    this.secondBowlPins = fallenPins;
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
    return hasSecondBowlPins() ? spareDisplay() : firstBowlPins + "";
  }

  private String spareDisplay() {
    if (firstBowlPins.isSpare(secondBowlPins)) {
      return firstBowlPins + "|/";
    }
    return firstBowlPins + "|" + secondBowlPins;
  }

  private boolean hasSecondBowlPins() {
    return secondBowlPins != null;
  }
}
