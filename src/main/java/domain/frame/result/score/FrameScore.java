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
        if (isSettingDone()) {
            return;
        }
        bonusPins.add(new Pin(num));
    }

    public int getScore() {
        /* TODO : 총합구하기 로직 구현 (Pins, Pin 사용)*/
        return 0;
    }

    public boolean isSettingDone() {
        return bonusPins.size() == bonusCount;
    }

    public boolean isStartedRecord() {
        return bonusPins.size() > 0;
    }
}
