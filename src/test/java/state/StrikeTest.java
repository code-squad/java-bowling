package state;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StrikeTest {
    private State state;

    @Test
    public void generate() {
        state = new Strike();
    }

    @Test
    public void equals() {
        state = new Strike();
        assertTrue(Strike.isStrike(state));
    }

    @Test
    public void print() {
        state = new Strike();
        assertEquals("X", state.printState());
    }
}
