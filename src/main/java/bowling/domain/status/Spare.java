package bowling.domain.status;

import bowling.domain.score.Score;

public class Spare extends Complete {
    private final int first;
    private final int second;

    public Spare(int first, int pins) {
        this.first = first;
        this.second = pins;
    }

    public Status bowl(int pins) {
        return this;
    }

    public Score createScore() {
        return Score.ofSpare();
    }

    public void updateScore(Score score) {
        score.bowl(first + second);
    }
}