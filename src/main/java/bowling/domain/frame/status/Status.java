package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

public interface Status {
    int ALL = 10;
    int NONE = 0;

    Status bowl(int pins);

    boolean isComplete();

    boolean isPlayed();

    Score createScore();

    void updateScore(Score score);

    boolean isStrike();

    boolean isSpare();

    @Override
    String toString();
}