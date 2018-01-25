package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Spare implements State {

  private Frame frame;
  private BowlPin firstBowlPins;
  private BowlPin secondBowlPins;
  private State bonusState;

  public Spare(Frame frame, BowlPin firstBowlPins, BowlPin secondBowlPins) {
    this.frame = frame;
    this.firstBowlPins = firstBowlPins;
    this.secondBowlPins = secondBowlPins;
  }

  @Override
  public void roll(BowlPin fallenPins) {
    if (frame.isFinalFrame()) {
      this.bonusState = new Bonus(frame, fallenPins);
    }
  }

  @Override
  public boolean isEnd() {
    if (frame.isFinalFrame()) {
      return hasBonusState();
    }
    return true;
  }

  @Override
  public int getScore() {
    if (hasBonusState()) {
      return bonusState.getScore() + firstBowlPins.getPins() + secondBowlPins.getPins();
    }
    return firstBowlPins.getPins() + secondBowlPins.getPins();
  }

  @Override
  public String toString() {
    if (hasBonusState()) {
      return firstBowlPins + "|/|" + bonusState.toString();
    }
    return firstBowlPins + "|/";
  }

  private boolean hasBonusState() {
    return bonusState != null;
  }
}
