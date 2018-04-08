package domain;

import java.util.ArrayList;
import java.util.List;

public class Scores {
    private static final int LIMIT_NUM = 2;
    private List<Score> scores = new ArrayList<>();

    public Score addScore(int number) throws IllegalArgumentException {
        Score newScore = new Score(number);
        if (newScore.isOverRecord(scores)) {
            throw new IllegalArgumentException("합산 : " + Score.MAX + "점을 넘을 수 없습니다");
        }
        scores.add(newScore);
        return newScore;
    }

    public boolean isFinish() {
        return isLimitSize() || isScoreLimit();
    }

    public boolean isScoreLimit() {
        return Score.isScoreLimit(scores);
    }

    public boolean isLimitSize() {
        return scores.size() == LIMIT_NUM;
    }
}
