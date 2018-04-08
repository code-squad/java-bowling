package domain.frame.status;

import domain.Scores;

public abstract class FrameStatus {

    public static FrameStatus changeStatus(Scores scores) {
        if (!scores.isScoreLimit()) {
            return scores.isLimitSize() ? Miss.of() : Ing.of();
        }
        return scores.isLimitSize() ? Spare.of() : Strike.of();
    }

    public abstract String convertScore(int score);

    public static boolean isFinish(FrameStatus status) {
        return !isIng(status);
    }

    public static boolean isBonus(FrameStatus status) {
        return isStrike(status) || isSpare(status);
    }

    public static boolean isStrike(FrameStatus status) {
        return status instanceof Strike;
    }

    public static boolean isSpare(FrameStatus status) {
        return status instanceof Spare;
    }

    public static boolean isMiss(FrameStatus status) {
        return status instanceof Miss;
    }

    public static boolean isIng(FrameStatus status) {
        return status instanceof Ing;
    }
}

