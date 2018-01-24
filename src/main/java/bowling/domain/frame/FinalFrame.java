package bowling.domain.frame;

import java.util.Optional;

import bowling.domain.score.EntireScore;
import bowling.domain.score.FinalScore;
import bowling.domain.score.Score;
import bowling.domain.score.ScoreType;

import static bowling.domain.ScoreMachine.calculateScore;
import static bowling.domain.ScoreMachine.convertScoreToString;
import static bowling.domain.ScoreMachine.firstCalculate;
import static bowling.domain.score.ScoreType.GUTTER;
import static bowling.domain.score.ScoreType.MISS;
import static bowling.domain.score.ScoreType.NUMBER;
import static bowling.domain.score.ScoreType.SPARE;
import static bowling.domain.score.ScoreType.STRIKE;
import static bowling.utils.StringUtils.scoreResultFormat;

public class FinalFrame implements Frame {
    private FinalScore finalScore;
    private String result;

    private FinalFrame(Score score) {
        finalScore = finalScore.generate(score);
        result = firstCalculate(finalScore);
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
        else if(!finalScore.hasSecondScore()) { result = getResultMapping(nextScore); }
        else if(!finalScore.hasThirdScore()) { result = thirdScoreCalculate(nextScore); }

        return this;
    }

    @Override
    public String result() {
        return result;
    }

    @Override
    public EntireScore getElement() {
        return finalScore;
    }

    private String thirdScoreCalculate(Score nextScore) {
        if(isFirstOrSecondStrike()) { return getResultMapping(FIRST_SCORE, nextScore); }
        Optional<ScoreType> scoreType = calculateScore(FinalScore.generate(finalScore.getScoreByKey(SECOND_SCORE)).inScore(THIRD_SCORE, nextScore));
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
        return convertScoreToString(type, finalScore);
    }

    private boolean isFirstStrikeAndHasNotSecond() {
        return STRIKE.match(finalScore) && !finalScore.hasSecondScore();
    }

    private boolean isFirstOrSecondStrike() {
        return SPARE.match(finalScore) || STRIKE.match(FinalScore.generate(finalScore.getScoreByKey(SECOND_SCORE)));
    }

    private Optional<ScoreType> getScoreType(String key, Score nextScore) {
        return calculateScore(finalScore.inScore(key, nextScore));
    }

    private boolean isFirstAndSecondAreNumber() {
        return finalScore.hasSecondScore() && NUMBER.match(finalScore);
    }

    private boolean isSpareAndHasThird() {
        return finalScore.hasSecondScore() && SPARE.match(finalScore) && finalScore.hasThirdScore();
    }

    private boolean isStrikeAndHasThird() {
        return STRIKE.match(finalScore) && finalScore.hasThirdScore();
    }

    private boolean isMissOrGutterAndHasSecond() {
        return finalScore.hasSecondScore() && (MISS.match(finalScore) || GUTTER.match(finalScore));
    }
}
