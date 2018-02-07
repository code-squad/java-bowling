package domain.score;

public class Ready {

    private Ready() {
    }

    public static State bowl(Pin pin) {
        if (pin.equals(Pin.TEN)) {
            return new Strike();
        }
        return new FirstBowl(pin);
    }
}
