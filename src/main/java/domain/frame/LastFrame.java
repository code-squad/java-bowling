package domain.frame;

import domain.frame.score.FrameScore;

public class LastFrame extends Frame {

    public LastFrame(int frameNum) {
        super(frameNum);
    }

    @Override
    Frame doRecord(FrameScore score, int num) throws IllegalArgumentException {
        // 좀 다르지않을까?
        score.roll(num);
        if (score.isRegularFinish() && score.isBeforeBonusRoll()) {
            score.increaseLeftCount();
        }
        return this;
    }

    @Override
    boolean doCheckFinish(FrameScore score) {
        return score.isRegularFinish() && score.isBonusFinish();
    }

    @Override
    public boolean isLast() {
        return true;
    }
}
