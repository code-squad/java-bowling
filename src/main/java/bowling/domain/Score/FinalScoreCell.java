package bowling.domain.Score;

import bowling.domain.number.BowlingScore;
import bowling.domain.number.MaxCount;
import bowling.util.ScoreAssistance;

public class FinalScoreCell {

    private FinalScore score;
    private Roll bonusRoll;

    public FinalScoreCell() {
    }

    public FinalScoreCell(FinalScoreCell cell) {
        this.score = cell.score;
        this.bonusRoll = cell.bonusRoll;
    }

    public boolean hasEmptyScore() {
        return score == null || score.isEmpty() || isTimeToFillBonusRoll();
    }

    public boolean isTimeToFillBonusRoll() {
        if (!score.isEmpty() && score.isSpared()) {
            return bonusRoll == null;
        }
        return false;
    }

    public FinalScoreCell add(Roll roll) {
        if (!hasEmptyScore()) throw new IllegalArgumentException();
        if (score == null) {
            score = new FinalScore();
        }
        if (isTimeToFillBonusRoll()) {
            if (!score.isSpared()) throw new IllegalArgumentException();
            bonusRoll = roll;
            return this;
        }
        score = new FinalScore(score.add(roll));
        return this;
    }

    private BowlingScore bonusRollScore() {
        return bonusRoll.isSpare() ? BowlingScore.STRIKE : bonusRoll.toBowlingScore();
    }

    public MaxCount nextMaxCount() {
        if (score == null) {
            score = new FinalScore();
        }
        return calcNextMaxCount();
    }

    private MaxCount calcNextMaxCount() {
        MaxCount maxCount = score.calcNextMaxCount();
        if (maxCount == null && score.isSpared()) {
            maxCount = new MaxCount(ScoreAssistance.MAX_PIN_COUNT);
        }
        return maxCount;
    }

    @Override
    public String toString() {
        String temp = score == null ? "" : score.toString();
        temp += bonusRoll == null ? "" : "|" + bonusRollScore().toString();
        return temp;
    }
}
