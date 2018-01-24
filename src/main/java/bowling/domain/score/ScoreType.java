package bowling.domain.score;

import static bowling.utils.ScoreUtils.MAX_POSSIBLE_SCORE;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_POSSIBLE_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.scoreResultFormat;

public enum ScoreType {
    STRIKE("X") {
        public boolean match(EntireScore entireScore) { return this.isStrike(entireScore); }
        public String convert(EntireScore entireScore) { return this.get(); }
    },
    SPARE("/") {
        public boolean match(EntireScore entireScore) { return this.isSpare(entireScore); }
        public String convert(EntireScore entireScore) { return scoreResultFormat(entireScore.firstScoreToString(), this.get()); }
    },
    MISS("-") {
        public boolean match(EntireScore entireScore) { return this.isFirstMiss(entireScore) || this.isSecondMiss(entireScore); }
        public String convert(EntireScore entireScore) {
            if(this.isSecondMiss(entireScore)) return scoreResultFormat(entireScore.firstScoreToString(), this.get());
            return scoreResultFormat(this.get(), entireScore.secondScoreToString());
        }
    },
    GUTTER("-"){
        public boolean match(EntireScore entireScore) { return this.isGutter(entireScore); }
        public String convert(EntireScore entireScore) { return this.get(); }
    },
    NUMBER("") {
        public boolean match(EntireScore entireScore) { return this.isNumber(entireScore); }
        public String convert(EntireScore entireScore) { return scoreResultFormat(entireScore.firstScoreToString(), entireScore.secondScoreToString()); }
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
        return entireScore.getFirstScore() == MAX_SCORE;
    }

    boolean isSpare(EntireScore entireScore) {
        return entireScore.hasSecondScore() && entireScore.getFirstScore() + entireScore.getSecondScore() == MAX_SCORE;
    }

    boolean isFirstMiss(EntireScore entireScore) {
        return entireScore.hasSecondScore() && entireScore.getFirstScore() == MIN_SCORE && entireScore.getSecondScore() > MIN_SCORE && (entireScore.getFirstScore() + entireScore.getSecondScore()) != MAX_SCORE;
    }

    boolean isSecondMiss(EntireScore entireScore) {
        return entireScore.hasSecondScore() && entireScore.getFirstScore() > MIN_SCORE && entireScore.getSecondScore() == MIN_SCORE && (entireScore.getFirstScore() + entireScore.getSecondScore()) != MAX_SCORE;
    }

    boolean isGutter(EntireScore entireScore) {
        return entireScore.getFirstScore() == MIN_SCORE && (entireScore.hasSecondScore() && entireScore.getSecondScore() == MIN_SCORE);
    }

    boolean isNumber(EntireScore entireScore) {
        if(!entireScore.hasSecondScore()) return false;
        int totalScore = entireScore.getFirstScore() + entireScore.getSecondScore();
        return MIN_POSSIBLE_SCORE <= totalScore && totalScore <= MAX_POSSIBLE_SCORE;
    }

}