package bowling.domain.frame;

import bowling.domain.score.Score;

public interface Frame {
    int FINAL_FRAME = 10;

    boolean isEnd();

    Frame nextRound(Score score);

    String result();
}
