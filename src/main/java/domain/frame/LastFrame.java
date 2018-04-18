package domain.frame;

import domain.frame.pin.Pin;
import domain.frame.result.Board;
import domain.frame.result.FrameResult;
import domain.frame.score.FrameScore;

import java.util.Collections;
import java.util.List;

public class LastFrame extends Frame {
    private BonusPins bonusPins = new BonusPins();

    public LastFrame(int frameNum) {
        super(frameNum);
    }

    @Override
    Frame doRecord(FrameScore score, int num) throws IllegalArgumentException {
        recordPin(score, num);
        return this;
    }

    private void recordPin(FrameScore score, int num) throws IllegalArgumentException {
        if (!score.isRegularFinish()) {
            score.roll(num);
            return;
        }
        bonusPins.saveBonusPin(num);
    }

    @Override
    void doRefreshPinNum(Frame currentFrame, FrameScore score) {
        score.rollBonusPins(this, this);
    }

    @Override
    List<Integer> doGetRecentlyPinNums(Frame askFrame, FrameScore score, int amount) {
        if (!askFrame.isLast()) {
            return buildRecentlyPinNumsForNormal(score, amount);
        }

        if (bonusPins.isEmpty()) {
            return Collections.emptyList();
        }
        return buildRecentlyPinNumsForLast();
    }

    private List<Integer> buildRecentlyPinNumsForNormal(FrameScore score, int amount) {
        if (!score.isPossibleGettingPins(amount)) {
            return Collections.emptyList();
        }
        return score.getPins(amount);
    }

    private List<Integer> buildRecentlyPinNumsForLast() {
        Pin bonusPin = bonusPins.getBonusPin();
        return Collections.singletonList(bonusPin.getNum());
    }

    @Override
    boolean doCheckFinish(FrameScore score) {
        return score.isRegularFinish() && score.isBonusFinish();
    }

    @Override
    public boolean isLast() {
        return true;
    }

    @Override
    void addFrameResult(Board board, int baseScore) {
        FrameResult result = getResult(baseScore);
        board.addResult(result);
    }
}
