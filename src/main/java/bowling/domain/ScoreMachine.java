package bowling.domain;

import bowling.domain.score.EntireScore;
import bowling.domain.score.ScoreType;

import java.util.Arrays;
import java.util.Optional;

public class ScoreMachine {

    public static Optional<ScoreType> calculateScore(EntireScore entireScore) {
        Optional<ScoreType> scoreCalculate = Arrays.stream(ScoreType.values()).filter(type -> type.match(entireScore)).findFirst();
        return scoreCalculate;
    }

    public static String convertScoreToString(EntireScore entireScore) {
        return calculateScore(entireScore).get().convert(entireScore);
    }
}
