package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scores {

    Score totalScore;
    List<Score> scores;

    public Scores() {
        scores = new ArrayList<>();
        totalScore = Score.of();
    }

    public void add(int score) {
        scores.add(Score.of(score));
        this.totalScore = totalScore.sum(Score.of(score));
    }

    public boolean isTen() {
        return totalScore.equals(Score.of(10));
    }

    public boolean isTrySecond() {
        return scores.size() == 2;
    }

    public boolean isTryFirst() {
        return scores.size() == 1;
    }

    public Score getTotalScore() {
        return totalScore;
    }

    public boolean isTryThird() {
        return scores.size() == 3;
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

    public int getSize() {
        return scores.size();
    }
}
