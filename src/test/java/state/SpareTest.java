package state;

import domain.Pins;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpareTest {
    private State state;

    @Test
    public void generate() {
        state = new Spare(new Pins(1), new Pins(9));
        assertTrue(Spare.isSpare(state));
    }

    @Test
    public void print() {
        state = new Spare(new Pins(2), new Pins(8));
        assertEquals("2|/", state.printState());
    }
}
