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
}
