package bowling.domain.frame;

import bowling.domain.Score.Roll;
import bowling.domain.Score.Score;
import bowling.domain.number.MaxCount;
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

    public Frame(Frame frame) {
        this.totalScore = frame.totalScore;
        this.score = frame.score;
    }

    public boolean hasEmptyScore() {
        return score.isEmpty();
    }

    public Frame add(Roll roll) {
        if (score == null) {
            score = new Score();
        }
        if (!score.isEmpty()) throw new IllegalArgumentException();
        score = new Score(score.add(roll));
        return this;
    }

    public MaxCount nextMaxCount() {
        return score.calcMaxDownCount();
    }

    @Override
    public String toString() {
        String temp = totalScore == null ? "" : totalScore.toString();
        temp += score == null ? String.format("%4s","") : score.toString();
        return OutPutView.frameFormat(temp);
    }
}
