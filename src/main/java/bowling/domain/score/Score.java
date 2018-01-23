package bowling.domain.score;

import java.util.Optional;

import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;

public class Score {
    private Integer score;

    private Score(Optional<Integer> score) {
        this.score = score.filter(Score::isValidScore).orElseThrow(() -> new IllegalArgumentException("점수는 1~10사이만 허용됩니다."));
    }

    public static Score in(Optional<Integer> score) {
        return new Score(score);
    }

    private static boolean isValidScore(Integer score) {
        return MIN_SCORE <= score && score <= MAX_SCORE;
    }

    public boolean checkNextScore(Score score) {
        int totalScore = this.score + score.get();
        return isValidScore(totalScore);
    }

    public Integer get() {
        return score;
    }
}
