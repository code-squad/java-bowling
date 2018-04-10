package domain.frame.result;

import domain.frame.result.message.FrameMessage;
import domain.frame.result.score.FrameScore;

public class FrameResult {
    private FrameMessage message = new FrameMessage();
    private FrameScore score = null;

    public void addMessage(String convertedScore) {
        message.add(convertedScore);
    }

    public String getMessage() {
        return message.toString();
    }

    public void addScore(FrameScore score) {
        this.score = score;
    }

    public FrameScore getScore() {
        return score;
    }
}
