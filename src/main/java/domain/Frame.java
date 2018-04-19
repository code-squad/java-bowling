package domain;

public abstract class Frame {
    private FrameNo frameNo;
    private Pin firstRoll;
    private Pin secondRoll;

    public Frame(FrameNo frameNo) {
        this.frameNo = frameNo;
    }

    public abstract void roll(int fallingPinNum);

    public boolean isEndFrame() {
        if (firstRoll != null && firstRoll.isStrike()) {
            return true;
        }
        if (firstRoll != null && secondRoll != null) {
            return true;
        }
        return false;
    }

    public void setFallingPinNum(int fallingPinNum) {
        if (firstRoll == null) {
            firstRoll = new Pin(fallingPinNum);
            return;
        }
        setSecondFallingPinNum(fallingPinNum);
    }


    public void setSecondFallingPinNum(int fallingPinNum) {
        if (secondRoll == null) {
            secondRoll = new Pin(fallingPinNum);
            if (!secondRoll.isValid(firstRoll)) {
                throw new IllegalArgumentException("핀은 최대 10개까지 쓰러트릴 수 있습니다.");
            }
        }
    }

    public boolean isExistBonusRoll() {
        if (firstRoll != null && secondRoll != null) {
            return secondRoll.isExistBonusRoll(firstRoll);
        }
        return false;
    }

    public abstract Frame getCurrentFrame();

    public abstract boolean isEndGame();


    public int getFrameScore() {
        return getFirstRoll() + getSecondRoll();
    }

    public int getFirstRoll() {
        return firstRoll.getFallingPinNum();
    }

    public int getSecondRoll() {
        return secondRoll.getFallingPinNum();
    }

    public boolean isFirstRollNull() {
        return firstRoll == null;
    }

    public boolean isSecondRollNull() {
        return secondRoll == null;
    }

    public abstract int getCurrentFrameNo();


    public int getFrameNo() {
        return frameNo.getNo();
    }

    public abstract Frame getNextFrame();

}