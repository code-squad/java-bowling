package domain.frame.result.score;

import domain.Pin;
import domain.Pins;

import java.util.ArrayList;
import java.util.List;

public class FrameScore {
    private Pins pins;
    private List<Pin> bonusPins = new ArrayList<>();
    private int bonusCount;

    public FrameScore(Pins pins, int bonusCount) {
        this.pins = pins;
        this.bonusCount = bonusCount;
    }

    public void addBonusPins(int num) throws IllegalArgumentException {
        if (!isDone()) {
            bonusPins.add(new Pin(num));
        }
    }

    public int getScore() {
        int score = pins.calcTotal();
        for (Pin pin : bonusPins) {
            score = pin.calcTotal(score);
        }
        return score;
    }

    public boolean isDone() {
        return bonusPins.size() == bonusCount;
    }

    public boolean isRecordStared() {
        return bonusPins.size() > 0;
    }
}
