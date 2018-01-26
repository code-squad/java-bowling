package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Spare implements State {

  private BowlPin firstBowlPins;
  private BowlPin secondBowlPins;

  public Spare(BowlPin firstBowlPins, BowlPin secondBowlPins) {
    this.firstBowlPins = firstBowlPins;
    this.secondBowlPins = secondBowlPins;
  }

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {
    if (frame.isFinalFrame()) {
      frame.changeState(new Bonus(firstBowlPins, secondBowlPins, fallenPins));
    }
  }

  @Override
  public boolean isEnd(Frame frame) {
    if (frame.isFinalFrame()) {
      return false;
    }
    return true;
  }

  @Override
  public int getScore() {
    return firstBowlPins.sum(secondBowlPins);
  }

  @Override
  public String toString() {
    return firstBowlPins + "|/";
  }
}
