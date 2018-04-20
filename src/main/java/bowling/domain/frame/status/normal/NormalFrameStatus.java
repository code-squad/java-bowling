package bowling.domain.frame.status.normal;

import bowling.domain.frame.score.Score;

public interface NormalFrameStatus {

    NormalFrameStatus bowl(int pins);

    boolean isComplete();

    Score createScore();

    int updateScore(Score score);

    boolean isStrike();

    @Override
    String toString();
}