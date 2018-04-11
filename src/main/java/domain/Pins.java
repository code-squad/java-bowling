package domain;

public class Pins {
    private Pin pin1;
    private Pin pin2;

    public Pin recordPins(int num) throws IllegalArgumentException {
        if (!isThrown()) {
            pin1 = new Pin(num);
            return pin1;
        }

        if (pin1.isOverRecord(num)) {
            throw new IllegalArgumentException(Pin.MAX + "개 까지만 기록가능합니다.");
        }
        pin2 = new Pin(num);
        return pin2;
    }

    private boolean isThrown() {
        return pin1 != null;
    }

    public boolean isFinish() {
        return isFullCount() || isFullPinNumRecord();
    }

    public boolean isFullPinNumRecord() {
        return pin1.isFullRecord(pin2);
    }

    public boolean isFullCount() {
        return pin1 != null && pin2 != null;
    }

    public int calcTotal() {
        return pin1.calcTotal(pin2);
    }
}
