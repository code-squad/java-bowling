package domain.frame;

import domain.Scores;
import domain.frame.result.FrameResult;
import domain.frame.status.FrameStatus;

public class NormalFrame implements Frame {
    private FrameStatus status;
    private Scores scores;

    public NormalFrame() {
        scores = new Scores();
        status = FrameStatus.of(scores);
    }

    @Override
    public FrameResult addScore(int score) throws IllegalArgumentException {
        scores.addScore(score);
        status = FrameStatus.of(scores);

        // Result 안에 무엇을 저장할 것인가 : Status가 enum이 아니라 일반 클래스여서 Scores를 받아서 만들게?
        return new FrameResult();
    }

    @Override
    public boolean isFinish() {
        return FrameStatus.isFinish(status);
    }
}
