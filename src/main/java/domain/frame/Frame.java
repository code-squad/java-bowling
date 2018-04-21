package domain.frame;

import domain.frame.result.Board;
import domain.frame.result.FrameResult;
import domain.frame.result.Score;

public interface Frame {
    int CANNOT_CALC_SCORE_STATE = -1;

    static Frame of(int frameNum) {
        if (frameNum == Board.LIMIT) {
            return new LastFrame();
        }
        return new NormalFrame(frameNum);
    }

    Frame roll(int num) throws IllegalArgumentException;

    boolean isLast();

    int getFrameNum();

    boolean isFinish();

    Board getBoard();

    void addFrameResult(Board board);

    FrameResult getResult();

    Score addRemainingPin(Score beforeFrameScore);
}
