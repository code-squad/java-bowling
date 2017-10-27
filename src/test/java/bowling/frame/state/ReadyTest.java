package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.pin.Pins;
import bowling.frame.state.FirstBowl;
import bowling.frame.state.Ready;
import bowling.frame.state.State;
import bowling.frame.state.Strike;

public class ReadyTest {
    @Test
    public void bowl_strike() throws Exception {
        Ready ready = new Ready();
        State state = ready.bowl(Pins.bowl(10));
        assertTrue(state instanceof Strike);
    }

    @Test
    public void bowl_first() throws Exception {
        Ready ready = new Ready();
        State state = ready.bowl(Pins.bowl(9));
        assertTrue(state instanceof FirstBowl);
    }
}
