package domain.frame.status;

import domain.frame.pin.Pin;

import java.util.List;

public abstract class FrameStatus {

    public static FrameStatus getInitStatus() {
        return Ing.of();
    }

    public FrameStatus changeStatus(int regularSum, int leftNumber) {
        if (Pin.isMax(regularSum)) {
            return leftNumber == 0 ? Spare.of() : Strike.of();
        }
        return leftNumber == 0 ? Miss.of() : Ing.of();
    }

    public abstract String convertScore(List<Pin> pins);

    public abstract boolean isFinish();

    public abstract boolean isBonus();

    public abstract boolean isStrike();

    public abstract boolean isRightThrewNum(int threwNum);
}

