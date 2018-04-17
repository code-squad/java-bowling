package bowling.domain;

public class Spare extends FrameStatus {

    static final int COUNT_ONE = 1;

    private Spare(Ball first, Ball second) {
        super(first, second);
    }

    public static Spare of(Ball first, Ball second) {
        return new Spare(first, second);
    }

    public boolean isLastBall() {
        return false;
    }

    public int pinOfFrame(){
        return PIN_TEN;
    }

    public int getCount() {
        return COUNT_ONE;
    }

    public String nomalPrint() {
        return "  " + getFirst() + "|/ |";
    }
}
