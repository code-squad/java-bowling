package domain;

public class Frame {
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

    @Override
    public String toString() {
        return scores.toString() + " |";
    }
}