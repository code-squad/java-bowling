package state;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpareTest {
    private State state;

    @Test
    public void generate() {
        state = new Spare(1, 9);
        assertTrue(Spare.isSpare(state));
    }

    @Test
    public void print() {
        state = new Spare(2, 8);
        assertEquals("2|/", state.printState());
    }
}
