package bowling.domain;

import java.util.List;

public class ScoreResult {

    private List<Score> scores;

    private ScoreResult(List<Score> scores) {
        this.scores = scores;
    }

    public static ScoreResult of(List<Score> scores) {
        return new ScoreResult(scores);
    }

    public List<Score> getScores() {
        return scores;
    }
}
