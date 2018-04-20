package bowling.domain.frame;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.last.LastFrameStatus;
import bowling.domain.util.Formatter;

public class LastFrame extends Frame {
    private final LastFrameStatus status;

    public LastFrame() {
        this.status = new LastFrameStatus();
    }

    @Override
    public Frame bowl(int pins) {
        status.bowl(pins);
        return null;
    }

    @Override
    public int calculateScore() { //TODO: Exception for frame number = 8
        return status.calculateScore();
    }

    @Override
    public int calculateAdditionalScore(Score prevScore) {
        return status.updateScore(prevScore);
    }

    @Override
    int updateScoreFromPrevPrev(Score prevPrev) {
        return status.updateScore(prevPrev);
    }

    @Override
    public boolean isLast() {
        return status.isComplete();
    }

    @Override
    public String toString() {
        return Formatter.formatFrame(status.toString()) + "|";
    }
}