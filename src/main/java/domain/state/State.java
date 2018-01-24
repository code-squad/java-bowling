package domain.state;

import domain.BowlPin;
import domain.frame.Frame;

public interface State {
  void roll(Frame frame, BowlPin fallenPins);
  boolean isCurrentFrameEnd();
  int getScore();
  String getSymbol();
}
