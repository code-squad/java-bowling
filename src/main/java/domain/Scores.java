package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Scores {

    private Score totalScore;
    private List<Score> scores;

    private Scores() {
        scores = new ArrayList<>();
        totalScore = Score.of();
    }

    public static Scores of() {
        return new Scores();
    }

    public void add(int score) {
        scores.add(Score.of(score));
        totalScore.sum(Score.of(score));
    }

    public boolean isTryFirst() {
        return scores.size() == 1;
    }

    public boolean isTrySecond() {
        return scores.size() == 2;
    }

    public boolean isTryThird() {
        return scores.size() == 3;
    }

    public Score getTotalScore() {
        return totalScore;
    }

    public String firstString() {
        return scores.get(0).toString();
    }

    public boolean isTen() {
        return totalScore.isTen();
    }

    public boolean isTwenty() {
        return totalScore.isTwenty();
    }

    public boolean isThirty() {
        return totalScore.isThirty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scores scores1 = (Scores) o;
        return Objects.equals(totalScore, scores1.totalScore) &&
                Objects.equals(scores, scores1.scores);
    }

    @Override
    public int hashCode() {

        return Objects.hash(totalScore, scores);
    }

    @Override
    public String toString() {
        return scores.stream().map(Score::toString).collect(Collectors.joining("|"));
    }

    public boolean isTotalScoreUnderTen() {
        return totalScore.isUnderTen();
    }

    public boolean isValidScoreForNormalCase(int score) {
        return totalScore.isValidAdditionScore(score);
    }

    public boolean isValidScoreForLastCase(int score) {
        boolean result = true;
        if (scores.size() == 1 && isTen()) {
            result = true;
        }
        if (scores.size() == 1 && !isTen()) {
            result = totalScore.isValidAdditionScore(score);
        }
        if (scores.size() == 2 && !isTen()) {
            result = true;
        }
        return result;
    }
}
