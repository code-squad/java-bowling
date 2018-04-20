package bowling.domain.frame.status.last;

import bowling.domain.frame.score.Score;

public interface LastFrameStatus {

    boolean isComplete();

    Score createScore();

    int updateScore(Score score);

    @Override
    String toString();
}
