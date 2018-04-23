package bowling.domain.frame;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.NotPlayed;
import bowling.domain.frame.status.Status;
import bowling.domain.util.Formatter;

public class NormalFrame implements frame {
    private final int frameNumber;
    private frame nextFrame;
    private Status status;

    public NormalFrame(int frameNumber) {
        this.frameNumber = frameNumber;
        this.nextFrame = createNextFrame();
        this.status = new NotPlayed();
    }

    private frame createNextFrame() {
        if (frameNumber == ONE_BEFORE_LAST) {
            return new LastFrame();
        }
        return new NormalFrame(frameNumber + 1);
    }

    public int getFrameNumber() {
        if (status.isComplete()) {
            nextFrame.getFrameNumber();
        }
        return frameNumber;
    }

    @Override
    public void bowl(int pins) {
        if (status.isComplete()) {
            nextFrame.bowl(pins);
            return;
        }
        status = status.bowl(pins);
    }

    @Override
    public boolean isLast() {
        if (status.isComplete()) {
            return nextFrame.isLast();
        }
        return false;
    }

    @Override
    public String getPrintableStatus() {
        return Formatter.formatFrame(status.toString())
                + "|"
                + nextFrame.getPrintableStatus();
    }

    @Override
    public String getPrintableScore(int accumulative) { //TODO: Exception for frame number = 8
        Score score = status.createScore();
        score.accumulateScore(accumulative);
        nextFrame.calculateAdditionalScore(score);
        return score.toString()
                + "|"
                + nextFrame.getPrintableScore(score.calculateTotal());
    }

    @Override
    public void calculateAdditionalScore(Score prevScore) {
        if (status.isStrike()) {
            status.updateScore(prevScore);
            nextFrame.updateScoreFromPrevPrev(prevScore);
            return;
        }
        status.updateScore(prevScore);
    }

    @Override
    public void updateScoreFromPrevPrev(Score prevPrev) {
        status.updateScore(prevPrev);
    }
}