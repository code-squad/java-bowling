package bowling.model.score;

import java.util.List;

public class FinalScore implements Score {

    private List<Integer> scores;

    public FinalScore(List<Integer> scores) {
        this.scores = scores;
    }

    @Override
    public int currentScore() {
        return scores.get(0) + scores.get(1);
    }

    @Override
    public int firstScore() {
        return scores.get(0);
    }

    public int finalScore() {
        return scores.stream().reduce(0, (a, b) -> a + b);
    }

}
