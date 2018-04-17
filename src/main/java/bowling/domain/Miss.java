package bowling.domain;

public class Miss extends FrameStatus {

    static final int COUNT_ZERO = 0;

    private Miss(Ball first, Ball second) {
        super(first, second);
    }

    public static Miss of(Ball first, Ball second) {
        return new Miss(first, second);
    }

    public boolean isLastBall() {
        return true;
    }

    public int pinOfFrame(){
        return getFirst()+getSecond();
    }

    public int getCount() {
        return COUNT_ZERO;
    }

    public String nomalPrint() {
        return "  " + getFirst() + "|" + getSecond() + " |";
    }
}
