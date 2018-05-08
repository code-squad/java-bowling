package bowling.status;

/**
 * @author sangsik.kim
 */
public class Gutter extends RunningStatus implements Status {
    @Override
    public Status bowl(int pin) {
        if (pin == 10) {
            return new Spare(0, 10);
        }
        return new Miss(0, pin);
    }

    @Override
    public String getScore() {
        return "-";
    }
}
