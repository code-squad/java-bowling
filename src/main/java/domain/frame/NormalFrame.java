package domain.frame;

import domain.Scores;
import domain.frame.status.FrameStatus;

public class NormalFrame implements Frame {
    private FrameStatus status;
    private Scores scores;

    public NormalFrame() {
        scores = new Scores();
        status = FrameStatus.changeStatus(scores);
    }

    @Override
    public String addScore(int score) throws IllegalArgumentException {
        scores.addScore(score);
        status = FrameStatus.changeStatus(scores);
        return convertScore(score);
    }

    @Override
    public String convertScore(int score) {
        return status.convertScore(score);
    }

    @Override
    public boolean isFinish() {
        return FrameStatus.isFinish(status);
    }
}
