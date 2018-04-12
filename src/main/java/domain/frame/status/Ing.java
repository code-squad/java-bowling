package domain.frame.status;

import domain.frame.ScoreMessage;

public class Ing extends FrameStatus {
    private static Ing ing = new Ing();

    private Ing(){

    }

    public static Ing of() {
        return ing;
    }

    @Override
    public String convertScore(int score) {
        return ScoreMessage.convertMessage(score);
    }

    @Override
    public boolean isFinish() {
        return false;
    }

    @Override
    public boolean isBonus() {
        return false;
    }
}
