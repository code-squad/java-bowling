package state;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReadyTest {
    private State state;

    @Test
    public void generate() {
        state = new Ready();
    }

    @Test
    public void equals() {
        state = new Ready();
        assertTrue(Ready.isReady(state));
    }

    @Test
    public void print() {
        state = new Ready();
        assertEquals("", state.printState());
    }
}
