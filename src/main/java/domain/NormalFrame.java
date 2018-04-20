package domain;

public class NormalFrame extends Frame {

    private static final int NORMAL_FRAME = 9;

    private Frame nextFrame;

    public NormalFrame(int frameNo) {
        super(new FrameNo(frameNo));

        if (frameNo == NORMAL_FRAME) {
            nextFrame = new LastFrame(FrameNo.MAX);
            return;
        }
        nextFrame = new NormalFrame(frameNo + FrameNo.MIN);
    }

    @Override
    public void roll(int fallingPinNum) {
        if (isEndFrame()) {
            nextFrame.roll(fallingPinNum);
            return;
        }
        setFallingPinNum(fallingPinNum);
    }

    public boolean isEndFrame() {
        if (firstRoll != null && firstRoll.isStrike()) {
            return true;
        }
        if (firstRoll != null && secondRoll != null) {
            return true;
        }
        return false;
    }

    @Override
    public Frame getCurrentFrame() {
        if (isEndFrame()) {
            return nextFrame.getCurrentFrame();
        }
        return this;
    }

    @Override
    public boolean isEndGame() {
        return false;
    }

    @Override
    public Frame getNextFrame() {
        return nextFrame;
    }

}