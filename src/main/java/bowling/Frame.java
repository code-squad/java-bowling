package bowling;

import bowling.status.Ready;
import bowling.status.Status;

/**
 * @author sangsik.kim
 */
public class Frame {
    private Status status = new Ready();

    public void bowl(int pin) {
        this.status = this.status.bowl(pin);
    }


    public String status() {
        return this.status.getClass().getSimpleName();
    }

}
