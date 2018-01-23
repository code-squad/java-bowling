package bowling.domain.frame;

import bowling.domain.ScoreMachine;
import bowling.domain.frame.element.FinalElement;
import bowling.domain.score.Score;

import static bowling.domain.score.ScoreType.*;

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
        //두번째, 세번째 확인 필요, 두번쨰, 세번째 계산
        //if(!finalElement.validTotalScore(nextScore)) { throw new IllegalArgumentException("투구점수가 올바르지 않습니다."); }
        result = ScoreMachine.calculateScore(finalElement.inScore(nextScore));

        return this;
    }

    @Override
    public String result() {
        return result;
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

    public FinalElement getFinalElement() {
        return finalElement;
    }
}
