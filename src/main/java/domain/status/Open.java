package domain.status;

import domain.Score;

import java.util.List;

public class Open extends FrameStatus {

    private Open() {
    }

    private Open(int left) {
        super(left);
        if (isEnd()) super.changeDo();
    }

    public static Open of() {
        return new Open();
    }

    public static Open of(int left) {
        return new Open(left);
    }

    public void takeAdditionalFromPresent(FrameStatus frameStatus, List<Score> scores) {
        return;
    }

    public void takeAdditionalFromBefore(FrameStatus frameStatus, List<Score> scores) {
        if (isNotYet()) {
            addWholeScores(frameStatus, scores);
        }
        frameStatus.changeDone();
        changeDone();
    }
}
