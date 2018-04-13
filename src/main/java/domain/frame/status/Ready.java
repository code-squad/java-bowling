package domain.frame.status;

import domain.frame.pin.Pin;

import java.util.List;

public class Ready extends FrameStatus {
    private static Ready ready = new Ready();

    private Ready() {
    }

    public static Ready of() {
        return ready;
    }

    @Override
    public String convertScore(List<Pin> pins) {
        return "";
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
        return threwNum == 0;
    }
}
