package domain.frame.status;

import domain.frame.result.ScoreMessage;

public class Spare extends FrameStatus {
    private static Spare spare = new Spare();

    private Spare() {

    }

    public static Spare of() {
        return spare;
    }

    @Override
    public String convertScore(int score) {
        return ScoreMessage.getMessage(ScoreMessage.SPARE);
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public boolean isBonus() {
        return true;
    }
}
