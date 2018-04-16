package domain.frame;

import domain.frame.result.Board;
import domain.frame.result.FrameResult;
import domain.frame.score.FrameScore;

import java.util.ArrayList;
import java.util.List;

public class NormalFrame extends Frame {
    private Frame nextFrame;

    public NormalFrame(int frameNum) {
        super(frameNum);
    }

    @Override
    Frame doRecord(FrameScore score, int num) throws IllegalArgumentException {
        score.roll(num);
        if (score.isRegularFinish() && score.isBeforeBonusRoll()) {
            score.increaseLeftCount();
            nextFrame = Frame.of(frameNum + 1);
            return nextFrame;
        }
        return this;
    }

    @Override
    boolean doCheckFinish(FrameScore score) {
        return score.isRegularFinish();
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    void doRefreshPinNum(Frame currentFrame, FrameScore score) {
        if (currentFrame == this || score.isBonusFinish()) {
            return;
        }
        score.rollBonusPins(this, nextFrame);
    }

    @Override
    List<Integer> doGetRecentlyPinNums(Frame askFrame, FrameScore score, int amount) {
        List<Integer> bonusPins = new ArrayList<>();
        if (!score.isPossibleGettingPins(nextFrame, amount)) {
            return bonusPins;
        }
        bonusPins.addAll(score.getBonusPins(nextFrame, amount));
        return bonusPins;
    }

    @Override
    void addFrameResult(Board board, int baseScore) {
        FrameResult result = getResult(baseScore);
        board.addResult(result);
        if (nextFrame != null) {
            nextFrame.addFrameResult(board, result.getScore());
        }
    }
}
