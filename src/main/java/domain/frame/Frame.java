package domain.frame;

import domain.frame.result.Board;
import domain.frame.result.CannotCalcException;
import domain.frame.result.FrameResult;
import domain.frame.result.Score;
import domain.frame.status.FrameStatus;

import static domain.frame.result.Board.isLimit;

public abstract class Frame {
    public static final int CANNOT_CALC_SCORE_STATE = -1;
    private FrameStatus status;

    private final int frameNum;

    public Frame(int frameNum) {
        this.frameNum = frameNum;
        status = FrameStatus.getInitStatus();
    }

    public static Frame of(int frameNum) {
        if (isLimit(frameNum)) {
            return new LastFrame(frameNum);
        }
        return new NormalFrame(frameNum);
    }

    public Frame roll(int num) throws IllegalArgumentException {
        status = status.roll(this, num);
        return createFrame(status);
    }

    abstract Frame createFrame(FrameStatus status) throws IllegalArgumentException;

    abstract boolean doCheckFinish(FrameStatus status);

    public abstract boolean isLast();

    public int getFrameNum() {
        return frameNum;
    }

    public boolean isFinish() {
        return doCheckFinish(status);
    }

    public boolean isDiff(Frame frame) {
        return this != frame;
    }

    public Board getBoard() {
        Board board = new Board();
        addFrameResult(board);
        return board;
    }

    abstract void addFrameResult(Board board);

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
        Score score = status.getScore();
        if (!score.hasBonusCount()) {
            return score.get();
        }

        try {
            return doAddBonusScore(score).get();
        } catch (CannotCalcException e) {
            return CANNOT_CALC_SCORE_STATE;
        }
    }

    abstract Score doAddBonusScore(Score score) throws CannotCalcException;

    Score addBonusScore(Score otherFrameScore) {
        return status.addBonusScore(otherFrameScore);
    }
}
