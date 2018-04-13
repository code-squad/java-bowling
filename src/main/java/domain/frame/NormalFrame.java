package domain.frame;

public class NormalFrame extends Frame {

    public NormalFrame(int frameNum) {
        super(frameNum);
    }

    @Override
    Frame doRecord(FrameScore score, int num) throws IllegalArgumentException {
        score.roll(num);
        if (score.isRegularFinish() && score.isBeforeBonusRoll()) {
            score.increaseLeftCount();
            return Frame.of(frameNum + 1);
        }
        return this;
    }

    @Override
    boolean doCheckFinish(FrameScore score) {
        return score.isRegularFinish();
    }

    @Override
    public boolean isLast() {
        return false;
    }
}
