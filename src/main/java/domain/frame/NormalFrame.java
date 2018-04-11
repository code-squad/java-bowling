package domain.frame;

import domain.frame.result.score.FrameScore;
import domain.frame.status.FrameStatus;

public class NormalFrame extends Frame {

    @Override
    boolean doCheckFinish(FrameStatus status, FrameScore score) {
        return status.isFinish() && score != null;
    }

    @Override
    String doConvert(FrameStatus status, FrameScore score, int num) {
        if (status.isFinish() && score.isRecordStared()) {
            return null;
        }
        return status.convertScore(num);
    }
}
