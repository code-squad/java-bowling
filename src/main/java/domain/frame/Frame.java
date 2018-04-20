package domain.frame;

import domain.frame.pin.Pin;
import domain.frame.result.Board;
import domain.frame.result.CannotCalcException;
import domain.frame.result.FrameResult;
import domain.frame.result.Score;
import domain.frame.status.FrameStatus;
import domain.frame.status.Ready;

import static domain.frame.result.Board.isLimit;

public abstract class Frame {
    public static final int CANNOT_CALC_SCORE_STATE = -1;
    private FrameStatus status;
    private final int frameNum;

    public Frame(int frameNum) {
        this.frameNum = frameNum;
        status = new Ready();
    }

    public static Frame of(int frameNum) {
        if (isLimit(frameNum)) {
            return new LastFrame(frameNum);
        }
        return new NormalFrame(frameNum);
    }

    public Frame roll(int num) throws IllegalArgumentException {
        status = status.roll(this, new Pin(num));
        return createFrame();
    }

    abstract Frame createFrame() throws IllegalArgumentException;

    public abstract boolean isLast();

    public int getFrameNum() {
        return frameNum;
    }

    public boolean isFinish() {
        return status.isFinish(this);
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
        try {
            return doGetScore(status);
        } catch (CannotCalcException e) {
            return CANNOT_CALC_SCORE_STATE;
        }
    }

    abstract int doGetScore(FrameStatus status);

    public Score addBonusScore(Score beforeFrameScore) {
        Score totalScore = status.addBonusScore(beforeFrameScore);
        if (totalScore.hasBonusCount()) {
            return doAddAdditionalBonusScore(totalScore);
        }
        return totalScore;
    }

    abstract Score doAddAdditionalBonusScore(Score unFinishedScore);
}
