package bowling.domain.frame.status.normal;

import bowling.domain.frame.score.NormalScore;
import bowling.domain.frame.score.Score;

public class PlayedOnce extends Incomplete {
    private final int first;

    public PlayedOnce(int pins) {
        this.first = pins;
    }

    @Override
    public Status bowl(int pins) {
        if (first + pins == 10) {
            return new Spare(first, pins);
        }
        return new AllPlayed(first, pins);
    }

    @Override
    public Score createScore() {
        return Score.ofNotPlayed();
    }

    @Override
    public boolean updateScore(NormalScore normalScore) {
        if (normalScore.twoMoreBowlsNeeded()) { //점수 두 개를 필요로 하는데 현 상태는 incomplete
            return false;
        }
        normalScore.bowl(first);
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(first);
    }
}