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
    Frame createFrame(FrameStatus status) throws IllegalArgumentException {
        if (status.isRegularFinish()) {
            nextFrame = Frame.of(getFrameNum() + 1);
            return nextFrame;
        }
        return this;
    }

    @Override
    boolean doCheckFinish(FrameStatus status) {
        return status.isRegularFinish();
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
    Score doAddBonusScore(Score score) throws CannotCalcException {
        if (nextFrame == null) {
            throw new CannotCalcException();
        }
        Score totalScore = nextFrame.addBonusScore(score);
        if (totalScore.hasBonusCount()) {
            return requestToNextOfNext(totalScore);
        }
        return totalScore;
    }

    private Score requestToNextOfNext(Score totalScore) throws CannotCalcException {
        if (nextFrame.isLast()) {
            throw new CannotCalcException();
        }
        totalScore = nextFrame.doAddBonusScore(totalScore);
        return totalScore;
    }
}
