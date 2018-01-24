package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public class Gutter implements State {

  private int seqNo;
  private BowlPin bowlPinZero;

  public Gutter() {
    bowlPinZero = new BowlPin(0);
    seqNo++;
  }

  @Override
  public void roll(Frame frame, BowlPin fallenPins) {
    if (fallenPins.isSpare(bowlPinZero)) {
      frame.changeState(new Spare(bowlPinZero, fallenPins));
      return;
    }

    if (fallenPins.isGutter()) {
      seqNo++;
      return;
    }

    frame.changeState(new Miss(bowlPinZero, fallenPins));
  }

  @Override
  public boolean isCurrentFrameEnd() {
    return seqNo == 2;
  }

  @Override
  public int getScore() {
    return 0;
  }

  @Override
  public String getSymbol() {
    return "-";
  }
}
