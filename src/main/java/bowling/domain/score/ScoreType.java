package bowling.domain.score;

import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.scoreResultFormat;

public enum ScoreType {
    STRIKE("X") {
        public boolean match(EntireScore entireScore) { return this.isStrike(entireScore); }
        public String convert(EntireScore entireScore) { return this.get(); }
    },
    SPARE("/") {
        public boolean match(EntireScore entireScore) { return this.isSpare(entireScore); }
        public String convert(EntireScore entireScore) { return scoreResultFormat(String.valueOf(entireScore.getBeforeLastScore().get()), this.get()); }
    },
    MISS("-") {
        public boolean match(EntireScore entireScore) { return this.isMiss(entireScore); }
        public String convert(EntireScore entireScore) { return this.get(); }
    },
    NUMBER("") {
        public boolean match(EntireScore entireScore) { return this.isNumber(entireScore); }
        public String convert(EntireScore entireScore) { return entireScore.firstScoreToString(); }
    },
    DUAL("|") {
        public boolean match(EntireScore entireScore) { return this.isDual(entireScore); }
        public String convert(EntireScore entireScore) {
            Integer first = entireScore.getBeforeLastScore().get();
            Integer second = entireScore.getLastScore().get();
            return (first == MIN_SCORE ? MISS.get() : String.valueOf(first)) + this.get() + (second == MIN_SCORE ? MISS.get() : String.valueOf(second));
        }
    };

    private String value;

    ScoreType(String value) {
        this.value = value;
    }

    public abstract boolean match(EntireScore entireScore);

    public abstract String convert(EntireScore entireScore);

    public String get() {
        return value;
    }

    public boolean isStrike(EntireScore entireScore) {
        return entireScore.getLastScore().get() == MAX_SCORE;
    }

    boolean isSpare(EntireScore entireScore) {
        return entireScore.hasSecondScore() && entireScore.getFirstScore() + entireScore.getSecondScore() == MAX_SCORE;
    }

    boolean isMiss(EntireScore entireScore) {
        return entireScore.length() == 1 && entireScore.getLastScore().get() == MIN_SCORE;
    }

    boolean isNumber(EntireScore entireScore) {
        return entireScore.length() == 1 && !isStrike(entireScore) && !isMiss(entireScore);
    }

    boolean isDual(EntireScore entireScore) {
        return entireScore.length() > 1 && !isStrike(entireScore) && !isSpare(entireScore);
    }

}