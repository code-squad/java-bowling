package bowling.domain.frame;

import bowling.domain.frame.score.LastFrameScore;
import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.last.LastFrameStatus;
import bowling.domain.util.Formatter;

public class LastFrame extends Frame {
    private final LastFrameStatus status;
    private final LastFrameScore score;

    public LastFrame() {
        this.status = new LastFrameStatus();
        this.score = new LastFrameScore();
    }

    @Override
    public Frame bowl(int pins) {
        status.bowl(pins);
        if (status.isComplete()) {
            status.updateLastFrameScore(score);
        }
        return null;
    }

    @Override
    public int calculateScore() { //TODO: Exception for frame number = 8
        return status.calculateScore();
    }

    @Override
    public int calculateAdditionalScore(Score prevScore) {
        return status.updateScoresFromPreviousFrames(prevScore);
    }

    @Override
    int updateScoreFromPrevPrev(Score prevPrev) {
        return status.updateScoresFromPreviousFrames(prevPrev);
    }

    @Override
    public boolean isLast() {
        return status.isComplete();
    }

    @Override
    public String toString() {
        return Formatter.formatFrame(status.toString()) + "|";
    }

    @Override
    public String convertStatusToPrintable() {
        return Formatter.formatFrame(status.toString()) + "|";
    }

    @Override
    public String convertScoreToPrintable() {
        return Formatter.formatFrame(score.toString()) + "|";
    }
}