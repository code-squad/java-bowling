package domain.frame.status;

import domain.frame.Pin;
import domain.frame.ScoreMessage;

import java.util.List;

public class Spare extends FrameStatus {
    private static Spare spare = new Spare();

    private Spare() {

    }

    public static Spare of() {
        return spare;
    }

    @Override
    public String convertScore(List<Pin> pins) {
        return ScoreMessage.convertMessage(pins.get(0).getNum()) + ScoreMessage.getMessage(ScoreMessage.MODIFIER) + ScoreMessage.getMessage(ScoreMessage.SPARE);
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
        return false;
    }

    @Override
    public boolean isRightThrewNum(int threwNum) {
        return threwNum == 2;
    }
}
