package bowling.domain;

public class Miss extends Status {

    static final int COUNT_ZERO = 0;

    private Miss(Ball first, Ball second) {
        super(first, second);
        if(first.getPin() + second.getPin() > Ball.MAX_PIN){
            throw new IllegalArgumentException("핀의 개수를 초과 했습니다.");
        }
    }

    public boolean isLastBall() {
        return true;
    }

    public boolean checkComplete() {
        return true;
    }

    public int pinOfFrame(){
        return getFirst()+getSecond();
    }

    public int getCount() {
        return COUNT_ZERO;
    }

    public Score getScore(int score){
        return Score.of(score + pinOfFrame(), COUNT_ZERO);
    }

    @Override
    public String toString() {
        return "  " + getFirst() + "|" + getSecond() + " |";
    }

    public String lastFramePrint(Ball third){
        if(third!=null){
            return getFirst() + "|" + getSecond() + "|" + third.getPin() + "|";
        }
        return toString();
    }

    public static Miss of(Ball first, Ball second) {
        return new Miss(first, second);
    }
}
