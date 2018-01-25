package bowling.domain;

import org.junit.Test;

public class TryTest {

    @Test(expected = IllegalArgumentException.class)
    public void illegalTryMinus() {
        new Try(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalTryOver() {
        new Try(BowlingConstants.PIN_COUNT + 1);
    }
}