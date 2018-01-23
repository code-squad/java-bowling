package domain;

import domain.score.FirstScore;
import domain.score.TotalScore;

public interface PlayStrategy {
    FirstScore playFirstScore(int frameNo);

    TotalScore playSecondScore(int frameNo, FirstScore firstScore);
}
