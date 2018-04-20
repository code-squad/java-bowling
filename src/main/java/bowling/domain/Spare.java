package bowling.domain;

public class Spare extends Status {

    static final int COUNT_ONE = 1;

    private Spare(Ball first, Ball second) {
        super(first, second);
    }

    public boolean isLastBall() {
        return false;
    }

    public int pinOfFrame(){
        return PIN_TEN;
    }

    public boolean checkComplete() {
        return true;
    }

    public int getCount() {
        return COUNT_ONE;
    }

    public Score getScore(int score){
        return Score.of(score + pinOfFrame(), COUNT_ONE);
    }

    @Override
    public String toString() {
        return "  " + getFirst() + "|/ |";
    }

    public String lastFramePrint(Ball third){
        if(third!=null){
            return " "+getFirst() + "|" +  "/|" + third.getPin() + "|";
        }
        return toString();
    }

    public static Spare of(Ball first, Ball second) {
        return new Spare(first, second);
    }
}
