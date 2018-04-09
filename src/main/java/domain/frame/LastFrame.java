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
        status = FrameStatus.getInitStatus();
    }

    @Override
    public String addScore(int score) throws IllegalArgumentException {
        if (status.isBonus()) {
            bonusScore = new Score(score);
            return convertScore(score);
        }
        scores.addScore(score);
        status = status.changeStatus(scores);
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
        if (!status.isFinish()) {
            return false;
        }

        if (!status.isBonus()) {
            return true;
        }
        return bonusScore != null;
    }
}
