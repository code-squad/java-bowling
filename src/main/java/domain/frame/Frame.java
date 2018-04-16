package domain.frame;

import domain.frame.result.Board;
import domain.frame.result.CannotCalcException;
import domain.frame.result.FrameResult;
import domain.frame.score.FrameScore;

import java.util.List;

import static domain.frame.result.Board.isLimit;

public abstract class Frame {
    public static final int REGULAR_COUNT = 2;
    public static final int CANNOT_CALC_SCORE_STATE = -1;

    final int frameNum;
    private FrameScore score;

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
        return doRecord(score, num);
    }

    abstract Frame doRecord(FrameScore score, int num) throws IllegalArgumentException;

    public void refreshPinNum(Frame currentFrame) {
        doRefreshPinNum(currentFrame, score);
    }

    abstract void doRefreshPinNum(Frame currentFrame, FrameScore score);

    public List<Integer> getRecentlyPinNums(Frame askFrame, int amount) {
        return doGetRecentlyPinNums(askFrame, score, amount);
    }

    abstract List<Integer> doGetRecentlyPinNums(Frame askFrame, FrameScore score, int amount);

    public boolean haveTried(int amount) {
        return score.isWithinRollNum(amount);
    }

    public List<Integer> getPins(int amount) {
        return score.getPins(amount);
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

    abstract void addFrameResult(Board board, int baseScore);

    public Board getBoard() {
        Board board = new Board();
        addFrameResult(board, 0);
        return board;
    }

    public boolean isFinish() {
        return doCheckFinish(score);
    }

    public boolean isDiff(Frame frame) {
        return this != frame;
    }
}
