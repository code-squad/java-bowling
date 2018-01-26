package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Miss implements State {

  private BowlPin firstBowlPins;
  private BowlPin secondBowlPins;

  public Miss(BowlPin firstBowlPins, BowlPin secondBowlPins) {
    this.firstBowlPins = firstBowlPins;
    this.secondBowlPins = secondBowlPins;
  }

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {
  }

  @Override
  public boolean isEnd(Frame frame) {
    return true;
  }

  @Override
  public int getScore() {
    return firstBowlPins.getPins() + secondBowlPins.getPins();
  }

  @Override
  public String toString() {
    return firstBowlPins + "|" + secondBowlPins;
  }
}
