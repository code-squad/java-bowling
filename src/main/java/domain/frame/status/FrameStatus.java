package domain.frame.status;

import domain.Scores;

/* 상태에 따라 다른게 뭘까 고민해보기 : 출력될 때 일단 달라 - enum으로 변경하자(어차피 다른건 출력되는 포맷만 달라) */
public enum FrameStatus {
    ING,
    STRIKE,
    SPARE,
    MISS;

    /* 여기서 다양한 상태의 FrameStatus 생성되도록? Scores 상태 체크하고 그에맞는 Status 리턴되도록(가장 초기는 Ing) - Status 각각에 맞는 뭔가 다른점을 메소드로 구현하기 */
    // 꼭 Scores를 가지고 있어야하나? 전달받으면 되지않나? scores 가지고 상태
    /* 이 방법 밖에 없나? status 계속 refresh 해줘야할 것 같은데 addScore하고나서 FrameStatus가 리턴되면 어떨까? (이 컨셉은 괜찮은듯 리프레시) */
    // 필요한 질문은 scores에 물어보기 - 일단 끝난것(ING)과 끝나지않은 것(이외) 구분하기
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
