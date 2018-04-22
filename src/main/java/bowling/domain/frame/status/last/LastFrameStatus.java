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

    public Status bowl(int pins) {
        if (!first.isPlayed()) {
            return first = first.bowl(pins);
        }
        if (!second.isPlayed()) {
            return second = first.bowl(pins);
        }
        return third = second.bowl(pins);
    }

    public boolean isComplete() {
        if (second.isPlayed() &&
                (!first.isStrike() && !second.isSpare())) {
            return true;
        }
        return (first.isStrike() || second.isSpare())
                && third.isPlayed();
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
        if (third.isPlayed()) {
            return first.toString()
                    + "|"
                    + second.toString()
                    + "|"
                    + third.toString();
        }
        if (second.isPlayed()) {
            return first.toString()
                    + "|"
                    + second.toString();
        }
        if (first.isPlayed()) {
            return first.toString();
        }
        return "";
    }
}