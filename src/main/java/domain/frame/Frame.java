package domain.frame;

import domain.Referee;
import domain.score.FirstScore;
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

    Frame playFrame(Referee referee) {
        FirstScore firstScore = referee.playFirstScore(frameNo);
        if (firstScore.isStrike()) {
            return nextFrame(new TotalScore(firstScore));
        }
        Frame frame = nextFrame(referee.playSecondScore(frameNo, firstScore));
        referee.reportFrameResult(frame);
        return frame;
    }

    Frame playOnlyFirst(Referee referee) {
        FirstScore firstScore = referee.playFirstScore(getNextFrameNo());
        if (firstScore.isStrike()) {
            return nextFrame(new TotalScore(firstScore));
        }
        return nextFrame(new TotalScore(firstScore, 0));
    }

    int getNextFrameNo() {
        return frameNo + 1;
    }

    public abstract Optional<Frame> playNextFrame(Referee referee);

    public abstract Frame nextFrame(TotalScore totalScore);

    @Override
    public String toString() {
        return totalScore.toString();
    }
}
