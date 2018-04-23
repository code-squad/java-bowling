package bowling.domain.frame.normal;

import bowling.domain.frame.Frame;
import bowling.domain.frame.last.LastFrame;
import bowling.domain.frame.normal.score.Score;
import bowling.domain.frame.normal.status.NotPlayed;
import bowling.domain.frame.normal.status.Status;
import bowling.domain.util.Formatter;

public class NormalFrame implements Frame {
    private Frame nextFrame;
    private Status status;


    public NormalFrame(int frameNumber) {
        this.nextFrame = createNextFrame(frameNumber);
        this.status = new NotPlayed();
    }

    private Frame createNextFrame(int frameNumber) {
        if (frameNumber == ONE_BEFORE_LAST) {
            return new LastFrame();
        }
        return new NormalFrame(++frameNumber);
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
    public String calculateScore(int accumulative) { //TODO: Exception for frame number = 8
        Score score = status.createScore();
        score.accumulateScore(accumulative);
        nextFrame.calculateAdditionalScore(score);
        return score.toString() + "|" + nextFrame.calculateScore(score.calculateTotal());
    }

    @Override
    public boolean calculateAdditionalScore(Score prevScore) {
        if (status.isStrike()) {
            status.updateScore(prevScore);
            return nextFrame.updateScoreFromPrevPrev(prevScore);
        }
        return status.updateScore(prevScore); //TODO: change to void using if/else?
    }

    @Override
    public boolean updateScoreFromPrevPrev(Score prevPrev) {
        return status.updateScore(prevPrev); //TODO: change to void?
    }

    @Override
    public boolean isLast() {
        if (status.isComplete()) {
            return nextFrame.isLast();
        }
        return false;
    }

    @Override
    public String convertStatusToPrintable() {
        return Formatter.formatFrame(status.toString())
                + "|"
                + nextFrame.convertStatusToPrintable();
    }
}