package domain.frame.status;

import domain.frame.Pin;
import domain.frame.ScoreMessage;

import java.util.List;

public class Strike extends FrameStatus {
    private static Strike strike = new Strike();

    private Strike() {

    }

    public static Strike of() {
        return strike;
    }

    @Override
    public String convertScore(List<Pin> pins) {
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

    @Override
    public boolean isStrike() {
        return true;
    }

    @Override
    public boolean isRightThrewNum(int threwNum) {
        return threwNum == 1;
    }
}
