package domain;


public class LastFrame extends Frame {
    private Pin bonusRoll;

    public LastFrame(int frameNo) {
        super(new FrameNo(frameNo));
    }

    @Override
    public void roll(int fallingPinNum) {
        if (isExistBonusRoll()) {
            bonusRoll = new Pin(fallingPinNum);
        }
        setFallingPinNum(fallingPinNum);
    }

    @Override
    public Frame getCurrentFrame() {
        return this;
    }

    @Override
    public boolean isEndGame() {
        return isEndFrame();
    }

    @Override
    public boolean isEndFrame() {
        if (bonusRoll != null) {
            return true;
        }

        // 스페어, 스트라이크가 아닌 경우
        if (!isFirstRollNull() && !isSecondRollNull() && getFrameScore() < 10) {
            return true;
        }
        return false;
    }

    @Override
    public int getCurrentFrameNo() {
        return getCurrentFrame().getFrameNo();
    }

    @Override
    public Frame getNextFrame() {
        return this;
    }

    public boolean isBonusRollNull() {
        return bonusRoll == null;
    }

    public int getBonusRoll() {
        return bonusRoll.getFallingPinNum();
    }
}