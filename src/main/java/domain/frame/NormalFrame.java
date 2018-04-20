package domain.frame;

import domain.frame.result.Board;
import domain.frame.result.CannotCalcException;
import domain.frame.result.FrameResult;
import domain.frame.result.Score;
import domain.frame.status.FrameStatus;

public class NormalFrame extends Frame {
    private Frame nextFrame;

    public NormalFrame(int frameNum) {
        super(frameNum);
    }

    @Override
    Frame createFrame() throws IllegalArgumentException {
        if (isFinish()) {
            nextFrame = Frame.of(getFrameNum() + 1);
            return nextFrame;
        }
        return this;
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    void addFrameResult(Board board) {
        FrameResult result = getResult();
        board.addResult(result);
        if (nextFrame != null) {
            nextFrame.addFrameResult(board);
        }
    }

    @Override
    int doGetRemainingPin(FrameStatus status) throws CannotCalcException {
        Score score = status.getScore();
        if (!score.hasBonusCount()) {
            return score.get();
        }
        score = nextFrame.addRemainingPin(score);
        return score.get();
    }

    @Override
    Score doAddAdditionalRemainingPin(Score unFinishedScore) throws CannotCalcException {
        if (nextFrame == null) {
            throw new CannotCalcException();
        }
        return nextFrame.addRemainingPin(unFinishedScore);
    }
}
