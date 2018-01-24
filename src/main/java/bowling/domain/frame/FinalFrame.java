package bowling.domain.frame;

import bowling.domain.score.EntireScore;
import bowling.domain.score.Score;
import bowling.domain.score.ScoreType;

import java.util.Optional;

import static bowling.domain.ScoreMachine.*;
import static bowling.domain.score.ScoreType.*;
import static bowling.utils.StringUtils.scoreResultFormat;

public class FinalFrame implements Frame {
    private EntireScore entireScore;
    private String result;

    private FinalFrame(Score score) {
        entireScore = entireScore.generate(score);
        result = firstCalculate(entireScore);
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
        if(isFirstStrikeAndHasNotSecond()) { result = resultFormatMapping(nextScore); }
        else if(!entireScore.hasSecondScore()) { result = stringFormatMapping(nextScore); }
        else if(!entireScore.hasThirdScore()) { result = thirdScoreCalculate(nextScore); }

        return this;
    }

    @Override
    public String result() {
        return result;
    }

    @Override
    public EntireScore getElement() {
        return entireScore;
    }

    private String thirdScoreCalculate(Score nextScore) {
        if(isFirstOrSecondStrike()) {
            return calculateScore(EntireScore.generate(nextScore))
                .map(this::resultFormat)
                .orElse(scoreResultFormat(result, String.valueOf(nextScore.get())));
        }
        Optional<ScoreType> scoreType = calculateScore(entireScore.generate(entireScore.getScoreByKey(1)).inScore(nextScore));
        return scoreType.map(this::resultFormat).get();
    }

    private String stringFormatMapping(Score nextScore) {
        return getScoreType(nextScore)
                .map(this::stringFormat)
                .orElse(scoreResultFormat(result, String.valueOf(nextScore.get())));
    }

    private String resultFormatMapping(Score nextScore) {
        return getScoreType(nextScore)
                .map(this::resultFormat)
                .orElse(scoreResultFormat(result, String.valueOf(nextScore.get())));
    }

    private String resultFormat(ScoreType type) {
        return scoreResultFormat(result, stringFormat(type));
    }

    private String stringFormat(ScoreType type) {
        return convertScoreToString(type, entireScore);
    }

    private boolean isFirstStrikeAndHasNotSecond() {
        return STRIKE.match(entireScore) && !entireScore.hasSecondScore();
    }

    private boolean isFirstOrSecondStrike() {
        return SPARE.match(entireScore) || STRIKE.match(entireScore.generate(entireScore.getScoreByKey(1)));
    }

    private Optional<ScoreType> getScoreType(Score nextScore) {
        return calculateScore(entireScore.inScore(nextScore));
    }

    private boolean isFirstAndSecondAreNumber() {
        return entireScore.hasSecondScore() && NUMBER.match(entireScore);
    }

    private boolean isSpareAndHasThird() {
        return entireScore.hasSecondScore() && SPARE.match(entireScore) && entireScore.hasThirdScore();
    }

    private boolean isStrikeAndHasThird() {
        return STRIKE.match(entireScore) && entireScore.hasThirdScore();
    }

    private boolean isMissOrGutterAndHasSecond() {
        return entireScore.hasSecondScore() && (MISS.match(entireScore) || GUTTER.match(entireScore));
    }
}
