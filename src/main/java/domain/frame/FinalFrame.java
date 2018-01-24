package domain.frame;

import domain.BowlPin;
import domain.state.State;

public class FinalFrame implements Frame {

  @Override
  public void changeState(State state) {

  }

  @Override
  public Frame roll(BowlPin bowlPin) {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }

  @Override
  public boolean isFrameEnd() {
    return false;
  }

  @Override
  public String getResult() {
    return null;
  }
}
