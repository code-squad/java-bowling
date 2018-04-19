package bowling.domain.status;

import bowling.domain.score.Score;

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

    public Score createScore() {
        return Score.ofNormal(first);
    }

    public int updateScore(Score score) {
        if (score.twoMoreBowlsNeeded()) { //점수 두 개를 필요로 하는데 현 상태는 incomplete
            throw new FrameNotCompleteException();
        }
        return score.bowl(first);
    }
}