package bowling.domain.frame.status.last;

import bowling.domain.frame.score.Score;

public class LastFrameStatus {
    private Status first;
    private Status second;
    private Status third;

    private boolean firstIsNotPlayed() {
        return first == null;
    }

    private boolean secondIsNotPlayed() {
        return second == null;
    }

    private boolean thirdIsNotPlayed() {
        return third == null;
    }

    public void bowl(int pins) {
        if (firstIsNotPlayed()) {
            first = new NotPlayed();
        }
        if (secondIsNotPlayed()) {
            second = first.bowl(pins);
        }
        if (thirdIsNotPlayed()) {
            third = second.bowl(pins);
        }
    }

    public boolean isComplete() {
        if (!secondIsNotPlayed() && (!first.isStrike() || !second.isSpare())) { //null pointer?
            return true;
        }
        return !thirdIsNotPlayed();
    }

    public int calculateScore() {
        return first.getScore() + second.getScore() + third.getScore();
    }

    @Override
    public String toString() {
        if (thirdIsNotPlayed()) {
            return first + "|" + second;
        }
        return first + "|" + second + "|" + third;
    }

    public int updateScore(Score prevPrev) {
        if (prevPrev.oneMoreBowlNeeded()) {
            return first.getScore();
        }
        return first.getScore() + second.getScore();
    }
}