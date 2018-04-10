package domain.frame;

import domain.frame.result.message.ScoreMessage;
import domain.frame.result.score.FrameScore;
import domain.frame.status.FrameStatus;

public class LastFrame extends Frame {

    @Override
    String doConvert(FrameStatus status, FrameScore score, int num) {
        if (status.isBonus() && score.isStartedRecord()) {
            return ScoreMessage.convertMessage(num);
        }
        return status.convertScore(num);
    }

    @Override
    boolean doCheckFinish(FrameStatus status) {
        if (!status.isFinish()) {
            return false;
        }

        if (!status.isBonus()) {
            return true;
        }
        return isBonusFinish();
    }

    @Override
    public boolean isLast() {
        return true;
    }
}
