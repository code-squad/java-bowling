package bowling.domain;

import bowling.domain.score.EntireScore;
import bowling.domain.score.ScoreType;

import java.util.Arrays;
import java.util.Optional;

import static bowling.domain.score.ScoreType.MISS;
import static bowling.domain.score.ScoreType.STRIKE;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;

public class ScoreMachine {

    public static Optional<ScoreType> calculateScore(EntireScore entireScore) {
        Optional<ScoreType> scoreCalculate = Arrays.stream(ScoreType.values()).filter(type -> type.match(entireScore)).findFirst();
        return scoreCalculate;
    }

    public static String convertScoreToString(ScoreType scoreType, EntireScore entireScore) {
        return scoreType.convert(entireScore);
    }

    public static String firstCalculate(EntireScore entireScore) {
        if(STRIKE.match(entireScore)) { return STRIKE.convert(entireScore); }
        else if(isValidNumber(entireScore.getFirstScore())) { return entireScore.firstScoreToString(); }
        return MISS.get();
    }

    private static boolean isValidNumber(Integer score) {
        return MIN_SCORE <= score && score <= MAX_SCORE;
    }
}
