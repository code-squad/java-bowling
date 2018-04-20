package domain;

public abstract class Frame {
    private FrameNo frameNo;
    protected Pin firstRoll;
    protected Pin secondRoll;

    public Frame(FrameNo frameNo) {
        this.frameNo = frameNo;
    }

    public abstract void roll(int fallingPinNum);

    public abstract boolean isEndFrame();

    public void setFallingPinNum(int fallingPinNum) {
        if (firstRoll == null) {
            firstRoll = new Pin(fallingPinNum);
            return;
        }
        setSecondFallingPinNum(fallingPinNum);
    }


    private void setSecondFallingPinNum(int fallingPinNum) {
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
        return firstRoll.totalPins(secondRoll);
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

    public int getCurrentFrameNo() {
        return getCurrentFrame().getFrameNo();
    }

    public int getFrameNo() {
        return frameNo.getNo();
    }

    public abstract Frame getNextFrame();

}