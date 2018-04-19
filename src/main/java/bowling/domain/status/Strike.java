package bowling.domain.status;

import bowling.domain.score.Score;

public class Strike extends Complete {

    @Override
    public Status bowl(int pins) {
        return this;
    }

    @Override
    public Score createScore() {
        return Score.ofStrike();
    }

    @Override
    public int updateScore(Score score) {
        return score.bowl(10);
    }

    @Override
    public boolean isStrike() {
        return true;
    }
}