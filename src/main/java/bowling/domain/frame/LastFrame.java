package bowling.domain.frame;

import bowling.domain.frame.status.LastFrameStatus;
import bowling.domain.frame.score.Score;
import bowling.domain.util.Formatter;

public class LastFrame implements frame {
    private static final int LAST = 10;

    private final LastFrameStatus status = new LastFrameStatus();

    @Override
    public int getFrameNumber() {
        return LAST;
    }

    @Override
    public void bowl(int pins) {
        status.bowl(pins);
    }

    @Override
    public boolean isLast() {
        return status.isComplete();
    }

    @Override
    public String getPrintableStatus() {
        return Formatter.formatFrame(status.toString()) + "|";
    }

    @Override
    public String getPrintableScore(int accumulative) {
        Score score = status.createScore();
        score.accumulateScore(accumulative);
        return score.toString() + "|";
    }

    @Override
    public void calculateAdditionalScore(Score prevScore) {
        status.updateScoresFromPreviousFrames(prevScore);
    }

    @Override
    public void updateScoreFromPrevPrev(Score prevPrev) {
        status.updateScoresFromPreviousFrames(prevPrev);
    }
}