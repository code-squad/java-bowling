package bowling.domain;

public abstract class Frame {
    Scores scores = new Scores();

    public boolean isStrike() {
        return scores.isStrike();
    }

    public boolean isSpare() {
        return scores.isSpare();
    }

    public abstract boolean updateScore(int pinsKnocked);

    @Override
    public abstract String toString();
}