package domain.frame;

import domain.Referee;
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

    public abstract Optional<Frame> playNextFrame(Referee referee);
}
