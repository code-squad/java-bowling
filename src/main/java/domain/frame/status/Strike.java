package domain.frame.status;

import domain.frame.ScoreMessage;

public class Strike extends FrameStatus {
    private static Strike strike = new Strike();

    private Strike() {

    }

    public static Strike of() {
        return strike;
    }

    @Override
    public String convertScore(int score) {
        return ScoreMessage.getMessage(ScoreMessage.TEN);
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
