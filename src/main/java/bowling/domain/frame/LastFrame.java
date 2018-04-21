package bowling.domain.frame;

import bowling.domain.frame.score.LastFrameScore;
import bowling.domain.frame.score.NormalScore;
import bowling.domain.frame.status.last.LastFrameStatus;
import bowling.domain.util.Formatter;

public class LastFrame extends Frame {
    private final LastFrameStatus status; //TODO: Refactoring needed - maybe could implement an interface?
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
    public void calculateScore() { //TODO: Exception for frame number = 8
        status.calculateScore(); //TODO: Do I even need this?? - NormalScore is updated each time bowl() is called.
    }

    @Override
    public void calculateAdditionalScore(NormalScore prevNormalScore) {
        status.updateScoresFromPreviousFrames(prevNormalScore);
    }

    @Override
    void updateScoreFromPrevPrev(NormalScore prevPrev) {
        status.updateScoresFromPreviousFrames(prevPrev);
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