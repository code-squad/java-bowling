package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.pin.Pins;
import bowling.frame.pin.Score;
import bowling.frame.state.Spare;

public class SpareTest {
    @Test(expected = IllegalArgumentException.class)
    public void createWhenillegal() throws Exception {
        new Spare(Pins.bowl(7), Pins.bowl(2));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void bowl() {
        new Spare(Pins.bowl(8), Pins.bowl(2)).bowl(Pins.bowl(8));
    }

    @Test
    public void cacluateAdditionalScore() throws Exception {
        Score score = new Score(10, 2);
        Spare spare = new Spare(Pins.bowl(8), Pins.bowl(2));
        assertEquals(new Score(20, 0), spare.cacluateAdditionalScore(score));
    }
}
