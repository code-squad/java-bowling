package domain;

import domain.status.FrameStatus;
import domain.status.Open;
import domain.status.Spare;
import domain.status.Strike;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Figure.FRAMEBAR;

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
        if (isStrike(scores)) {
            frameStatus = Strike.of();
            return;
        }
        if (isSpare(scores)) {
            frameStatus = Spare.of();
            return;
        }
        frameStatus = Open.of(2 - scores.size());
    }

    public boolean isEnd() {
        return frameStatus.isEnd();
    }

    private boolean isSpare(List<Score> scores) {
        return scores.size() == 2 && totalScore(scores).isTen();
    }

    private boolean isStrike(List<Score> scores) {
        return scores.size() == 1 && scores.get(0).isTen();
    }

    private Score totalScore(List<Score> scores) {
        int result = 0;
        for (Score score : scores) {
            result += score.getScore();
        }
        return Score.of(result);
    }

    public void takeFromPresent(Scores presentScores) {
        frameStatus.takeAdditionalFromPresent(presentScores.frameStatus, presentScores.scores);
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
        return frameStatus.isSpare();
    }

    boolean isValidScore(final int score) {
        return isValidScoreToTotalScore(score, 0);
    }

    boolean isValidScoreToTotalScore(final int score, final int compareIndex) {
        if (compareIndex == 0) {
            return Score.of().isValidAdditionScore(score);
        }
        return scores.get(compareIndex).isValidAdditionScore(score);
    }

    public String toScoreString() {
        return scores.stream().map(Score::toString).collect(Collectors.joining(FRAMEBAR.toString()));
    }

    public int getTotalScore() {
        if (frameStatus == null) {
            return 0;
        }
        return frameStatus.calcTotal(totalScore(scores));
    }
}
