package domain.frame;

import domain.Scores;
import domain.frame.status.FrameStatus;

/*
    1. 프레임 종류별로 어떻게 다른지 생각해보기
    - 노말 프레임
    - 라스트 프레임

    2. 구현되어있는 status, scores를 각각 어떻게 활용할지
 */
public class Frame {
    private FrameStatus status;
    private Scores scores;

    public Frame() {
        scores = new Scores();
        status = FrameStatus.of(scores);
    }

    public void addScore(int score) throws IllegalArgumentException {
        scores.addScore(score);
        status = FrameStatus.of(scores);
    }

    public boolean isFinish() {
        return FrameStatus.isFinish(status);
    }

    @Override
    public String toString() {
        return status.formationScore(scores);
    }
}
