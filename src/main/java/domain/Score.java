package domain;

import java.util.List;

public class Score {
    public static final int MIN = 0;
    public static final int MAX = 10;
    private int score;

    public Score(int score) {
        if (!isValidRange(score)) {
            throw new IllegalArgumentException("유효하지않은 범위의 점수입니다");
        }
        this.score = score;
    }

    public static boolean isValidRange(int score) {
        return score >= MIN && score <= MAX;
    }

    public boolean isOverRecord(List<Score> scores) {
        int existingSum = 0;
        for (Score scoreInstance : scores) {
            existingSum += scoreInstance.score;
        }
        return existingSum + this.score > MAX;
    }
}
