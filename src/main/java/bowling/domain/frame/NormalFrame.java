package bowling.domain.frame;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.normal.NotPlayed;
import bowling.domain.frame.status.normal.Status;
import bowling.domain.util.Formatter;

public class NormalFrame extends Frame {
    private Frame nextFrame;
    private Status status;
    private Score score;

    public NormalFrame(int frameNumber) {
        this.nextFrame = createNextFrame(frameNumber);
        this.status = new NotPlayed();
        this.score = Score.ofNotPlayed();
    }

    private Frame createNextFrame(int frameNumber) {
        if (frameNumber == 9) {
            return new LastFrame();
        }
        return new NormalFrame(frameNumber + 1);
    }

    @Override
    public Frame bowl(int pins) {
        if (status.isComplete()) {
            nextFrame.bowl(pins);
            return nextFrame;
        }
        status = status.bowl(pins);
        return null;
    }

    @Override
    public boolean calculateScore(int accumulative) { //TODO: Exception for frame number = 8
        score = status.createScore();
        score.accumulateScore(accumulative);
        nextFrame.calculateAdditionalScore(score);
        nextFrame.calculateScore(score.calculateTotal());
        return true;
    }

    @Override
    public boolean calculateAdditionalScore(Score prevScore) {
        if (status.isStrike()) {
            status.updateScore(prevScore);
            return nextFrame.updateScoreFromPrevPrev(prevScore);
        }
        return status.updateScore(prevScore);
    }

    @Override
    public boolean updateScoreFromPrevPrev(Score prevPrev) {
        return status.updateScore(prevPrev);
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    public String convertStatusToPrintable() {
        return Formatter.formatFrame(status.toString()) + "|" + nextFrame.convertStatusToPrintable();
    }

    @Override
    public String convertScoreToPrintable() {
        return Formatter.formatFrame(score.toString()) + "|" + nextFrame.convertScoreToPrintable();
    }
}