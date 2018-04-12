package domain;

public class NormalFrame extends Frame {
    private int pins;  //남은 핀 개수
    private int firstPins = UNPLAYED;  //1투구 쓰러트린 핀 개수
    private int secondPins = UNPLAYED; //2투구 쓰러트린 핀 개수

    public NormalFrame(int frameNo) {
        this(UNPLAYED, UNPLAYED, frameNo);
    }

    public NormalFrame(int firstPins, int secondPins, int frameNo) {
        super(frameNo);
        pins = TEN_PINS;
        this.firstPins = firstPins;
        this.secondPins = secondPins;
    }

    @Override
    public int getThrowing(int pinCount) {
        isValidCount(pins, pinCount);
        if (isFirst()) {
            firstPins = pinCount;
            return pins = getFallenPin(pins, pinCount);
        }
        secondPins = pinCount;
        return pins = getFallenPin(pins, pinCount);
    }

    public boolean isFirst() {
        return firstPins == UNPLAYED && secondPins == UNPLAYED;
    }

    public boolean isSecond() {
        return firstPins != UNPLAYED && secondPins == UNPLAYED;
    }

    public boolean isEnd() {
        if (firstPins == TEN_PINS) {
            return true;
        }
        if (secondPins != UNPLAYED) {
            return true;
        }
        return false;
    }

    public boolean isStrike(int currPins, int nextPins) {
        return currPins == TEN_PINS && nextPins == UNPLAYED;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String first = String.valueOf(firstPins);
        String middle = "|";
        String second = "";

        if (isStrike(firstPins, secondPins)) {
            return STRIKE;
        }
        if (isGutter(firstPins)) {
            first = GUTTER;
        }
        if (isGutter(secondPins)) {
            second = GUTTER;
        }
        if (isSpare(firstPins, secondPins)) {
            second = SPARE;
        }
        if (isOpen(firstPins, secondPins)) {
            second = String.valueOf(secondPins);
        }

        sb.append(first);
        sb.append(middle);
        sb.append(second);
        return sb.toString();
    }
}
