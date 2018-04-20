package domain;

public class Pin {
    private static final int MIN = 0;
    private static final int MAX = 10;

    private int fallingPinNum;

    public Pin(int fallingPinNum){
        if(MIN > fallingPinNum || MAX < fallingPinNum) {
            throw new IllegalArgumentException("핀은 최소 0개 ~ 최대 10개까지 넘어트릴 수 있습니다.");
        }
        this.fallingPinNum = fallingPinNum;
    }


    public int getFallingPinNum() {
        return fallingPinNum;
    }

    public boolean isStrike() {
        if (fallingPinNum == MAX) {
            return true;
        }
        return false;
    }


    public boolean isValid(Pin firstRoll) {
        if(fallingPinNum + firstRoll.getFallingPinNum() > MAX) {
            return false;
        }
        return true;
    }

    public boolean isExistBonusRoll(Pin firstRoll) {
        if (fallingPinNum + firstRoll.getFallingPinNum() == MAX) {
            return true;
        }
        return false;
    }

    public int totalPins(Pin secondRoll) {
        return fallingPinNum + secondRoll.getFallingPinNum();
    }
}