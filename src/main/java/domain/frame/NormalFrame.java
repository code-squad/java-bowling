package domain.frame;

import domain.score.Score;

public class NormalFrame extends Frame {

    public NormalFrame(Score score, int frameNo) {
        super(score, frameNo);
        if (frameNo < 0 || frameNo > 9) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    boolean isFinal() {
        return false;
    }

    @Override
    Frame nextFrame(Score score) {
        if (frameNo == 9) {
            return new FinalFrame(score, getNextFrameNo());
        }
        return new NormalFrame(score, getNextFrameNo());
    }
}
