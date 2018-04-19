package domain.status;

import domain.Score;

import java.util.Arrays;
import java.util.List;

public class Strike extends FrameStatus{

    private Strike() {
        super(0);
     }

    public static Strike of() {
        return new Strike();
    }

    public void takeAdditionalFromPresent(FrameStatus frameStatus, List<Score> scores) {
        if (isDone()) return;
        if (frameStatus.isStrike()) {
            if (scores.size() != 1) {
                addScore(frameStatus, Arrays.asList(scores.get(0), scores.get(1)));
                changeNotYet();
                return;
            }
            addScore(frameStatus, scores);
            changeNotYet();
            return;
        }
        addScore(Score.of(scores.get(0).sumPrint(scores.get(1))));
        changeNotYet();
    }

    public void takeAdditionalFromBefore(FrameStatus frameStatus, List<Score> scores) {
        if (isNotYet()) {
            addWholeScores(frameStatus, scores);
            changeAddNotComplete();
        }
        frameStatus.changeDone();
    }
}
