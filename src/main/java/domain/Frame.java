package domain;

abstract public class Frame {
    protected static final int TEN_PINS = 10;
    protected static final int NO_PINS = 0;
    protected static final String STRIKE = "x";
    protected static final String SPARE = "/";
    protected static final String GUTTER = "-";
    protected static final String MIDDLE = "|";
    protected static final int UNPLAYED = -1;

    private int frameNo;

    public Frame(int frameNo) {
        this.frameNo = frameNo;
    }

    abstract public int getThrowing(int pinCount);

    abstract public boolean isFirst();

    abstract public boolean isSecond();

    abstract public boolean isEnd();

    protected boolean isValidCount(int pins, int pinCount) {
        if (pinCount > pins) {
            throw new RuntimeException("넘어진 핀의 개수는 남아있는 핀의 개수보다 클 수 없습니다.");
        }
        if (pinCount > TEN_PINS) {
            throw new RuntimeException("볼링 핀의 개수는 10개입니다.");
        }
        return true;
    }

    public int getFrameNo() {
        return frameNo;
    }

    protected int getFallenPin(int pins, int pinCount) {
        return pins - pinCount;
    }

    protected boolean isGutter(int currPins) {
        return currPins == NO_PINS;
    }

    protected boolean isSpare(int prevPins, int nextPins) {
        return !isSecond() && TEN_PINS - (prevPins + nextPins) == NO_PINS;
    }

    // open : spare처리 못한채로 프레임 마감
    protected boolean isOpen(int prevPins, int nextPins) {
        if (isFirst()) {
            return false;
        }
        if (isSecond()) {
            return false;
        }
        if (prevPins == NO_PINS || nextPins == NO_PINS) {
            return false;
        }
        return TEN_PINS - (prevPins + nextPins) > NO_PINS;
    }
}
