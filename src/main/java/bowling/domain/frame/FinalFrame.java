package bowling.domain.frame;

import java.util.Optional;

import bowling.domain.score.EntireScore;
import bowling.domain.score.Score;
import bowling.domain.score.ScoreType;

import static bowling.domain.ScoreMachine.calculateScore;
import static bowling.domain.ScoreMachine.convertScoreToString;
import static bowling.domain.ScoreMachine.firstCalculate;
import static bowling.domain.score.ScoreType.SPARE;
import static bowling.domain.score.ScoreType.STRIKE;
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
        return entireScore.length() == 3 || ScoreType.isDual(entireScore);
    }

    @Override
    public FinalFrame nextRound(Score nextScore) {
        result = convertScoreToString(entireScore.inScore(nextScore)); //숫자 3개일때 처리
        /*if(isFirstStrikeAndHasNotSecond()) { result = convertScoreToString(entireScore.inScore(nextScore)); }//{ result = resultFormatMapping(nextScore); }
        else if(!(entireScore.length() == 2)) { result = stringFormatMapping(nextScore); }
        else if(!(entireScore.length() == 3)) { result = thirdScoreCalculate(nextScore); }*/

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
        Optional<ScoreType> scoreType = calculateScore(entireScore.generate(entireScore.lastScore()).inScore(nextScore));
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
        return STRIKE.match(entireScore) && !(entireScore.length() == 2);
    }

    private boolean isFirstOrSecondStrike() {
        return SPARE.match(entireScore) || STRIKE.match(entireScore.generate(entireScore.lastScore()));
    }

    private Optional<ScoreType> getScoreType(Score nextScore) {
        return calculateScore(entireScore.inScore(nextScore));
    }
}
