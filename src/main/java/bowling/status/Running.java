package bowling.status;

/**
 * @author sangsik.kim
 */
public class Running extends RunningStatus implements Status {
    private int first;

    public Running(int pin) {
        this.first = pin;
    }

    @Override
    public Status bowl(int pin) {
        if (this.first + pin > 10) {
            throw new IllegalArgumentException("쓰러진 핀의 갯수가 올바르지 않습니다.");
        }
        if (this.first + pin == 10) {
            return new Spare(this.first, pin);
        }
        return new Miss(this.first, pin);
    }

    @Override
    public String getScore() {
        return String.valueOf(first);
    }
}
