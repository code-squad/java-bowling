package domain.frame;

import domain.score.Score;
import domain.score.TotalScore;

import java.util.Optional;

public abstract class Frame {
    final TotalScore totalScore;
    final int frameNo;

    Frame(TotalScore totalScore, int frameNo) {
        if (totalScore == null) {
            throw new IllegalArgumentException();
        }
        this.totalScore = totalScore;
        this.frameNo = frameNo;
    }

    void addSecondScore(Score score) {
        if (score == null) {
            throw new IllegalArgumentException();
        }
        this.totalScore.addSecondScore(score);
    }

    int getNextFrameNo() {
        return frameNo + 1;
    }

    abstract Optional<Frame> playNextFrame(BowlingGame game);

    abstract Frame nextFrame(TotalScore totalScore);

    @Override
    public String toString() {
        return String.format("%-4s", totalScore.toString());
    }
}
