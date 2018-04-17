package state;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadyTest {
    State state;

    @Test
    public void generate() {
        state = new Ready();
    }

    @Test
    public void print() {
        state = new Ready();
        assertEquals("", state.printState());
    }
}
