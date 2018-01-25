package domain.frame;

import domain.BowlPin;
import domain.state.NoneState;
import domain.state.State;

public class NormalFrame implements Frame {

  private State state;

  public NormalFrame() {
    state = new NoneState(this);
  }

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

  public String getResult() {
    return state.toString();
  }

  @Override
  public boolean isFinalFrame() {
    return false;
  }

}
