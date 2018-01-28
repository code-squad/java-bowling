package bowling.domain.score.type;

import bowling.domain.score.EntireScore;
import bowling.domain.score.Score;

import java.util.function.Function;

import static bowling.domain.ScoreMachine.convertFinalScore;
import static bowling.domain.score.type.NormalScoreType.*;
import static bowling.utils.StringUtils.scoreResultFormat;

/**
 * Created by youngjae on 2018. 1. 27..
 */
public enum FinalScoreType implements ScoreType {
    STRIKE_AND_DUAL(entireScore -> isStrikeAndDual(entireScore)) {
        public String convert(EntireScore entireScore) {
            return firstStrikeFormat(entireScore.lastScore());
        }
    },
    STRIKE_AND_SPARE(entireScore -> isFirstStrikeAndSpare(entireScore)) {
        public String convert(EntireScore entireScore) {
            String result1 = firstStrikeFormat(entireScore.beforeLastScore());

            return scoreResultFormat(result1, SPARE.get());
        }
    },
    FIRST_STRIKE_OTHER(entireScore -> isFirstStrikeAndThree(entireScore)) {
        public String convert(EntireScore entireScore) {
            String result1 = firstStrikeFormat(entireScore.beforeLastScore());
            String result2 = convertFinalScore(EntireScore.generate(entireScore.lastScore()));

            return scoreResultFormat(result1, result2);
        }
    },
    THREE(entireScore -> isThree(entireScore)) {
        public String convert(EntireScore entireScore) {
            EntireScore firstEntire = EntireScore.generate(entireScore.firstScore());
            String result1 = convertFinalScore(firstEntire.inScore(entireScore.beforeLastScore()));
            String result2 = convertFinalScore(EntireScore.generate(entireScore.lastScore()));

            return scoreResultFormat(result1, result2);
        }
    };

    private Function<EntireScore, Boolean> match;

    FinalScoreType(Function<EntireScore, Boolean> match) {
        this.match = match;
    }

    public boolean match(EntireScore entireScore) {
        return this.match.apply(entireScore);
    }

    private static Boolean isStrikeAndDual(EntireScore entireScore) {
        return entireScore.length() == 2 && isStrike(EntireScore.generate(entireScore.firstScore()));
    }

    private static Boolean isFirstStrikeAndSpare(EntireScore entireScore) {
        return isFirstStrikeAndThree(entireScore) && isSpare(EntireScore.generate(entireScore.beforeLastScore()).inScore(entireScore.lastScore()));
    }

    private static Boolean isFirstStrikeAndThree(EntireScore entireScore) {
        return isStrike(EntireScore.generate(entireScore.firstScore())) && isThree(entireScore);
    }

    public static boolean isThree(EntireScore entireScore) {
        return entireScore.length() == 3;
    }

    public static String firstStrikeFormat(Score score) {
        return scoreResultFormat(STRIKE.get(), convertFinalScore(EntireScore.generate(score)));
    }

}
