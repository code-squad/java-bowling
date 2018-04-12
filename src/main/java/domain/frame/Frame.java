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

    //보너스 점수가 들어올 때는 어떻게 해? 아 넥스트로부터 가져오고, 그게 다르구나 roll로 호출하는게 아니라 다른걸로 호출하나
    //여기 자체가 다른거같은데?

    abstract Frame doRecord(FrameScore score, int num);

    public boolean isFinish() {
        return doCheckFinish(score);
    }

    abstract boolean doCheckFinish(FrameScore score);
}
