package state;

import domain.Pins;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class StateTest {
    @Test
    public void equals() {
        State state1 = new Ready();
        State state2 = new Ready();
        assertTrue(state1.equals(state2));
    }

    @Test
    public void isEndAllState() {
        State open = new Open(new Pins(1), new Pins(2));
        State spare = new Spare(new Pins(1), new Pins(9));
        State strike = new Strike();
        assertTrue(open.isEnd() && spare.isEnd() && strike.isEnd());
    }
}
