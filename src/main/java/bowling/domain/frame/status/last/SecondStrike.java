package bowling.domain.frame.status.last;

import bowling.domain.frame.score.Score;

public class SecondStrike extends LastIncomplete {

    public LastFrameStatus bowl(int pins) {
        if (pins == 10) {
            return new SecondStrike();
        }
        return new StrikeMiss(pins);
    }

    @Override
    public Score createScore() {
        return Score.ofStrike();
    }

    @Override
    public int updateScore(Score score) {

    }

    @Override
    public String toString() {
        return "|X";
    }
}
