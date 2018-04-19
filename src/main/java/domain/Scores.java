package domain;

import domain.status.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.BowlingUtils.totalScore;
import static domain.Figure.FRAMEBAR;
import static domain.Figure.SPARE;

public class Scores {

    private List<Score> scores;
    private FrameStatus frameStatus;

    private Scores() {
        scores = new ArrayList<>();
    }

    public static Scores of () {
        return new Scores();
    }

    public void assignStatus(int countOfPins) {
        scores.add(Score.of(countOfPins));
        if (isStrikeCondition(scores)) {
            frameStatus = Strike.of();
            return;
        }
        if (isSpareCondition(scores)) {
            frameStatus = Spare.of();
            return;
        }
        if (isBonusCondition()) {
            frameStatus = Strike.of();
            return;
        }
        frameStatus = Open.of(2 - scores.size());
    }

    public boolean isEnd() {
        if (frameStatus == null) {
            return false;
        }
        return frameStatus.isEnd();
    }

    private boolean isSpareCondition(List<Score> scores) {
        return scores.size() == 2 && totalScore(scores) == 10;
    }

    private boolean isStrikeCondition(List<Score> scores) {
        return scores.size() == 1 && scores.get(0).isTen();
    }

    private boolean isBonusCondition() {
        return scores.size() == 2 && scores.get(1).isTen() || scores.size() == 2 && scores.get(0).isTen() || scores.size() == 3;
    }

    public void takeFromPresent(Scores presentScores) {
        frameStatus.takeAdditionalFromPresent(presentScores.frameStatus, presentScores.scores);
    }

    public void takeFromBefore(Scores beforeScores) {
        frameStatus.takeAdditionalFromBefore(beforeScores.frameStatus, beforeScores.scores);
    }

    public void changeDo() {
        frameStatus.changeDo();
    }

    public boolean isDo() {
        return frameStatus.isDo();
    }

    public void changeNotYet() {
        frameStatus.changeNotYet();
    }

    public boolean isSpare() {
        try {
            return frameStatus.isSpare();
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean isStrike() {
        return frameStatus.isStrike();
    }

    public boolean isOpen() {
        return frameStatus.isOpen();
    }

    boolean isValidScore(final int score, int compareIndex) {
        if (compareIndex == 0) {
            return Score.of().isValidAdditionScore(score);
        }
        return scores.get(compareIndex).isValidAdditionScore(score);
    }

    public String toScoreString() {
        return scores.stream().map(Score::toString).collect(Collectors.joining(FRAMEBAR.toString()));
    }

    public String spareString() {
        return scores.get(0).toString() + FRAMEBAR + SPARE;
    }

    public int getTotalScore() {
        if (frameStatus == null) {
            return 0;
        }
        return frameStatus.calcTotal(scores);
    }

    public CalculateStatus getCalculateStatus() {
        return frameStatus.getCalculateStatus();
    }

    public FrameStatus getFrameStatus() {
        return frameStatus;
    }
}
