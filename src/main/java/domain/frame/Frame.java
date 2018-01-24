package domain.frame;

import domain.BowlPin;
import domain.state.State;

public interface Frame {
  void changeState(State state);
  Frame roll(BowlPin bowlPin);
  String getSymbol();
  int getScore();
  boolean isCurrentFrameEnd();
}
