package domain.frame.status;

import domain.Scores;

public abstract class FrameStatus {

    public static FrameStatus getInitStatus() {
        return Ing.of();
    }

    public FrameStatus changeStatus(Scores scores) {
        if (!scores.isScoreLimit()) {
            return scores.isLimitSize() ? Miss.of() : Ing.of();
        }
        return scores.isLimitSize() ? Spare.of() : Strike.of();
    }

    public abstract String convertScore(int score);

    public abstract boolean isFinish();

    public abstract boolean isBonus();

    public abstract int getBonusCount();
}

