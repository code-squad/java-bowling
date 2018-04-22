package bowling.domain.frame.normal.status;

import bowling.domain.frame.normal.score.Score;

public interface Status {
    int ALL = 10;

    Status bowl(int pins);

    boolean isComplete();

    Score createScore();

    boolean updateScore(Score score);

    boolean isStrike();

    @Override
    String toString();
}