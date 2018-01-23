package bowling.domain.frame;

import bowling.domain.score.Score;

public interface Frame {
    boolean isEnd();

    Frame nextRound(Score score);

    String result();
}
