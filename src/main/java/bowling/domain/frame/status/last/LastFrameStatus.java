package bowling.domain.frame.status.last;

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

    private boolean firstIsNotPlayed() {
        return first.isNotPlayed();
    }

    private boolean secondIsNotPlayed() {
        return second.isNotPlayed();
    }

    private boolean thirdIsNotPlayed() {
        return third.isNotPlayed();
    }

    public Status bowl(int pins) {
        if (firstIsNotPlayed()) {
            return first = first.bowl(pins);
        }
        if (secondIsNotPlayed()) {
            return second = first.bowl(pins);
        }
        return third = second.bowl(pins);
    }

    public boolean isComplete() {
        if (!secondIsNotPlayed() && (!first.isStrike() && !second.isSpare())) {
            return true;
        }
        return (first.isStrike() || second.isSpare()) && !thirdIsNotPlayed();
    }

    @Override
    public String toString() {
        if (!thirdIsNotPlayed()) {
            return first.toString() + "|" + second.toString() + "|" + third.toString();
        }
        if (!secondIsNotPlayed()) {
            return first.toString() + "|" + second.toString();
        }
        if (!firstIsNotPlayed()) {
            return first.toString();
        }
        return "";
    }

    public boolean updateScoresFromPreviousFrames(Score prevPrev) {
        if (prevPrev.onlyFirstBowlNeeded()) {
            System.out.println(prevPrev.count); //2
            prevPrev.bowl(first.getScore());
            System.out.println(prevPrev.count); //1
            return true;
        }
        if (prevPrev.twoMoreBowlsNeeded()) {
            prevPrev.bowl(first.getScore());
            prevPrev.bowl(second.getScore());
            return true;
        }
        return false;
    }

    public boolean updateLastFrameScore(Score score) {
        if (thirdIsNotPlayed()) {
            score.updateLastFrameScore(first.getScore());
            score.updateLastFrameScore(second.getScore());
            return true;
        }
        score.updateLastFrameScore(first.getScore());
        score.updateLastFrameScore(second.getScore());
        score.updateLastFrameScore(third.getScore());
        return true;
    }
}