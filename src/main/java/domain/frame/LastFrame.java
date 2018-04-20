package domain.frame;

import domain.frame.result.Board;
import domain.frame.result.CannotCalcException;
import domain.frame.result.FrameResult;
import domain.frame.result.Score;
import domain.frame.status.FrameStatus;

public class LastFrame extends Frame {

    public LastFrame(int frameNum) {
        super(frameNum);
    }

    @Override
    Frame createFrame() throws IllegalArgumentException {
        return this;
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
    int doGetScore(FrameStatus status) throws CannotCalcException {
        Score score = status.getScore();
        return score.get();
    }

    @Override
    Score doAddAdditionalBonusScore(Score unFinishedScore) throws CannotCalcException {
        throw new CannotCalcException();
    }
}
