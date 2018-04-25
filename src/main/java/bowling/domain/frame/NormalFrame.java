package bowling.domain.frame;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.NotPlayed;
import bowling.domain.frame.status.Status;
import bowling.domain.util.Formatter;

public class NormalFrame implements Frame {
    private final Frame nextFrame;
    private Status status;

    public NormalFrame(int frameNumber) {
        this.nextFrame = createNextFrame(frameNumber);
        this.status = new NotPlayed();
    }

    private Frame createNextFrame(int frameNumber) {
        if (frameNumber == ONE_BEFORE_LAST) {
            return new LastFrame();
        }
        return new NormalFrame(frameNumber + 1);
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
    public boolean isLastFrame() {
        return false;
    }

    @Override
    public boolean isNewFrame() {
        if (status.isComplete()) {
            return nextFrame.isNewFrame();
        }
        return !status.isPlayed();
    }

    @Override
    public String getPrintableStatus() {
        return Formatter.formatFrame(status.toString())
                + "|"
                + nextFrame.getPrintableStatus();
    }

    @Override
    public String getPrintableScore(int total) {
        Score score = status.createScore();
        if (status.isStrike() || status.isSpare()) {
            nextFrame.calculateAdditionalScore(score);
        }

        int newTotal = score.calculateNewTotal(total);
        return score.getScore(newTotal)
                + "|"
                + nextFrame.getPrintableScore(newTotal);
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