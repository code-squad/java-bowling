package domain.frame;

import domain.Score;
import domain.Scores;
import domain.frame.result.ScoreMessage;
import domain.frame.status.FrameStatus;

public class LastFrame implements Frame {
    private FrameStatus status;
    private Scores scores;
    private Score bonusScore;

    public LastFrame() {
        scores = new Scores();
        status = FrameStatus.changeStatus(scores);
    }

    @Override
    public String addScore(int score) throws IllegalArgumentException {
        if (FrameStatus.isBonus(status)) {
            bonusScore = new Score(score);
            return convertScore(score);
        }
        scores.addScore(score);
        status = FrameStatus.changeStatus(scores);
        return convertScore(score);
    }

    @Override
    public String convertScore(int score) {
        if (scores.isFinish()) {
            return ScoreMessage.convertMessage(score);
        }
        return status.convertScore(score);
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
