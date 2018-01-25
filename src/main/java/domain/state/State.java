package domain.state;

import domain.BowlPin;

public interface State {
  void roll(BowlPin fallenPins);

  boolean isEnd();

  int getScore();
}
