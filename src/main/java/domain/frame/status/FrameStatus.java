package domain.frame.status;

import domain.Scores;

public enum FrameStatus {
    ING,
    STRIKE,
    SPARE,
    MISS;

    public static FrameStatus of(Scores scores) {
        if (!scores.isScoreLimit()) {
            return scores.isLimitSize() ? MISS : ING;
        }
        return scores.isLimitSize() ? SPARE : STRIKE;
    }

    public static boolean isFinish(FrameStatus status) {
        return status != ING;
    }

    public static boolean isBonus(FrameStatus status) {
        return status == STRIKE || status == SPARE;
    }
}
