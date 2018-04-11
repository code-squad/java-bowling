package domain;

public abstract class Frame {
    Scores scores;

    public Frame() {
        this.scores = new Scores();
    }

    public boolean isStrike() {
        return scores.isStrike();
    }

    public boolean isSpare() {
        return scores.isSpare();
    }

    public abstract void updateScore(int pinsKnocked);
}
