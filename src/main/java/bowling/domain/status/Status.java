package bowling.domain.status;

import bowling.domain.score.Score;

public interface Status {

    Status bowl(int pins);

    boolean isComplete();

    Score createScore();

    int updateScore(Score score);

    boolean isStrike();
}