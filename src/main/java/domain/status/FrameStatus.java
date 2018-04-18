package domain.status;

import domain.CalculateStatus;
import domain.Score;

import java.util.ArrayList;
import java.util.List;

import static domain.BowlingUtils.totalScore;
import static domain.CalculateStatus.*;

public abstract class FrameStatus {

    private List<Score> additionalScore = new ArrayList<>();
    private CalculateStatus calculateStatus = NOT_YET;
    private int left = 2;

    FrameStatus() {
    }

    FrameStatus(int left) {
        this.left = left;
    }

    public boolean isEnd() {
        return left == 0;
    }

    public abstract void takeAdditionalFromPresent(FrameStatus frameStatus, List<Score> scores);

    public abstract void takeAdditionalFromBefore(FrameStatus frameStatus, List<Score> scores);

    public boolean isOpen() {
        return this instanceof Open;
    }

    public boolean isSpare() {
        return this instanceof Spare;
    }

    public boolean isStrike() {
        return this instanceof Strike;
    }

    public void changeDo() {
        calculateStatus = DO;
    }

    public void addWholeScores(FrameStatus frameStatus, List<Score> scores) {
        additionalScore.addAll(frameStatus.additionalScore);
        additionalScore.addAll(scores);
    }

    public void addScore(FrameStatus frameStatus, List<Score> score) {
        if (frameStatus.additionalScore.size() > 1) {
            additionalScore.add(frameStatus.additionalScore.get(1));
            additionalScore.addAll(score);
            return;
        }
        additionalScore.addAll(frameStatus.additionalScore);
        additionalScore.addAll(score);
    }

    public void addScore(Score score) {
        additionalScore.add(score);
    }

    public boolean isDo() {
        return calculateStatus == DO;
    }

    public boolean isNotYet() {
        return calculateStatus == NOT_YET;
    }

    public boolean isDone() {
        return calculateStatus == DONE;
    }

    public void changeNotYet() {
        calculateStatus = NOT_YET;
    }

    public void changeDone() {
        calculateStatus = DONE;
    }

    public int calcTotal(List<Score> scores) {
        List<Score> temp = new ArrayList<>();
        temp.addAll(scores);
        temp.addAll(additionalScore);
        return totalScore(temp);
    }

    public void changeAddNotComplete() {
        calculateStatus = BONUS_NOT_COMPLETE;
    }
}
