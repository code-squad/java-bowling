package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Bonus implements State {

  private BowlPin firstBowlPins;
  private BowlPin secondBowlPins;
  private BowlPin thirdBowlPins;

  public Bonus(BowlPin firstBowlPins, BowlPin secondBowlPins) {
    this.firstBowlPins = firstBowlPins;
    this.secondBowlPins = secondBowlPins;
  }

  public Bonus(BowlPin firstBowlPins, BowlPin secondBowlPins, BowlPin thirdBowlPins) {
    this.firstBowlPins = firstBowlPins;
    this.secondBowlPins = secondBowlPins;
    this.thirdBowlPins = thirdBowlPins;
  }

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {
    if (hasSecondBowlPins()) {
      this.thirdBowlPins = fallenPins;
      return;
    }
  }

  @Override
  public boolean isEnd(Frame frame) {
    if (hasThirdBowlPins()) {
      return true;
    }
    return firstBowlPins.isSpare(secondBowlPins);
  }

  @Override
  public int getScore() {
    if (hasThirdBowlPins()) {
      return firstBowlPins.sum(secondBowlPins) + thirdBowlPins.getPins();
    }
    return firstBowlPins.sum(secondBowlPins);
  }

  @Override
  public String toString() {
    if (hasThirdBowlPins()) {
      if (firstBowlPins.isSpare(secondBowlPins)) {
        return spareDisplay(firstBowlPins, secondBowlPins) + "|" + thirdBowlPins;
      }
      return firstBowlPins + "|" + spareDisplay(secondBowlPins, thirdBowlPins);
    }

    return spareDisplay(firstBowlPins, secondBowlPins);
  }

  private String spareDisplay(BowlPin firstBowlPins, BowlPin secondBowlPins) {
    if (firstBowlPins.isSpare(secondBowlPins)) {
      return firstBowlPins + "|/";
    }
    return firstBowlPins + "|" + secondBowlPins;
  }

  private boolean hasSecondBowlPins() {
    return secondBowlPins != null;
  }

  private boolean hasThirdBowlPins() {
    return thirdBowlPins != null;
  }
}
