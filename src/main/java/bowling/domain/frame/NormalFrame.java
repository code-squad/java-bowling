package bowling.domain.frame;

import bowling.domain.score.Score;
import bowling.domain.status.Status;

public class NormalFrame implements Frame {
    private final int frameNumber;
    private Status status;
    private Score score;

    public NormalFrame(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public void bowl(int pins) {
        status = status.bowl(pins);
        if (status.isComplete()) {
            score = status.createScore();
        }
    }

    public void calculateScore(Frames frames) {
        if (score.countUntilCalcIsZero()) {
            status.getBothBowl();
        }
        if (score.countUntilCalcIsOne()) {
            frames.getNext(frameNumber).calculateAdditionalScore(score);
        }
        frames.getNextNext(frameNumber).calculateAdditionalScore(score);
    }

    public void calculateAdditionalScore(Score prevScore) {
        if (!status.isComplete()) {
            throw new FrameNotCompleteException();
        }
        if (prevScore.countUntilCalcIsOne()) {
            prevScore.bowl(status.getFirstBowl());
        }
        //if (prevScore.countUntilCalcIsZero()) {
        prevScore.bowl(status.getBothBowl());
        //}
    }
}