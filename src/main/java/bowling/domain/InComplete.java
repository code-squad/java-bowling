package bowling.domain;

import bowling.view.View;

public class InComplete extends FrameStatus {

    public InComplete(Ball first, Ball second) {
        super(first, second);
    }

    public boolean isLastBall() {
        return false;
    }

    public int pinOfFrame() {
        if (isNew()){
            return 0;
        }
        return getFirst();
    }

    public boolean checkComplete() {
        return false;
    }

    public int getCount(){
        return Miss.COUNT_ZERO;
    }

    public String toString() {
        if (isNew()) {
            return "      |";
        }
        return "  " + View.isStrike(getFirst()) + "|  |";
    }

    public String lastFramePrint(Ball third){
        return toString();
    }

    public Score getScore(int score){
        return Score.of(score + pinOfFrame(), Miss.COUNT_ZERO);
    }

    public static InComplete of(Ball first, Ball second){
        return new InComplete(first, second);
    }
}
