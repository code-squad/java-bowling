package bowling.domain.frame;

import bowling.domain.frame.status.LastFrameStatus;
import bowling.domain.frame.score.Score;
import bowling.domain.util.Formatter;

public class LastFrame implements Frame {

    private final LastFrameStatus status = new LastFrameStatus();

    @Override
    public void bowl(int pins) {
        status.bowl(pins);
    }

    @Override
    public boolean allBowlsPlayed() {
        return status.isComplete();
    }

    @Override
    public boolean isNewFrame() {
        return !status.bowlStarted() || status.isComplete();
    }

    @Override
    public String getPrintableStatus() {
        return Formatter.formatFrame(status.toString()) + "|";
    }

    @Override
    public String getPrintableScore(int total) {
        Score score = status.createScore();
        status.updateLastFrameScore(score);
        int newTotal = score.calculateNewTotal(total);

        return score.getScore(newTotal) + "|";
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