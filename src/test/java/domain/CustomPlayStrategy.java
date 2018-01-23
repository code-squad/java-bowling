package domain;

import domain.score.FirstScore;
import domain.score.SecondScore;
import domain.score.TotalScore;

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
    public FirstScore playFirstScore(int frameNo) {
        return firstScore;
    }

    @Override
    public TotalScore playSecondScore(int frameNo, FirstScore firstScore) {
        return new TotalScore(firstScore, secondScore);
    }
}
