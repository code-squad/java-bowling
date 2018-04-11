package domain.frame;

import domain.frame.result.message.ScoreMessage;
import domain.frame.result.score.FrameScore;
import domain.frame.status.FrameStatus;

public class LastFrame extends Frame {

    @Override
    boolean doCheckFinish(FrameStatus status, FrameScore score) {
        return status.isFinish() && score.isDone();
    }

    @Override
    String doConvert(FrameStatus status, FrameScore score, int num) {
        if (status.isBonus() && score.isRecordStared()) {
            return ScoreMessage.convertMessage(num);
        }
        return status.convertScore(num);
    }
}
