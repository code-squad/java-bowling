package bowling.domain.status;

import bowling.domain.score.Score;

public class AllPlayed extends Complete {
    private final int first;
    private final int second;

    public AllPlayed(int first, int pins) {
        this.first = first;
        this.second = pins;
    }

    public Status bowl(int pins) {
        return this;
    }

    public Score createScore() {
        return Score.ofNormal(first + second);
    }

    public void updateScore(Score score) {
        score.bowl(first + second);
    }
}