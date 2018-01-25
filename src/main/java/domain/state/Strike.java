package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Strike implements State {

  private Frame frame;
  private BowlPin firstBowlPins;
  private State bonusState;

  public Strike(Frame frame, BowlPin firstBowlPins) {
    this.frame = frame;
    this.firstBowlPins = firstBowlPins;
  }

  @Override
  public void roll(BowlPin fallenPins) {
    if (frame.isFinalFrame()) {
      if (hasBonusState()) {
        this.bonusState.roll(fallenPins);
        return;
      }
      this.bonusState = new Bonus(frame, fallenPins);
    }
  }

  @Override
  public boolean isEnd() {
    if (frame.isFinalFrame()) {
      if (hasBonusState()) {
        return bonusState.isEnd();
      }
      return false;
    }
    return true;
  }

  @Override
  public int getScore() {
    if (hasBonusState()) {
      return bonusState.getScore() + firstBowlPins.getPins();
    }
    return firstBowlPins.getPins();
  }

  @Override
  public String toString() {
    if (hasBonusState()) {
      return firstBowlPins + "|" + bonusState.toString();
    }
    return firstBowlPins + "";
  }

  private boolean hasBonusState() {
    return bonusState != null;
  }
}
