package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

class Strike extends Complete {

    @Override
    public Status bowl(int pins) {
        return this;
    }

    @Override
    public Score createScore() {
        return Score.ofStrike();
    }

    @Override
    public void updateScore(Score score) {
        score.bowl(ALL);
    }

    @Override
    public boolean isStrike() {
        return true;
    }

    @Override
    public boolean isSpare() {
        return false;
    }

    @Override
    public boolean isMiss() {
        return false;
    }

    @Override
    public String toString() {
        return "X";
    }
}