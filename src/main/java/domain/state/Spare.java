package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Spare implements State {

  private BowlPin firstBowlPin;
  private BowlPin secondBowlPin;

  public Spare(BowlPin firstBowlPin, BowlPin secondBowlPin) {
    this.firstBowlPin = firstBowlPin;
    this.secondBowlPin = secondBowlPin;
  }

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {}

  @Override
  public boolean isCurrentFrameEnd() {
    return true;
  }

  @Override
  public int getScore() {
    System.out.println("firstBowlPin = " + firstBowlPin);
    System.out.println("secondBowlPin = " + secondBowlPin);
    return firstBowlPin.sum(secondBowlPin);
  }

  @Override
  public String getSymbol() {
    return "/";
  }
}
