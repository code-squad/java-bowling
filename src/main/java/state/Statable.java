package state;

import domain.Score;

public interface Statable {
    String printState();
    Score getScore();
}
