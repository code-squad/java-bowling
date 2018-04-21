package bowling.domain.frame.status.normal;

import bowling.domain.frame.score.Score;

public interface Status {

    Status bowl(int pins);

    boolean isComplete();

    Score createScore();

    boolean updateScore(Score score);

    boolean isStrike();

    @Override
    String toString();
}