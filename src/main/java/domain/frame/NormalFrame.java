package domain.frame;

import domain.Scores;
import domain.frame.status.FrameStatus;

public class NormalFrame implements Frame {
    private FrameStatus status;
    private Scores scores;

    public NormalFrame() {
        scores = new Scores();
        status = FrameStatus.of(scores);
    }

    @Override
    public void addScore(int score) throws IllegalArgumentException {
        scores.addScore(score);
        status = FrameStatus.of(scores);
    }

    @Override
    public boolean isFinish() {
        return FrameStatus.isFinish(status);
    }
}
