package domain.score;

public class Ready {

    private static final Ready instance = new Ready();

    private Ready() {
    }

    static Ready getInstance() {
        return instance;
    }

    public State bowl(Pin pin) {
        if (pin.equals(Pin.TEN)) {
            return new Strike();
        }
        return new FirstBowl(pin);
    }
}
