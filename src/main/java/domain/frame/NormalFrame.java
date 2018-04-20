package domain.frame;

import domain.frame.pin.Pin;
import domain.frame.result.Board;
import domain.frame.result.CannotCalcException;
import domain.frame.result.FrameResult;
import domain.frame.result.Score;
import domain.frame.status.FrameStatus;
import domain.frame.status.Ready;

public class NormalFrame implements Frame {
    private final int frameNum;
    private FrameStatus status;
    private Frame nextFrame;

    public NormalFrame(int frameNum) {
        this.frameNum = frameNum;
        status = new Ready();
    }

    @Override
    public Frame roll(int num) throws IllegalArgumentException {
        status = status.roll(new Pin(num));
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
    public boolean isFinish() {
        return status.isFinish();
    }

    @Override
    public boolean isDiff(Frame frame) {
        return this == frame;
    }

    @Override
    public int getFrameNum() {
        return frameNum;
    }

    @Override
    public Board getBoard() {
        Board board = new Board();
        addFrameResult(board);
        return board;
    }

    @Override
    public void addFrameResult(Board board) {
        FrameResult result = getResult();
        board.addResult(result);
        if (nextFrame != null) {
            nextFrame.addFrameResult(board);
        }
    }

    @Override
    public FrameResult getResult() {
        if (!isFinish()) {
            return new FrameResult(getScoreMessage(), CANNOT_CALC_SCORE_STATE);
        }
        return new FrameResult(getScoreMessage(), getScore());
    }

    private String getScoreMessage() {
        return status.getResultMessage();
    }

    private int getScore() {
        try {
            return getRemainingPin();
        } catch (CannotCalcException e) {
            return CANNOT_CALC_SCORE_STATE;
        }
    }

    @Override
    public int getRemainingPin() throws CannotCalcException {
        Score score = status.getScore();
        if (!score.hasBonusCount()) {
            return score.get();
        }
        score = nextFrame.addRemainingPin(score);
        return score.get();
    }

    @Override
    public Score addRemainingPin(Score beforeFrameScore) {
        Score totalScore = status.addBonusScore(beforeFrameScore);
        if (totalScore.hasBonusCount()) {
            return nextFrame.AddAdditionalRemainingPin(totalScore);
        }
        return totalScore;
    }

    @Override
    public Score AddAdditionalRemainingPin(Score unFinishedScore) throws CannotCalcException {
        if (nextFrame == null) {
            throw new CannotCalcException();
        }
        return nextFrame.addRemainingPin(unFinishedScore);
    }
}
