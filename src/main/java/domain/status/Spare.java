package domain.status;

import domain.Score;

import java.util.List;

public class Spare extends FrameStatus {

    private Spare() {
        super(0);
    }

    public static Spare of() {
        return new Spare();
    }

    public void takeAdditionalFromPresent(FrameStatus frameStatus, List<Score> scores) {
        if (isDone()) return;
        if ((frameStatus.isOpen() || frameStatus.isSpare()) && frameStatus.isEnd()) return;
        addScore(scores.get(0));
        if (frameStatus.isStrike()) {
            frameStatus.changeAddNotComplete();
        }
    }

    public void takeAdditionalFromBefore(FrameStatus frameStatus, List<Score> scores) {
        if (isNotYet()) {
            addWholeScores(frameStatus, scores);
            changeAddNotComplete();
        }
        frameStatus.changeDone();
    }
}
