package bowling.domain.frame.status.last;

import bowling.domain.frame.score.LastFrameScore;
import bowling.domain.frame.score.Score;

public class LastFrameStatus {
    private Status first;
    private Status second;
    private Status third;

    public LastFrameStatus() {
        this.first = new NotPlayed();
        this.second = new NotPlayed();
        this.third = new NotPlayed();
    }

    private boolean firstIsPlayed() {
        return first.isPlayed();
    }

    private boolean secondIsPlayed() {
        return second.isPlayed();
    }

    private boolean thirdIsPlayed() {
        return third.isPlayed();
    }

    public Status bowl(int pins) {
        if (!firstIsPlayed()) {
            return first = first.bowl(pins);
        }
        if (!secondIsPlayed()) {
            return second = first.bowl(pins);
        }
        return third = second.bowl(pins);
    }

    public boolean isComplete() {
        if (secondIsPlayed() &&
                (!first.isStrike() && !second.isSpare())) {
            return true;
        }
        return (first.isStrike() || second.isSpare())
                && thirdIsPlayed();
    }

    private int getScores() {
        return first.getScore()
                + second.getScore()
                + third.getScore();
    }

    public LastFrameScore createScore() {
        if (isComplete()) {
            return LastFrameScore.ofReady(getScores());
        }
        return LastFrameScore.ofNotReady(getScores());
    }

    public boolean updateScoresFromPreviousFrames(Score prevPrev) {
        if (prevPrev.onlyFirstBowlNeeded()) {
            prevPrev.bowl(first.getScore());
            return true;
        }
        if (prevPrev.twoMoreBowlsNeeded()) {
            prevPrev.bowl(first.getScore());
            prevPrev.bowl(second.getScore());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (thirdIsPlayed()) {
            return first.toString()
                    + "|"
                    + second.toString()
                    + "|"
                    + third.toString();
        }
        if (secondIsPlayed()) {
            return first.toString()
                    + "|"
                    + second.toString();
        }
        if (firstIsPlayed()) {
            return first.toString();
        }
        return "";
    }
}