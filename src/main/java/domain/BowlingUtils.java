package domain;

import java.util.List;

public class BowlingUtils {

    public static int totalScore(List<Score> scores) {
        Score tempScore = Score.of(scores.get(0).getScore());
        for (int i = 1; i < scores.size(); i++) {
            tempScore.sum(scores.get(i));
        }
        return tempScore.getScore();
    }
}
