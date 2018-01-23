package domain;

import domain.score.Score;

public interface PlayStrategy {
    Score play(int frameNo);
}
