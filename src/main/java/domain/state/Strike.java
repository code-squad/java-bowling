package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Strike implements State {

  private BowlPin firstBowlPins;

  public Strike(BowlPin firstBowlPins) {
    this.firstBowlPins = firstBowlPins;
  }

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {
    if (frame.isFinalFrame()) {
      frame.changeState(new Bonus(firstBowlPins, fallenPins));
      return;
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
    return firstBowlPins.getPins();
  }

  @Override
  public String toString() {
    return firstBowlPins + "";
  }
}
