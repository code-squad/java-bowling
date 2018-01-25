package bowling.domain.frame;

import bowling.domain.Score.FinalScoreCell;
import bowling.domain.number.MaxCount;
import bowling.domain.number.Roll;
import bowling.domain.number.TotalScore;
import bowling.io.OutPutView;

public class FinalFrame {

    private TotalScore totalScore;
    private FinalScoreCell score;

    public FinalFrame() {
    }

    public FinalFrame(FinalScoreCell score) {
        this.score = score;
    }

    public boolean hasEmptyFrame() {
        return score == null || score.hasEmptyScore() || score.isTimeToFillBonusRoll();
    }

    public FinalFrame add(Roll roll) {
        if (!hasEmptyFrame()) throw new IllegalArgumentException();
        if (score == null) {
            score = new FinalScoreCell();
        }
        return new FinalFrame(score.add(roll));
    }

    public MaxCount nextMaxCount() {
        if (!hasEmptyFrame()) throw  new IllegalArgumentException();
        if (score == null) {
            score = new FinalScoreCell();
        }
        return score.nextMaxCount();
    }

    @Override
    public String toString() {
        String temp = totalScore == null ? "" : totalScore.toString();
        temp += score == null ? String.format("%4s","") : score.toString();
        return OutPutView.frameFormat(temp);
    }
}