package domain.frame;

import domain.Score;
import domain.Scores;
import domain.frame.result.FrameResult;
import domain.frame.status.FrameStatus;

public class LastFrame implements Frame {
    private FrameStatus status;
    private Scores scores;
    private Score bonusScore;

    public LastFrame() {
        scores = new Scores();
        status = FrameStatus.of(scores);
    }

    @Override
    public FrameResult addScore(int score) throws IllegalArgumentException {
        if (!FrameStatus.isBonus(status)) {
            scores.addScore(score);
        }

        if (FrameStatus.isBonus(status)) {
            bonusScore = new Score(score);
        }
        status = FrameStatus.of(scores);

        // Result 안에 무엇을 저장할 것인가
        return new FrameResult();
    }

    @Override
    public boolean isFinish() {
        if (!FrameStatus.isFinish(status)) {
            return false;
        }

        if (!FrameStatus.isBonus(status)) {
            return true;
        }
        return bonusScore != null;
    }
}
