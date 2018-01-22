package domain;

import domain.score.FirstScore;
import domain.score.SecondScore;

public class CustomPlayStrategy implements PlayStrategy {
    private final FirstScore firstScore;
    private final SecondScore secondScore;

    public CustomPlayStrategy(FirstScore firstScore, SecondScore secondScore) {
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    public CustomPlayStrategy(FirstScore firstScore) {
        if (!firstScore.isStrike()) {
            throw new IllegalArgumentException();
        }
        this.firstScore = firstScore;
        this.secondScore = null;
    }

    @Override
    public FirstScore playFirstScore() {
        return firstScore;
    }

    @Override
    public SecondScore playSecondScore(FirstScore firstScore) {
        return secondScore;
    }
}
