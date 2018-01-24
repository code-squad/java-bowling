package bowling.domain.frame;

import java.util.Optional;

import bowling.domain.ScoreMachine;
import bowling.domain.frame.element.Element;
import bowling.domain.frame.element.FinalElement;
import bowling.domain.score.Score;
import bowling.domain.score.ScoreType;

import static bowling.domain.score.ScoreType.GUTTER;
import static bowling.domain.score.ScoreType.MISS;
import static bowling.domain.score.ScoreType.NUMBER;
import static bowling.domain.score.ScoreType.SPARE;
import static bowling.domain.score.ScoreType.STRIKE;
import static bowling.utils.StringUtils.scoreResultFormat;

public class FinalFrame implements Frame {
    private FinalElement finalElement;
    private String result;

    private FinalFrame(Score score) {
        finalElement = finalElement.generate(score);
        result = ScoreMachine.firstCalculate(finalElement);
    }

    public static FinalFrame generate(Score score) {
        return new FinalFrame(score);
    }

    @Override
    public boolean isEnd() {
        return isFirstAndSecondAreNumber() || isStrikeAndHasThird() || isSpareAndHasThird() || isMissOrGutterAndHasSecond();
    }

    @Override
    public FinalFrame nextRound(Score nextScore) {
        if(isFirstStrikeAndHasNotSecond()) { result = getResultMapping(SECOND_SCORE, nextScore); }
        else if(!finalElement.hasSecondScore()) { result = getResultMapping(nextScore); }
        else if(!finalElement.hasThirdScore()) { result = thirdScoreCalculate(nextScore); }

        return this;
    }

    @Override
    public String result() {
        return result;
    }

    @Override
    public Element getElement() {
        return finalElement;
    }

    @Override
    public String formattingResult() {
        return null;
    }

    private String thirdScoreCalculate(Score nextScore) {
        if(isFirstOrSecondStrike()) { return getResultMapping(FIRST_SCORE, nextScore); }
        Optional<ScoreType> scoreType = ScoreMachine.calculateScore(FinalElement.generate(finalElement.getScoreByKey(SECOND_SCORE)).inScore(THIRD_SCORE, nextScore));
        return scoreType.map(this::resultFormat).get();
    }

    private String getResultMapping(Score nextScore) {
        return getScoreType(SECOND_SCORE, nextScore)
                .map(this::stringFormat)
                .orElse(scoreResultFormat(result, String.valueOf(nextScore.get())));
    }

    private String getResultMapping(String key, Score nextScore) {
        return getScoreType(key, nextScore)
                .map(this::resultFormat)
                .orElse(scoreResultFormat(result, String.valueOf(nextScore.get())));
    }

    private String resultFormat(ScoreType type) {
        return scoreResultFormat(result, stringFormat(type));
    }

    private String stringFormat(ScoreType type) {
        return ScoreMachine.convertScoreToString(type, finalElement);
    }

    private boolean isFirstStrikeAndHasNotSecond() {
        return STRIKE.match(finalElement) && !finalElement.hasSecondScore();
    }

    private boolean isFirstOrSecondStrike() {
        return SPARE.match(finalElement) || STRIKE.match(FinalElement.generate(finalElement.getScoreByKey(SECOND_SCORE)));
    }

    private Optional<ScoreType> getScoreType(String key, Score nextScore) {
        return ScoreMachine.calculateScore(finalElement.inScore(key, nextScore));
    }

    private boolean isFirstAndSecondAreNumber() {
        return finalElement.hasSecondScore() && NUMBER.match(finalElement);
    }

    private boolean isSpareAndHasThird() {
        return finalElement.hasSecondScore() && SPARE.match(finalElement) && finalElement.hasThirdScore();
    }

    private boolean isStrikeAndHasThird() {
        return STRIKE.match(finalElement) && finalElement.hasThirdScore();
    }

    private boolean isMissOrGutterAndHasSecond() {
        return finalElement.hasSecondScore() && (MISS.match(finalElement) || GUTTER.match(finalElement));
    }
}
