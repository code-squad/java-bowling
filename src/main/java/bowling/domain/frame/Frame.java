package bowling.domain.frame;

import bowling.domain.Score.Score;
import bowling.domain.number.MaxCount;
import bowling.domain.number.Roll;
import bowling.domain.number.TotalScore;
import bowling.io.OutPutView;

public class Frame {

    private TotalScore totalScore;
    private Score score;

    public Frame() {
    }

    public Frame(Score score) {
        this.score = score;
    }

    public Frame(Score score, TotalScore totalScore) {
        this.totalScore = totalScore;
        this.score = score;
    }

    public boolean hasEmptyScore() {
        return score == null ? true : score.isEmpty();
    }

    public Score add(Roll roll) {
        if (score == null) {
            score = new Score();
        }
        if (!score.isEmpty()) throw new IllegalArgumentException();
        return score.add(roll);
    }

    public MaxCount nextMaxCount() {
        return score.calcMaxDownCount();
    }

    public TotalScore calcTotal() {
        return totalScore;
    }

    @Override
    public String toString() {
        String temp = totalScore == null ? "" : totalScore.toString();
        temp += score == null ? String.format("%4s","") : score.toString();
        return OutPutView.frameFormat(temp);
    }
}