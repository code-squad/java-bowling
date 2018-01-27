package bowling.domain.frame;

import bowling.domain.score.EntireScore;
import bowling.domain.score.Score;
import bowling.domain.score.ScoreType;

import static bowling.domain.ScoreMachine.convertScoreToString;
import static bowling.domain.score.ScoreType.*;

public class FinalFrame implements Frame {
    private EntireScore entireScore;
    private String result;

    private FinalFrame(Score score) {
        entireScore = entireScore.generate(score);
        result = convertScoreToString(entireScore);
    }

    public static FinalFrame generate(Score score) {
        return new FinalFrame(score);
    }

    @Override
    public boolean isEnd() {
        return isThree(entireScore) || (ScoreType.isDual(entireScore) && entireScore.beforeLastScore().get() != 10);
    }

    @Override
    public FinalFrame nextRound(Score nextScore) {
        EntireScore firstEntire = EntireScore.generate(entireScore.firstScore());
        EntireScore setEntireScore = this.entireScore.inScore(nextScore);

        if(setEntireScore.length() == 2 && isStrike(firstEntire)) {
            result = firstStrikeFormat(setEntireScore.lastScore());
            return this;
        }

        result = convertScoreToString(setEntireScore);
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

}
