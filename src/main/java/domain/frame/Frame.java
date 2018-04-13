package domain.frame;

import domain.frame.result.Board;
import domain.frame.result.CannotCalcException;
import domain.frame.result.FrameResult;
import domain.frame.score.FrameScore;

import static domain.frame.result.Board.isLimit;

public abstract class Frame {
    public static final int REGULAR_COUNT = 2;
    public static final int CANNOT_CALC_SCORE_STATE = -1;

    final int frameNum;
    private FrameScore score;
    private Frame nextFrame;

    public Frame(int frameNum) {
        this.frameNum = frameNum;
        score = new FrameScore(REGULAR_COUNT);
    }

    public static Frame of(int frameNum) {
        if (isLimit(frameNum)) {
            return new LastFrame(frameNum);
        }
        return new NormalFrame(frameNum);
    }

    public Frame roll(int num) throws IllegalArgumentException {
        Frame frame = doRecord(score, num);
        if (this != frame) {
            nextFrame = frame;
            return nextFrame;
        }
        return this;
    }

    abstract Frame doRecord(FrameScore score, int num) throws IllegalArgumentException;

    public boolean isFinish() {
        return doCheckFinish(score);
    }

    abstract boolean doCheckFinish(FrameScore score);

    public abstract boolean isLast();

    public int getFrameNum() {
        return frameNum;
    }

    private int getScore() {
        try {
            FrameScore frameScore = score.getScore();
            return frameScore.get();
        } catch (CannotCalcException e) {
            return CANNOT_CALC_SCORE_STATE;
        }
    }

    public abstract String getScoreMessage(FrameScore score);

    public FrameResult getResult() {
        if (!score.isBonusFinish()) {
            return new FrameResult(getScoreMessage(score), CANNOT_CALC_SCORE_STATE);
        }
        return new FrameResult(getScoreMessage(score), getScore());
    }

    private void addFrameResult(Board board) {
        board.addResult(getResult());
        if (nextFrame != null) {
            nextFrame.addFrameResult(board);
        }
    }

    public Board getBoard() {
        Board board = new Board();
        addFrameResult(board);
        return board;
    }
}
