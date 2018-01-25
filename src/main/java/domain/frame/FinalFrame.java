package domain.frame;

import domain.BowlPin;
import domain.state.NoneState;
import domain.state.State;

public class FinalFrame implements Frame {

  private State state;

  public FinalFrame() {
    this.state = new NoneState(this);
  }

  @Override
  public void changeState(State state) {
    this.state = state;
  }

  @Override
  public void roll(BowlPin bowlPin) {
    state.roll(bowlPin);
  }

  @Override
  public int getScore() {

    return state.getScore();
  }

  @Override
  public boolean isFrameEnd() {
    return state.isEnd();
  }

  @Override
  public String getResult() {
    return state.toString();
  }

  @Override
  public boolean isFinalFrame() {
    return true;
  }
}
