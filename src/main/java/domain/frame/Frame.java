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

    public void bonusRoll(Frame currentFrame, int num) throws IllegalArgumentException {
        if (currentFrame == this) {
            return;
        }

        doRecord(score, num);
        if (nextFrame != null) {
            nextFrame.bonusRoll(currentFrame, num);
        }
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

    private String getScoreMessage() {
        return score.makeScoreMessage(this);
    }

    public FrameResult getResult(int baseScore) {
        if (!score.isBonusFinish()) {
            return new FrameResult(getScoreMessage(), CANNOT_CALC_SCORE_STATE);
        }
        return new FrameResult(getScoreMessage(), baseScore + getScore());
    }

    private void addFrameResult(Board board, int baseScore) {
        FrameResult result = getResult(baseScore);
        board.addResult(result);
        if (nextFrame != null) {
            nextFrame.addFrameResult(board, result.getScore());
        }
    }

    public Board getBoard() {
        Board board = new Board();
        addFrameResult(board, 0);
        return board;
    }
}
