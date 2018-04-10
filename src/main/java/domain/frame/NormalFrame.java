package domain.frame;

import domain.frame.result.score.FrameScore;
import domain.frame.status.FrameStatus;

public class NormalFrame extends Frame {

    @Override
    public String doConvert(FrameStatus status, FrameScore score, int num) {
        if (status.isFinish() && score.isStartedRecord()) {
            return null;
        }
        return status.convertScore(num);
    }

    @Override
    public boolean doCheckFinish(FrameStatus status) {
        return status.isFinish();
    }

    @Override
    public boolean isLast() {
        return false;
    }
}
