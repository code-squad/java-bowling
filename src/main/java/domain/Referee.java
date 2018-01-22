package domain;

import domain.score.FirstScore;
import domain.score.TotalScore;

public class Referee {

    private final PlayStrategy strategy;

    public Referee(PlayStrategy strategy) {
        this.strategy = strategy;
    }

    public TotalScore playNextFrame() {
        FirstScore firstScore = strategy.playFirstScore();
        if (firstScore.isStrike()) {
            return new TotalScore(firstScore);
        }
        return new TotalScore(firstScore, strategy.playSecondScore(firstScore));
    }

    public TotalScore playOnlyFirst() {
        FirstScore firstScore = strategy.playFirstScore();
        if (firstScore.isStrike()) {
            return new TotalScore(firstScore);
        }
        return new TotalScore(firstScore, 0);
    }
}
