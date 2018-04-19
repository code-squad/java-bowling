package bowling.domain;

public class Strike extends FrameStatus {

    static final int COUNT_TWO = 2;

    private Strike(Ball first, Ball second) {
        super(first, second);
    }

    public static Strike of(Ball first, Ball second) {
        return new Strike(first, second);
    }

    public boolean isLastBall() {
        return false;
    }

    public int pinOfFrame() {
        if (!isTwiceBall()) {
            return 10;
        }
        return getFirst() + getSecond();
    }

    public boolean checkComplete() {
        return true;
    }

    public int getCount() {
        return COUNT_TWO;
    }

    public Score getScore(int score){
        return Score.of(score + pinOfFrame(), COUNT_TWO);
    }

    @Override
    public String toString() {
        return "   X  |";
    }

    public String lastFramePrint(Ball third){
        if(third!=null){
            return " X|" + getSecond() + "|" + third.getPin() + "|";
        }
        return "  " + "X|" + getSecond() + " |";
    }
}
