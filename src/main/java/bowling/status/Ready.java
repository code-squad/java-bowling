package bowling.status;

/**
 * @author sangsik.kim
 */
public class Ready extends RunningStatus implements Status {
    @Override
    public Status bowl(int pin) {
        if (pin == 10) {
            return new Strike();
        }
        if (pin == 0) {
            return new Gutter();
        }
        return new Running(pin);
    }

    @Override
    public String getScore() {
        return "Ready";
    }
}
