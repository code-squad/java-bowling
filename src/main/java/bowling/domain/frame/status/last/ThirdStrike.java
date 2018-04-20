package bowling.domain.frame.status.last;

import bowling.domain.frame.score.Score;

public class ThirdStrike extends LastComplete {

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