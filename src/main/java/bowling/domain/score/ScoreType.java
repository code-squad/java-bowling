package bowling.domain.score;

import bowling.domain.frame.element.Element;

import static bowling.utils.ScoreUtils.MAX_POSSIBLE_SCORE;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_POSSIBLE_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.emptyBlockFormat;
import static bowling.utils.StringUtils.scoreResultFormat;
import static bowling.utils.StringUtils.getIngFormat;

public enum ScoreType {
    STRIKE("X") {
        public boolean match(Element element) { return this.isStrike(element); }
        public String convert(Element element) { return emptyBlockFormat(this.get()); }
    },
    SPARE("/") {
        public boolean match(Element element) { return this.isSpare(element); }
        public String convert(Element element) { return getIngFormat(scoreResultFormat(element.firstScoreToString(), this.get())); }
    },
    MISS("-") {
        public boolean match(Element element) { return this.isFirstMiss(element) || this.isSecondMiss(element); }
        public String convert(Element element) {
            if(this.isSecondMiss(element)) return getIngFormat(scoreResultFormat(element.firstScoreToString(), this.get()));
            return getIngFormat(scoreResultFormat(this.get(), element.secondScoreToString()));
        }
    },
    GUTTER("-"){
        public boolean match(Element element) { return this.isGutter(element); }
        public String convert(Element element) { return emptyBlockFormat(this.get()); }
    },
    NUMBER("") {
        public boolean match(Element element) { return this.isNumber(element); }
        public String convert(Element element) { return getIngFormat(scoreResultFormat(element.firstScoreToString(), element.secondScoreToString())); }
    };

    private String value;

    ScoreType(String value) {
        this.value = value;
    }

    public abstract boolean match(Element element);

    public abstract String convert(Element element);

    public String get() {
        return value;
    }

    public boolean isStrike(Element element) {
        return element.getFirstScore() == MAX_SCORE;
    }

    boolean isSpare(Element element) {
        return element.getFirstScore() + element.getSecondScore() == MAX_SCORE;
    }

    boolean isFirstMiss(Element element) {
        int totalScore = element.getFirstScore() + element.getSecondScore();
        return element.getFirstScore() == MIN_SCORE && element.getSecondScore() > MIN_SCORE && totalScore != MAX_SCORE;
    }

    boolean isSecondMiss(Element element) {
        int totalScore = element.getFirstScore() + element.getSecondScore();
        return element.getFirstScore() > MIN_SCORE && element.getSecondScore() == MIN_SCORE && totalScore != MAX_SCORE;
    }

    boolean isGutter(Element element) {
        return element.getFirstScore() == MIN_SCORE && element.getSecondScore() == MIN_SCORE;
    }

    boolean isNumber(Element element) {
        int totalScore = element.getFirstScore() + element.getSecondScore();
        return MIN_POSSIBLE_SCORE <= totalScore && totalScore <= MAX_POSSIBLE_SCORE;
    }
}