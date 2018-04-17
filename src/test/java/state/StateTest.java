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
}
