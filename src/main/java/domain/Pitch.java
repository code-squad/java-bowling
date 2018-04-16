package domain;

public class Pitch {
    private int pinCount;
    private int startPinCount;

    public Pitch(int startPinCount, int pinCount) {
        if (startPinCount < pinCount) {
            throw new IllegalArgumentException("쓰러뜨린 핀수는 투구 시작 전 남아있는 핀수보다 작거나 같아야 한다.");
        }
        this.startPinCount = startPinCount;
        this.pinCount = pinCount;
    }

    public boolean isRemained() {
        return startPinCount - pinCount > 0;
    }

    public int getRemainPinCount() {
        return startPinCount - pinCount;
    }

    public boolean isClear() {
        return startPinCount - pinCount == 0;
    }
}
