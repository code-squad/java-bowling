package bowling.domain.frame;

import bowling.domain.score.Score;

public interface Frame {

    void bowl(int pins);

    void calculateScore(Frame next, Frame nextNext);

    void calculateAdditionalScore(Score score);

    boolean isStrike();

    boolean isPlayedOnce();
}
