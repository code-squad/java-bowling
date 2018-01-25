package bowling.domain;

import bowling.domain.Score.Roll;
import bowling.domain.frame.ScoreSheet;
import bowling.domain.number.MaxCount;
import bowling.domain.number.Pins;

public class Player {
    private Name name;
    private ScoreSheet scoreSheet;

    public Player(Name name, ScoreSheet scoreSheet) {
        this.name = name;
        this.scoreSheet = scoreSheet;
    }

    public void roll() {
        scoreSheet.add(new Roll(scoreSheet.nextMaxCount()));
    }

    public void roll(Pins downPins) {
        scoreSheet.add(new Roll(downPins));
    }

    public boolean needToRoll() {
        return scoreSheet.hasEmptyFrame();
    }

    public MaxCount nextMaxCount() {
        return scoreSheet.nextMaxCount();
    }

    @Override
    public String toString() {
        return name.toString()+scoreSheet.toString();
    }
}
