package domain.frame;

import domain.frame.result.Board;
import domain.frame.result.FrameResult;
import domain.frame.result.Score;

import static domain.frame.result.Board.isLimit;

public interface Frame {
    int CANNOT_CALC_SCORE_STATE = -1;

    static Frame of(int frameNum) {
        if (frameNum == Board.LIMIT) {
            return new LastFrame(frameNum);
        }
        return new NormalFrame(frameNum);
    }

    Frame roll(int num) throws IllegalArgumentException;

    boolean isLast();

    int getFrameNum();

    boolean isFinish();

    boolean isDiff(Frame frame);

    Board getBoard();

    void addFrameResult(Board board);

    FrameResult getResult();

    int getRemainingPin();

    Score addRemainingPin(Score beforeFrameScore);

    Score AddAdditionalRemainingPin(Score unFinishedScore);
}
