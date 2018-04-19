package bowling.domain.status;

import bowling.domain.score.Score;

public class Strike extends Complete {

    public Status bowl(int pins) {
        return this;
    }

    public Score createScore() {
        return Score.ofStrike();
    }

    public void updateScore(Score score) {
        score.bowl(10);
    }
}