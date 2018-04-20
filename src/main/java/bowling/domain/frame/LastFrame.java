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
        return null;
    }

    @Override
    public int calculateScore() { //TODO: Exception for frame number = 8
        return status.
    }

    @Override
    public int calculateAdditionalScore(Score prevScore) { //TODO: 만약 다음 프레임에서 다 해결 된다면?? 다다음까지 갈 필요가 없다.
        if (status.isStrike()) {
            status.updateScore(prevScore);
            return 0;//nextFrame.updateScoreFromPrevPrev(prevScore); //TODO: 만약 다음 프레임까지 가야한다면..
        }
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