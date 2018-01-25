package bowling.domain;

import bowling.domain.Score.Roll;
import bowling.domain.frame.ScoreSheet;
import bowling.domain.number.MaxCount;
import bowling.domain.number.Pins;

public class Player {
    private Name name;
    private ScoreSheet scoreSheet;

    public Player(Name name) {
        this.name = name;
        scoreSheet = new ScoreSheet();
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

    public int currentFrame() {
        if (!needToRoll()) throw new IllegalArgumentException();
        return scoreSheet.currentFrameIndex();
    }

    @Override
    public String toString() {
        return name.toString()+scoreSheet.toString();
    }
}