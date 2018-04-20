package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

public interface Status {

    Status bowl(int pins);

    boolean isComplete();

    Score createScore();

    int updateScore(Score score);

    boolean isStrike();

    @Override
    String toString();
}