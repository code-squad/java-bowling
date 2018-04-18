package domain.frame;

import domain.frame.result.Board;
import domain.frame.result.FrameResult;
import domain.frame.result.Score;
import domain.frame.status.FrameStatus;

public class LastFrame extends Frame {

    public LastFrame(int frameNum) {
        super(frameNum);
    }

    @Override
    Frame createFrame(FrameStatus status) throws IllegalArgumentException {
        return this;
    }

    @Override
    boolean doCheckFinish(FrameStatus status) {
        return status.isRegularFinish() && status.isBonusFinish();
    }

    @Override
    public boolean isLast() {
        return true;
    }

    @Override
    void addFrameResult(Board board) {
        FrameResult result = getResult();
        board.addResult(result);
    }

    @Override
    Score doAddBonusScore(Score thisScore) {
        return null;
    }
}
