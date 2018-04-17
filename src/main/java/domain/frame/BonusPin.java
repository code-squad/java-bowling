package domain.frame;

import domain.frame.pin.Pin;

import java.util.ArrayList;
import java.util.List;

public class BonusPin {
    private List<Pin> bonusPins = new ArrayList<>();
    private int bonusRecordCount = 0;

    public void saveBonusPin(int num) throws IllegalArgumentException {
        if (bonusPins.isEmpty() || isMaxFirstBonusPin()) {
            bonusPins.add(new Pin(num));
            return;
        }

        Pin firstPin = getFirstBonusPin();
        if (firstPin.isOverRecordPin(num)) {
            throw new IllegalArgumentException(Pin.MAX + "개 까지만 입력가능합니다.");
        }
        bonusPins.add(new Pin(num));
    }

    public Pin getBonusPin() {
        return bonusPins.get(bonusRecordCount++);
    }

    public boolean isEmpty() {
        return bonusPins.isEmpty();
    }

    private boolean isMaxFirstBonusPin() {
        Pin firstBonus = getFirstBonusPin();
        return firstBonus.isMax();
    }

    private Pin getFirstBonusPin() {
        return bonusPins.get(0);
    }
}
