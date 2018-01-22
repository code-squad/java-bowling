package domain;

import domain.score.FirstScore;
import domain.score.SecondScore;

public interface PlayStrategy {
    FirstScore playFirstScore();

    SecondScore playSecondScore(FirstScore firstScore);
}
