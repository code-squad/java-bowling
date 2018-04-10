package domain.frame.status;

import domain.Pins;

public abstract class FrameStatus {

    public static FrameStatus getInitStatus() {
        return Ing.of();
    }

    public FrameStatus changeStatus(Pins pins) {
        if (!pins.isFullPinNumRecord()) {
            return pins.isFullCount() ? Miss.of() : Ing.of();
        }
        return pins.isFullCount() ? Spare.of() : Strike.of();
    }

    public abstract String convertScore(int score);

    public abstract boolean isFinish();

    public abstract boolean isBonus();

    public abstract int getBonusCount();
}

