package domain.status;

import domain.CalculateStatus;
import domain.Score;

import java.util.ArrayList;
import java.util.List;

import static domain.CalculateStatus.DO;
import static domain.CalculateStatus.NOT_YET;

public abstract class FrameStatus {

    private List<Score> additionalScore = new ArrayList<>();
    private CalculateStatus calculateStatus = NOT_YET;
    private int left = 2;

    FrameStatus() {
    }

    FrameStatus(int left) {
        this.left = left;
    }

    FrameStatus(int left, CalculateStatus calculateStatus) {
        this.left = left;
        this.calculateStatus = calculateStatus;
    }

    public boolean isEnd() {
        System.out.println("남은 시도 횟수 " + left);
        return left == 0;
    }

    public abstract void takeAdditionalFromPresent(FrameStatus frameStatus, List<Score> scores);

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

    public void addScore(FrameStatus frameStatus, Score score) {
        additionalScore.addAll(frameStatus.additionalScore);
        additionalScore.add(score);
    }

    public void addScore(Score score) {
        additionalScore.add(score);
    }

    public boolean isDo() {
        return calculateStatus == DO;
    }

    public void changeNotYet() {
        calculateStatus = NOT_YET;
    }

    public int calcTotal(Score score) {
        return score.sumPrint(additionalScore);
    }

}
