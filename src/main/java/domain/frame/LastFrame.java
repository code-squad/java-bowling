package domain.frame;

import domain.frame.result.message.ScoreMessage;
import domain.frame.result.score.FrameScore;
import domain.frame.status.FrameStatus;

public class LastFrame extends Frame {

    @Override
    boolean doCheckFinish(FrameStatus status) {
        if (!status.isFinish() || !isBonus()) {
            return false;
        }
        return isBonusFinish();
    }

    @Override
    String doConvert(FrameStatus status, FrameScore score, int num) {
        if (status.isBonus() && score != null) {
            return ScoreMessage.convertMessage(num);
        }
        return status.convertScore(num);
    }
}
