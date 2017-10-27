package bowling.frame.state;

import org.junit.Test;

import bowling.frame.pin.Pins;

public class MissTest {

    @Test(expected = UnsupportedOperationException.class)
    public void bowl() {
        Ready ready = new Ready();
        ready.bowl(Pins.bowl(8)).bowl(Pins.bowl(1)).bowl(Pins.bowl(10));
    }

}
