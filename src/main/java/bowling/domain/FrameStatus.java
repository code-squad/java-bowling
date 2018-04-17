package bowling.domain;

public abstract class FrameStatus {

    static final int PIN_TEN = 10;

    private Ball first;
    private Ball second;

    public FrameStatus(Ball first, Ball second){
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first.getPin();
    }

    public int getSecond() {
        return second.getPin();
    }

    public boolean isTwiceBall() {
        return second != null;
    }

    public abstract String nomalPrint();

    public abstract boolean isLastBall();

    public abstract int pinOfFrame();

    public abstract int getCount();
}
