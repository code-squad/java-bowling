package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Figure.FRAMEBAR;
import static domain.Figure.SPARE;

public class ScoreManager {

    private Score frameScore;
    private Score totalScore;
    private List<Score> scores;

    private ScoreManager() {
        frameScore = Score.of();
        totalScore = Score.of();
        scores = new ArrayList<>();
    }

    private ScoreManager(int totalScore) {
        frameScore = Score.of();
        this.totalScore = Score.of();
        this.totalScore.sum(totalScore);
        scores = new ArrayList<>();
    }

    public static ScoreManager of() {
        return new ScoreManager();
    }

    public static ScoreManager totalScoreOf(int score) {
        return new ScoreManager(score);
    }

    boolean isTrySecond() {
        return scores.size() == 2;
    }

    boolean isSpare() {
        return frameScore.isTen() && isTrySecond();
    }

    boolean isStrike(int index) {
        return scores.get(index).isTen();
    }

    Score getFrameScore() {
        return frameScore;
    }

    boolean isValidScore(final int score) {
        return isValidScoreToTotalScore(score, 0);
    }

    boolean isValidScoreToTotalScore(final int score, final int compareIndex) {
        if (compareIndex == 0) {
            return frameScore.isValidAdditionScore(score);
        }
        return scores.get(compareIndex).isValidAdditionScore(score);
    }

    public void add(int score) {
        this.scores.add(Score.of(score));
        this.frameScore.sum(Score.of(score));
        this.totalScore.sum(Score.of(score));
    }

    public boolean isBonusOverThirty() {
        return totalScore.isBonusOverThirty();
    }

    public void sum(int i) {
        totalScore.sum(i);
    }

    public void sum(ScoreManager scoreManager) {
        totalScore.sum(scoreManager.totalScore);
    }

    public Score getTotalScore() {
        return totalScore;
    }

    public String toScoreString() {
        return scores.stream().map(Score::toString).collect(Collectors.joining(FRAMEBAR.toString()));
    }

    public String spareString() {
        return scores.get(0).toString() + FRAMEBAR + SPARE;
    }

}
