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

    public Ball getFirstBall(){
        return first;
    }

    public int getSecond() {
        return second.getPin();
    }

    public boolean isNew(){
        return first == null;
    }

    public boolean isTwiceBall() {
        return second != null;
    }

    public abstract boolean isLastBall();

    public abstract int pinOfFrame();

    public abstract boolean checkComplete();

    public abstract int getCount();

    public abstract Score getScore(int score);

    public abstract String toString();

    public abstract String lastFramePrint(Ball third);
}
