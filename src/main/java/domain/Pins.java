package domain;

import java.util.ArrayList;
import java.util.List;

public class Pins {
    private static final int LIMIT_NUM = 2;
    private List<Pin> pins = new ArrayList<>();

    public Pin recordPins(int num) throws IllegalArgumentException {
        Pin newPin = new Pin(num);
        if (isThrown() && newPin.isOverRecord(pins)) {
            throw new IllegalArgumentException("한 프레임에 정규 투구 점수" + Pin.MAX + "개를 기록할 수 없습니다.");
        }
        pins.add(newPin);
        return newPin;
    }

    private boolean isThrown() {
        return pins.size() != 0;
    }

    public boolean isFinish() {
        return isFullCount() || isFullPinNumRecord();
    }

    public boolean isFullPinNumRecord() {
        return Pin.isFullPinNumRecord(pins);
    }

    public boolean isFullCount() {
        return pins.size() == LIMIT_NUM;
    }
}
