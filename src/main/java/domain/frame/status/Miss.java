package domain.frame.status;

import domain.frame.result.message.ScoreMessage;

public class Miss extends FrameStatus {
    private static Miss miss = new Miss();

    private Miss() {

    }

    public static Miss of() {
        return miss;
    }

    @Override
    public String convertScore(int score) {
        if (score == 0) {
            return ScoreMessage.getMessage(ScoreMessage.ZERO);
        }
        return String.valueOf(score);
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public boolean isBonus() {
        return false;
    }

    @Override
    public int getBonusCount() {
        return 0;
    }
}
