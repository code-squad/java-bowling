package bowling.domain.frame;

import bowling.domain.score.Scores;

public class NormalFrame implements Frame {
    private Scores scores = new Scores();

    public boolean knockPins(int pinsKnocked) {
        if (!scores.firstThrowIsPlayed()) {
            scores.updateFirstThrow(pinsKnocked);
            return true;
        }
        if (!scores.secondThrowIsPlayed()) {
            scores.updateSecondThrow(pinsKnocked);
            return true;
        }
        return false;
    }

    public boolean isStrike() {
        return scores.isStrike();
    }

    public boolean isSpare() {
        return scores.isSpare();
    }

    @Override
    public String toString() {
        return " " + scores.toString();
    }
}