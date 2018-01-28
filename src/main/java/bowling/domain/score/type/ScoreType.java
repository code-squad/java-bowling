package bowling.domain.score.type;

import bowling.domain.score.EntireScore;

public interface ScoreType {
    String convert(EntireScore entireScore);
}
