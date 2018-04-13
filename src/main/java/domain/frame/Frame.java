package domain.frame;

public abstract class Frame {
    public static final int REGULAR_COUNT = 2;
    public final int frameNum;
    private FrameScore score;

    public Frame(int frameNum) {
        this.frameNum = frameNum;
        score = new FrameScore(REGULAR_COUNT);
    }

    public static Frame of(int frameNum) {
        if (Frames.isLimit(frameNum)) {
            return new LastFrame(frameNum);
        }
        return new NormalFrame(frameNum);
    }

    public Frame roll(int num) throws IllegalArgumentException {
        return doRecord(score, num);
    }

    public void bonusRoll(int num) throws IllegalArgumentException {
        if (score.isRegularFinish() && score.isBonusFinish()) {
            score.roll(num);
        }
    }

    public FrameScore getScore() throws RuntimeException {
        return score.get();
    }

    public String getPinMessage() {
        return score.getPinMessage();
    }

    abstract Frame doRecord(FrameScore score, int num);

    public boolean isFinish() {
        return doCheckFinish(score);
    }

    public boolean isBonusFinish() {
        return score.isBonusFinish();
    }

    abstract boolean doCheckFinish(FrameScore score);

    public abstract boolean isLast();

    public int getFrameNum() {
        return frameNum;
    }

    public boolean isDiffFrame(Frame ohterFrame) {
        return this != ohterFrame;
    }
}
