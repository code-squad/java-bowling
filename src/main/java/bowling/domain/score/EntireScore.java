package bowling.domain.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EntireScore {
    private List<Score> scores = new ArrayList<>();

    public EntireScore(Score score) {
        scores.add(score);
    }

    public static EntireScore generate(Score score) {
        return new EntireScore(score);
    }

    public boolean validTotalScore(Score nextScore)  {
        return scores.get(0).validTotalScore(nextScore);
    }

    public Score lastScore() {
        return Optional.of(scores.get(scores.size()-1)).orElseThrow(() -> new IllegalArgumentException("프레임에 점수가 입력되지 않았습니다."));
    }

    public Score beforeLastScore() {
        return Optional.of(scores.get(scores.size()-2)).orElseThrow(() -> new IllegalArgumentException("프레임에 2번 이상 점수가 입력되지 않았습니다."));
    }

    public int length() {
        return scores.size();
    }

    public Integer getFirstScore() {
        return scores.get(0).get();
    }

    public String firstScoreToString() {
        return String.valueOf(getFirstScore());
    }

    public Integer getSecondScore() {
        return scores.get(1).get();
    }

    public String secondScoreToString() {
        return String.valueOf(getSecondScore());
    }

    public boolean hasSecondScore() {
        return scores.size() == 2;
    }

    public boolean hasThirdScore() { return scores.size() == 3; }

    public Score getScoreByKey(int key) { return scores.get(key); }

    public EntireScore inScore(Score nextScore) {
        scores.add(nextScore);
        return this;
    }
}
