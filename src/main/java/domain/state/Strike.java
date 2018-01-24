package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Strike implements State {

  private BowlPin fallenPins;

  public Strike(BowlPin fallenPins) {
    this.fallenPins = fallenPins;
  }

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {}

  @Override
  public boolean isFrameEnd() {
    return true;
  }

  @Override
  public int getScore() {
    return 10;
  }

  @Override
  public String toString() {
    return fallenPins + "";
  }
}
