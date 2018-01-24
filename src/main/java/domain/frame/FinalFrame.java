package domain.frame;

import domain.score.Score;

public class FinalFrame extends Frame {

    FinalFrame(Score score, int frameNo) {
        super(score, frameNo);
        if (frameNo < 10) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    boolean isFinal() {
        return true;
    }

    @Override
    Frame nextFrame(Score score) {
        return new FinalFrame(score, getNextFrameNo());
    }
}
