package domain;

public class Pins {
    private static final int MAX_PINS = 10;
    private static final int MIN_PINS = 0;

    private final int falledPins;

    public Pins(int falledPins) {
        isValid(falledPins);
        this.falledPins = falledPins;
    }

    public boolean isValid(int falledPins) {
        if (falledPins > MAX_PINS) {
            throw new IllegalArgumentException(
                    String.format("볼링 핀은 최대 10을 넘을 수 없습니다. 현재 쓰러진 핀 수는 %d", falledPins));
        }

        if (falledPins < MIN_PINS) {
            throw new IllegalArgumentException(
                    String.format("볼링 핀은 최초 0 미만이 될 수 없습니다. 현재 쓰러진 핀 수는 %d", falledPins));
        }
        return true;
    }

    public boolean isStrike() {
        return this.falledPins == MAX_PINS;
    }

    public boolean isSpare(Pins secondPins) {
        return this.falledPins + secondPins.falledPins == MAX_PINS;
    }

    public boolean isOpen(Pins secondPins) {
        return this.falledPins + secondPins.falledPins < MAX_PINS;
    }

    public boolean isGutter() {
        return falledPins == MIN_PINS;
    }

    @Override
    public String toString() {
        return String.valueOf(falledPins);
    }

    public static int sumPins(Pins first, Pins second) {
        if (first.falledPins + second.falledPins > 10 && first.falledPins + second.falledPins < 0) {
            throw new RuntimeException("Pins.java : 쓰러진 핀의 합계는 0~10까지 입니다.");
        }
        return first.falledPins + second.falledPins;
    }

    public int sumScore(int score) {
        return this.falledPins + score;
    }

    public Score createFirstBowlScore(int left) {
        return new Score(falledPins, left);
    }
}
