package domain.frame;

import domain.BowlPin;
import domain.state.NoneState;
import domain.state.State;

public class NormalFrame implements Frame {

  private State state;

  public NormalFrame() {
    state = new NoneState();
  }

  public void changeState(State state) {
    this.state = state;
  }

  @Override
  public Frame roll(BowlPin bowlPin) {
    state.roll(this, bowlPin);
    return this;
  }

  @Override
  public String getSymbol() {
    return state.getSymbol();
  }

  @Override
  public int getScore() {
    return state.getScore();
  }

  @Override
  public boolean isCurrentFrameEnd() {
    return state.isCurrentFrameEnd();
  }
}
