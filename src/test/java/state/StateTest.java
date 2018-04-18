package state;

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
        State open = new Open(1,2);
        State spare = new Spare(1,9);
        State strike = new Strike();
        assertTrue(open.isEnd() && spare.isEnd() && strike.isEnd());
    }
}
