package bowling.domain.frame;

import bowling.domain.score.EntireScore;
import bowling.domain.score.Score;

import static bowling.domain.ScoreMachine.convertFinalScore;
import static bowling.domain.score.type.FinalScoreType.isThree;
import static bowling.domain.score.type.NormalScoreType.isDual;
import static bowling.domain.score.type.NormalScoreType.isStrike;

public class FinalFrame implements Frame {
    private EntireScore entireScore;

    private FinalFrame(Score score) {
        entireScore = entireScore.generate(score);
    }

    public static FinalFrame generate(Score score) {
        return new FinalFrame(score);
    }

    @Override
    public boolean isEnd() {
        return isThree(entireScore) || (isDual(entireScore) && !isStrike(EntireScore.generate(entireScore.beforeLastScore())));
    }

    @Override
    public FinalFrame nextRound(Score nextScore) {
        entireScore.inScore(nextScore);
        return this;
    }

    @Override
    public String result() {
        return convertFinalScore(entireScore);
    }
}
