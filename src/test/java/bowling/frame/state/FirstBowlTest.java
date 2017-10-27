package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.pin.Pins;
import bowling.frame.state.FirstBowl;
import bowling.frame.state.Miss;
import bowling.frame.state.Spare;
import bowling.frame.state.State;

public class FirstBowlTest {

    @Test
    public void bowlWhenSpare() {
        FirstBowl firstBowl = new FirstBowl(Pins.bowl(9));
        State state = firstBowl.bowl(Pins.bowl(1));
        assertTrue(state instanceof Spare);
    }

    @Test
    public void bowlWhenMiss() throws Exception {
        FirstBowl firstBowl = new FirstBowl(Pins.bowl(9));
        State state = firstBowl.bowl(Pins.bowl(0));
        assertTrue(state instanceof Miss);
    }

}
