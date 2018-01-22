package domain;

import domain.score.FirstScore;
import domain.score.SecondScore;

public interface PlayStrategy {
    FirstScore playFirstScore(int frameNo);

    SecondScore playSecondScore(int frameNo, FirstScore firstScore);
}
