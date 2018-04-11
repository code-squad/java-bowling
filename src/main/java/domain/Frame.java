package domain;

public class Frame {
    private static final int TEN_PINS = 10;
    private static final String STRIKE = "x";
    private static final String SPARE = "/";
    private static final String GUTTER = "-";
    private static final String MIDDLE = "|";
    private static final String UNPLAYED = "";

    int frameNo; // n번째 프레임
    int pins;  //남은 핀 개수
    int firstThrowing = -1;  //1투구 쓰러트린 핀 개수
    int secondThrowing = -1; //2투구 쓰러트린 핀 개수

    public Frame(int frameNo) {
        this.frameNo = frameNo;
        pins = TEN_PINS;
    }

    public int getThrowing(int pinCount) {
        isValidCount(pinCount);
        if (this.isFirst()) {
            firstThrowing = pinCount;
            return pins = downPin(pinCount);
        }
        secondThrowing = pinCount;
        return pins = downPin(pinCount);
    }

    private boolean isValidCount(int pinCount) {
        if (pinCount > pins) {
            throw new RuntimeException("넘어진 핀의 개수는 남아있는 핀의 개수보다 클 수 없습니다.");
        }
        if (pinCount > TEN_PINS) {
            throw new RuntimeException("볼링 핀의 개수는 10개입니다.");
        }
        return true;
    }

    private int downPin(int pinCount) {
        return pins - pinCount;
    }


    public int getFrameNo() {
        return this.frameNo;
    }

    public boolean isFirst() {
        return firstThrowing == -1;
    }

    public boolean isSecond() {
        return firstThrowing != -1 && secondThrowing == -1;
    }

    public boolean isEnd() {
        if (pins == 0) {
            return true;
        }
        if (firstThrowing != -1 && secondThrowing != -1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String first = "";
        String middle = "|";
        String second = "";
        // Strike
        if (firstThrowing == TEN_PINS) {
            return STRIKE;
        }
        // Gutter
        if (firstThrowing == 0) {
            first = GUTTER;
        }
        if (secondThrowing == 0) {
            second = GUTTER;
        }
        // SPARE
        if (TEN_PINS - firstThrowing == secondThrowing) {
            second = SPARE;
        }
        // open
        if (firstThrowing != 0 && firstThrowing != -1) {
            first = String.valueOf(firstThrowing);
        }
        if (secondThrowing != 0 && secondThrowing != -1) {
            second = String.valueOf(secondThrowing);
        }

        return first + middle + second;
    }
}
