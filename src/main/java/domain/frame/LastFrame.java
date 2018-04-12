package domain.frame;

public class LastFrame extends Frame {

    public LastFrame(int frameNum) {
        super(frameNum);
    }

    @Override
    Frame doRecord(FrameScore score, int num) {
        score.roll(num);
        if (score.isBeforeBonusRoll()) {
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
