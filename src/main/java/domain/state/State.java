package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public interface State {
  void roll(Frame frame, BowlPin fallenPins);
  boolean isFrameEnd();
  int getScore();
}
