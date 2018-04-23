package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

public class LastFrameStatus {
    private Status first = new NotPlayed();
    private Status second = new NotPlayed();
    private Status third = new NotPlayed();

    public void bowl(int pins) {
        if (!first.isPlayed()) {
            first = first.bowl(pins);
            return;
        }
        if (!second.isPlayed()) {
            second = second.bowl(pins);
            return;
        }
        third = third.bowl(pins);
    }

    public boolean isComplete() {
        if (second.isPlayed() &&
                (!first.isStrike() && !second.isSpare())) {
            return true;
        }
        return (first.isStrike() || second.isSpare())
                && third.isPlayed();
    }

    public Score createScore() {
        Score score = first.createScore();
        second.updateScore(score);
        third.updateScore(score);
        return score;
    }

    public void updateScoresFromPreviousFrames(Score prevPrev) {
        if (prevPrev.onlyFirstBowlNeeded()) {
            first.updateScore(prevPrev);
            return;
        }
        first.updateScore(prevPrev);
        second.updateScore(prevPrev);
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