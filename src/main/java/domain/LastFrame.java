package domain;

public class LastFrame extends Frame {
    private int pins;  //남은 핀 개수
    private int firstPins = UNPLAYED;  //1투구 쓰러트린 핀 개수
    private int secondPins = UNPLAYED; //2투구 쓰러트린 핀 개수
    private int thirdPins = UNPLAYED;  //3투구 쓰러트린 핀 개수

    public LastFrame(int frameNo) {
        super(frameNo);
        pins = TEN_PINS;
    }

    @Override
    public int getThrowing(int pinCount) {
        isValidCount(pins, pinCount);
        if (isFirst()) {
            firstPins = pinCount;
            return pins = getFallenPin(pins, pinCount);
        }
        if (isSecond()) {
            secondPins = pinCount;
            return pins = getFallenPin(pins, pinCount);
        }
        thirdPins = pinCount;
        return pins = getFallenPin(pins, pinCount);
    }

    @Override
    public boolean isFirst() {
        return firstPins == UNPLAYED && secondPins == UNPLAYED && thirdPins == UNPLAYED;
    }

    @Override
    public boolean isSecond() {
        return firstPins != UNPLAYED && secondPins == UNPLAYED && thirdPins == UNPLAYED;
    }

    public boolean isThird() {
        return firstPins != UNPLAYED && secondPins != UNPLAYED && thirdPins == UNPLAYED;
    }

    public boolean isOver() {
        return firstPins != UNPLAYED && secondPins != UNPLAYED && thirdPins != UNPLAYED;
    }

    @Override
    public boolean isEnd() {
        if (isOver()) {
            return true;
        }
        if (isOpen(firstPins, secondPins)) {
            return true;
        }
        return false;
    }

    public boolean isStrike(int currPins) {
        if (isOver() && currPins == TEN_PINS) {
            return true;
        }
        if (currPins == TEN_PINS) {
            pins = TEN_PINS; // 다음 투구를 위해 리셋
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String first = String.valueOf(firstPins);
        String middle = "|";
        String second = " ";
        String third = "";

        if (isStrike(firstPins)) {
            first = STRIKE;
        }
        if (isStrike(secondPins)) {
            second = STRIKE;
        }
        if (isStrike(thirdPins)) {
            third = STRIKE;
        }
        if (isGutter(firstPins)) {
            first = GUTTER;
        }
        if (isGutter(secondPins)) {
            second = GUTTER;
        }
        if (isGutter(thirdPins)) {
            third = GUTTER;
        }
        if (isSpare(firstPins, secondPins)) {
            second = SPARE;
        }
        if (!isStrike(firstPins) && isOpen(firstPins, secondPins)) {
            second = String.valueOf(secondPins);
        }

        sb.append(first);
        sb.append(middle);
        sb.append(second);
        sb.append(middle);
        sb.append(third);

        return first + middle + second + middle + third;
    }
}
