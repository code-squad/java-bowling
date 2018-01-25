package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Spare implements State {

  private Frame frame;
  private BowlPin firstBowlPins;
  private BowlPin secondBowlPins;

  public Spare(Frame frame, BowlPin firstBowlPins, BowlPin secondBowlPins) {
    this.frame = frame;
    this.firstBowlPins = firstBowlPins;
    this.secondBowlPins = secondBowlPins;
  }

  @Override
  public void roll(BowlPin fallenPins) {}

  @Override
  public boolean isEnd() {
    return true;
  }

  @Override
  public int getScore() {
    return firstBowlPins.getPins() + secondBowlPins.getPins();
  }

  @Override
  public String toString() {
    return firstBowlPins + "|" + "/";
  }
}
