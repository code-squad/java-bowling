package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Miss implements State {

  private BowlPin firstPins;
  private BowlPin secondPins;

  public Miss(BowlPin firstPins, BowlPin secondPins) {
    this.firstPins = firstPins;
    this.secondPins = secondPins;
  }

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {

  }

  @Override
  public boolean isCurrentFrameEnd() {
    return true;
  }

  @Override
  public int getScore() {
    return firstPins.sum(secondPins);
  }

  @Override
  public String getSymbol() {
    return null;
  }
}
