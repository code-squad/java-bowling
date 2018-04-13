package domain.frame.status;

import domain.frame.pin.Pin;
import domain.frame.score.ScoreMessage;

import java.util.List;

public class Ing extends FrameStatus {
    private static Ing ing = new Ing();

    private Ing(){

    }

    public static Ing of() {
        return ing;
    }

    @Override
    public String convertScore(List<Pin> pins) {
        return ScoreMessage.convertMessage(pins.get(0).getNum());
    }

    @Override
    public boolean isFinish() {
        return false;
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
        return threwNum == 1;
    }
}
