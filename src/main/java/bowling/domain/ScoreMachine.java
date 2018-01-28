package bowling.domain;

import bowling.domain.score.EntireScore;
import bowling.domain.score.type.FinalScoreType;
import bowling.domain.score.type.NormalScoreType;
import bowling.domain.score.type.ScoreType;

import java.util.Arrays;
import java.util.Optional;

public class ScoreMachine {

    public static String convertScore(EntireScore entireScore) {
        return calculateScore(entireScore).get().convert(entireScore);
    }

    public static String convertFinalScore(EntireScore entireScore) {
        return calculateFianlScore(entireScore).get().convert(entireScore);
    }

    private static Optional<? extends ScoreType> calculateScore(EntireScore entireScore) {
        return Arrays.stream(NormalScoreType.values()).filter(type -> type.match(entireScore)).findFirst();
    }

    private static Optional<? extends ScoreType> calculateFianlScore(EntireScore entireScore) {
        Optional<? extends ScoreType> scoreCalculate = Arrays.stream(FinalScoreType.values()).filter(type -> type.match(entireScore)).findFirst();
        if(!scoreCalculate.isPresent()) { return calculateScore(entireScore); } //TODO: orElse를 사용하려면 generic적용이 안됨...가능 여부 공부
        return scoreCalculate;
    }
}
