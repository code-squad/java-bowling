package bowling.domain.score.type;

import bowling.domain.score.EntireScore;

import java.util.function.Function;

import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.scoreResultFormat;

public enum NormalScoreType implements ScoreType {
    STRIKE("X", entireScore -> isStrike(entireScore)) {
        public String convert(EntireScore entireScore) { return this.get(); }
    },
    SPARE("/", entireScore -> isSpare(entireScore)) {
        public String convert(EntireScore entireScore) { return scoreResultFormat(String.valueOf(entireScore.beforeLastScore().get()), this.get()); }
    },
    MISS("-", entireScore -> isMiss(entireScore)) {
        public String convert(EntireScore entireScore) { return this.get(); }
    },
    NUMBER("", entireScore -> isNumber(entireScore)) {
        public String convert(EntireScore entireScore) { return String.valueOf(entireScore.lastScore().get()); }
    },
    DUAL("|", entireScore -> isDual(entireScore)) {
        public String convert(EntireScore entireScore) {
            Integer first = entireScore.beforeLastScore().get();
            Integer second = entireScore.lastScore().get();
            return convertString(first) + this.get() + convertString(second);
        }

        private String convertString(Integer first) {
            return first == MIN_SCORE ? MISS.get() : String.valueOf(first);
        }
    };

    private String value;
    private Function<EntireScore, Boolean> match;

    NormalScoreType(String value, Function<EntireScore, Boolean> match) {
        this.value = value;
        this.match = match;
    }

    public String get() {
        return this.value;
    }

    public boolean match(EntireScore entireScore) {
        return this.match.apply(entireScore);
    }

    public static boolean isStrike(EntireScore entireScore) {
        return entireScore.length() == 1 && entireScore.lastScore().get() == MAX_SCORE;
    }

    public static boolean isSpare(EntireScore entireScore) {
        return entireScore.length() > 1 && entireScore.beforeLastScore().get() + entireScore.lastScore().get() == MAX_SCORE;
    }

    public static boolean isMiss(EntireScore entireScore) {
        return entireScore.length() == 1 && entireScore.lastScore().get() == MIN_SCORE;
    }

    public static boolean isNumber(EntireScore entireScore) {
        return entireScore.length() == 1 && !isStrike(entireScore) && !isMiss(entireScore);
    }

    public static boolean isDual(EntireScore entireScore) {
        return entireScore.length() > 1 && !isStrike(entireScore) && !isSpare(entireScore);
    }
}
