package domain.frame.status;

import domain.frame.Pin;
import domain.frame.ScoreMessage;

import java.util.List;

public class Miss extends FrameStatus {
    private static Miss miss = new Miss();

    private Miss() {

    }

    public static Miss of() {
        return miss;
    }

    @Override
    public String convertScore(List<Pin> pins) {
        return ScoreMessage.convertMessage(pins.get(0).getNum()) + ScoreMessage.getMessage(ScoreMessage.MODIFIER) + ScoreMessage.convertMessage(pins.get(1).getNum());
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
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isRightThrewNum(int threwNum) {
        return threwNum == 2;
    }
}
