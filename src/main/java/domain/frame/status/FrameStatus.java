package domain.frame.status;

import domain.Scores;

/* 상태에 따라 다른게 뭘까 고민해보기 : 출력될 때 일단 달라 - enum으로 변경하자(어차피 다른건 출력되는 포맷만 달라) */
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

    public String formationScore(Scores scores) {
        return null;
    }
}
