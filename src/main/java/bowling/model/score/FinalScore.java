package bowling.model.score;

import java.util.List;

public class FinalScore implements Score {

    private List<Integer> scores;

    public FinalScore(List<Integer> scores) {
        this.scores = scores;
    }

    @Override
    public int currentScore() {
        return 0;
    }

    @Override
    public int firstScore() {
        return scores.get(0);
    }

}
