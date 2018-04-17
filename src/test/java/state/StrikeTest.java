package state;

import domain.Pins;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrikeTest {
    @Test
    public void generate() {
        State state = new Strike(new Pins(10));
    }

    @Test
    public void print() {
        State state = new Strike(new Pins(10));
        assertEquals("x", state.printState());
    }
}
